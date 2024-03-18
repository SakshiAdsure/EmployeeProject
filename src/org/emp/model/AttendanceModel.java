package org.emp.model;

import java.sql.Date;

public class AttendanceModel {
	
	private int empid;
	private String Adate;
	private String InTime;
//	private String fname;


	public AttendanceModel( int empid, String adate, String inTime, String outTime) {
		super();
		this.empid = empid;
//		this.fname=fname;
		Adate = adate;
		InTime = inTime;
		OutTime = outTime;
		//Status = status;
	}

	private String OutTime;
	private String Status;
	public AttendanceModel() {

	}
	
//	public String getFname() {
//		return fname;
//	}
//
//	public void setFname(String fname) {
//		this.fname = fname;
//	}
	
	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getAdate() {
		return Adate;
	}

	public void setAdate(String adate) {
		Adate = adate;
	}

	public String getInTime() {
		return InTime;
	}

	public void setInTime(String inTime) {
		InTime = inTime;
	}

	public String getOutTime() {
		return OutTime;
	}

	public void setOutTime(String outTime) {
		OutTime = outTime;
	}

	public int getFname() {
		// TODO Auto-generated method stub
		return 0;
	}

}
