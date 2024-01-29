<%@page import="application.Food"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<%
	Food food = (Food) request.getAttribute("food");
	String color;
	if (food.getFoodDiet().equals("vegetarian"))
		color = "#DAF7A6";
	else
		color = "#F1948A";
	%>
	<div class="container mt-4 border border-dark">
		<div style="background-color: <%=color%> " align="center"
			class="container ">
			<h1>
				<%=food.getFoodName()%>
			</h1>
		</div>

		<div align="center" class="container p-5">
			<div class="row">

				<div class="col">
					<h4>Preparation Time</h4>
					<p>
						<%=food.getPrepTime()%>
					</p>
				</div>
				<div class="col">
					<h4>Cook Time</h4>
					<p>
						<%=food.getCookTime()%>
					</p>
				</div>

			</div>
			<hr>
			<div class="row">
				<h4>Ingredients</h4>
				<p>
					<%=food.getFoodIngredients()%>
				</p>
			</div>
			<hr>
			<div class="row">

				<div class="col">
					<h4>Flavor profile</h4>
					<p>
						<%=food.getFlavorProfile()%>
					</p>
				</div>

				<div class="col">
					<h4>Course</h4>
					<p>
						<%=food.getFoodCourse()%>
					</p>
				</div>

				<div class="col">
					<h4>State, Region</h4>
					<p>
						<%=food.getState() + ", " + food.getRegion()%>
					</p>
				</div>

			</div>

			<div class="row">
				<div class="col">

				<a href=<%= "delete?id="+food.getFoodId() %>>	<button type="button" class="btn btn-danger">Delete</button></a>
				</div>
				<div class="col">

				 <a href=<%= "update?id="+food.getFoodId() %>  >	<button type="button" class="btn btn-warning">update</button> </a>
				</div>

			</div>
		</div>
	</div>
</body>
</html>









