package load_or_register;

public class load {
public static void main(String[] args) {
	
	try {
		Class.forName("org.postgresql.Driver");
		System.out.println("load successfully");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
