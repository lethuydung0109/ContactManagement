<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Contact Page</title>
</head>
<body>
<h1>Create Contact Page</h1>
 <form method="POST" action="contactServlet">
  <div class="container">
    <!-- <label for="uid"><b>id</b></label>
    <input type="text" placeholder="Enter User id" name="id" required> 
    </br> -->
   
    
    <h4>Identity</h4>
	</br>
	<label for="ufirstname"><b>FirstName</b></label>
	<input type="text" placeholder="Enter FirstName" name="firstname" required>
	</br>
	<label for="ulastname"><b>LastName</b></label>
	<input type="text" placeholder="Enter LastName" name="lastname" required>	
	</br>
	<label for="uemail"><b>Email</b></label>
	<input type="email" placeholder="Enter email" name="email" required>
	</br>
	<h4>Address</h4>
	</br>
	<label for="ustreet"><b>Street</b></label>
	<input type="text" placeholder="Enter Street" name="street">
	</br>
	<label for="ucity"><b>City</b></label>
	<input type="text" placeholder="Enter city" name="city">
	</br>
	<label for="uzip"><b>Zip</b></label>
	<input type="text" placeholder="Enter Zip" name="zip">
	</br>
	<label for="ucountry"><b>Country</b></label>
	<input type="text" placeholder="Enter Country" name="country">
	</br>
	<h4>Phones</h4>
	</br>
	<label for="uportable"><b>Portable</b></label>
	<input type="text" placeholder="Enter Phone1" name="portable">
	</br>
	<label for="ufixe"><b>Fixe</b></label>
	<input type="text" placeholder="Enter Phone2" name="fixe">
	</br></br>

    <button type="submit">Create</button>
  </div>
</form> 
</body>
</html>