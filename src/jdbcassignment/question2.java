package jdbcassignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class question2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mealpha","root","root");
			System.out.println("getting here");
			String query=" select distinct * from employee e,deparment d where salary = (select distinct salary from employee order by salary desc limit 2,1) and e.dept_no=d.dept_no order by salary desc;";
			Statement stmt=con.createStatement();
		 	ResultSet rs = stmt.executeQuery(query);
		 	
		 	while(rs.next()) {
				  System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8));
			  }
		
		 	con.close();
		 	
		}catch(Exception e)
		{
			e.printStackTrace();
		}


	}

}
