package com.wipro.springboot.usecase1;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {

    private final Map<Integer, Employee> employeeMap = new HashMap<>();

    public Employee addEmployee(int id, String name, String role) {
        Employee employee = new Employee(id, name, assignRole(role));
        employeeMap.put(id, employee);
        return employee;
    }

    public Employee getEmployee(int id) {
        return employeeMap.get(id);
    }

    public Map<Integer, Employee> getAllEmployees() {
        return employeeMap;
    }

    public Employee updateEmployeeRole(int id, String newRole) {
        Employee employee = employeeMap.get(id);
        if (employee != null) {
            employee.setRole(assignRole(newRole));
        }
        return employee;
    }

    private String assignRole(String role) {
        switch (role.toLowerCase()) {
            case "developer":
                return "Developer";
            case "manager":
                return "Manager";
            case "tester":
                return "Tester";
            default:
                return "Employee";
        }
    }
}