package jdbcassignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class question7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			// getting reference of current class
			Class.forName("com.mysql.jdbc.Driver");
			//Establishing connection with database via JDBC 
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mealpha","root","root");
			
			Statement stmt = con.createStatement();
			
			 String fk ="ALTER TABLE employee DROP foreign key dept_no";
			 String drop="DROP TABLE deparment";
			
			stmt.executeUpdate(fk);
			stmt.executeUpdate(drop);
			  
			  con.close();
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
	}

}
