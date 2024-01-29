package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Service {
	
	private static Connection conn = GetConnection.conn ;
	
	public List<Food> getAllFoodItems()
	{
		List<Food> foodList = new ArrayList();
		String selectQuery = "select id , name , diet from food_info";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(selectQuery);
			while(rs.next())
			{
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String diet = rs.getString(3);
				
				Food food = new Food() ;
				food.setFoodId(id);
				food.setFoodName(name);
				food.setFoodDiet(diet);
				
				foodList.add(food);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return foodList ;
	}
	
	public Food getFoodById(String id)
	{
		String query = "select * from food_info where id = ?";
		PreparedStatement pstmt;
		Food food = new Food();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery() ;
			if(rs.next()) {
				food.setFoodId( rs.getInt(1) );
				food.setFoodName(rs.getString(2));
				food.setFoodIngredients(rs.getString(3));
				food.setFoodDiet(rs.getString(4));
				food.setPrepTime(rs.getInt(5));
				food.setCookTime(rs.getInt(6));
				food.setFlavorProfile(rs.getString(7));
				food.setFoodCourse(rs.getString(8));
				food.setState(rs.getString(9));
				food.setRegion(rs.getString(10));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return food ;
		
	}

	public int deleteProductById(String id) {
		String query = "delete from food_info where id = "+ id ;
		try {
			Statement stmt = conn.createStatement() ;
			int n = stmt.executeUpdate(query);
			return n ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0 ;
		
	}
	

}










