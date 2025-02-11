<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Registration Page</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
	<!-- Employee Registration Page -->
    <div class="container">
        <h1 class="tpm">EMPLOYEE REGISTRATION FORM</h1>
        <form name="registerForm" action="registerServlet" method="post" onsubmit="return validateForm()">
            <div class="form-columns">
        <div class="column">
            <label for="username">UserName:</label>
            <input type="text" id="username" name="username" pattern="[a-zA-Z0-9]{5}" title="Username must be exactly 5 alphanumeric characters." required />

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" pattern="[a-zA-Z0-9$_]+" title="Password can only contain letters, numbers, $, and _." required />

            <label for="company">Company:</label>
            <select name="company" required>
                <option value="">Select Company</option>
                <option value="Company A">Company A</option>
                <option value="Company B">Company B</option>
                <option value="Company C">Company C</option>
            </select>

            <label for="payRoll">Pay Roll:</label>
            <input type="text" id="payRoll" name="payRoll" pattern="[a-zA-Z0-9 ]+" title="No special characters allowed." required />

            <label for="fullName">Full Name:</label>
            <input type="text" id="fullName" name="fullName" pattern="[a-zA-Z0-9 ]+" title="No special characters allowed." required />

            <label for="referenceIndicator">Reference Indicator:</label>
            <input type="text" id="referenceIndicator" name="referenceIndicator" pattern="[a-zA-Z0-9 ]+" title="No special characters allowed." required />

            <label for="jobTitle">Job Title:</label>
            <input type="text" id="jobTitle" name="jobTitle" pattern="[a-zA-Z0-9 ]+" title="No special characters allowed." required />

            <label for="functionField">Function:</label>
            <input type="text" id="functionField" name="functionField" pattern="[a-zA-Z0-9 ]+" title="No special characters allowed." required />
        </div>

        <div class="column">
            <label for="subFunction">SUB FUNCTION:</label>
            <input type="text" id="subFunction" name="subFunction" pattern="[a-zA-Z0-9 ]+" title="No special characters allowed." required />

            <label for="section">SECTION:</label>
            <input type="text" id="section" name="section" pattern="[a-zA-Z0-9 ]+" title="No special characters allowed." required />

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
            <input type="text" id="room" name="room" pattern="[a-zA-Z0-9 ]+" title="No special characters allowed." required />

            <label for="requesterTel">REQUESTER TEL.#:</label>
            <input type="text" id="requesterTel" name="requesterTel" pattern="[a-zA-Z0-9 ]+" title="No special characters allowed." required />
        </div>
    </div>

    <div class="form-footer">
        <input type="checkbox" id="confirmationCheckbox" name="confirmationCheckbox" required />
        <label for="confirmationCheckbox">I have filled all the records and all the information is correct.</label>
        <br><br>
        <input class="btn" type="submit" value="Register" />
    </div>
        </form>
        <p>Already have an account? <a href="login.jsp">Login here</a></p>
    </div>
</body>
</html>