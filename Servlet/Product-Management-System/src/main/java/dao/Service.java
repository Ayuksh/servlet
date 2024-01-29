package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.Product;

public class Service {
	
	public List<Product> displayAllProducts()
	{
		List<Product> productList = new ArrayList();
		Connection conn = GetConn.conn ;
		String selectQuery = "select * from product_info"  ;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(selectQuery);
			
			while(rs.next())
			{
				int id = rs.getInt(1);
				String name = rs.getString(2);
				double price = rs.getDouble(3);
				String type = rs.getString(4);
				Product pro = new Product(id, name, price, type);
				productList.add(pro);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList ;
	}
	
	
	
}
