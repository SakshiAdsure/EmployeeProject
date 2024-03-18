package org.emp.repository;

import java.sql.*;
import java.util.*;
//import java.util.Date;

import org.emp.model.EmployeeModel;

public class EmployeeRepository extends DBConfig {
	List<EmployeeModel> listEmployee = new ArrayList<EmployeeModel>();

	public boolean isAddEmployee(EmployeeModel model) {
//		System.out.println(model);
		try {

			stmt = conn.prepareStatement("insert into Employee1 values('0',?,?,?,?,?)");

			stmt.setString(1, model.getFname());
			stmt.setString(2, model.getLname());
			stmt.setString(3, model.getJoinDate());
			stmt.setString(4, model.getContact());
			stmt.setString(5, model.getEmail());

			int value = stmt.executeUpdate();
//			System.out.println("value is" + value);
			if (value > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			System.out.println("Error is" + ex.getMessage());
			return false;
		}
	}

//	Search logic
	public boolean isEmployeePresent(String empName) {
		try {
			stmt = conn.prepareStatement("select *from Employee1 where Fname=?");
			stmt.setString(1, empName);
			rs = stmt.executeQuery();
			return rs.next();

		} catch (Exception ex) {
			System.out.println("Error is" + ex);
			return false;
		}
	}
	

//	view employee
	public List<EmployeeModel> getAllEmployees() {
		List<EmployeeModel> lst=new ArrayList();
		try {
			stmt = conn.prepareStatement("select *from Employee1");
			rs = stmt.executeQuery();
			while (rs.next()) {
				EmployeeModel em = new EmployeeModel();
				em.setEmpid(rs.getInt(1));
				em.setFname(rs.getString(2));
				em.setLname(rs.getString(3));
				em.setJoinDate(rs.getString(4));
				em.setContact(rs.getString(5));
				em.setEmail(rs.getString(6));
				lst.add(em);
			}
			return lst.size() > 0 ? lst : null;

		} catch (Exception ex) {
			System.out.println("Error is" + ex);
			return null;
		}
	}

//	delete

	public int isDeleteEmployee(int did) {
		try {
			stmt = conn.prepareStatement("delete from Employee1 where empid=?");
			stmt.setInt(1, did);
//			rs=stmt.executeQuery();
//			return rs.next();

			int result = stmt.executeUpdate();
			if (result > 0) {
				System.out.println("Employee deleted successfully....");
			} else {
				System.out.println("Something problem is there...");
			}

		} catch (Exception ex) {
			System.out.println("Error is " + ex);
//			return did;
		}
		return did;
	}

	public int isUpdateEmployee(EmployeeModel empModel) {
		try {
//			fname=?,lname=?,joinDate=?,contact=?,email=?
			stmt = conn.prepareStatement("update Employee1 set fname=?,lname=?,joinDate=?,contact=?,email=? where id=?");
		
			stmt.setString(1, empModel.getFname());
			stmt.setString(2, empModel.getLname());
			stmt.setString(3, empModel.getJoinDate());
			stmt.setString(4, empModel.getContact());
			stmt.setString(5, empModel.getEmail());
			stmt.setInt(6, empModel.getEmpid());

			int result = stmt.executeUpdate();
//			return result > 0 ? 1 : 0;
			if(result>0) {
				System.out.println("Employee updated successfully....");
			}else {
				System.out.println("Something problem is there...");
			}

		} catch (Exception ex) {
			System.out.println("Error is " + ex);
//			return did;
		}
		return 0;

	}

}
