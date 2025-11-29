package com.next.payroll_system.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "payroll")
public class Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Many payroll records belong to one employee
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    private String month;
    private double basic;
    private double hra;
    private double pf;
    private double netSalary;

    // Getters & setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }

    public String getMonth() { return month; }
    public void setMonth(String month) { this.month = month; }

    public double getBasic() { return basic; }
    public void setBasic(double basic) { this.basic = basic; }

    public double getHra() { return hra; }
    public void setHra(double hra) { this.hra = hra; }

    public double getPf() { return pf; }
    public void setPf(double pf) { this.pf = pf; }

    public double getNetSalary() { return netSalary; }
    public void setNetSalary(double netSalary) { this.netSalary = netSalary; }
}
