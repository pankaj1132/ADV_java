package models.entity;

public class Employee {
	
	private int id;
	private String name;
	private double salary;
	private Long phone;
	private String password;
	private String role;
	
	public Employee() {}
	public Employee(int id, String name, double salary, Long phone, String password, String role) {
		this(name , salary , phone , password , role);
		this.id = id;
		
	}
	public Employee( String name, double salary, Long phone, String password, String role) {
		super();
		
		this.name = name;
		this.salary = salary;
		this.phone = phone;
		this.password = password;
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", phone=" + phone + ", password="
				+ password + ", role=" + role + "]";
	}
	
	
	
	

}
