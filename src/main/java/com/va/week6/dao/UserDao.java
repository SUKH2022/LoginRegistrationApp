package com.va.week6.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.va.week6.model.User;

public class UserDao {

    // Method to insert user into the database
    public int registerUser(User user) throws ClassNotFoundException {
        // Validate the user object
        String validationError = validateUser(user);
        if (validationError != null) {
            System.err.println(validationError);
            return -1; 
        }

        // Updated SQL query to include all fields
        String INSERT_USERS_SQL = "INSERT INTO users (username, password, company, pay_roll, full_name, reference_indicator, job_title, function_field, sub_function, section, location, building, room, requester_tel) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        int result = 0;

        // Load the JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Local_Server", "root", "password")) {
            // Create a PreparedStatement
            PreparedStatement ps = connection.prepareStatement(INSERT_USERS_SQL);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getCompany());
            ps.setString(4, user.getPayRoll());
            ps.setString(5, user.getFullName());
            ps.setString(6, user.getReferenceIndicator());
            ps.setString(7, user.getJobTitle());
            ps.setString(8, user.getFunctionField());
            ps.setString(9, user.getSubFunction());
            ps.setString(10, user.getSection());
            ps.setString(11, user.getLocation());
            ps.setString(12, user.getBuilding());
            ps.setString(13, user.getRoom());
            ps.setString(14, user.getRequesterTel());

            // Execute the query
            result = ps.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
        return result;
    }

    // Method to validate the User object
    private String validateUser(User user) {
        // Username must be exactly 5 characters long
        if (user.getUsername() == null || user.getUsername().length() != 5) {
            return "Username must be exactly 5 characters long.";
        }

        // Password must be alphanumeric and can only contain $ or _
        String password = user.getPassword();
        if (password == null || !password.matches("^[a-zA-Z0-9$_]+$")) {
            return "Password must be alphanumeric and can only contain $ or _.";
        }

        // All fields are required
        if (user.getUsername() == null || user.getPassword() == null || user.getCompany() == null || user.getPayRoll() == null || user.getFullName() == null || user.getReferenceIndicator() == null || user.getJobTitle() == null || user.getFunctionField() == null || user.getSubFunction() == null || user.getSection() == null || user.getLocation() == null || user.getBuilding() == null || user.getRoom() == null || user.getRequesterTel() == null) {
            return "All fields are required.";
        }

        // No fields should permit special characters (except password, which allows $ and _)
        String specialCharRegex = "^[a-zA-Z0-9\\s]+$"; // Allows alphanumeric and spaces
        if (!user.getPayRoll().matches(specialCharRegex) || !user.getFullName().matches(specialCharRegex) || !user.getReferenceIndicator().matches(specialCharRegex) || !user.getJobTitle().matches(specialCharRegex) || !user.getFunctionField().matches(specialCharRegex) || !user.getSubFunction().matches(specialCharRegex) || !user.getSection().matches(specialCharRegex) || !user.getRoom().matches(specialCharRegex) || !user.getRequesterTel().matches(specialCharRegex)) {
            return "Fields should not contain special characters (except password).";
        }

        // If all validations pass, return null
        return null;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
            }
        }
    }
}