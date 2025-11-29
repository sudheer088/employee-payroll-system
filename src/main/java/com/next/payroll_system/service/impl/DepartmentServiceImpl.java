package com.next.payroll_system.service.impl;

import com.next.payroll_system.entity.Department;
import com.next.payroll_system.repository.DepartmentRepository;
import com.next.payroll_system.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  // Marks this class as service layer
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository repo;

    @Override
    public Department addDepartment(Department d) {
        return repo.save(d);   // inserts into DB
    }

    @Override
    public Department getDepartment(int id) {
        return repo.findById(id)
                .orElse(null);   // returns null if not found (later we add exceptions)
    }

    @Override
    public List<Department> getAllDepartments() {
        return repo.findAll();
    }
}
