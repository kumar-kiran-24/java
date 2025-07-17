import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CookieDemo")
public class CookieDemo extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Check if cookie already exists
        Cookie[] cookies = request.getCookies();
        boolean found = false;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    found = true;
                    out.println("<h2>Welcome back, " + cookie.getValue() + "!</h2>");
                }
            }
        }

        // If not found, create a new cookie
        if (!found) {
            Cookie cookie = new Cookie("username", "kiran");
            cookie.setMaxAge(24 * 60 * 60); // 1 day
            response.addCookie(cookie);
            out.println("<h2>Cookie created. Reload the page to see it read.</h2>");
        }
    }
}
