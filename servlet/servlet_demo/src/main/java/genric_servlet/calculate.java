package genric_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class calculate extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        int num1 = Integer.parseInt(req.getParameter("num1"));
        int num2 = Integer.parseInt(req.getParameter("num2"));
        String[] operation = req.getParameterValues("operations"); // Corrected typo

        PrintWriter pw = res.getWriter();
        res.setContentType("text/html");

        if (operation == null) {
            pw.println("No operations selected.");
            return;
        }

        for (String s : operation) {
            

            if (s.equals("add")) {
                pw.println("<h1>Adding value 1 and value 2 is " + (num1 + num2));
            }
            if (s.equals("sub")) {
                pw.println("<h1>Subtraction of value 1 and value 2 is " + (num1 - num2));
            }
            if (s.equals("mul")) {
                pw.println("<h1>Multiple of value 1 and value 2 is " + (num1 * num2));
            }
            if (s.equals("div")) {
                if (num2 != 0) {
                    pw.println("<h1>Division of value 1 and value 2 is " + (num1 / num2));
                } else {
                    pw.println("Cannot be divided by zero");
                }
            }
        }
    }
}