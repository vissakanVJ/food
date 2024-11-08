<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link rel="stylesheet" href="styles.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    
</head>
<body>
    <div class="wrapper">
        <form action="loginn" method="post" class="form">
            <h1>Login</h1>
            <div class="input-box">
                <input type="text" placeholder="Email" name="email" required>
                <i class='bx bx-user'></i>
            </div>
            <div class="input-box">
                <input type="password" placeholder="password" name="pass" required>
                <i class='bx bx-lock-alt'></i>
            </div>
            <div class="remember-forget">
                 <label for="check">Remember me <input type="checkbox" id="check"> </label>
                 <a href="">forgot password?</a>
            </div>
            <input type="submit" value="login">
            <div class="register">
                <p>Don't have an account? <a href="adduser.jsp">Register</a></p>
            </div>
        </form>
        <c:if test="${not empty error}">
    		<p style="color: red;">${error}</p>
		</c:if>
    </div>
   
</body>
</html>
    