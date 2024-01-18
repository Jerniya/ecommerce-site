<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/includes/head.jsp"%>
<title>E-Commerce Cart</title>
</head>
<body>
     


	<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">Welcome to Our Website</div>
			<div class="card-body">
				<form action="Prod" method="post">
				<div class="form-group">
						<label>Name</label> 
						<input type="text" name="name" class="form-control" placeholder="prod name">
				</div>
					<div class="form-group">
					
						<label>Category</label> 
						<input type="text" name="category" class="form-control" placeholder="Enter category">
					</div>
					<div class="form-group">
						<label>Price</label> 
						<input type="number" name="price" class="form-control" placeholder="Price">
					</div>
					<div class="form-group">
						<label>ImageURL</label> 
						<input type="text" name="url" class="form-control" placeholder="URL">
					</div>
					
					<div class="text-center">
						<button type="submit" class="btn btn-primary">ADD</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<%@include file="/includes/footer.jsp"%>
</body>
</html>