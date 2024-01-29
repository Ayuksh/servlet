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
	%>

	<div align="center" class="conatiner mt-5">
		<h1>UPDATE FOOD !!</h1>
	</div>
	<form action="updateFood">
		<input name="id" required="required" readonly="readonly" type="text" value="<%= food.getFoodId() %>"  hidden>
	
		<div style="width: 800px" class="container mt-5 p-4 border">
			<div class="row">
				<div class="input-group mb-3">
					<span class="input-group-text" id="basic-addon1">Food name </span>
					<input type="text" name="foodName"
						value="<%=food.getFoodName()%>" class="form-control">
				</div>

			</div>

			<div class="row">
				<div class="col">
					<div class="input-group mb-3">
						<span class="input-group-text" id="basic-addon1">Preparation
							time </span> <input type="text" name="prepTime"
							value="<%=food.getPrepTime()%>" class="form-control">
					</div>
				</div>

				<div class="col">
					<div class="input-group mb-3">
						<span class="input-group-text" id="basic-addon1">Cook Time
						</span> <input type="text" name="cookTime"
							value="<%=food.getCookTime()%>" class="form-control">
					</div>
				</div>

			</div>

			<div class="row">
				<div class="input-group">
					<span class="input-group-text">Ingredients</span>
					<textarea class="form-control" name="ingredients"
						value="<%=food.getFoodIngredients()%>"
						aria-label="With textarea"></textarea>
				</div>

			</div>

			<div class="row mt-4">
				<div class="col">
					<div class="input-group mb-3">
						<span class="input-group-text" id="basic-addon1">Flavor
							profile </span> <input type="text" name="foodFlavor"
							value="<%=food.getFlavorProfile()%>" class="form-control">
					</div>
				</div>

				<div class="col">
					<div class="input-group mb-3">
						<span class="input-group-text" id="basic-addon1">Course </span> <input
							type="text" name="foodCourse" value="<%=food.getFoodCourse()%>"
							class="form-control">
					</div>
				</div>

				<div class="col">
					<div class="input-group mb-3">
						<span class="input-group-text" id="basic-addon1">State,
							Region </span> <input type="text" name="state&Region"
							value="<%=food.getState() + ", " + food.getRegion()%>"
							class="form-control">
					</div>
				</div>

			</div>


		</div>
		<div class="mt-3" align="center">
			<button type="submit" class="btn btn-success">Save</button>
		</div>

	</form>
</body>
</html>