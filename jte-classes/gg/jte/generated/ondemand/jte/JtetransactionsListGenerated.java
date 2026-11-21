package gg.jte.generated.ondemand.jte;
@SuppressWarnings("unchecked")
public final class JtetransactionsListGenerated {
	public static final String JTE_NAME = "jte/transactionsList.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,0,6,6,6,8,8,8,8,8,8,10,10,12,12,12,0,0,0,0};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, String> transactions) {
		jteOutput.writeContent("\r\n<div class=\"transactions\">\r\n    <h2>Transactions</h2>\r\n\r\n    <ul>\r\n        ");
		for (var transaction : transactions.entrySet()) {
			jteOutput.writeContent("\r\n            <li>\r\n                ");
			jteOutput.setContext("li", null);
			jteOutput.writeUserContent(transaction.getKey());
			jteOutput.writeContent(": ");
			jteOutput.setContext("li", null);
			jteOutput.writeUserContent(transaction.getValue());
			jteOutput.writeContent("\r\n            </li>\r\n        ");
		}
		jteOutput.writeContent("\r\n    </ul>\r\n</div>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		java.util.Map<String, String> transactions = (java.util.Map<String, String>)params.get("transactions");
		render(jteOutput, jteHtmlInterceptor, transactions);
	}
}
