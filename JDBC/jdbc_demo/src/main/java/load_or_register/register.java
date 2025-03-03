package load_or_register;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.Driver;

public class register {
	public static void main(String[] args) {
		Driver d = new Driver ();
		try {
			DriverManager.registerDriver(d);
			System.out.println("registered successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
