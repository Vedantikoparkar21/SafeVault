<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login - SafeVault</title>

<style>
body {
    background: linear-gradient(135deg, #1e3c72, #2a5298);
    font-family: Arial;
}

.container {
    width: 350px;
    margin: 100px auto;
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
    <h2>Login</h2>

    <form action="LoginServlet" method="post">

        <label>Email</label>
        <input type="email" name="email" required>

        <label>Password</label>
        <input type="password" name="password" required>

        <label>Security Question</label>
        <input type="text" value="What is the name of your best childhood friend?" readonly>

        <label>Security Answer</label>
        <input type="text" name="securityAnswer" required>

        <button type="submit">Login</button>

    </form>

    <p style="text-align:center;">
        Don't have account? <a href="register.jsp">Register</a>
    </p>

</div>

</body>
</html>