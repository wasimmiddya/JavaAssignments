<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Profile</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<link rel="stylesheet" href="./profile.css" />
</head>
<body>
	<%

	String firstName = (String) session.getAttribute("fName");
	String lastName = (String) session.getAttribute("lName");
	Integer sid = (Integer) session.getAttribute("sid");
	
	if(firstName == null && lastName == null && sid == null) {
		firstName = "first name";
		lastName = "last name";
		sid = 0;
	}
	String description = "Hi there I am " + firstName + " " + lastName + " and I'm from bangaluru." + "My student id is "
			+ sid;
	%>
	
	<h1>Manage your profile</h1>
	<div class="card" style="width: 20rem;">
		<img src="./images/illustpro.png" class="card-img-top" alt="prof-img"
			height="300">
		<div class="card-body">
			<h5 class="card-title"><%=firstName + " " + lastName%></h5>
			<p class="card-text"><%=description%></p>
			<a href="./controller/prof_edit?sid=<%=sid %>" class="btn btn-primary" >Edit
				Profile</a>
			<a href="./controller/log_out" class="btn btn-primary" >Logout
				</a>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
</body>
</html>