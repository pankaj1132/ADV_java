package servlet_life_cycle;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/lifecycle")
public class LifeCycleServlet extends GenericServlet{

	// static memebers
	static String static_var = "This is static variable";
	
	String non_static_var = "This is static variable";
	
	
	public static void staticMethod() {
		System.out.println("this is static method");
	}
	
	

	public  void nonStaticMethod() {
		System.out.println("this is non static method");
	}
	
	
	static {
		
		staticMethod();
		System.out.println("static_var : " + static_var);
		
	}
	
	
	{
		
		nonStaticMethod();
		System.out.println("non-static_var : " + non_static_var);
		
		
	}
	
	
	public LifeCycleServlet() {
		System.out.println("Constructor is executed");
	}
	
	
	@Override
	public void init() throws ServletException {
		System.out.println("Init() method is executed");
	}
	
	
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("service() is executed");
		
	}
	
}
