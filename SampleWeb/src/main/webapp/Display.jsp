<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Management</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }
        .container {
            width: 80%;
            margin: 0 auto;
            text-align: center;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 10px;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
        .btn {
            padding: 8px 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .btn-update {
            background-color: blue;
            color: white;
        }
        .btn-delete {
            background-color: red;
            color: white;
        }
        .btn-add {
            background-color: green;
            color: white;
            position: absolute;
            top: 20px;
            left: 20px;
            padding: 10px 20px;
            text-decoration: none;
        }
    </style>
</head>
<body>
    <a href="Form.jsp" class="btn btn-add">Add User</a>
    <div class="container">
        <h1>User Management</h1>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${userList}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                    <td>${user.phone}</td>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                    <td>
                        <a href="UserUpdateServlet?id=${user.id}" class="btn btn-update">Update</a>
                        <a href="UserDeleteServlet?id=${user.id}" class="btn btn-delete">Delete</a>
                    </td>
                </tr>
              </c:forEach>
                <!-- More rows as needed -->
            </tbody>
        </table>
    </div>
</body>
</html>
