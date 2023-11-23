    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
             pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <%@ page import="java.util.Date, java.text.SimpleDateFormat"%>
        <!DOCTYPE html>
        <html lang="en">
        <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Add your CSS links here -->
        <link rel="stylesheet" href="assets/css/test.css">
        <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
        rel="stylesheet">
        <link rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <!-- Add your JavaScript links here -->
        <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js">
        </script>

        <title>Student Registration Project</title>
        </head>
        <body>
        <!-- Header section -->
        <div id="testheader">
        <div class="container">
        <div class=row>
        <div class="col-md-5 ">
        <a href="/studentRegister.jsp"><h3>Student Registration</h3></a>
        </div>
        <div class="col-md-6">
        <p>User: ${sessionScope.userName}</p> <p>
        Current Date :
        <%-- Use Java code to get the current date and format it --%>
            <% SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); %>
            <%= dateFormat.format(new Date()) %>
        </p>
        </div>
        <div class="col-md-1">
        <input type="button" class="btn-basic" id="lgnout-button"
        value="Log Out" onclick="location.href='LogOutServlet'">
        </div>
        </div>
        </div>
        </div>

        <!-- Navigation section -->
        <div class="container">
        <div class="sidenav">
        <button class="dropdown-btn">
        Class Management <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-container">
        <c:if test="${sessionScope.role != 2}">
            <a href="CourseRegisterServlet">Course Registration </a>
        </c:if>
        <c:if test="${sessionScope.role == 2}">
            <a href="UserUpdateServlet?id=${sessionScope.id}">Profile Setting</a>
        </c:if>
        <a href="StudentRegisterServlet">Student Registration </a>
        <a href="StudentSearchbyIdServlet">Student Search </a>
        </div>
        <a href="UserViewServlet">Users Management</a>
        </div>
        <div class="main_contents">
        <!-- Main content section starts here -->