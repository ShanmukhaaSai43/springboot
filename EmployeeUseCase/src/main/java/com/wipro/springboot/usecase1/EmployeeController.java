package com.wipro.springboot.usecase1;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestParam int id, @RequestParam String name, @RequestParam String role) {
        return employeeService.addEmployee(id, name, role);
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return employeeService.getEmployee(id);
    }

    @GetMapping("/all")
    public Map<Integer, Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestParam String newRole) {
        return employeeService.updateEmployeeRole(id, newRole);
    }
}