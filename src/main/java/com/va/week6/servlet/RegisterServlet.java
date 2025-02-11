package com.va.week6.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.va.week6.dao.UserDao;
import com.va.week6.model.User;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDao;

    public void init() {http://localhost:8080/LoginRegistrationApp/login.jsp
        userDao = new UserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve all form fields
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String company = request.getParameter("company");
        String payRoll = request.getParameter("payRoll");
        String fullName = request.getParameter("fullName");
        String referenceIndicator = request.getParameter("referenceIndicator");
        String jobTitle = request.getParameter("jobTitle");
        String functionField = request.getParameter("functionField");
        String subFunction = request.getParameter("subFunction");
        String section = request.getParameter("section");
        String location = request.getParameter("location");
        String building = request.getParameter("building");
        String room = request.getParameter("room");
        String requesterTel = request.getParameter("requesterTel");

        // Create a User object and set all fields
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setCompany(company);
        user.setPayRoll(payRoll);
        user.setFullName(fullName);
        user.setReferenceIndicator(referenceIndicator);
        user.setJobTitle(jobTitle);
        user.setFunctionField(functionField);
        user.setSubFunction(subFunction);
        user.setSection(section);
        user.setLocation(location);
        user.setBuilding(building);
        user.setRoom(room);
        user.setRequesterTel(requesterTel);

        try {
            // Register the user
            userDao.registerUser(user);
            // Redirect to success page
            response.sendRedirect("success.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            // Redirect back to registration page in case of error
            response.sendRedirect("register.jsp");
        }
    }
}