package sendRedirect;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/send")
public class send extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	 String choice = req.getParameter("choice");
	 
	 if(choice.equals("insta")) {
		 resp.sendRedirect("https://www.instagram.com/");
	 }
	 else if(choice.equals("greet")) {
		 resp.sendRedirect("greet.html");
	 }
	 else if(choice.equals("index")) {
		 resp.sendRedirect("index.jsp");
	 }
	 else  if(choice.equals("servlet")) {
		 resp.sendRedirect("serv");
	 }
	}

}
