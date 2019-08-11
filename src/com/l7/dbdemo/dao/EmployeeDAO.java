package com.l7.dbdemo.dao;

import com.l7.dbdemo.dto.EmployeeDTO;


public interface EmployeeDAO {
    void addEmployee(EmployeeDTO employee);
    void deleteEmployee(int empID);
    void getAllEmployee();
    void getOneEmployee(int empID);
}
