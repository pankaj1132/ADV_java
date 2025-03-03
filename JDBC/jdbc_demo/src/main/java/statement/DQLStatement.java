package statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DQLStatement {
public static void main(String[] args) {
	try {
		Class.forName("org.postgresql.Driver");
		String url = "jdbc:postgresql://localhost:5432/demo?user=postgres&password=pankaj123";
		
		Connection con = DriverManager.getConnection(url);
		
		
		System.out.println("connected");
		
		
//		Statement stm = con.createStatement();
//		String q = "select * from employee";
//		boolean result = stm.execute(q);
//		ResultSet r = stm.getResultSet();
//		while(r.next()) {
//			System.out.println(r.getInt(1)+ "  "+ r.getString(2)+" "+r.getDouble(3)+" "+r.getLong(4)+" "+r.getString(5));
//		}
		
		
		
//		using executequery ()
		
		Statement stm = con.createStatement();
		String q = "select * from employee where id=1";
		
		ResultSet r = stm.executeQuery(q);
		while(r.next()) {
			System.out.println(r.getInt("id")+ "  "+ r.getString("name")+" "+r.getDouble("salary")+" "+r.getLong("phone")+" "+r.getString("doj"));
		}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}

}
