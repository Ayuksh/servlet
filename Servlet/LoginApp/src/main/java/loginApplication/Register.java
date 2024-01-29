package loginApplication;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Register extends HttpServlet {
	static private Connection conn;

	@Override
	public void init() throws ServletException {

		String url = "jdbc:mysql://localhost:3306/j2ee";
		String username = "root", password = "tiger";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter(); 
		
		String p1 = req.getParameter("password1");
		String p2 = req.getParameter("password2");
		if (p1.equals(p2)) {
			
			String username = req.getParameter("username");
			String email = req.getParameter("email");
			String dob = req.getParameter("date");
			String gender = req.getParameter("gender");
			String phoneNo = req.getParameter("phoneNo");
			String query = "insert into user_info\r\n"
					+ "(username , email , dob , gender , phone_no , user_password)\r\n"
					+ "values(? , ? , ? , ? , ? , ?)";
			
			try {
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setString(1, username);
				pstmt.setString(2, email);
				pstmt.setString(3, dob);
				pstmt.setString(4, gender);
				pstmt.setInt(5, Integer.parseInt(phoneNo));
				pstmt.setString(6, p1);
				
				int n = pstmt.executeUpdate();
				if(n>0)
					out.print("<h1 style='color:green'>  Register successfull !!</h1>");
				else
					out.print("<h1 style='color:red'> Username not available !!</h1>");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}else {
			out.print("<h1 style='color:red'> Password mismatch !!</h1>");
		}
	}
	
	
}
