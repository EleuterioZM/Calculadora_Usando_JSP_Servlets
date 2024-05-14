package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Calculadora_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Calculadora</title>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\n");
      out.write("    <script>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        function appendToDisplay(value) {\n");
      out.write("            if (value === '^') {\n");
      out.write("                // Se o valor for \"^\", adicione \"**\" ao invés de \"^\"\n");
      out.write("                document.getElementById('display').innerText += \"^\";\n");
      out.write("                document.getElementById('expressao').value += \"**\";\n");
      out.write("            } else if (value === '√') {\n");
      out.write("                // Se o valor for \"√\", adicione \"Math.sqrt(\" ao invés de \"√(\"\n");
      out.write("                document.getElementById('display').innerText += \"√\";\n");
      out.write("                document.getElementById('expressao').value += \"Math.sqrt(\";\n");
      out.write("            } else {\n");
      out.write("                // Caso contrário, adicione o valor normalmente\n");
      out.write("                document.getElementById('display').innerText += value;\n");
      out.write("                document.getElementById('expressao').value += value;\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function calculate() {\n");
      out.write("            try {\n");
      out.write("                let expressao = document.getElementById('expressao').value;\n");
      out.write("                // Substitua a função Math.sqrt pelo seu valor numérico\n");
      out.write("                expressao = expressao.replace(/Math.sqrt/g, 'Math.sqrt(');\n");
      out.write("                // Substitua todos os parênteses de fechamento ausentes\n");
      out.write("                let countOpeningParenthesis = (expressao.match(/\\(/g) || []).length;\n");
      out.write("                let countClosingParenthesis = (expressao.match(/\\)/g) || []).length;\n");
      out.write("                for (let i = 0; i < countOpeningParenthesis - countClosingParenthesis; i++) {\n");
      out.write("                    expressao += ')';\n");
      out.write("                }\n");
      out.write("                let result = eval(expressao);\n");
      out.write("                document.getElementById('display').innerText = result;\n");
      out.write("                document.getElementById('expressao').value = result;\n");
      out.write("            } catch (error) {\n");
      out.write("                document.getElementById('display').innerText = 'Erro';\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function clearDisplay() {\n");
      out.write("            document.getElementById('display').innerText = '0';\n");
      out.write("            document.getElementById('expressao').value = '';\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("    </script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"calculator\">\n");
      out.write("        <form method=\"post\" onsubmit=\"calculate(); return false;\">\n");
      out.write("            <input type=\"hidden\" name=\"expressao\" id=\"expressao\">\n");
      out.write("            <div class=\"display\" id=\"display\">0</div>\n");
      out.write("            <div class=\"buttons\">\n");
      out.write("                <button type=\"button\" onclick=\"appendToDisplay('7')\">7</button>\n");
      out.write("                <button type=\"button\" onclick=\"appendToDisplay('8')\">8</button>\n");
      out.write("                <button type=\"button\" onclick=\"appendToDisplay('9')\">9</button>\n");
      out.write("                <button type=\"button\" onclick=\"appendToDisplay('+')\">+</button>\n");
      out.write("\n");
      out.write("                <button type=\"button\" onclick=\"appendToDisplay('4')\">4</button>\n");
      out.write("                <button type=\"button\" onclick=\"appendToDisplay('5')\">5</button>\n");
      out.write("                <button type=\"button\" onclick=\"appendToDisplay('6')\">6</button>\n");
      out.write("                <button type=\"button\" onclick=\"appendToDisplay('-')\">-</button>\n");
      out.write("\n");
      out.write("                <button type=\"button\" onclick=\"appendToDisplay('1')\">1</button>\n");
      out.write("                <button type=\"button\" onclick=\"appendToDisplay('2')\">2</button>\n");
      out.write("                <button type=\"button\" onclick=\"appendToDisplay('3')\">3</button>\n");
      out.write("                <button type=\"button\" onclick=\"appendToDisplay('*')\">*</button>\n");
      out.write("\n");
      out.write("                <button type=\"button\" onclick=\"appendToDisplay('0')\">0</button>\n");
      out.write("                <button type=\"button\" onclick=\"appendToDisplay('.')\">.</button>\n");
      out.write("                <button type=\"button\" onclick=\"appendToDisplay('√')\">√</button>\n");
      out.write("                <button type=\"button\" onclick=\"appendToDisplay('^')\">^</button>\n");
      out.write("\n");
      out.write("                <button type=\"button\" onclick=\"appendToDisplay('/')\">/</button>\n");
      out.write("                <button type=\"submit\">=</button>\n");
      out.write("\n");
      out.write("                <!-- Botão C para limpar -->\n");
      out.write("                <button type=\"button\" id=\"clear\" onclick=\"clearDisplay()\">CE</button>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
