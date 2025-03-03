package Connection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class connectionProperties {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			
			FileInputStream fis = new FileInputStream("D:\\ADD JAVA\\JDBC\\jdbc_demo\\src\\main\\resources\\data.properties");
			
			Properties p = new Properties();
			p.load(fis);
			String url = p.getProperty("url");
			Connection c = DriverManager.getConnection(url,p);
			
			System.out.println("connected");
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

