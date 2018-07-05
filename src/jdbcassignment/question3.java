package jdbcassignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class question3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mealpha","root","root");
			
			 Statement stmt = con.createStatement();
			 String query=" select  * from employee e,deparment d where  e.dept_no=d.dept_no and lower(d.dept_name)='hr';";
			 ResultSet rs = stmt.executeQuery(query);
			 String mail="",next_query="";
			  Scanner sc= new Scanner(System.in);
			  while(rs.next()) {
				  
				  System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8));
				 
				  System.out.println("Enter the New email : ");
				  
				  mail = sc.nextLine();
				  next_query = "update employee set empmail = '"+mail+"' where empid= '"+rs.getInt(1)+"'";
				 
				  Statement stmt2 = con.createStatement();
				  System.out.println(stmt2.executeUpdate(next_query)+"row updated");
			  }
			  sc.close();
			  con.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
