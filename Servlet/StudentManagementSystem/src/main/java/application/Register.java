package application;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Register extends HttpServlet {

	List<Student> studentList = new ArrayList() ;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String rn = req.getParameter("rollNo");
		String name = req.getParameter("name");
		String dob = req.getParameter("dob");
		String degree = req.getParameter("degree");
		String stream = req.getParameter("stream");
		String per = req.getParameter("percentage");
		
		int rollNo = Integer.parseInt(rn);
		double percentage = Double.parseDouble(per);
		
		Student s1 = new Student(rollNo , name , dob , degree , stream , percentage);
	
		studentList.add(s1);
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter() ;
		
		out.print("<table border='1'>");
			out.print("<tr>");
				out.print("<th>ROLL NO </th>");
				out.print("<th>NAME </th>");
				out.print("<th>DOB </th>");
				out.print("<th>DEGREE </th>");
				out.print("<th>STREAM </th>");
				out.print("<th>PERCENTAGE </th>");
			out.print("</tr>");
			
			for(Student s : studentList) {
				out.print("<tr>");
					out.print("<td>"+ s.getRollNo() +"</td>");
					out.print("<td>"+ s.getName() +"</td>");
					out.print("<td>"+ s.getDob() +"</td>");
					out.print("<td>"+ s.getDegree() +"</td>");
					out.print("<td>"+ s.getStream() +"</td>");
					out.print("<td>"+ s.getPercentage() +"</td>");
				out.print("</tr>");
			}
			
		out.print("</table>");
	}
}






