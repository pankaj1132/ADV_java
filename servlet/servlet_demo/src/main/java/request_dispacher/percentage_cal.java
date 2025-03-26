package request_dispacher;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/prec")
public class percentage_cal  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		Double Physics = Double.parseDouble(req.getParameter("physics"));
		Double math = Double.parseDouble(req.getParameter("math"));
		Double chem = Double.parseDouble(req.getParameter("chem"));
		
		double prec = ((Physics + math + chem)/300)*100;
		req.setAttribute("precentage", prec);
		RequestDispatcher rd = req.getRequestDispatcher("result_prec");
		rd.forward(req, resp);
	}
	

}
