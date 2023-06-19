<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Edit Profile</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<link rel="stylesheet" href="./../signup/CSS/signup.css">
</head>
<body>
	<%
		System.out.println(request.getAttribute("fName")+" "+request.getAttribute("lName"));
	%>
	<div class="container">
		<h3 >Edit Profile</h3>
		<form action="controller" method="post">
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">First Name</label> 
				<input type="text" class="form-control" name="fname" value="<%=request.getAttribute("fName") %>"
					id="exampleInputEmail1" aria-describedby="emailHelp">
				<label for="exampleInputPassword1" class="form-label">Last Name</label>
				<input type="text" class="form-control" name="lname" value="<%=request.getAttribute("lName") %>"
					id="exampleInputPassword1">
				<label for="exampleInputPassword1" class="form-label">Student ID</label>
				<input type="text" class="form-control" name="show" value="<%=request.getParameter("sid") %>"  disabled="disabled"
					id="exampleInputPassword1">
				<input type="hidden" name="sid" value="<%=request.getParameter("sid") %>"/>
				<label for="exampleInputPassword1" class="form-label" >Password</label>
				<input type="password" class="form-control" name="pwd" value="<%=request.getAttribute("password") %>"
					id="exampleInputPassword1">
				<input type="hidden" name="form-type" value="Update"/>
			</div>
			<button type="submit" class="btn btn-primary">Update</button>
		</form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
</body>
</html>