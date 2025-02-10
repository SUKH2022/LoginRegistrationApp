package com.va.week6.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.va.week6.model.User;

public class UserDao {

    // Method to insert user into the database
    public int registerUser(User user) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO users (username, password, email) VALUES (?, ?, ?);";
        int result = 0;

        // Load the JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment3", "root", "password")) {
            // Create a PreparedStatement
            PreparedStatement ps = connection.prepareStatement(INSERT_USERS_SQL);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());

            // Execute the query
            result = ps.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
        return result;
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