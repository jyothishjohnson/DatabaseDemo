package com.l7.dbdemo.dto;

public class EmployeeDTO {
    private int empID;
    private String empName;

    @Override
    public String toString() {
        return empID + ": " + empName;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }
}
