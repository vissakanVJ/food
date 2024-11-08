<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.tap.model.Menu" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" href = "menustyle.css">
</head>
<body>

<% ArrayList<Menu> list = new ArrayList<Menu>();
   list = (ArrayList<Menu>) session.getAttribute("menu");	
%>
	<h1><%= list.size()%></h1>
	
	<div class="menu-container">
    <h1>Our Menu</h1>
    <% for(Menu i : list){ %>
    <div class="menu-item">
        <img src="https://via.placeholder.com/100" alt="Dish 1">
        <div class="menu-details">
            <h2><%= i.getItemName() %></h2>
            <p><%= i.getDescription() %></p>
            <span class="price"><%= i.getPrice() %></span>
        </div>
        <button class="add-to-cart">Add to Cart</button>
    </div>
    <% } %>
</div>
	

</body>
</html>