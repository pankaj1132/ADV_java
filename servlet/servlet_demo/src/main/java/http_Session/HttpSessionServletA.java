package http_Session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionA")
public class HttpSessionServletA extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String name=req.getParameter("name");
		int id=Integer.parseInt(req.getParameter("id"));
		double percentage=Double.parseDouble(req.getParameter("percentage"));
		
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		
		
		
		HttpSession session= req.getSession();
		Student s=new Student(id,name,percentage);
		session.setAttribute("student",s);
		
		pw.println("<a href='sessionB'>View Details</a><br>");
		pw.println("<a href='logoutSession'>Log Out</a><br>");
		
	}

}
