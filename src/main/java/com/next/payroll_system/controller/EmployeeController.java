package com.next.payroll_system.controller;

import com.next.payroll_system.entity.Employee;
import com.next.payroll_system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")       // Base URL: /employees
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // -------------- ADD EMPLOYEE ------------------
    @PostMapping
    public Employee addEmp(@RequestBody Employee e) {
        return service.addEmployee(e);
    }

    // -------------- UPDATE EMPLOYEE  ---------------
    @PutMapping("/{id}")
    public Employee updateEmp(@PathVariable int id, @RequestBody Employee e) {
        return service.updateEmployee(id, e);
    }

    // -------------- DELETE EMPLOYEE  ---------------
    @DeleteMapping("/{id}")
    public String deleteEmp(@PathVariable int id) {
        service.deleteEmployee(id);
        return "Employee Deleted Successfully";
    }

    // -------------- GET EMPLOYEE BY ID -------------
    @GetMapping("/{id}")
    public Employee getEmp(@PathVariable int id) {
        return service.getEmployee(id);
    }

    // -------------- GET ALL EMPLOYEES --------------
    @GetMapping
    public List<Employee> getAll() {
        return service.getAllEmployees();
    }
}
