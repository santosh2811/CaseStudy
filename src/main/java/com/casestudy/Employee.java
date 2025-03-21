package com.casestudy;


import java.util.List;

public class Employee {
    int id;
    String firstName;
    String lastName;
    double salary;
    int managerId;
    int level;

    public int getDepth() {
        return level;
    }

    public void setDepth(int depth) {
        this.level = depth;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public Employee() {
    }

    public Employee(String[] employeeDetail) {
        this.id = Integer.parseInt(employeeDetail[0]);
        this.firstName = employeeDetail[1];
        this.lastName = employeeDetail[2];
        this.salary = Double.parseDouble(employeeDetail[3]);
        if (employeeDetail.length == 5) {
            this.managerId = Integer.parseInt(employeeDetail[4]);
        }
    }
}
