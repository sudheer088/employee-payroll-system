package com.next.payroll_system.service;

import com.next.payroll_system.entity.Payroll;

import java.util.List;

public interface PayrollService {

    Payroll generateSalary(int employeeId, String month);

    Payroll getPayroll(int id);

    List<Payroll> getPayrollByEmployee(int employeeId);

    Payroll generateOrGetPayroll(int employeeId, String month);
}
