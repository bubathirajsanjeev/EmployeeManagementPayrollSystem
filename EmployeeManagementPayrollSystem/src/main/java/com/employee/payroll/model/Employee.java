package com.employee.payroll.model;
import jakarta.persistence.*; import jakarta.validation.constraints.*;
@Entity
public class Employee {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank private String name; @NotBlank @Email @Column(unique=true) private String email;
 private String department; private String designation;
 @PositiveOrZero private double basicSalary;
 public Employee(){}
 public Long getId(){return id;} public void setId(Long id){this.id=id;}
 public String getName(){return name;} public void setName(String name){this.name=name;}
 public String getEmail(){return email;} public void setEmail(String email){this.email=email;}
 public String getDepartment(){return department;} public void setDepartment(String department){this.department=department;}
 public String getDesignation(){return designation;} public void setDesignation(String designation){this.designation=designation;}
 public double getBasicSalary(){return basicSalary;} public void setBasicSalary(double basicSalary){this.basicSalary=basicSalary;}
}