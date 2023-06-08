package com.employe.salarydetails.controller;
	
import static com.employe.salarydetails.constants.EmployeeConstants.GET_EMPLOYEE_DETAILS;
import static com.employe.salarydetails.constants.EmployeeConstants.SAVE_EMPLOYEE_DETAILS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employe.salarydetails.dto.Employee;
import com.employe.salarydetails.service.Interface.EmployeService;

@RestController			
public class EmployeeDetailsController {
 
private static final Logger logger = LoggerFactory.getLogger(EmployeeDetailsController.class);
	
  @Autowired		
  private EmployeService employeService;
  
  @RequestMapping(value = GET_EMPLOYEE_DETAILS ,method =RequestMethod.GET)
  @CrossOrigin
  public ResponseEntity<Employee> getEmployee(@RequestParam("employeeId")  Integer employeeId){
	  logger.info("Get Employee begins");
	  if(employeeId ==0) {
		  return new ResponseEntity("Unable to Process the request",HttpStatus.NO_CONTENT);
	  }
	return new ResponseEntity<Employee>(employeService.getEmployeeDetails(employeeId),HttpStatus.OK);
  }
	
  @RequestMapping(value = SAVE_EMPLOYEE_DETAILS	 ,method =RequestMethod.POST)
  @CrossOrigin
  public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
	  logger.info("save Employee begins");
	  if(employee ==null) {
		  return new ResponseEntity("Unable to Process the request",HttpStatus.NO_CONTENT);
	  }
	return new ResponseEntity<Employee>(employeService.saveEmployeeDetails(employee),HttpStatus.OK);	  
  }

	
	
}
