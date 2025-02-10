<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Registration Page</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<script>
    function validateForm() {
        // Get form values
        var username = document.forms["registerForm"]["username"].value;
        var password = document.forms["registerForm"]["password"].value;
        var company = document.forms["registerForm"]["company"].value;
        var payRoll = document.forms["registerForm"]["payRoll"].value;
        var fullName = document.forms["registerForm"]["fullName"].value;
        var referenceIndicator = document.forms["registerForm"]["referenceIndicator"].value;
        var jobTitle = document.forms["registerForm"]["jobTitle"].value;
        var functionField = document.forms["registerForm"]["functionField"].value;
        var subFunction = document.forms["registerForm"]["subFunction"].value;
        var section = document.forms["registerForm"]["section"].value;
        var location = document.forms["registerForm"]["location"].value;
        var building = document.forms["registerForm"]["building"].value;
        var room = document.forms["registerForm"]["room"].value;
        var requesterTel = document.forms["registerForm"]["requesterTel"].value;
        var confirmationCheckbox = document.forms["registerForm"]["confirmationCheckbox"].checked;

        // Username must be exactly 5 characters long
        if (username.length !== 5) {
            alert("Username must be exactly 5 characters long.");
            return false;
        }

        // Password must be alphanumeric and can only contain $ or _
        var passwordRegex = /^[a-zA-Z0-9$_]+$/;
        if (!passwordRegex.test(password)) {
            alert("Password must be alphanumeric and can only contain $ or _.");
            return false;
        }

        // All fields are required
        if (username === "" || password === "" || company === "" || payRoll === "" || fullName === "" || referenceIndicator === "" || jobTitle === "" || functionField === "" || subFunction === "" || section === "" || location === "" || building === "" || room === "" || requesterTel === "") {
            alert("All fields are required.");
            return false;
        }

        // No fields should permit special characters (except password, which allows $ and _)
        var specialCharRegex = /^[a-zA-Z0-9\s]+$/; // Allows alphanumeric and spaces
        if (!specialCharRegex.test(payRoll) || !specialCharRegex.test(fullName) || !specialCharRegex.test(referenceIndicator) || !specialCharRegex.test(jobTitle) || !specialCharRegex.test(functionField) || !specialCharRegex.test(subFunction) || !specialCharRegex.test(section) || !specialCharRegex.test(room) || !specialCharRegex.test(requesterTel)) {
            alert("Fields should not contain special characters (except password).");
            return false;
        }

        // Check if the confirmation checkbox is checked
        if (!confirmationCheckbox) {
            alert("Please confirm that all the information is correct.");
            return false;
        }

        return true;
    }
</script>
</head>
<body>
	<!-- Employee Registration Page -->
    <div class="container">
        <h1 class="tpm">EMPLOYEE REGISTRATION FORM</h1>
        <form name="registerForm" action="registerServlet" method="post" onsubmit="return validateForm()">
            <div class="form-columns">
                <!-- Left Column -->
                <div class="column">
                    <label for="username">UserName:</label>
                    <input type="text" name="username" required />

                    <label for="password">Password:</label>
                    <input type="password" name="password" required />

                    <label for="company">Company:</label>
                    <select name="company" required>
                        <option value="">Select Company</option>
                        <option value="Company A">Company A</option>
                        <option value="Company B">Company B</option>
                        <option value="Company C">Company C</option>
                    </select>

                    <label for="payRoll">Pay Roll:</label>
                    <input type="text" name="payRoll" required />

                    <label for="fullName">Full Name:</label>
                    <input type="text" name="fullName" required />

                    <label for="referenceIndicator">Reference Indicator:</label>
                    <input type="text" name="referenceIndicator" required />

                    <label for="jobTitle">Job Title:</label>
                    <input type="text" name="jobTitle" required />

                    <label for="functionField">Function:</label>
                    <input type="text" name="functionField" required />
                </div>

                <!-- Right Column -->
                <div class="column">
                    <label for="subFunction">SUB FUNCTION:</label>
                    <input type="text" name="subFunction" required />

                    <label for="section">SECTION:</label>
                    <input type="text" name="section" required />

                    <label for="location">LOCATION:</label>
                    <select name="location" required>
                        <option value="">Select Location</option>
                        <option value="Location 1">Location 1</option>
                        <option value="Location 2">Location 2</option>
                        <option value="Location 3">Location 3</option>
                    </select>

                    <label for="building">BUILDING:</label>
                    <select name="building" required>
                        <option value="">Select Building</option>
                        <option value="Building A">Building A</option>
                        <option value="Building B">Building B</option>
                        <option value="Building C">Building C</option>
                    </select>

                    <label for="room">ROOM:</label>
                    <input type="text" name="room" required />

                    <label for="requesterTel">REQUESTER TEL.#:</label>
                    <input type="text" name="requesterTel" required />
                </div>
            </div>

            <!-- Checkbox and Submit Button -->
            <div class="form-footer">
                <input type="checkbox" name="confirmationCheckbox" required />
                <label for="confirmationCheckbox">I have filled all the records and all the information is correct.</label>
                <br><br>
                <input class="btn" type="submit" value="Register" />
            </div>
        </form>
        <p>Already have an account? <a href="login.jsp">Login here</a></p>
    </div>
</body>
</html>