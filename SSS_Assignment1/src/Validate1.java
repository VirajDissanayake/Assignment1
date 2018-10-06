import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import java.io.IOException;
//IT16168114
//Viraj Dissanayake
@WebServlet(name = "Validate1", urlPatterns = {"/Validate1"})
public class Validate1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = null;
        Cookie[] cookies = null;
        cookies = request.getCookies();
        String scheme=request.getScheme();
        String method=request.getMethod();
        String token = request.getParameter("token");
        if(scheme.equals("http") && method.equals("POST")) {
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    cookie = cookies[i];
                    if (cookie.getValue().equals(token)) {
                          response.sendRedirect("welcome.jsp");
                    }
                }
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}



