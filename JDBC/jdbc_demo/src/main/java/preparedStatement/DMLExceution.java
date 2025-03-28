package preparedStatement;

import java.io.FileInputStream;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class DMLExceution {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			
			FileInputStream fis = new FileInputStream("D:\\ADD JAVA\\JDBC\\jdbc_demo\\src\\main\\resources\\data.properties");
			
			Properties p = new Properties();
			p.load(fis);
			String url = p.getProperty("url");
			Connection c = DriverManager.getConnection(url,p);
			
			
			System.out.println("connected");
			
			String s = "insert into employee values(?,?,?,?,?)";
			PreparedStatement ps = c.prepareStatement(s);
			
			Scanner sc = new Scanner(System.in);
			System.out.println("enter id");
			int id = sc.nextInt();
			sc.nextLine();
			
			
			System.out.println("enter name");
			String name= sc.nextLine();
			
			System.out.println("enter salary");
			double salary= sc.nextDouble();
			sc.nextLine();
			
			System.out.println("enter mobileno");
			Long phone= sc.nextLong();
			sc.nextLine();
			
			System.out.println("enter date");
			String doj = sc.nextLine();
;			
			
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setDouble(3, salary);
			ps.setLong(4, phone);
			ps.setDate(5 ,Date.valueOf(doj));
			
			int rs=ps.executeUpdate();
			if (rs>0) {
				System.out.println("executed");
			} else {
                System.out.println("failed");
			}

			
			
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
