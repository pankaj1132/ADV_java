package urlWriting;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/urlA")
public class frista  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		PrintWriter pw = resp.getWriter();
	      resp.setContentType("text/html");
	      
	     
	      if(email.equals("pankaj@gmail.com") && password.equals("1212")) {
	    	  pw.print("<a href='urlB?email="+email+"&password="+password+"'>view details</a>");
	      }

		
		
	}
	

}
