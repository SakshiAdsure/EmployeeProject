package org.emp.service;

import java.util.List;

import org.emp.model.EmployeeModel;
import org.emp.repository.EmployeeRepository;

public class EmployeeService {
	EmployeeRepository empRepo = new EmployeeRepository();
	
	public int isAddEmployee(EmployeeModel model) {
		
		return (empRepo.isEmployeePresent(model.getFname()))?-1:empRepo.isAddEmployee(model)?1:0;
	}
	
//	public boolean isEmployeePresent(String empName) {
//		return empRepo.isEmployeePresent(empName)?true:false;
//	}

	public List<EmployeeModel> getAllEmployees(){
		return empRepo.getAllEmployees();
	}

	public int isDeleteEmployee(int did) {
		return empRepo.isDeleteEmployee(did);
	}
	
	public int isUpdateEmployee(EmployeeModel empModel) {
		return empRepo.isUpdateEmployee(empModel);
	}
	
	
//		public EmployeeModel isEmployeePresent(String name) {
//			return empRepo.isEmployeePresent(name);
//		}
		
		
	}

