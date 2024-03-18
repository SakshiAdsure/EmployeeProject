package org.emp.service;
import java.util.List;

import org.emp.model.AttendanceModel;
import org.emp.repository.AttendanceRepository;


public class AttendanceService {
	AttendanceRepository aRepo = new AttendanceRepository();
//	
//	public boolean isAttedance(AttendanceModel amodel) {
//		
//		return (aRepo.isAttedance(amodel));
//	}

	
	private int checkPresenti(String presenti) {
	
		if(presenti.equals("yes"))
		{
			return 1;
		}
		else
		{
		return 0;
		}
	}
	
	
//	public boolean addservice(AttendanceModel al, String fname, String presenti,int empid) {
//		
//		int p=checkPresenti(presenti);// 1
//		//System.err.println("==============>"+p);
//		return aRepo.addservice(empid,al,fname,p);
//	}


	public List<AttendanceModel> getAttendanceEmployee() {
		
		return null;
	}


	public boolean addservice(int empid, String presenti, AttendanceModel al) {
	
		int p=checkPresenti(presenti);// 1
		System.out.println(p);
		//System.err.println("==============>"+p);
		return aRepo.addservice(empid,p,al);
	
	}

	
	

}
