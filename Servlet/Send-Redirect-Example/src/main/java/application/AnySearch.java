package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/search")
public class AnySearch extends HttpServlet{
	
	static Connection conn  ;
	@Override
	public void init() throws ServletException {
		String url = "jdbc:mysql://localhost:3306/questiondb";
		String username = "root" , password = "tiger";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url , username , password);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String searchQuery = req.getParameter("searchQuery");
		
		String query = "select answer from question_answer where question like '%"+searchQuery+"%'";
		ResultSet rs = null ;
		try {
			Statement stmt = conn.createStatement();
			 rs = stmt.executeQuery(query);
			 
			 if(rs.next()) {
				 do{
					 resp.setContentType("text/html");
					 resp.getWriter().print("<h3>"+ rs.getString(1)+"</h3>");
				 }while(rs.next()); 	 
			 }else {
				 resp.sendRedirect("https://www.google.com/search?q="+searchQuery);
			 }
			
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
}
