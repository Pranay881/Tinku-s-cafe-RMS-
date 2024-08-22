<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SingUp here</title>
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
  max-width: 300px;
  width: 100%;
  background-color: #fff;
  padding: 80px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  border-radius: 10px;
}

input[type=text], input[type=password], input[type=email], input[type=tel] {
  width: 100%;
  padding: 8px 12px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
  border-radius: 20px;
}

button {
  background-color: #04AA6D;
  color: white;
  padding: 10px 14px;
  margin: 4px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  border-radius: 20px;
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

.resetbtn {
  width: auto;
  padding: 8px 10px;
  background-color: #f44336;
  color: white;
  border-radius: 5px;
}

.container {
  padding: 10px;
}

.container-inline {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

span.psw {
  padding-left: 10px;
}


 (max-width: 150px) {
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
  <h2 style="text-align:center;">Sign Up Form</h2>
  <form action="UserServletFinal" method="post">
  <input type="hidden" name="task" value="singup">
    <div class="container">
      <label for="fname"><b>Firstname</b></label>
      <input type="text" placeholder="Enter First Name" name="firstname" required>
  
      <label for="lname"><b>Last Name</b></label>
      <input type="text" placeholder="Enter Last Name" name="lastname" required>
  
      <label for="email"><b>Email</b></label>
      <input type="email" placeholder="Enter Email" name="email" required>

      <label for="mobile"><b>MobileNumber</b></label>
      <input type="tel" placeholder="Enter Mobile Number" name="mobilenumber" required>
  
      <label for="mobile"><b>address</b></label>
      <input type="text" placeholder="Enter address" name="address" required>
      
      <select name=gender>
      <option value="Male">Male</option>
      <option value="Female">Female</option>
      </select>
      
      <label for="psw"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="Password" required>
   
      <button type="submit">signup</button>
   
    </div>
  
 <div class="container container-inline" style="background-color:#f1f1f1; border-radius: 10px;">
      <button type="reset" class="resetbtn">Reset</button>
      <span class="psw">You Have Already an account? <a href="login.jsp">Login here</a></span>
    </div>
  </form>
</div>

</body>
</html>