package com.employee.payroll.controller;
import com.employee.payroll.model.*; import com.employee.payroll.repository.*;
import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.web.bind.annotation.*; import java.time.LocalDate;
@Controller
public class PayrollController {
 private final EmployeeRepository employees; private final PayrollRepository payrolls;
 public PayrollController(EmployeeRepository employees,PayrollRepository payrolls){this.employees=employees;this.payrolls=payrolls;}
 @GetMapping("/payroll") public String list(Model m){m.addAttribute("payrolls",payrolls.findAll());m.addAttribute("employees",employees.findAll());return "payroll";}
 @PostMapping("/payroll/generate") public String generate(@RequestParam Long employeeId,@RequestParam String month,@RequestParam double allowance,@RequestParam double deduction){
 Employee e=employees.findById(employeeId).orElseThrow(); Payroll p=new Payroll();p.setEmployee(e);p.setMonth(month);p.setBasicSalary(e.getBasicSalary());p.setAllowance(allowance);p.setDeduction(deduction);p.setNetSalary(e.getBasicSalary()+allowance-deduction);p.setGeneratedDate(LocalDate.now());payrolls.save(p);return "redirect:/payroll";}
 @GetMapping("/payroll/delete/{id}") public String delete(@PathVariable Long id){payrolls.deleteById(id);return "redirect:/payroll";}
}