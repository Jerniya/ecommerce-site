<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/includes/head.jsp"%>
<title>E-Commerce Cart</title>
</head>
<body>
     
    <%@include file="/includes/navbar.jsp"%>

	<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">Welcome to Our Website!!!Signin</div>
			<div class="card-body">
				<form action="Signin" method="post">
				<div class="form-group">
						<label>Name</label> 
						<input type="text" name="name" class="form-control" placeholder="your goodname">
				</div>
					<div class="form-group">
					
						<label>Email address</label> 
						<input type="email" name="login-email" class="form-control" placeholder="Enter email">
					</div>
					<div class="form-group">
						<label>Password</label> 
						<input type="password" name="login-password" class="form-control" placeholder="Password">
					</div>
					
					
					<div class="text-center">
						<button type="submit" class="btn btn-primary">Signin</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<%@include file="/includes/footer.jsp"%>
</body>
</html>