import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;
//IT16168114
//Viraj Dissanayake
@WebServlet(name = "/Login1", urlPatterns = {"/Login1"})
public class Login1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(username.equals("viraj dissanayake") && password.equals("IT16168114"))
        {
          //Generating session cookie
          Cookie DScookie = new Cookie("DScookie", username);
          DScookie.setMaxAge(60*5);
          DScookie.setPath("localhost/SSS_Assignment1");
          DScookie.setDomain("localhost");
          response.addCookie(DScookie);
          //Genrating CSRF Token
          String CSRFToken = UUID.randomUUID().toString();
          //Genraing CSRF Token cookie
          Cookie Tokencookie = new Cookie("Tokencookie", CSRFToken);
          Tokencookie.setMaxAge(60*5);
          Tokencookie.setPath("localhost/SSS_Assignment1");
          Tokencookie.setDomain("localhost");
          response.addCookie(Tokencookie);
          //sending the CSRF Token value to the hidden field of the index1 form
          request.setAttribute("CSRFToken",CSRFToken);
          request.getRequestDispatcher("index1.jsp").forward(request, response);
          //Redirecting the user to index page*
          response.sendRedirect("index1.jsp");

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

