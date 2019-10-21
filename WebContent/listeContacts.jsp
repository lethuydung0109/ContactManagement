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
	Statement stmtAddress = null;
	ResultSet resultat;
%>
<h2 align="center"><font><strong>Liste Contacts</strong></font></h2>
<table align="center">
	<tr>

		</tr>
			<tr>
			<td><b>ID</b></td>
			<td><b>First Name</b></td>
			<td><b>Last Name</b></td>
			<td><b>Email</b></td>
			<td><b>Address</b></td>
			<td><b> </b></td>
		</tr>
<%
try{ 
	Context ctx = new InitialContext();
	ds=(DataSource)ctx.lookup("java:comp/env/jdbc/jee");
	cn=ds.getConnection();
				
	stmt = (Statement) cn.createStatement();
	stmtAddress = cn.createStatement();
	 
	 //Récupération des contact dans la bd
    resultat =stmt.executeQuery("SELECT * from Contact");
	while(resultat.next()){
		int idAddress = resultat.getInt("idAddress");
		ResultSet rsAddress = stmtAddress.executeQuery("SELECT * FROM address WHERE idaddress = "+ idAddress);
		rsAddress.next();
%>
	<tr>	
		<td><a href="updateContact.jsp/email=<%=resultat.getString("email")%>"><%=resultat.getString("idContact") %></a></td>
		<td><%=resultat.getString("firstname") %></td>
		<td><%=resultat.getString("lastname") %></td>
		<td><%=resultat.getString("email") %></td>
		<td><%=rsAddress.getString("street") + ", " + rsAddress.getString("city") + ", " + rsAddress.getString("zip") + ", " + rsAddress.getString("country") %></td>
		<td><a href=""> Delete </a></td>	
	</tr>

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