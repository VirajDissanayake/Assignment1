import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
//IT16168114
//Viraj Dissanayake

@WebServlet(name = "/Validate", urlPatterns = {"/Validate"})
public class Validate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String scheme=request.getScheme();
        String method=request.getMethod();
        //Check whether the request is a http request and the method is post
        if(scheme.equals("http") && method.equals("POST"))
        {
          HttpSession session = request.getSession();
          String storedToken = (String)session.getAttribute("CSRFToken");
          String token = request.getParameter("token");
          if (storedToken.equals(token))
          {
            response.sendRedirect("welcome.jsp");
          }
          else {
              response.sendRedirect("index.jsp");
              out.println("<script type=\"text/javascript\">");
              out.println("alert('Error in identifying the user session!');");
              out.println("location='login.jsp';");
              out.println("</script>");
          }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}


