package com.employe.salarydetails.dto;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name ="EMPLOYE")
public class Employee {
   
@Id
   @GeneratedValue
   @Column(name="EMPLOYE_ID")
	private Integer employeID;
   
   @NotNull
   @NotBlank
   @Column(name ="EMPLOYEE_FIRSTNAME")
   private String  firstName;
   
   @NotBlank
   @NotNull
   @Column(name ="EMPLOYEE_LASTNAME")
   private String lastName;
   
   @NotBlank
   @NotNull
   @Column(name ="EMPLOYEE_EMAIL" )
   private String email;
   
   @NotBlank
   @NotNull
   @Column(name ="EMPLOYEE_PHONENUMBER")
   private List<String> phoneNumber;
   
   @NotBlank
   @NotNull
   @DateTimeFormat(pattern="dd/MM/yyyy")
   @Column(name ="EMPLOYEE_DOJ")
   private Date doj;
   
   @NotBlank
   @NotNull
   @Column(name ="EMPLOYEE_SALARY")
   private String salary;
   
   @Transient
   @JsonProperty( defaultValue ="CESS_AMOUNT")
   private double cessAmount;
   
   
   @Transient
   @JsonProperty( defaultValue ="TAX_AMOUNT")
   private double taxamount;
   
   

public double getTaxamount() {
	return taxamount;
}

public void setTaxamount(double taxamount) {
	this.taxamount = taxamount;
}

public double getCessAmount() {
	return cessAmount;
}

public void setCessAmount(double cessAmount) {
	this.cessAmount = cessAmount;
}

public Integer getEmployeID() {
	return employeID;
}

public void setEmployeID(Integer employeID) {
	this.employeID = employeID;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public List<String> getPhoneNumber() {
	return phoneNumber;
}

public void setPhoneNumber(List<String> phoneNumber) {
	this.phoneNumber = phoneNumber;
}


@DateTimeFormat(pattern="dd/MM/yyyy")
public Date getDoj() {
	return doj;
}

public void setDoj(Date doj) {
	this.doj = doj;
}

public String getSalary() {
	return salary;
}

public void setSalary(String salary) {
	this.salary = salary;
}
   
@Override
public String toString() {
	return "Employee [employeID=" + employeID + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
			+ email + ", phoneNumber=" + phoneNumber + ", doj=" + doj + ", salary=" + salary + ", cessAmount="
			+ cessAmount + ", taxamount=" + taxamount + "]";
}

   
   
}
