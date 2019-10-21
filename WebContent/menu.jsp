<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Accueil</title>
	<style type="text/css">
		nav ul{
			padding: 0px;
			margin: 0 px;
			list-style-type:none;
		}
		
		nav li {
			display:inline-block;
		}
	</style>
</head>
<body>
	<h2> Accueil </h2>
	<nav>
		<ul>
			<li><a>Contacts</a></li>
			<li><a>Groups</a></li>
		</ul>
	</nav>
	<br>
	
	<a href="createContact.jsp">Créer un nouveau contact</a> </br>
	
	<h3> Liste des contacts</h3>
	
	<a href="listeContacts.jsp">voir les contacts</a> </br>

	
</body>
</html>