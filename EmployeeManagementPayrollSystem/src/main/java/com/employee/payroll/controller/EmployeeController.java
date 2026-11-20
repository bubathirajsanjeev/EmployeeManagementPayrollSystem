package com.employee.payroll.controller;
import com.employee.payroll.model.Employee; import com.employee.payroll.repository.EmployeeRepository;
import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.web.bind.annotation.*;
@Controller
public class EmployeeController {
 private final EmployeeRepository repo; public EmployeeController(EmployeeRepository repo){this.repo=repo;}
 @GetMapping("/") public String home(Model m){m.addAttribute("employees",repo.findAll());m.addAttribute("count",repo.count());return "index";}
 @GetMapping("/employees") public String list(Model m){m.addAttribute("employees",repo.findAll());return "employees";}
 @GetMapping("/employees/add") public String add(Model m){m.addAttribute("employee",new Employee());return "employee-form";}
 @PostMapping("/employees/save") public String save(@ModelAttribute Employee e){repo.save(e);return "redirect:/employees";}
 @GetMapping("/employees/edit/{id}") public String edit(@PathVariable Long id,Model m){m.addAttribute("employee",repo.findById(id).orElseThrow());return "employee-form";}
 @GetMapping("/employees/delete/{id}") public String delete(@PathVariable Long id){repo.deleteById(id);return "redirect:/employees";}
}