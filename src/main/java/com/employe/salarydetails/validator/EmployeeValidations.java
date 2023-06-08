package com.employe.salarydetails.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import com.employe.salarydetails.Exception.EmployeException;
import com.employe.salarydetails.dto.Employee;


public class EmployeeValidations {
	private static final Logger LOGGER=LoggerFactory.getLogger(EmployeeValidations.class);
	
	 @Value(value ="${data.exception.employeedetails.requestblank}")
		private String requestblank;	 
	 @Value(value ="${data.exception.employeedetails.phonenumber.matching}")
		private String numberMatching;
	 @Value(value ="${data.exception.employeedetails.phonenumber.length}")
		private String numberLength;
	 @Value(value ="${data.exception.employeedetails.mail}")
		private String mail ;
	 
	@SuppressWarnings("null")
	public void getEmployeValid(Employee employee) {
		LOGGER.info("Request Validations.. ");
	if(employee == null && employee.getEmployeID()==null && employee.getFirstName().equals(null)&& employee.getFirstName().isEmpty()&&
			employee.getLastName().equals(null)&& employee.getLastName().isEmpty()&& employee.getDoj().equals(null)
			&&employee.getPhoneNumber().equals(null)&&employee.getPhoneNumber().isEmpty()&& employee.getSalary().equals(null)&& employee.getSalary().isEmpty()) {
		throw new  EmployeException(requestblank , HttpStatus.BAD_REQUEST);
	}
	else if (employee.getPhoneNumber().stream().anyMatch((a)->{a.matches("[0-9]{10}+"); return false;})){
		throw new EmployeException(numberMatching, HttpStatus.BAD_REQUEST);
	}
	else if(employee.getEmail().contains("@gmail.com"));
	throw new EmployeException(mail, HttpStatus.BAD_REQUEST);
	}
	
}
