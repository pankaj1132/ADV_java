package urlWriting;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/urlB")
public class secondb extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		
		PrintWriter pw = resp.getWriter();
	      resp.setContentType("text/html");
	      
	      pw.println("<h1> email"+email);
	      pw.println("<h1> password"+password);
	      
	}

}
