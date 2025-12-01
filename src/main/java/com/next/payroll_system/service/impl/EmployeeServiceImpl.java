package com.next.payroll_system.service.impl;

import com.next.payroll_system.entity.Employee;
import com.next.payroll_system.exception.ResourceNotFoundExecption;
import com.next.payroll_system.repository.EmployeeRepository;
import com.next.payroll_system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    @Override
    public Employee addEmployee(Employee e) {
        return repo.save(e);
    }

    @Override
    public Employee updateEmployee(int id, Employee newData) {

        Employee existing = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExecption("Employee not found with id: " + id));
        existing.setName(newData.getName());
        existing.setEmail(newData.getEmail());
        existing.setSalary(newData.getSalary());
        existing.setDepartment(newData.getDepartment());

        // 3️⃣ Save updated employee
        return repo.save(existing);
    }

    @Override
    public void deleteEmployee(int id) {
        repo.deleteById(id);
    }

    @Override
    public Employee getEmployee(int id) {
        return repo.findById(id)
                .orElse(null);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }
}
