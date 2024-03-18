package org.emp.clientApp;

import java.util.*;

import org.emp.model.AttendanceModel;
import org.emp.model.EmployeeModel;
import org.emp.repository.EmployeeRepository;
import org.emp.service.AttendanceService;
import org.emp.service.EmployeeService;
import java.io.*;
import java.sql.Date;

public class EmployeeApp {
	public static void main(String[] args) {
		EmployeeService ms = new EmployeeService();
		AttendanceService as = new AttendanceService();

		Scanner sc = new Scanner(System.in);

		System.out.println("Please enter username ans password");
		String username = sc.nextLine();
		String password = sc.nextLine();

		if (username.equals("admin") && password.equals("admin")) {
			System.out.println("Authentication Successfull");

			do {
				int choice;
				System.out.println("case1: Add employee");
				System.out.println("case2: Attendance of employee");
				System.out.println("Enter your choice");
				choice = sc.nextInt();
				switch (choice) {

				case 1:
					sc.nextLine();
					// 1. Add New Employee /View/Delete/Update/Search Employee

					System.out.println("Enter employee id, first name,last name,joinDate,contact and email");
					/* int empid=sc.nextInt(); */
//					String dateformat = sc.nextLine();
					String fname = sc.nextLine();
					String lname = sc.nextLine();
					String dateformat = sc.nextLine();
					String contact = sc.nextLine();
					String email = sc.nextLine();

					EmployeeModel model = new EmployeeModel();
					/* model.setEmpid(empid); */
					model.setFname(fname);
					model.setLname(lname);
					model.setJoinDate(dateformat);
					model.setContact(contact);
					model.setEmail(email);
					int result = ms.isAddEmployee(model);

					if (result == 1) {
						System.out.println("Employee added..");
						do {
							System.out.println("case 1:View employee");
							System.out.println("case 2:Delete employee");
							System.out.println("case 3:Update employee");
							System.out.println("case 4:Search employee");

							System.out.println("Enter your choice");
							int ch = sc.nextInt();

							switch (ch) {

							case 1:
//								view
								sc.nextLine();
								List<EmployeeModel> list = ms.getAllEmployees();
								System.out.println("All information about employee");
								for (EmployeeModel em : list) {
									System.out.println(em.getEmpid() + "\t" + em.getFname() + "\t" + em.getLname()
											+ "\t" + em.getJoinDate() + "\t" + em.getContact() + "\t" + em.getEmail());
								}
								break;

							case 2:
//								delete
								sc.nextLine();
								EmployeeModel em = new EmployeeModel();
								System.out.println("Enter employee id to delete");
								int did = sc.nextInt();
								int result1 = ms.isDeleteEmployee(did);

								break;

							case 3:
//								update
								sc.nextLine();
								System.out.println("Enter employee id to Update employee");
								did = sc.nextInt();
								System.out.println("Enter employee fname ,lname,joinDate, contact and email");
//								int id = sc.nextInt();
								String Fname = sc.nextLine();
								String Lname = sc.nextLine();
								String joinDate = sc.nextLine();
								String Contact = sc.nextLine();
								String Email = sc.nextLine();

								EmployeeModel empModel = new EmployeeModel();
								empModel.setFname(fname);
								empModel.setLname(lname);
								empModel.setJoinDate(joinDate);
								empModel.setContact(contact);
								empModel.setEmail(email);

								result = ms.isUpdateEmployee(empModel);

								break;

							case 4:
//											sc.nextLine();
//											
//											EmployeeService es = new EmployeeService();
//											
//											System.out.println("Enter employee name for search");
//											sc.nextLine();
//											String name=sc.nextLine();
//											
//											es.isEmployeePresent(name);
//											
//										try {
//											boolean isEmployeePresent = EmployeeRepository.isEmployeePresent(name);
//										} catch (Exception e) {
//											// TODO Auto-generated catch block
//											e.printStackTrace();
//										}
//										
//											boolean check = ms.isEmployeePresent(name);
//											if(check==true) {
//												return name;
//											}else {
//												return false;
//											}
								break;

							default:
								System.out.println("Enter correct choice");
								break;

							}
						} while (true);
					} else {
						System.out.println("Employee not added...");
					}

				case 2:
//					Take attendance of employee
					sc.nextLine();
					
					System.out.println("Enter employee id");
					int empid=sc.nextInt();
					System.out.println("Enter Employee Present or not");
					sc.nextLine();
					String presenti = sc.nextLine();
					System.out.println("Enter Employee In Time  And Out Time and Data");
					String in_time = sc.nextLine();
					String out_time = sc.nextLine();
					String data = sc.nextLine();

					AttendanceModel al = new AttendanceModel(empid,data, in_time, out_time);

					AttendanceService atte_setv = new AttendanceService();
					boolean b = atte_setv.addservice(empid, presenti,  al);
					if (b) {
						System.out.println("Added Sucsess.........");
					} else {
						System.out.println("Not Attendance Sucsess........");
					}
					
					sc.nextLine();
					
					System.out.println("case1:View attendace of employee");
					int attend = sc.nextInt();
					
					switch(attend) {
						
					case 1:
//						// View attendance of employee
//						List<AttendanceModel> alist =as.getAttendanceEmployee();
//						System.out.println("Attendance of employee");
//						for (AttendanceModel as1 : alist) {
//							System.out.println(as1.getEmpid() + "\t" + as1.getFname() + "\t" + em.getLname() + "\t" + em.getJoinDate()
//									+ "\t" + em.getContact() + "\t" + em.getEmail());
//						}
						
						break;
					}
					

					break;

				case 3:
//					Calculate salary of employee

					break;

				default:
					System.out.println("Enter wrong choice");
					break;
				}
			} while (true);
		} else {
			System.out.println("Authentication failed");
			System.out.println("Please enter correct username and password");

		}

	}

}
