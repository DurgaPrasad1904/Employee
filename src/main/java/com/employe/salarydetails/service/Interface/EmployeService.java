package com.employe.salarydetails.service.Interface;

import org.springframework.stereotype.Component;

import com.employe.salarydetails.dto.Employee;
@Component
public interface EmployeService {
   
	public Employee getEmployeeDetails(Integer employeeId);
	public Employee saveEmployeeDetails(Employee employee);
}
