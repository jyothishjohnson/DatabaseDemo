package com.l7.dbdemo.impl;

import com.l7.dbdemo.dao.EmployeeDAO;
import com.l7.dbdemo.dto.EmployeeDTO;
import com.l7.dbdemo.utils.ConnectionManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class EmployeeDAO_IMPL implements EmployeeDAO {
    private Properties queryProperties;

    public EmployeeDAO_IMPL() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("query.properties");
        queryProperties = new Properties();
        queryProperties.load(fileInputStream);
        fileInputStream.close();
    }

    @Override
    public void addEmployee(EmployeeDTO employee) {
        Connection connection = ConnectionManager.getInstance().getConnection();
        CallableStatement stmt;
        try {
            System.out.println(employee.getEmpName());
            String sql = queryProperties.getProperty("insertEmp");
            stmt = connection.prepareCall(sql);
            stmt.setInt(1, employee.getEmpID());
            stmt.setString(2, employee.getEmpName());
            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException se) {
            System.out.println();
        }
    }

    @Override
    public void deleteEmployee(int empID) {
        Connection connection = ConnectionManager.getInstance().getConnection();
        CallableStatement stmt;
        try {
            String sql = queryProperties.getProperty("deleteEmp");
            stmt = connection.prepareCall(sql);
            stmt.setInt(1, empID);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException se) {
            System.out.println("Error in creating the Statement");
        }

    }

    @Override
    public void getAllEmployee() {
        Connection connection = ConnectionManager.getInstance().getConnection();
        CallableStatement stmt;
        ResultSet rs;
        try {
            String sql = queryProperties.getProperty("getAllEmp");
            stmt = connection.prepareCall(sql);

            rs = stmt.executeQuery();
            while (rs.next()) {
                int empId = rs.getInt("empId");
                String empName = rs.getString("empName");
                System.out.println(empId + ": " + empName);
            }
            rs.close();
            stmt.close();

        } catch (SQLException se) {
            System.out.println("Error in creating the Statement");
        }

    }

    @Override
    public void getOneEmployee(int empID) {
        Connection connection = ConnectionManager.getInstance().getConnection();
        CallableStatement stmt;
        ResultSet rs;
        try {
            String sql = queryProperties.getProperty("getOneEmp");
            stmt = connection.prepareCall(sql);
            System.out.println(empID);
            stmt.setInt(1, empID);
            rs = stmt.executeQuery();

            rs.next();

            int empId = rs.getInt("empId");
            String empName = rs.getString("empName");
            System.out.println(empId + ": " + empName);

            rs.close();
            stmt.close();

        } catch (SQLException se) {
            System.out.println("Error in creating the Statement");
        }
    }
}
