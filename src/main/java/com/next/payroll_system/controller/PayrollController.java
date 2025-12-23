package com.next.payroll_system.controller;

import com.next.payroll_system.entity.Payroll;
import com.next.payroll_system.service.PayrollService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.YearMonth;
import java.util.List;

@RestController
@RequestMapping("/payroll")
public class PayrollController {

    @Autowired
    private PayrollService service;

    @PostMapping("/generate/{employeeId}/{month}")
    public Payroll generateSalary(@PathVariable int employeeId,
                                  @PathVariable String month) {

        // Validate month format (yyyy-MM)
        YearMonth givenMonth;
        try {
            givenMonth = YearMonth.parse(month);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid month format. Use yyyy-MM");
        }

        // Current month
        YearMonth currentMonth = YearMonth.now();

        // Allow only completed months → givenMonth must be BEFORE currentMonth
        if (!givenMonth.isBefore(currentMonth)) {
            throw new IllegalArgumentException("Payroll can only be generated for completed months.");
        }

        // If validation passes → business logic
        return service.generateOrGetPayroll(employeeId, month);
    }


    @GetMapping("/{id}")
    public Payroll getPayroll(@Valid @PathVariable int id) {
        return service.getPayroll(id);
    }

    @GetMapping("/employee/{employeeId}")
    public List<Payroll> getPayrollByEmployee(@PathVariable int employeeId) {
        return service.getPayrollByEmployee(employeeId);
    }
}
