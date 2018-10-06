import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;
//IT16168114
//Viraj Dissanayake
@WebServlet(name = "/Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        /*Hard coded user credentials have been used for demonstration purposes*/
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(username.equals("viraj dissanayake") && password.equals("IT16168114"))
        {

            /*Setting the CSRFToken*/
            String CSRFToken = UUID.randomUUID().toString();
            /*Setting up the cookie*/
            Cookie STPcookie = new Cookie("STPCookie",username);
            STPcookie.setMaxAge(60*5);
            STPcookie.setPath("localhost/SSS_Assignment1");
            STPcookie.setDomain("localhost");
            response.addCookie(STPcookie);
            /*Creating the user session*/
            HttpSession session = request.getSession(true);
            /*Storing the token in the server side endpoint*/
            session.setAttribute("CSRFToken", CSRFToken);
            /*Redirecting the user to index page*/
            response.sendRedirect("index.jsp");
        }
        else {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Username or Password is incorrect!');");
            out.println("location='login.jsp';");
            out.println("</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
