package request_dispacher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/result_prec")
public class result_perc  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		
		resp.setContentType("text/html");
		
		
		String Name =req.getParameter("name");
		Double prec=(Double)req.getAttribute("precentage");
		pw.println("<h1> Name:  " + Name);
		pw.println("<h1> Prec:  " + prec);
		if(prec>33) {
		
			pw.println("<h1> result pass" );
			
		}
		else {
			pw.println("<h1> fail");
		}
	}
	

}
