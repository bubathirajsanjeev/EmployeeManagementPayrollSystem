package com.employee.payroll.model;
import jakarta.persistence.*; import java.time.LocalDate;
@Entity
public class Payroll {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) private Employee employee;
 private String month; private double basicSalary, allowance, deduction, netSalary; private LocalDate generatedDate;
 public Payroll(){}
 public Long getId(){return id;} public Employee getEmployee(){return employee;} public void setEmployee(Employee employee){this.employee=employee;}
 public String getMonth(){return month;} public void setMonth(String month){this.month=month;}
 public double getBasicSalary(){return basicSalary;} public void setBasicSalary(double basicSalary){this.basicSalary=basicSalary;}
 public double getAllowance(){return allowance;} public void setAllowance(double allowance){this.allowance=allowance;}
 public double getDeduction(){return deduction;} public void setDeduction(double deduction){this.deduction=deduction;}
 public double getNetSalary(){return netSalary;} public void setNetSalary(double netSalary){this.netSalary=netSalary;}
 public LocalDate getGeneratedDate(){return generatedDate;} public void setGeneratedDate(LocalDate generatedDate){this.generatedDate=generatedDate;}
}