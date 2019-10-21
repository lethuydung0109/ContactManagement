<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>

<%
	DataSource ds = null;
	Connection cn =null;
	Statement stmt = null;
	ResultSet resultat;
%>

	
    <button type="submit">Create</button>
<h2 align="center"><font><strong>Liste Contacts</strong></font></h2>
<table align="center">
	<tr>

		</tr>
			<tr>
			<td><b>id</b></td>
			<td><b>FirstName</b></td>
			<td><b>LastName</b></td>
			<td><b>Email</b></td>
			<td><b> </b></td>
		</tr>
<%
try{ 
	Context ctx = new InitialContext();
	ds=(DataSource)ctx.lookup("java:comp/env/jdbc/jee");
	cn=ds.getConnection();
				
	stmt = (Statement) cn.createStatement();
	


    String email = request.getParameter( "email" );
      
	 
	 //Récupération des contact dans la bd
    resultat =stmt.executeQuery("SELECT * from Contact where email="+email);
	while(resultat.next()){
%>

	<h4>Identity</h4>
	</br>
	<label for="ufirstname"><b>FirstName</b></label>
	<input type="text" placeholder="Enter FirstName" name="firstname" value=<%=resultat.getString("firstname")%>">
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
	<input type="text" placeholder="Enter Country" name="Country">
	</br>
	<h4>Phones</h4>
	</br>
	<label for="uportable"><b>Portable</b></label>
	<input type="text" placeholder="Enter Phone1" name="portable">
	</br>
	<label for="ufixe"><b>Fixe</b></label>
	<input type="text" placeholder="Enter Phone2" name="fixe">
	</br></br>
	

<% 
	}
	
	} catch (Exception e) {
	e.printStackTrace();
	}
%>
</table>


<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="ISO-8859-1">
<title>Liste de contact</title>
</head>
<body>
<div class="body"></div>
    <h1>Liste des contacts</h1>
        <br>
        <form method="GET" action="contactServlet" class="login">
        <table class="table">
                	
	      <c:forEach var="contact" items="contacts" varStatus="counter">
	        
	        <tr>
	          <td>${contacts.key}</td>
	          <td>${contacts.value}</td>	          
	         </tr>
	      </c:forEach>
    	</table>
        </form>
</body>
</html> --%>