package servlet_Context;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/contextA")
public class servletA extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext context = req.getServletContext();
		
		String id = context.getInitParameter("id");
		String name = context.getInitParameter("name");
		String perc = context.getInitParameter("percentage");
		
		
		context.setAttribute("message", "hello");
		Cricketer c = new Cricketer(18,"virat");
		
		context.setAttribute("cricketer", c);
		
		PrintWriter pw = resp.getWriter();
		
		pw.println("id  :  "  + id);
		pw.println("name :::"  + name);
		pw.println("");
		
		
	}

}
