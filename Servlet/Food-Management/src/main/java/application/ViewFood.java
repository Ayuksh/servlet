package application;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/product")
public class ViewFood extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Service s1 = new Service();
		
		String id = req.getParameter("id");
		Food food = s1.getFoodById(id);
		
		req.setAttribute("food", food);
		
		RequestDispatcher rd = req.getRequestDispatcher("product.jsp");
		rd.forward(req, resp);
		
	}
}
