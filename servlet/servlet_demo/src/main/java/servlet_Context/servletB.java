package servlet_Context;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/contextB")
public class servletB  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext context = req.getServletContext()
;
		
	
		String message=(String)context.getAttribute("message");
		Cricketer c=(Cricketer)context.getAttribute("cricketer");
		
		PrintWriter pw = resp.getWriter();
		pw.println("message::"+  message);
		pw.println("name::"+  c.getName());
		pw.println("id::"+  c.getId());
		
	}

}
