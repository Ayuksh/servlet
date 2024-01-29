
<%@page import="application.Food"%>
<%@page import="java.util.List"%>
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
	List<Food> foodList = (List<Food>) request.getAttribute("foodList");
	%>
	<div class="container">
		<h1 align="center">Indian Foods</h1>
		<hr>
	</div>

	<div class="container">

		<table class="table table-sm">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Food Name</th>
					<th scope="col">Diet</th>

				</tr>
			</thead>
			<tbody>
				<%
				for (Food f : foodList) {
				%>
				<tr>
					<th scope="row"><%=f.getFoodId()%></th>
					<td><%=f.getFoodName()%></td>
					<td><%=f.getFoodDiet()%></td>
					<td>
						<a href=<%= "product?id="+f.getFoodId() %>>
							<button type="button" class="btn btn-primary">View</button>
						</a>
					</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>

</body>
</html>