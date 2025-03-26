 package hidden;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/hiddenB")
public class HiddenFormB extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name = req.getParameter("name");
	String dob = req.getParameter("dob");
	String phone = req.getParameter("phone");
	String email = req.getParameter("email");
	
	PrintWriter pw = resp.getWriter();
resp.setContentType("text/html");


pw.println("user Detail::");
pw.println("nmae::" +name );
pw.println("email::"+email);
pw.println("dob::"+dob);
pw.println("phone::"+phone);

}
}
