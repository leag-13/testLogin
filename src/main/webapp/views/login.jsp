<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="flm" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Form</title>
</head>
<body>
    <h2>Login</h2>
    <form action="/twebct2l/login" method="post">
        <div class="container">
            <div>
                <label for="uname">Username:</label>
                <input type="text" placeholder="Enter Username"  id="username" name="uname" required>
            </div>
            <br>
            <div>
                <label for="psw">Password:</label>
                <input type="password" placeholder="Enter password" id="password" name="psw" required>

                
            </div>
            <br>
            <div>
                <input type="checkbox" id="rememberMe" name="rememberMe">
                <label for="rememberMe">Remember Me</label>
            </div>
            <br>
            <div>
                <button type="submit">Login</button>
            </div>
        </div>
    </form>
</body>
</html>
