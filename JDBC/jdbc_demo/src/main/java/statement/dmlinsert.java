package statement;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class dmlinsert {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			
			String url = "jdbc:postgresql://localhost:5432/demo?user=postgres&password=pankaj123";
			
			Connection con = DriverManager.getConnection(url);
			
			
			System.out.println("connected");
			
		
			Statement s  =con.createStatement();
		String Query = "insert into employee values (3,'sahil',49000,987343377,'2021-01-10')";
			boolean result = s.execute(Query);
			System.out.println(result);
		
			
			
			
//			Statement s  =con.createStatement();
//			String Query = "insert into employee values (2,'tarun',8000,876877877,'2023-09-18')";
//			int result = s.executeUpdate(Query);
//			System.out.println(result);
//			if(result>0) {
//				System.out.println("created");
//				
//			}
//			else {
//				System.out.println("failed");
//			}
			
			
//			
//			Statement s  =con.createStatement();
//			String Query = "update employee SET salary=30000 where id =2";
//			int result = s.executeUpdate(Query);
//			System.out.println(result);
//			if(result>0) {
//				System.out.println("created");
//				
//			}
//			else {
//				System.out.println("failed");
//			}
			
			
			
			

//			Statement s  =con.createStatement();
//			String Query = "delete from employee where id =2";
//			int result = s.executeUpdate(Query);
//			System.out.println(result);
//			if(result>0) {
//				System.out.println("deleted");
//				
//			}
//			else {
//				System.out.println("failed");
//			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
