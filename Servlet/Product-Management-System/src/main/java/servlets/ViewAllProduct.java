package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Service;
import dto.Product;

@WebServlet("/view")
public class ViewAllProduct extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Service service = new Service() ;
		List<Product> productList =  service.displayAllProducts() ;
		
		PrintWriter out= resp.getWriter() ;
		
		out.print("<table border='1'>");
				out.print("<tr>");
					out.print("<td> Id </td>");
					out.print("<td> NAME </td>");
					out.print("<td> PRICE </td>");
					out.print("<td> TYPE </td>");
				out.print("</tr>");
				
				for(Product p : productList) {
					out.print("<tr>");
						out.print("<td> "+p.getProductId()+" </td>");
						out.print("<td> "+p.getProductName()+" </td>");
						out.print("<td> "+p.getProductPrice()+" </td>");
						out.print("<td> "+p.getProductType()+" </td>");
					out.print("</tr>");
				}
		out.print("</table>");
		
		
		
	}

}
