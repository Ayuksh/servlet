package application;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/calculatelink")
public class Calculator extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String s1 =  req.getParameter("num1");
		String s2 = req.getParameter("num2") ;
		
		int num1 = Integer.parseInt(s1) ;
		int num2 = Integer.parseInt(s2) ;
		
		String op = req.getParameter("operator");
		
		int ans = 0 ;
		
		switch (op) {
		case "add":
			ans = num1 + num2 ;
			break;
		case "sub":
			ans = num1 - num2 ;
			break;
		case "mul":
			ans = num1 * num2 ;
			break;
		case "div":
			ans = num1 / num2 ;
			break;
		
		}
		
		PrintWriter out = resp.getWriter() ;
		
		resp.setContentType("text/html");
		
		out.println(" <h1> ANSWER IS "+ ans + " </h1>");
		
		out.println("<a href='calculator.html'> click here </a>");
		
	}

}
