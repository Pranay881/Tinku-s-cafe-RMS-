<%@page import="com.amstech.tinkus_cafe1.dto.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Search here</title>
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  height: 100vh;
  margin: 0;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #f2f2f2;
}

form {
  border: 3px solid #f1f1f1;
  max-width: 400px;
  width: 100%;
  background-color: #fff;
  padding: 20px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  border-radius: 10px;
}

input[type=text], input[type=User]{
  width: 100%;
  padding: 8px 12px;
  margin: 4px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
  border-radius: 5px;
}

button {
  background-color: #04AA6D;
  color: white;
  padding: 10px 14px;
  margin: 4px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  border-radius: 5px;
}

button:hover {
  opacity: 0.8;
}

.findallbtn {
  background-color: #007BFF;
  color: white;
}

.container {
  padding: 10px;
}
---------------------------------------
table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        th, td {
            padding: 8px;
            text-align: left;
        }
        .btn {
            border: none;
            color: white;
            padding: 14px 28px;
            font-size: 16px;
            cursor: pointer;
        }
        .success {
            background-color: #04AA6D; /* Green */
        }
        .success:hover {
            background-color: #46a049;
        }
        .danger {
            background-color: #f44336; /* Red */
        }
        .danger:hover {
            background-color: #da190b;
        }

</style>
</head>
<body>

<div class="form-wrapper">
  <h2 style="text-align:center;">User Search</h2>
  <form action="/userSearch" method="post">
    <div class="container">
      <label for="User Search"><b>User Search</b></label>
      <input type="User" placeholder="Enter Email / Mobile No" name="User">
      
      <button type="submit">Search</button>
    </div>
  </form>
  
  <div class="container">
    <button type="button" class="findallbtn" onclick="window.location.href='/findAllUsers'">Find All Users</button>
  </div>
 <h1>Welcome, intern to Amstech.</h1>

    <table>
        <tr>
            <th>Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Address</th>
            <th>Mobile Number</th>
            <th>Gender</th>
            <th>Email</th>
            <th>Action</th>
        </tr>

        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td>
                <button class="btn success">Edit</button>
                <button class="btn danger">Delete</button>
            </td>
        </tr>
    </table>
</div>

</body>
</html>