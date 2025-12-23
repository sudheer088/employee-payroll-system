package com.next.payroll_system.config;

import com.next.payroll_system.dto.PayrollDto;
import com.next.payroll_system.entity.Payroll;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PayrollMapper {

    @Mapping(source = "employee.id", target = "employeeId")
    PayrollDto toDto(Payroll payroll);

    @Mapping(source = "employeeId", target = "employee.id")
    Payroll toEntity(PayrollDto dto);
}
