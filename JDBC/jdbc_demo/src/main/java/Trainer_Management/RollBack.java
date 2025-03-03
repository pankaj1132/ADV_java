package Trainer_Management;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RollBack {
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
			String query1 = "delete from employee  where id =8";
			String query2 = "delete from employee  where id =7";
			String query3 = "delete from employee  where id =10";
			int r1=stm.executeUpdate(query3);
			int r2=stm.executeUpdate(query1);
			int r3 =stm.executeUpdate(query2);
			
			if(r1>0 && r2>0 && r3>0) {
				con.commit();
				System.out.println("connection");
			}
			else {
				con.rollback();
				System.out.println("failed");
			}
			con.commit();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
