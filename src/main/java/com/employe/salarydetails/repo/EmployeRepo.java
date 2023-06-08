package com.employe.salarydetails.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employe.salarydetails.dto.Employee;

@Repository
public interface EmployeRepo extends JpaRepository< Employee, Integer> {
	
	//@Query(name =)
//	public Employee getEmployeDetails(Integer employeId);
	
	

}
