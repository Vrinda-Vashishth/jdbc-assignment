package jdbcassignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class question5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mealpha","root","root");
			
			Statement stmt = con.createStatement();
			 String query ="Delete from employee where salary < 20000 ";
			
			int row =stmt.executeUpdate(query);
			
			System.out.println(" "+row+" no. of rows deleted.");
			  
			  con.close();
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
	}

	}


