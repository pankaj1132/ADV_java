package batchexecution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class usingstatement {
public static void main(String[] args) {
	try {
		Class.forName("org.postgresql.Driver");
		
		String url = "jdbc:postgresql://localhost:5432/demo?user=postgres&password=pankaj123";
		
		Connection con = DriverManager.getConnection(url);
		
		
		Statement stm = con.createStatement();
		String q1 = "insert into employee values(8,'sachin' , 7097007 , 34564345445,'2020-02-20')";
		String q2 = "update employee set salary = 45658 where id =4";
		String q3="delete from employee where id=2";
		stm.addBatch(q1);
		stm.addBatch(q2);
		stm.addBatch(q3);
		
		
		int []result= stm.executeBatch();
		for(int r: result) {
			System.out.println(r);
			
		}
		
		
		
		System.out.println("connected");
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
