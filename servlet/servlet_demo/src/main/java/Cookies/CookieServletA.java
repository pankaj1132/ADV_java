package Cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieA")
public class CookieServletA extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        PrintWriter pw = resp.getWriter();
        resp.setContentType("text/html");

        Cookie cookie_name = new Cookie("name", name);
        Cookie cookie_email = new Cookie("email", email);
        Cookie cookie_password = new Cookie("password", password);

        resp.addCookie(cookie_name);
        resp.addCookie(cookie_email);
        resp.addCookie(cookie_password);

        pw.println("<a href='cookieB'>View User Details</a><br>");
        pw.println("<a href='cookie_logout'>Logout</a>");
    }
}
