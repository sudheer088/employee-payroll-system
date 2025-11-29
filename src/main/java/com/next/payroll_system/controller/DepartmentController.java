package com.next.payroll_system.controller;

import com.next.payroll_system.entity.Department;
import com.next.payroll_system.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController                           // Marks this class as REST API controller
@RequestMapping("/departments")           // Base URL for all department APIs
public class DepartmentController {

    @Autowired
    private DepartmentService service;    // Inject service layer

    // ---------------- ADD DEPARTMENT ----------------
    @PostMapping
    public Department addDept(@RequestBody Department d) {
        return service.addDepartment(d);
    }

    // ---------------- GET DEPARTMENT BY ID ----------
    @GetMapping("/{id}")
    public Department getDept(@PathVariable int id) {
        return service.getDepartment(id);
    }

    // ---------------- GET ALL DEPARTMENTS -----------
    @GetMapping
    public List<Department> getAllDept() {
        return service.getAllDepartments();
    }
}
