package com.next.payroll_system.entity;

import jakarta.persistence.*;

@Entity //tells jpa this class maps to a table
@Table(name="departments")//maps to the departments table
public class Department {
    @Id //PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name; //department name colum
    public int getId(){return id;}
    public void setId(int id){this.id=id;}
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
}
