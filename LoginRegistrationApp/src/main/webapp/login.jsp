<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
    <div align="center">
        <h1>Register</h1>
        <form action="registerServlet" method="post">
            <table>
                <tr>
                    <td>UserName:</td>
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