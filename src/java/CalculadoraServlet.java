
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalculadoraServlet")
public class CalculadoraServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            String expressao = request.getParameter("expressao");

            if (expressao == null || expressao.isEmpty()) {
                request.setAttribute("result", "Erro: Nenhuma expressão fornecida!");
            } else {
                String[] components = expressao.split("(?<=[-+*/])|(?=[-+*/])");

                if (components.length != 3) {
                    request.setAttribute("result", "Erro: Expressão inválida!");
                } else {
                    double num1 = Double.parseDouble(components[0].trim());
                    double num2 = Double.parseDouble(components[2].trim());
                    double resultado = 0;

                    switch (components[1].trim()) {
                        case "+":
                            resultado = num1 + num2;
                            break;
                        case "-":
                            resultado = num1 - num2;
                            break;
                        case "*":
                            resultado = num1 * num2;
                            break;
                        case "/":
                            if (num2 != 0) {
                                resultado = num1 / num2;
                            } else {
                                request.setAttribute("result", "Erro: Divisão por zero!");
                                return; // Adicionado o return para sair do método
                            }
                            break;
                        case "√":
                            if (num1 >= 0) {
                                resultado = Math.sqrt(num1);
                            } else {
                                request.setAttribute("result", "Erro: Número negativo para a raiz quadrada!");
                                return; // Adicionado o return para sair do método
                            }
                            break;
                        case "^":
                            resultado = Math.pow(num1, num2);
                            break;
                        default:
                            request.setAttribute("result", "Erro: Operação inválida!");
                            return; // Adicionado o return para sair do método
                    }

                    request.setAttribute("result", resultado);
                }
            }
        } catch (NumberFormatException e) {
            request.setAttribute("result", "Erro: Números inválidos!");
        }

        request.getRequestDispatcher("Calculadora.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
