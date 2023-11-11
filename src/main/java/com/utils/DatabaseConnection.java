package com.utils;

import java.sql.*;

public class DatabaseConnection {
    public static void main(String[] Args) {

        // Define the database connection URL with integrated security
        String jdbcURL = "jdbc:sqlserver://Rahul\\SQLEXPRESS;databaseName=pvr;integratedSecurity=true;";


        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try {
            Connection connection = DriverManager.getConnection(jdbcURL);

            // Perform database operations (e.g., execute SQL queries) here
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");


            while (resultSet.next()) {

                String empName = resultSet.getString("empName");
                String empId = resultSet.getString("empId");
                String empSalary = resultSet.getString("empSalary");
                String empAge = resultSet.getString("empAge");

                System.out.print("|" +empName +"|"+ empId +"|" +empSalary +"|" +empAge +"|");
            }


            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
