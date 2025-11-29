package com.next.payroll_system.service.impl;

import com.next.payroll_system.entity.Employee;
import com.next.payroll_system.entity.Payroll;
import com.next.payroll_system.repository.EmployeeRepository;
import com.next.payroll_system.repository.PayrollRepository;
import com.next.payroll_system.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayrollServiceImpl implements PayrollService {

    @Autowired
    private EmployeeRepository employeeRepo;

    @Autowired
    private PayrollRepository payrollRepo;

    @Override
    public Payroll generateSalary(int employeeId, String month) {

        Employee emp = employeeRepo.findById(employeeId)
                .orElse(null);

        if(emp == null)
            return null; // later: custom exception

        double salary = emp.getSalary();

        double basic = salary * 0.50;
        double hra   = salary * 0.30;
        double pf    = salary * 0.12;

        double netSalary = basic + hra - pf;

        Payroll p = new Payroll();
        p.setEmployee(emp);
        p.setMonth(month);
        p.setBasic(basic);
        p.setHra(hra);
        p.setPf(pf);
        p.setNetSalary(netSalary);

        return payrollRepo.save(p);
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
}