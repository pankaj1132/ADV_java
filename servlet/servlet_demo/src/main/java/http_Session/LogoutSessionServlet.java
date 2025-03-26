package http_Session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logoutSession")
public class LogoutSessionServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		
		HttpSession session=req.getSession();
		session.invalidate();
		pw.println("<h1>Seems you have been logged out !!!");
		pw.println("<a href='http://localhost:8080/sevelet_demo/httpSession.html'>Home </a>");
		
		
	}

}