package Trainer_Management;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class savepoint {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			
			String url = "jdbc:postgresql://localhost:5432/demo";
			String user = "postgres";
			String password="pankaj123";
			
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("connected");
			con.setAutoCommit(false);
			Statement stm = con.createStatement();
			String q1= "insert into employee values (21 , 'hemant',32321)";
			String q2= "insert into employee values (22 , 'ravi',32324431)";
			String q3= "insert into employee values (23 , 'sahil',66632321)";
			System.out.println(stm.executeUpdate(q1));
			Savepoint sp =  con.setSavepoint();
			System.out.println(stm.executeUpdate(q2));
			
			System.out.println(stm.executeUpdate(q3));
			
			con.rollback(sp);
			con.commit();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
