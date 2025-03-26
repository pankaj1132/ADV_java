package views;

import java.util.List;
import java.util.Scanner;

import controller.employeeController;
import models.entity.Employee;

public class Run {
	static Scanner sc=new Scanner(System.in);
	static employeeController controller=new employeeController();
	public static void main(String[]argu) {
		System.out.println("============start Employee management system=====================");
		boolean condition=true;
		while(condition) {
			System.out.println("1.Admin Access");
			System.out.println("2.Employee Access");
			System.out.println("3.Exit");
			System.out.println("Enter your choice");
			int choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
				case 1:{
						if(controller.validateAdmin()) {
							boolean innerCondtion=true;
							while(innerCondtion) {
								System.out.println("Access granted");
								System.out.println("1.To insert Employee");
								System.out.println("2.To delete Employee");
								System.out.println("3.To update Employee");
								System.out.println("4.To Show all Employee");
								System.out.println("5.exit");
								System.out.println("Enter your Choice");
								int innerChoice = sc.nextInt();
								sc.nextLine();
								switch(innerChoice) {
									case 1:{
										if(controller.addEmployee()) {
											System.out.println("Record inserted successfully");
										}
										else {
											System.out.println("Fail to insert Record");
										}
										break;
									}
									case 2:{
										if(controller.deleteEmployeeById()) {
											System.out.println("Record deleted successfully");
										}
										else {
											System.out.println("Fail to delete Record");
										}
										break;
									}
									case 3:{
										if(controller.updateEmployee()) {
											System.out.println("Record updated successfully");
										}
										else {
											System.out.println("Fail to update Record");
										}
										break;
										
									}
									case 4:{
										List<Employee> data=controller.ShowAllEmployee();
										if(data!=null) {
											for(Employee e:data) {
												System.out.println(e);
											}
										}
										else {
											System.out.println("Fail to fetch Records");
										}
										break;
										
									}
									case 5:{
										innerCondtion=false;
										break;
									}
									default:
										System.out.println("Invalid choice");
								}
							}
						}else {
							System.out.println("Access denies");
						}
						break;
					}
				case 2:{
						if(controller.validateEmployee()) {
							boolean innerCondition=true;
							while(innerCondition) {
								System.out.println("Access granted");
								System.out.println("1.Show my data");
								System.out.println("2.Update my data");
								System.out.println("3.Exit");
								int innerChoice =sc.nextInt();
								switch(innerChoice) {
									case 1:{
										System.out.println(controller.showEmployeeData());
										break;
									}
									case 2:{
										if(controller.udpateMydata()) {
											System.out.println("your data updated");
										}else {
											System.out.println("your data cannot be update");
										}
										break;
									}
									case 3:{
										innerCondition=false;
										break;
									}
										
									default:
										System.out.println("Invalid choice");
								}
							}
						}
						else {
							System.out.println("Access denied");
						}
						break;
				    }
				case 3:{
						condition=false;
						break;
					}
				default:
					System.out.println("Invalid choice");
			}
		}
		
		System.out.println("============end Employee management system=====================");
	}
}