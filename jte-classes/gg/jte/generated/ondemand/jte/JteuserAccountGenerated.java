package gg.jte.generated.ondemand.jte;
@SuppressWarnings("unchecked")
public final class JteuserAccountGenerated {
	public static final String JTE_NAME = "jte/userAccount.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,0,6,6,6,6,7,7,7,8,8,8,0,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String name, String balance) {
		jteOutput.writeContent("\r\n<div class=\"user-account\">\r\n    <h2>Account Information</h2>\r\n\r\n    <p>Name: ");
		jteOutput.setContext("p", null);
		jteOutput.writeUserContent(name);
		jteOutput.writeContent("</p>\r\n    <p>Balance: ");
		jteOutput.setContext("p", null);
		jteOutput.writeUserContent(balance);
		jteOutput.writeContent("</p>\r\n</div>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String name = (String)params.get("name");
		String balance = (String)params.get("balance");
		render(jteOutput, jteHtmlInterceptor, name, balance);
	}
}
