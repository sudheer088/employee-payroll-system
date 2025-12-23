package com.next.payroll_system.config;

import com.next.payroll_system.dto.EmployeeDTO;
import com.next.payroll_system.entity.Employee;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    @Mapping(source = "departmentId", target = "department.id")
    Employee toEntity(EmployeeDTO dto);

    @Mapping(source = "department.id", target = "departmentId")
    EmployeeDTO toDto(Employee entity);
}

