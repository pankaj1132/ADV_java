package genric_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EmployeeServlet extends  GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String dob =req.getParameter("dob");
		Long phone = Long.parseLong(req.getParameter("phone"));
		String  gender= req.getParameter("gender");
		String []skills=req.getParameterValues("skills");
		
		PrintWriter pw = res.getWriter();
	
		res.setContentType("text/html");
		pw.println("<h1> Employee data: </h1>");
		pw.println("<h1> Employee id:" + id);
		pw.println("<h1> Employee Nmae :"+name);
		pw.println("<h1> Employee dob:" + dob);
		pw.println("<h1> Employee phone :"+ phone);
		pw.println("<h1> Employee gender : " +gender);
		pw.println("<h1> Employee skills :");
		for(String s :skills) {
			pw.println("<h3>" + s + "</h3>");
		}
	}

}
