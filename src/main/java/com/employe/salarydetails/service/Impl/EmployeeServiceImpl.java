package com.employe.salarydetails.service.Impl;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.employe.salarydetails.Exception.EmployeException;
import com.employe.salarydetails.dto.Employee;
import com.employe.salarydetails.repo.EmployeRepo;
import com.employe.salarydetails.service.Interface.EmployeService;
import com.employe.salarydetails.validator.EmployeeValidations;
@Service
public class EmployeeServiceImpl implements EmployeService {

	private static final Logger LOGGER=LoggerFactory.getLogger(EmployeeServiceImpl.class);
    
	@Autowired
	private EmployeRepo employeeRepo;
	@Value(value ="${data.exception.employeedetails.notfound}")
	private String notfound;
	
	
	@SuppressWarnings("deprecation")
	@Override
	public Employee getEmployeeDetails(Integer employeeId) {
		LOGGER.info("Service  begins..");
		Employee emp =employeeRepo.getById(employeeId);
		LOGGER.info("Employee Details.."+ emp);
		if(emp==null) {
			LOGGER.info("Employee Details.. not found"+ emp);
			throw new EmployeException(notfound, HttpStatus.NO_CONTENT);
		}
		
		
		emp.getSalary();
		double sal =Integer.parseInt(emp.getSalary());
		double month = emp.getDoj().getMonth();
		double date =  emp.getDoj().getDate();
		double year =  emp.getDoj().getYear();
		double excess ;
		LOGGER.info("Date...."+ date );
		    if(month > 4) {
		    	excess =(month-4);
		    	if(Arrays.asList(6,9,11).stream().anyMatch((a)-> {a.equals(month) ; return false;})) {
		    	sal =  sal*(12-excess)-(30-date)*(sal/30);
		    	}else {
		    		sal =  sal*(12-excess)-(30-date)*(sal/30);
		    	}    	
		    }
		    else if(month < 4){
		    	excess =(4-month);
		    	 if(month ==2) {
		    		 if(year %4==0 && year%100 ==0&& year%400 ==0) {
		    		sal =  sal*(12+excess)-(29-date)*(sal/29);
		    		 }
		    		 else {
		    			 sal =  sal*(12+excess)-(28-date)*(sal/28); 
		    		 }
		    	}
		    	else {
		    		sal =  sal*(12+excess)-(30-date)*(sal/30);
		    	}
		    }
		    else {
		    	sal =  sal*12-(30-date)*(sal/30);
		    }
		
		if(sal<=250000) {
			emp.setTaxamount(sal);
		}
		else if(sal>250000 &&sal <=500000) {
			sal =(sal-250000)*(5.0/100) ;	
			emp.setTaxamount(sal);
		}
		else if(sal>500000 && sal<=1000000) {
			sal =(sal-250000)*(10.0/100) ;	
			emp.setTaxamount(sal);
		}
		else {
			sal =(sal-250000)*(20.0/100) ;	
			emp.setTaxamount(sal);
			if (sal >2500000) {
				emp.setCessAmount((sal-2500000)*2.0/100);
			}
		}
		
		return emp ;
	}


	
	
	
	@Override
	public Employee saveEmployeeDetails(Employee employee) {
		LOGGER.info("Service  begins..");
		EmployeeValidations emp = new EmployeeValidations();
		emp.getEmployeValid(employee);
		return employeeRepo.saveAndFlush(employee);
	}

	
	
}
