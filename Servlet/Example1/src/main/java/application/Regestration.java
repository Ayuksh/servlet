package application;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registration")
public class Regestration extends HttpServlet {

	Map<String, String> userList = new HashMap<>();
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		
		String toRememeber = req.getParameter("rememberMe");
		
		if (toRememeber != null &&  toRememeber.equals("on")) {
			userList.put(userName, password);	
		}
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		Set<Map.Entry<String, String>> entries = userList.entrySet();
		
		out.print("<table border='1'>");
		out.print("<tr>");
			out.print("<th> USERNAME </th>");
			out.print("<th> PASSWORD </th>");
		out.print("</tr>");
		
		for( Map.Entry<String, String> ent  : entries) {
			out.print("<tr>");
				out.print("<td>"+ent.getKey()+"</td>");
				out.print("<td>"+ent.getValue()+"</td>");
			out.print("</tr>");
		}
		out.print("</table>");
		
	}
	
}
