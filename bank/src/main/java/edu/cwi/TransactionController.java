package edu.cwi;

import io.javalin.apibuilder.CrudHandler;
import io.javalin.http.Context;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import static j2html.TagCreator.*;

public class TransactionController implements CrudHandler {

    private final Map<String, String> transactions = new ConcurrentHashMap<>();

    private String htmlString() {
        return html(
                body(
                        h1("Transactions"),

                        form()
                                .withMethod("post")
                                .withAction("/transactions")
                                .with(
                                        input().withName("transaction"),
                                        button("Create Transaction")), // this works

                        each(transactions.entrySet(), transaction -> div(
                                h2("Transaction " + transaction.getKey()),
                                p(transaction.getValue()),

                                form()
                                        .withMethod("put")
                                        .withAction("/transactions/" + transaction.getKey())
                                        .with(
                                                input()
                                                        .withType("text")
                                                        .withName("transaction")
                                                        .withValue(transaction.getValue()),
                                                button("Update Transaction")),

                                form()
                                        .withMethod("delete")
                                        .withAction("/transactions/" + transaction.getKey())
                                        .with(
                                                button("Delete Transaction"))))))
                .render().toString();
    }

    @Override
    public void getAll(Context ctx) {

        UserAccount account = new UserAccount(
                "John",
                12500.50,
                transactions);

        ctx.render("jte/accountPage.jte",
                Map.of(
                        "title", "My Bank Account",
                        "account", account));
        // ctx.render("jte/transactionsPage.jte",
        // Map.of("transactions", transactions));
    }

    // Use ctx to render all transactions html

    @Override
    public void getOne(Context ctx, String resourceId) {
        // I think it's calling here
        String user = transactions.get(resourceId);

        if (user != null) {
            ctx.html(
                    html(
                            body(
                                    h1("Transaction " + resourceId),
                                    p(user)))
                            .render());

            // Use ctx to render transaction html
        } else {
            ctx.status(404).result("Transaction not found");
        }
    }

    @Override
    public void create(Context ctx) {

        String body = ctx.body();
        String id = String.valueOf(transactions.size() + 1);

        transactions.put(id, body);

        getAll(ctx);
        // Use ctx to render all transactions html
    }

    @Override
    public void update(Context ctx, String resourceId) {

        if (transactions.containsKey(resourceId)) {
            transactions.put(resourceId, ctx.body());

            getAll(ctx);
            // Use ctx to render all transactions html
        } else {
            ctx.status(404).result("Transaction not found");
        }
    }

    @Override
    public void delete(Context ctx, String resourceId) {

        transactions.remove(resourceId);
        ctx.html(htmlString());
        // Use ctx to render all transactions html
    }
}
