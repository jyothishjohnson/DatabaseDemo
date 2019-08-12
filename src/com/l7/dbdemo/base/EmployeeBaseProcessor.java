package com.l7.dbdemo.base;

import com.l7.dbdemo.dto.EmployeeDTO;
import com.l7.dbdemo.impl.EmployeeDAO_IMPL;

import java.io.IOException;
import java.util.Scanner;

public class EmployeeBaseProcessor {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeDAO_IMPL employeeDAOImpl = null;
        try {
            employeeDAOImpl = new EmployeeDAO_IMPL();
        } catch (IOException fe) {
            System.out.println(fe.getMessage());
        }
        EmployeeDTO employeeDTO;

        int empId;
        String empName;

        String temp;
        do {
            System.out.println("1.Add an employee\n2.Show an employee\n3.Show all employee\n4.Delete an employee");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    employeeDTO = new EmployeeDTO();
                    System.out.println("Enter the empId");
                    empId = sc.nextInt();
                    System.out.println("Enter the empName");
                    empName = sc.next();
                    employeeDTO.setEmpID(empId);
                    employeeDTO.setEmpName(empName);
                    if (employeeDAOImpl != null) {
                        employeeDAOImpl.addEmployee(employeeDTO);
                    }
                    break;
                case 2:
                    System.out.println("Enter the empId");
                    empId = sc.nextInt();
                    if (employeeDAOImpl != null) {
                        employeeDAOImpl.getOneEmployee(empId);
                    }
                    break;
                case 3:
                    if (employeeDAOImpl != null) {
                        employeeDAOImpl.getAllEmployee();
                    }
                    break;
                case 4:
                    System.out.println("Enter the empId");
                    empId = sc.nextInt();
                    if (employeeDAOImpl != null) {
                        employeeDAOImpl.deleteEmployee(empId);
                    }
                    break;
                default:
                    System.out.println("Enter a valid choice");
                    break;
            }
            System.out.println("Wanna continue");
            temp = sc.next();
        } while (temp.equals("y") || temp.equals("Y"));
    }
}
