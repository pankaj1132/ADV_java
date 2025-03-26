package models.dao;
import java.sql.Statement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import models.entity.Employee;

public class EmployeeDao {
	
	FileInputStream fis;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	Statement stm;
//	non static initializer
	{
		
		try {
			fis=new FileInputStream("D:\\ADD JAVA\\JDBC\\epmolyee_maangement_sys\\src\\main\\resources\\data.properties");
		    //step1:load or register driver
			Properties property=new Properties();
			property.load(fis);
			
			String driver=property.getProperty("driver");
			Class.forName(driver);
			
//			Step2:connetion to database
			String url=property.getProperty("url");
			con=DriverManager.getConnection(url,property);
			
			System.out.println("connetion done...");
			
//			step3:Statement object
			stm=con.createStatement();
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
	    } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//All Admin accessable methods 
	
	public boolean validateAdmin(Employee emp) {
		
		String query="select password ,role from employee where id=?";
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1, emp.getId());
			
			rs=ps.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("password").equals(emp.getPassword()) && rs.getString("role").equalsIgnoreCase("admin")) {
					return true;
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	public boolean addEmployee(Employee emp) {
		String query ="insert into employee(name,salary,phone,password,role) values(?,?,?,?,?)";
		try {
			ps=con.prepareStatement(query);
			
			ps.setString(1, emp.getName());
			ps.setDouble(2,emp.getSalary());
			ps.setLong(3, emp.getPhone());
			ps.setString(4, emp.getPassword());
			ps.setString(5,emp.getRole());
			
			if(ps.executeUpdate()>0) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	
	public Employee getEmployee(int id) {
		String query="select * from employee where id=?";
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			Employee emp=new Employee();
			if(rs.next()) {
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setPhone(rs.getLong("phone"));
				emp.setPassword(rs.getString("password"));
				emp.setRole(rs.getString("role"));
				
				return emp;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	
	public boolean updateEmployee(int id) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Which column you want to update:");
		String column=sc.nextLine();
		String update="update employee set "+column+"=? where id="+id;
		

		try {
			ps=con.prepareStatement(update);
			if(column.equalsIgnoreCase("id")) {
				System.out.println("id cannot be change");
				return false;
			}else if(column.equalsIgnoreCase("name")) {
				System.out.println("Enter the new value:");
				String name=sc.nextLine();
				ps.setString(1, name);
			}else if(column.equalsIgnoreCase("phone")) {
				System.out.println("Enter the new value:");
				long phone=sc.nextLong();
				ps.setLong(1, phone);
				sc.nextLine();
			}else if(column.equalsIgnoreCase("salary")) {
				System.out.println("Enter the new value:");
				double salary=sc.nextDouble();
				ps.setDouble(1, salary);
				sc.nextLine();
			}else if(column.equalsIgnoreCase("password")) {
				System.out.println("Enter the new value:");
				String password=sc.nextLine();
				ps.setString(1, password);
			}else if(column.equalsIgnoreCase("role")) {
				System.out.println("Enter the new value:");
				String role=sc.nextLine();
				ps.setString(1, role);
			}
			if(ps.executeUpdate()>0)
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteEmployeeById(int id) {
		String query="delete from employee where id=?";
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1, id);
		    if(ps.executeUpdate()>0) {
		    	return true;
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		return false;
	}

	public List<Employee> showAllEmployee(){
		List<Employee> data = new ArrayList<Employee>();
		
		String query="select * from employee";
		
		try {
			rs=stm.executeQuery(query);
			if(rs.next()) {
				do {
					data.add(new Employee(rs.getInt("id"),rs.getString("name"),rs.getDouble("salary"),
							rs.getLong("phone"),rs.getString("password"),rs.getString("role")));
				}while(rs.next());
				return data;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
		
	}

	
	public boolean updateEmployee(Employee emp) {
		String query="update employee set name=?, salary=?,phone=?,password=?,role=? where id=?";
		
		try {
			ps=con.prepareStatement(query);
			
			ps.setString(1, emp.getName());
			ps.setDouble(2, emp.getSalary());
			ps.setLong(3, emp.getPhone());
			ps.setString(4, emp.getPassword());
			ps.setString(5, emp.getRole());
			ps.setInt(6, emp.getId());
			if(ps.executeUpdate()>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return false;
	}

//	end of admin accessable method
	
//	All employee accessable method
	
	public boolean validateEmployee(Employee emp) {
		String query="select role,password from employee where id=?";
		
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1, emp.getId());
			
			rs=ps.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("password").equals(emp.getPassword()) && !rs.getString("role").equalsIgnoreCase("admin")) {
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	public Employee showEmployeeData(int id) {
		String query="select * from employee where id=?";
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1, id);
			
//			boolean s=ps.execute();
//			if(s) {
//				rs=ps.getResultSet();
//			}
			
			rs=ps.executeQuery();
			if(rs.next()) {
				Employee emp=new Employee(rs.getInt("id"),rs.getString("name"),
						rs.getDouble("salary"),rs.getLong("phone"),rs.getString("password"),rs.getString("role"));
				return emp;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public boolean updateMyData(Employee emp) {
		String query="update employee set name=?,salary=?,phone=?,password=?,role=?";
		
		try {
			ps.setString(1,emp.getName());
			ps.setDouble(2, emp.getSalary());
			ps.setLong(3,emp.getPhone());
			ps.setString(4, emp.getPassword());
			ps.setString(5, emp.getRole());
			
			if(ps.executeUpdate()>0) {
				
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	
	
	
}