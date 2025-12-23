package com.next.payroll_system.controller;

import com.next.payroll_system.entity.Department;
import com.next.payroll_system.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService service;


    @PostMapping
    public Department addDept(@RequestBody Department d) {
        return service.addDepartment(d);
    }


    @GetMapping("/{id}")
    public Department getDept(@PathVariable int id) {
        return service.getDepartment(id);
    }


    @GetMapping
    public List<Department> getAllDept() {
        return service.getAllDepartments();
    }
}
