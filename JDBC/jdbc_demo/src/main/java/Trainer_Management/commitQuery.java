package Trainer_Management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class commitQuery {
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
			String query = "insert into employee values(12,'sachin',2500)";
			int r = stm.executeUpdate(query);
			con.commit();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
