<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String n1 = request.getParameter("n1");
		String n2 = request.getParameter("n2");
		
		double num1 = Double.parseDouble(n1);
		double num2 = Double.parseDouble(n2);
	%>
	
	 <h1> ADDITION OF <%= num1 %> & <%= num2 %> is <%= num1+num2 %>  </h1>
	
</body>
</html>