package com.next.payroll_system.repository;

import com.next.payroll_system.entity.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PayrollRepository extends JpaRepository<Payroll,Integer> {
    
    Optional<Payroll> findByEmployeeIdAndMonth(int employeeId, String month);

}
