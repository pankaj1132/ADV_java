 package hidden;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/hiddenA")
public class HiddenFormA  extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name = req.getParameter("name");
	String dob= req.getParameter("dob");
	
	PrintWriter pw = resp.getWriter()
;
	resp.setContentType("text/html");
	
	pw.println("<form action='hiddenB' method='post'>");
	
	
	pw.println("email:<input type='email' name='email'><br>");
	pw.println("email:<input type='email' name='email'><br>");
	pw.println("<input type='hidden' name='name' value ='"+name+"'><br>");
	pw.println("<input type='hidden' name='dob'  value ='"+dob+"'><br>");
	
	
	pw.println("<input type='submit'>");
	pw.println("</form>");
}
}
