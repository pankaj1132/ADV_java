package batchexecution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class preparedSTATement {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			
			String url = "jdbc:postgresql://localhost:5432/demo?user=postgres&password=pankaj123";
			
			Connection con = DriverManager.getConnection(url);
			
			String q = "delete from employee where id =?";
			PreparedStatement p = con.prepareStatement(q);
			Scanner s = new Scanner (System.in);
			System.out.println("enter id");
			int id = s.nextInt();
			s.nextLine();
			
			p.setInt(1, id);
			p.addBatch();
			
			
			
			System.out.println("enter id");
			int id2 = s.nextInt();
			s.nextLine();
			
			p.setInt(1, id2);
			p.addBatch();
			
			
			int []result = p.executeBatch();
			for (int r:result) {
				System.out.println(r);
			}
			
			
			System.out.println("connected");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
