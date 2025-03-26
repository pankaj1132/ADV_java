package Cookies;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie_logout")
public class CookieLogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {
                c.setMaxAge(5);
                resp.addCookie(c);
            }
        }

        PrintWriter pw = resp.getWriter();
        resp.setContentType("text/html");
        pw.println("<a href='cookieB'>View User Details</a>");
    }
}

