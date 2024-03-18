package org.emp.repository;
import org.emp.model.AttendanceModel;
import org.emp.model.EmployeeModel;

import java.util.*;
import java.sql.*;
public class AttendanceRepository extends DBConfig{
	public boolean addservice(int empid, int p, AttendanceModel al) {
		try {
			stmt = conn.prepareStatement("insert into attendance values(?,?,?,?,?)");
			stmt.setInt(1, al.getEmpid());
			stmt.setString(2,String.valueOf(p));
			stmt.setString(3, al.getAdate());
			stmt.setString(4, al.getInTime());
			stmt.setString(5, al.getOutTime());
			int val=stmt.executeUpdate();
			if(val>0)
			{
				return true;
			}
			else
			{
				return false;
			}	
		} catch (Exception e) {
			System.out.println("Attendance Repo Error--"+e);
		}
		return false;
	}

	public boolean isAttedance(AttendanceModel amodel) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public List<EmployeeModel> getAttendance() {
		List<EmployeeModel> attendlst=new ArrayList();
		try {
			stmt = conn.prepareStatement("select *from Employee1");
			rs = stmt.executeQuery();
			while (rs.next()) {
				AttendanceModel em = new AttendanceModel();
				em.setEmpid(rs.getInt(1));
				em.setFname(rs.getString(2));
//				em.setLname(rs.getString(3));
//				em.setJoinDate(rs.getString(4));
//				em.setContact(rs.getString(5));
//				em.setEmail(rs.getString(6));
//				attendlst.addAll(em);
			}
			return attendlst.size() > 0 ? attendlst : null;

		} catch (Exception ex) {
			System.out.println("Error is" + ex);
			return null;
		}
	}
	
	
}
