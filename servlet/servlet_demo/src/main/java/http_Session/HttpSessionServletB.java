package http_Session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionB")
public class HttpSessionServletB extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HttpSession session=req.getSession();
		Student s=(Student)session.getAttribute("student");
		
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		
		pw.println("<h2> Name :"+s.getName()+"</h2>");
		pw.println("<h2> Id :"+s.getId()+"</h2>");
		pw.println("<h2> Percentage :"+s.getPercentage()+"</h2>");
		
	}

}