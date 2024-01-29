package application;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addNumber")
public class AddNumbers extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String s1 = req.getParameter("num1");
		String s2 = req.getParameter("num2");
		
		int num1 = Integer.parseInt(s1);
		int num2 = Integer.parseInt(s2);
		
		int sum = num1 + num2 ;
		PrintWriter pw = resp.getWriter();
		pw.write("<h1 style='color :green'>SUM OF NUMBER IS "+ sum + "</h1>");
		
		
	}

}
