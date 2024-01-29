package loginApplication;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {
	
	static private Connection conn ;
	
	@Override
	public void init() throws ServletException {
		
		String url = "jdbc:mysql://localhost:3306/j2ee";
		String username = "root" , password = "tiger" ;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url , username , password);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		String query = "select * from user_info where username = ? and user_password = ?";
		
		PreparedStatement pstmt = null ;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs =  pstmt.executeQuery();
			if(rs.next())
				resp.getWriter().print("<h1> LOGIN SUCCESSFULL !! </h1>");
			else
				resp.getWriter().print("<h1> LOGIN UNSUCCESSFUL !! </h1>");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
