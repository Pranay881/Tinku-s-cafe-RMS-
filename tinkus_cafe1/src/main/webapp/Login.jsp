<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login here</title>
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
  max-width: 500px;
  width: 200%;
  background-color: #fff;
  padding: 40px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  border-radius: 10px;
}

input[type=text], input[type=password] {
  width: 100%;
  padding: 10px 14px;
  margin: 6px 0;
  display: inline-block;
  border: 2px solid #ccc;
  box-sizing: border-box;
  border-radius: 100px;
}

button {
  background-color: #04AA6D;
  color: white;
  padding: 10px 14px;
  margin: 6px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  border-radius: 10px;
}

button:hover {
  opacity: 0.9;
}

.cancelbtn {
  width: auto;
  padding: 8px 10px;
  background-color: #f44336;
  border-radius: 5px;
}

.container {
  padding: 20px;
}

span.psw {
  float: right;
  padding-top: 10px;
}

@media screen and (max-width: 150px) {
  span.psw {
     display: block;
     float: none;
  }
  .cancelbtn {
     width: 100%;
  }
}
</style>
</head>
<body>

<div class="form-wrapper">
  <h2 style="text-align:center;">Login Form</h2>
  <form action="UserServletFinal" method="post">
  <input type="hidden" name="task" value="Login">
    <div class="container">
      <label for="uname"><b>Username</b></label>
      <input type="text" placeholder="Enter Username" name="Username">
  
      <label for="psw"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="Password">
          
       <button type="submit">Login</button>
    </div>
  
    <div class="container" style="background-color:#f1f1f1; border-radius: 10px;">
      <button type="reset" class="cancelbtn">Reset</button>
      <span class="psw">Sign Up <a href="#">Here</a></span>
    </div>
  </form>
</div>
</body>
</html>