package preparedStatement;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class dqlexecution {
	public static void main(String[] args) {
		
	
	try {
		Class.forName("org.postgresql.Driver");
		
		FileInputStream fis = new FileInputStream("D:\\ADD JAVA\\JDBC\\jdbc_demo\\src\\main\\resources\\data.properties");
		
		Properties p = new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		Connection c = DriverManager.getConnection(url,p);
		
		
		System.out.println("connected");
		
		String s = "select * from employee where id =?";
		PreparedStatement ps = c.prepareStatement(s);
		Scanner sc = new Scanner(System.in);
		System.out.println("enter id");
		int id = sc.nextInt();
		sc.nextLine();
		
		
		ps.setInt(1, id);
		
//		boolean r = ps.execute();
//		ResultSet rs = ps.getResultSet();
		
		
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		
	    
		
	
		
	
		System.out.println(rs.getInt(1) +" "+rs.getString("name"));
	} catch (ClassNotFoundException | IOException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}