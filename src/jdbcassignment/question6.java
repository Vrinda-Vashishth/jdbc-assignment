package jdbcassignment;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class question6 {

	private static Scanner sc;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			// getting reference of current class
			Class.forName("com.mysql.jdbc.Driver");
			//Establishing connection with database via JDBC 
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mealpha","root","root");
			
			PreparedStatement ps = con.prepareStatement("insert into employee values(?,?,?,?,?,?,?,?)");
			sc = new Scanner(System.in);
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			
         
			do
			{
				System.out.println("Enter Employee ID :");
				int empid=sc.nextInt();
				
				System.out.println("Enter First Name :");
				String fname =br.readLine();
				
				System.out.println("Enter Last Name :");
				String lname =br.readLine();
				
				System.out.println("Enter Salary :");
				int sal =sc.nextInt();
				
				System.out.println("Enter Date of Joining :");
				String doj =br.readLine();
				
				System.out.println("Enter Department :");
				String dept =br.readLine();
				
				System.out.println("Enter Department Number :");
				String dept_no =br.readLine();
				
				System.out.println("Enter Email Address :");
				String mail =br.readLine();
				
				ps.setInt(1,empid);  
				ps.setString(2,fname);  
				ps.setString(3,lname);  
				ps.setInt(4,sal);  
				ps.setDate(5,java.sql.Date.valueOf(doj));  
				ps.setString(6,dept);  
				ps.setString(7,dept_no);  
				ps.setString(8,mail);
				
				
				int i=ps.executeUpdate();  
				System.out.println(i+" records affected");  
				  
				System.out.println("Do you want to continue: y/n");  
				String ch=br.readLine();  
				if(ch.startsWith("n"))
				  {  
				    break;  
				  }  
			}	while(true);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
