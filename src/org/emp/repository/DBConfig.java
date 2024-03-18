package org.emp.repository;

import java.sql.*;

//import org.emp.helper.PathHelper;


public class DBConfig {

	public Connection conn;
	public PreparedStatement stmt;
	public ResultSet rs;
	
	public DBConfig() {
//		try {
//			    Class.forName("com.mysql.cj.jdbc.Driver");
//				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeep","root","sa1234");
//				if(conn!=null) {
//					System.out.println("Database is connected......");
//				}else {
//					System.out.println("Something problem is occured......");
//				}
//				public EmployeeRepository() {
				    try {
				        Class.forName("com.mysql.cj.jdbc.Driver");
				        this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeep", "root", "sa1234");

				        if (this.conn != null) {
				            System.out.println("Database is connected......");
				        } else {
				            System.out.println("Something problem is occurred......");
				        }
				    } catch (Exception ex) {
				        System.out.println(ex.getMessage());
				    }
//		}catch(Exception ex) {
//			System.out.print("Error is"+ex);
//		}
	}
}
