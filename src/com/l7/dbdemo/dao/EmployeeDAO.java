package com.l7.dbdemo.dao;

import com.l7.dbdemo.dto.EmployeeDTO;


public interface EmployeeDAO {
    String addEmployee(EmployeeDTO employee);
    String deleteEmployee(int empID);
    void getAllEmployee();
    void getOneEmployee(int empID);
}
