package com.next.payroll_system.controller;

import com.next.payroll_system.config.EmployeeMapper;
import com.next.payroll_system.dto.EmployeeDTO;
import com.next.payroll_system.entity.Employee;
import com.next.payroll_system.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeMapper mapper;

    @Autowired
    private EmployeeService service;

    @PostMapping("/add")
    public EmployeeDTO addEmp(@Valid @RequestBody EmployeeDTO dto) {
        Employee saved = service.addEmployee(mapper.toEntity(dto));
        return mapper.toDto(saved);
    }

    @PutMapping("/{id}")
    public EmployeeDTO updateEmp(@PathVariable int id,
                                 @Valid @RequestBody EmployeeDTO dto) {
        Employee updated = service.updateEmployee(id, mapper.toEntity(dto));
        return mapper.toDto(updated);
    }

    @GetMapping("/{id}")
    public EmployeeDTO getEmp(@PathVariable int id) {
        Employee e = service.getEmployee(id);
        return mapper.toDto(e);
    }

    @GetMapping
    public List<EmployeeDTO> getAll() {
        return service.getAllEmployees()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @DeleteMapping("/{id}")
    public String deleteEmp(@PathVariable int id) {
        service.deleteEmployee(id);
        return "Employee deleted successfully";
    }
}
