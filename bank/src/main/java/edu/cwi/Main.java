package edu.cwi;

import edu.cwi.TransactionController;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import static io.javalin.apibuilder.ApiBuilder.*;
import io.javalin.rendering.template.JavalinJte;

public class Main {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {

            config.fileRenderer(new JavalinJte());

            config.staticFiles.add("/public", Location.CLASSPATH);

            config.routes.post("/account", ctx -> {
                ctx.redirect("account.html");
            });

            config.routes.get("/logout", ctx -> {
                ctx.redirect("/");
            });

            config.routes.apiBuilder(() -> {
                crud("transactions/{id}", new TransactionController());
            });

        });
        app.start(7070);
    }
}
