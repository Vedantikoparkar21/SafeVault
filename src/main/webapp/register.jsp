<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register - SafeVault</title>

<style>
body {
    background: linear-gradient(135deg, #1e3c72, #2a5298);
    font-family: Arial;
}

.container {
    width: 350px;
    margin: 80px auto;
    background: white;
    padding: 25px;
    border-radius: 10px;
}

input {
    width: 100%;
    padding: 8px;
    margin: 8px 0;
}

button {
    width: 100%;
    padding: 10px;
    background: #2a5298;
    color: white;
    border: none;
}

h2 {
    text-align: center;
}
</style>

</head>

<body>

<div class="container">
    <h2>Register</h2>

    <form action="RegisterServlet" method="post">

        <label>Full Name</label>
        <input type="text" name="fullName" required>

        <label>Email</label>
        <input type="email" name="email" required>

        <label>Password</label>
        <input type="password" name="password" required>

        <label>Security Question</label>
        <input type="text" value="What is the name of your best childhood friend?" readonly>

        <label>Your Answer</label>
        <input type="text" name="securityAnswer" required>

        <button type="submit">Register</button>

    </form>

    <p style="text-align:center;">
        Already have account? <a href="login.jsp">Login</a>
    </p>

</div>

</body>
</html>