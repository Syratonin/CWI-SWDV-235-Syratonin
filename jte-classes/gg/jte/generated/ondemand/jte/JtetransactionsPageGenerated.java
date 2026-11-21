package gg.jte.generated.ondemand.jte;
@SuppressWarnings("unchecked")
public final class JtetransactionsPageGenerated {
	public static final String JTE_NAME = "jte/transactionsPage.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,0,15,15,15,17,17,17,18,18,18,20,20,20,20,21,21,21,21,21,21,21,21,21,25,25,25,25,29,29,32,32,32,0,0,0,0};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, String> transactions) {
		jteOutput.writeContent("\r\n<!DOCTYPE html>\r\n<html>\r\n<head>\r\n    <title>Transactions</title>\r\n</head>\r\n<body>\r\n    <h1>Transactions</h1>\r\n\r\n    <form method=\"post\" action=\"/transactions\">\r\n        <input type=\"text\" name=\"transaction\">\r\n        <button type=\"submit\">Create Transaction</button>\r\n    </form>\r\n\r\n    ");
		for (var transaction : transactions.entrySet()) {
			jteOutput.writeContent("\r\n        <div>\r\n            <h2>Transaction ");
			jteOutput.setContext("h2", null);
			jteOutput.writeUserContent(transaction.getKey());
			jteOutput.writeContent("</h2>\r\n            <p>");
			jteOutput.setContext("p", null);
			jteOutput.writeUserContent(transaction.getValue());
			jteOutput.writeContent("</p>\r\n\r\n            <form method=\"post\" action=\"/transactions/");
			jteOutput.setContext("form", "action");
			jteOutput.writeUserContent(transaction.getKey());
			jteOutput.setContext("form", null);
			jteOutput.writeContent("/update\">\r\n                <input type=\"text\" name=\"transaction\"");
			var __jte_html_attribute_0 = transaction.getValue();
			if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
				jteOutput.writeContent(" value=\"");
				jteOutput.setContext("input", "value");
				jteOutput.writeUserContent(__jte_html_attribute_0);
				jteOutput.setContext("input", null);
				jteOutput.writeContent("\"");
			}
			jteOutput.writeContent(">\r\n                <button type=\"submit\">Update Transaction</button>\r\n            </form>\r\n\r\n            <form method=\"post\" action=\"/transactions/");
			jteOutput.setContext("form", "action");
			jteOutput.writeUserContent(transaction.getKey());
			jteOutput.setContext("form", null);
			jteOutput.writeContent("/delete\">\r\n                <button type=\"submit\">Delete Transaction</button>\r\n            </form>\r\n        </div>\r\n    ");
		}
		jteOutput.writeContent("\r\n\r\n</body>\r\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		java.util.Map<String, String> transactions = (java.util.Map<String, String>)params.get("transactions");
		render(jteOutput, jteHtmlInterceptor, transactions);
	}
}
