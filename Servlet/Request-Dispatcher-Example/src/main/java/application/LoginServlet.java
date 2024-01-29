package application;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if(username.equals("Ayush") && password.equals("Ayush@123")) {
			RequestDispatcher rd =  req.getRequestDispatcher("welcome");
			rd.forward(req, resp);
		}else {
			resp.setContentType("text/html");
			resp.getWriter().print("<h1 style='color:red'> INVAILD CREDENTIALS !! </h1>");
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.include(req, resp);
		}
	}
	

}
