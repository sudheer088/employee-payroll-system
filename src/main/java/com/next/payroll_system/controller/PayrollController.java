package com.next.payroll_system.controller;

import com.next.payroll_system.entity.Payroll;
import com.next.payroll_system.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payroll")
public class PayrollController {

    @Autowired
    private PayrollService service;

    // ------------ GENERATE SALARY FOR EMPLOYEE -------------
    @PostMapping("/generate/{employeeId}/{month}")
    public Payroll generateSalary(@PathVariable int employeeId, @PathVariable String month) {
        return service.generateSalary(employeeId, month);
    }

    // ------------ GET PAYROLL BY ID -------------------------
    @GetMapping("/{id}")
    public Payroll getPayroll(@PathVariable int id) {
        return service.getPayroll(id);
    }

    // ------------ GET ALL SALARIES FOR EMPLOYEE -------------
    @GetMapping("/employee/{employeeId}")
    public List<Payroll> getPayrollByEmployee(@PathVariable int employeeId) {
        return service.getPayrollByEmployee(employeeId);
    }
}
