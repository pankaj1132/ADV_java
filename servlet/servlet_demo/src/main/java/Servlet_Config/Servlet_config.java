package Servlet_Config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet_config extends HttpServlet {
	
	String  url;
	String user;
	String password;
	
	@Override
	public void init() throws ServletException {
		ServletConfig con = getServletConfig();
		 url = con.getInitParameter("url");
		user = con.getInitParameter("user");
		password = con.getInitParameter("password");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	PrintWriter pw = resp.getWriter();
	pw.println("url : "+ url);
	pw.println("user : "+ user);
	pw.println("password : "+ password);
	}

}
