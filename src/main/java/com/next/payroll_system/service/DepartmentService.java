package com.next.payroll_system.service;

import com.next.payroll_system.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department addDepartment(Department d);

    Department getDepartment(int id);

    List<Department> getAllDepartments();
}
