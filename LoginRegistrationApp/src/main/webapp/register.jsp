<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<script>
    function validateForm() {
        var username = document.forms["registerForm"]["username"].value;
        var password = document.forms["registerForm"]["password"].value;
        var email = document.forms["registerForm"]["email"].value;

        // Part B
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
        if (username === "" || password === "" || email === "") {
            alert("All fields are required.");
            return false;
        }

        return true;
    }
</script>
</head>
<body>
    <div align="center">
        <h1>Register</h1>
        <form name="registerForm" action="registerServlet" method="post" onsubmit="return validateForm()">
            <table>
                <tr>
                    <td>Username:</td>
                    <td><input type="text" name="username" required /></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password" required /></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="email" name="email" required /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Register" />
                    </td>
                </tr>
            </table>
        </form>
        <p>Already have an account? <a href="login.jsp">Login here</a></p>
    </div>
</body>
</html>