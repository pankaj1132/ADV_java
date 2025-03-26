package request_dispacher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class with_include extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 int id = Integer.parseInt(req.getParameter("id"));
		 String password =req.getParameter("pass");
		 
		 PrintWriter pw = resp.getWriter();
			
			resp.setContentType("text/html");
			
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			if(id == 101 && password.equals("admin124")) {
				rd.include(req, resp);
				pw.print("login succes");
				
				
			}
			else {
				rd.include(req, resp);
				pw.print("login failed");
				
			}
	}

}
