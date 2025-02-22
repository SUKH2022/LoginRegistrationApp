package com.va.week6.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.va.week6.dao.Md5Hashing;
import com.va.week6.dao.UserDao;
import com.va.week6.model.User;


/**
 * Servlet implementation class RegisterServlet
 */

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDao;

    public void init() {http://localhost:8080/LoginRegistrationApp/login.jsp
        userDao = new UserDao();
    }

    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve all form fields
    	String username = request.getParameter("username");
        String password = request.getParameter("password");
        String company = request.getParameter("company");
        String payRollStr = request.getParameter("payRoll");
        String fullName = request.getParameter("fullName");
        String referenceIndicator = request.getParameter("referenceIndicator");
        String jobTitle = request.getParameter("jobTitle");
        String functionField = request.getParameter("functionField");
        String subFunction = request.getParameter("subFunction");
        String section = request.getParameter("section");
        String location = request.getParameter("location");
        String building = request.getParameter("building");
        String room = request.getParameter("room");
        String requesterTelStr = request.getParameter("requesterTel");

        // Validate the form fields
        String validationError = validateFormFields(username, password, company, payRollStr, fullName, referenceIndicator, jobTitle, functionField, subFunction, section, location, building, room, requesterTelStr);
        if (validationError != null) {
            request.setAttribute("errorMessage", validationError);
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }
        
        // Parse integer fields
        Integer payRoll = Integer.parseInt(payRollStr);
        Integer requesterTel = Integer.parseInt(requesterTelStr);
        
        // Hash the required fields
        Md5Hashing m1 = new Md5Hashing();
        String hashedFullName = m1.getMd5(fullName);
        String hashedPayRoll = m1.getMd5(payRoll.toString());
        String hashedRequesterTel = m1.getMd5(requesterTel.toString());
        
        // Convert hashed values to integers (taking the fst 9 digits of the hash)
        Integer hashedPayRollInt = Integer.parseInt(hashedPayRoll.substring(0, 7), 16);
        Integer hashedRequesterTelInt = Integer.parseInt(hashedRequesterTel.substring(0, 7), 16);
        
        // Create a User object and set all fields
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setCompany(company);
        user.setPayRoll(hashedPayRollInt);
        user.setFullName(hashedFullName);
        user.setReferenceIndicator(referenceIndicator);
        user.setJobTitle(jobTitle);
        user.setFunctionField(functionField);
        user.setSubFunction(subFunction);
        user.setSection(section);
        user.setLocation(location);
        user.setBuilding(building);
        user.setRoom(room);
        user.setRequesterTel(hashedRequesterTelInt);

        // Store original values for decryption 
        user.setOriginalPayRoll(payRollStr);
        user.setOriginalRequesterTel(requesterTelStr);
        user.setOriginalFullName(fullName);
        
        try {
            // Register the user
            userDao.registerUser(user);
            
            // Print the hashed values and decrypted values
            System.out.println("Hashed PayRoll: " + hashedPayRollInt);
            System.out.println("Hashed RequesterTel: " + hashedRequesterTelInt);
            System.out.println("Hashed FullName: " + hashedFullName);
            System.out.println("Decrypted PayRoll: " + user.getOriginalPayRoll());
            System.out.println("Decrypted RequesterTel: " + user.getOriginalRequesterTel());
            System.out.println("Decrypted FullName: " + user.getOriginalFullName());
            
            // Redirect to success page
            response.sendRedirect("success.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            // Redirect back to registration page in case of error
            request.setAttribute("errorMessage", "An error occurred during registration.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
    
 // Validation logic moved to the Servlet
    private String validateFormFields(String username, String password, String company, String payRollStr, String fullName, String referenceIndicator, String jobTitle, String functionField, String subFunction, String section, String location, String building, String room, String requesterTelStr) {
        // UserName must be exactly 5 characters long
        if (username == null || username.length() != 5) {
            return "Username must be exactly 5 characters long.";
        }

        // Password must be alphanumeric and can only contain $ or _
        if (password == null || !password.matches("^[a-zA-Z0-9$_]+$")) {
            return "Password must be alphanumeric and can only contain $ or _.";
        }

        // All fields are required
        if (username == null || password == null || company == null || payRollStr == null || fullName == null || referenceIndicator == null || jobTitle == null || functionField == null || subFunction == null || section == null || location == null || building == null || room == null || requesterTelStr == null) {
            return "All fields are required.";
        }

        // Validate integer fields (payRoll and requesterTel)
        try {
            Integer.parseInt(payRollStr);
            Integer.parseInt(requesterTelStr);
        } catch (NumberFormatException e) {
            return "Pay Roll and Requester Tel must be valid numbers.";
        }

        // No fields should permit special characters (except password, which allows $ and _)
        String specialCharRegex = "^[a-zA-Z0-9\\s]+$"; // Allows alphanumeric and spaces
        if (!fullName.matches(specialCharRegex) || !referenceIndicator.matches(specialCharRegex) || !jobTitle.matches(specialCharRegex) || !functionField.matches(specialCharRegex) || !subFunction.matches(specialCharRegex) || !section.matches(specialCharRegex) || !room.matches(specialCharRegex)) {
            return "Fields should not contain special characters (except password).";
        }

        // If all validations pass, return null
        return null;
    }
}