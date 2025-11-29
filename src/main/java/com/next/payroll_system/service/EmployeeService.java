package com.next.payroll_system.service;

import com.next.payroll_system.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(Employee e);

    Employee updateEmployee(int id, Employee e);

    void deleteEmployee(int id);

    Employee getEmployee(int id);

    List<Employee> getAllEmployees();
}