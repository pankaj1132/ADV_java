package controller;

import java.util.List;
import java.util.Scanner;

import models.dao.EmployeeDao;
import models.entity.Employee;

public class employeeController {
	private Employee emp=new Employee();
	private EmployeeDao Edao =new EmployeeDao();
	
//	All admin method start
	public boolean validateAdmin() {
		Scanner sc=new Scanner(System.in);
		emp=new Employee();
		System.out.println("Enter id:");
		int id=sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter password");
		String password=sc.nextLine();
		emp.setId(id);
		emp.setPassword(password);
		
		return Edao.validateAdmin(emp);
		
	}
	
	public boolean addEmployee() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter name:");
		String name=sc.nextLine();
		
		System.out.println("Enter salary:");
		double salary=sc.nextDouble();
		
		System.out.println("Enter phone:");
		long phone=sc.nextLong();
		sc.nextLine();
		
		System.out.println("Enter password:");
		String password=sc.nextLine();
		
		System.out.println("Enter role:");
		String role=sc.nextLine();
		
		Employee emp=new Employee(name,salary,phone,password,role);
		
		return Edao.addEmployee(emp);
		
	}
	
	public Employee getEmployee() {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter id:");
			int id=sc.nextInt();
			return Edao.getEmployee(id);
			
	}
	
//	public boolean updateEmployee() {
//		System.out.println("Enter id:");
//		Scanner sc=new Scanner(System.in);
//		int id=sc.nextInt();
//		return Edao.updateEmployee(id);
//	}

	public boolean deleteEmployeeById() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id:");
		int id=sc.nextInt();
		return Edao.deleteEmployeeById(id);
	}
	
	public List<Employee> ShowAllEmployee(){
		return Edao.showAllEmployee();
	}
	
	public boolean updateEmployee() {
		Scanner sc=new Scanner(System.in);
		Employee existing =this.getEmployee();
		if(existing==null) {
			return false;
		}
		System.out.println(existing);
		
		System.out.println("Enter name:");
		String name=sc.nextLine();
		
		System.out.println("Enter salary");
		String salary=sc.nextLine();
		
		System.out.println("Enter phone");
		String phone=sc.nextLine();
		
		System.out.println("Enter password");
		String password=sc.nextLine();
		
		System.out.println("Enter role");
		String role=sc.nextLine();
		
		if(!name.isEmpty()) {
			existing.setName(name);
		}
		if(!salary.isEmpty()) {
			existing.setSalary(Double.parseDouble(salary));
		}
		if(!phone.isEmpty()) {
			existing.setPhone(Long.parseLong(phone));
		}
		if(!password.isEmpty()) {
			existing.setPassword(password);
		}
		if(!role.isEmpty()) {
			existing.setRole(role);
		}
		return Edao.updateEmployee(existing);
		
		
	}
	
	//all admin method end 
	
	//all employee method start
	public boolean validateEmployee() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id:");
		int id=sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter password:");
		String password=sc.nextLine();
		
		emp.setId(id);
		emp.setPassword(password);
		
		//setting the employee data
		boolean result= Edao.validateEmployee(emp);
		
		if(result) {
			emp=Edao.getEmployee(id);
		}
		return result;
		
	}
	
	
	public Employee  showEmployeeData() {
		return this.emp;
	}

	public boolean udpateMydata() {
		
		System.out.println(emp);
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter name:");
		String name=sc.nextLine();
		
		System.out.println("Enter salary:");
		String salary=sc.nextLine();
		
		System.out.println("Enter phone:");
		String phone=sc.nextLine();
		
		System.out.println("Enter password:");
		String password=sc.nextLine();
		
		System.out.println("Enter role:");
		String role=sc.nextLine();
		
		if(!name.isEmpty()) {
			emp.setName(name);
		}
		if(!salary.isEmpty()) {
			emp.setSalary(Double.parseDouble(salary));
		}
		if(!phone.isEmpty()){
			emp.setPhone(Long.parseLong(phone));
		}
		if(!password.isEmpty()) {
			emp.setPassword(password);
		}
		if(!role.isEmpty()) {
			emp.setRole(role);
		}
		
		return Edao.updateEmployee(emp);
		
	}

	
	public static void  main(String[]argu) {
		employeeController empcon =new employeeController();
		
//		System.out.println(empcon.validateAdmin());
//		System.out.println(empcon.addEmployee());
//		System.out.println(empcon.getEmployee());
		
//		System.out.println(empcon.updateEmployee());
		
//		System.out.println(empcon.deleteEmployeeById());
		
//		List<Employee> data=empcon.ShowAllEmployee();
//		
//		for(Employee d:data) {
//			System.out.println(d);
//		}
		
//		System.out.println(empcon.updateEmployee());
		
//		System.out.println(empcon.validateEmployee());
//		empcon.showEmployeeData();
//		System.out.println(empcon.udpateMydata());
		
	}
	
	
}