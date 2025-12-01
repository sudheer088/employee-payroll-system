package com.next.payroll_system.controller;

import com.next.payroll_system.dto.EmployeeDTO;
import com.next.payroll_system.entity.Department;
import com.next.payroll_system.entity.Employee;
import com.next.payroll_system.service.EmployeeService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @Autowired
    private ModelMapper mapper;

    // ------------ CREATE EMPLOYEE ----------------
    @PostMapping
    public EmployeeDTO addEmp(@Valid @RequestBody EmployeeDTO dto) {

        Employee saved = service.addEmployee(dtoToEntity(dto));
        return entityToDto(saved);
    }

    // ------------ UPDATE EMPLOYEE ----------------
    @PutMapping("/{id}")
    public EmployeeDTO updateEmp(@PathVariable int id,
                                 @Valid @RequestBody EmployeeDTO dto) {

        Employee updated = service.updateEmployee(id, dtoToEntity(dto));
        return entityToDto(updated);
    }

    // ------------ GET EMPLOYEE -------------------
    @GetMapping("/{id}")
    public EmployeeDTO getEmp(@PathVariable int id) {

        Employee e = service.getEmployee(id);
        return entityToDto(e);
    }

    // ------------ GET ALL ------------------------
    @GetMapping
    public List<EmployeeDTO> getAll() {

        return service.getAllEmployees()
                .stream()
                .map(this::entityToDto)
                .toList();
    }

    // ------------ DELETE --------------------------
    @DeleteMapping("/{id}")
    public String deleteEmp(@PathVariable int id) {
        service.deleteEmployee(id);
        return "Employee deleted successfully";
    }

    // ------------ MAPPING METHODS -----------------
    private Employee dtoToEntity(EmployeeDTO dto) {
        Employee e = mapper.map(dto, Employee.class);
        // manually set department
        Department d = new Department();
        d.setId(dto.getDepartmentId());
        e.setDepartment(d);
        return e;
    }

    private EmployeeDTO entityToDto(Employee e) {
        EmployeeDTO dto = mapper.map(e, EmployeeDTO.class);
        dto.setDepartmentId(e.getDepartment().getId());
        return dto;
    }
}
