package com.next.payroll_system.service.impl;

import com.next.payroll_system.entity.Employee;
import com.next.payroll_system.entity.Payroll;
import com.next.payroll_system.exception.ResourceNotFoundExecption;
import com.next.payroll_system.repository.EmployeeRepository;
import com.next.payroll_system.repository.PayrollRepository;
import com.next.payroll_system.service.PayrollService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PayrollServiceImpl implements PayrollService {
    private final PayrollRepository payrollRepo;
    private final EmployeeRepository employeeRepo;

    PayrollServiceImpl(EmployeeRepository employeeRepo, PayrollRepository payrollRepo) {
        this.employeeRepo = employeeRepo;
        this.payrollRepo = payrollRepo;
    }


    @Override
    public Payroll generateSalary(int employeeId, String month) {

        // 1️⃣ Check if exists
        Payroll existing = payrollRepo.findByEmployeeIdAndMonth(employeeId, month)
                .orElse(null);

        if (existing != null) {
            return existing; // 2️⃣ Return old slip
        }

        // 3️⃣ Salary calculation
        Employee emp = employeeRepo.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundExecption("Employee not found"));

        double salary = emp.getSalary();

        double basic = salary * 0.50;
        double hra = salary * 0.30;
        double pf = salary * 0.12;
        double net = basic + hra - pf;

        // 4️⃣ Construct new payroll
        Payroll p = new Payroll();
        p.setEmployee(emp);
        p.setMonth(month);
        p.setBasic(basic);
        p.setHra(hra);
        p.setPf(pf);
        p.setNetSalary(net);

        return payrollRepo.save(p); // 5️⃣ Save & return
    }


    @Override
    public Payroll getPayroll(int id) {
        return payrollRepo.findById(id)
                .orElse(null);
    }

    @Override
    public List<Payroll> getPayrollByEmployee(int employeeId) {
        return payrollRepo.findAll()
                .stream()
                .filter(p -> p.getEmployee().getId() == employeeId)
                .toList();
    }

    @Override
    public Payroll generateOrGetPayroll(int employeeId, String month) {
        // 1. Check if payroll already exists
                Optional<Payroll> existing = payrollRepo.findByEmployeeIdAndMonth(employeeId, month);

        // return already generated record
        return existing.orElse(null);
    }
}