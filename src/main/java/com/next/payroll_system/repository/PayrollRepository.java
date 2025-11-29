package com.next.payroll_system.repository;

import com.next.payroll_system.entity.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayrollRepository extends JpaRepository<Payroll,Integer> {
}
