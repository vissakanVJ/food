<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>register</title>
    <link rel="stylesheet" href="st.css">
</head>
<body>
    <div class="wrapper">
        <div class="left">
        </div>
        <div class="right">
            <form action="register" method="post" class="form">
                <h1>Register</h1>
                <div class="input-box">
                    <label for="name">Name</label>
                    <input type="text" id="name" placeholder="enter your name" name="nm">
                </div>
                <div class="input-box">
                    <label for="phone">Phone</label>
                    <input type="text" id="phone" placeholder="enter your phone" name="pn">
                </div>
                <div class="input-box">
                    <label for="email">Email</label>
                    <input type="text" id="email" placeholder="enter your email" name="em">
                </div>
                <div class="input-box">
                    <label for="pass">Password</label>
                    <input type="text" id="pass" placeholder="enter your password" name="ps">
                </div>
                <div class="input-box">
                    <label for="add">Address</label>
                    <input type="text" id="add" placeholder="enter your address" name="ad">
                </div>
                <input type="submit" value="register">
            </form>
        </div>
    </div>
</body>
</html>