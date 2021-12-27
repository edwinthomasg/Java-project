package EmployeeManagementApplication;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class SqlDatabase {
	String url = "jdbc:mysql://localhost:3306/employee";
	String userName = "root";
	String password = "Edwin@29";
	public void insertDataToDatabase(String fullName,String employeeId,LocalDate birthDate,LocalDate joinDate,String gender,String designation,String number,
			String email,double defaultSalary)
	{
		Date bornDate = Date.valueOf(birthDate);
		Date joinedDate = Date.valueOf(joinDate);
		
    	
    	/*String query = "create table Employee_Details(Name varchar(20) not null,"
    			+ "Employee_Id varchar(7) primary key not null,"
    			+ "Birth_Date Date,"
    			+ "Joined_Date Date,"
    			+ "Gender varchar(2),"
    			+ "Designation varchar(15),"
    			+ "Phone_Number varchar(10),"
    			+ "Email varchar(20),"
    			+ "Default_Salary double(7,0));";*/
    	String insertionQuery =
    "Insert into Employee_Details (Name,Employee_Id,Birth_Date,Joined_Date,Gender,Designation,Phone_Number,Email,Default_Salary) values(?,?,?,?,?,?,?,?,?);";
		try(Connection connection = DriverManager.getConnection(url,userName,password);
				PreparedStatement preparedStatement = connection.prepareStatement(insertionQuery);
				)
		{
			//preparedStatement.executeUpdate(query);
		    preparedStatement.setString(1,fullName);
			preparedStatement.setString(2,employeeId);
			preparedStatement.setDate(3,bornDate);
			preparedStatement.setDate(4,joinedDate);
			preparedStatement.setString(5,gender);
			preparedStatement.setString(6,designation);
			preparedStatement.setString(7,number);
			preparedStatement.setString(8,email);
			preparedStatement.setDouble(9,defaultSalary);
			preparedStatement.execute();
	
		}
        catch(SQLException sqlException) 
		{
        	sqlException.printStackTrace();
        }
	}
	public void updateSalary(double Salary,String employeeId) throws SQLException
	{
		String salaryQuery = "update Employee_Details set Default_Salary = "+Salary+" where Employee_Id = '"+employeeId+"'";
		try(Connection connection = DriverManager.getConnection(url,userName,password);
				PreparedStatement preparedStatement = connection.prepareStatement(salaryQuery);) {
			preparedStatement.execute();
		}
		 catch(SQLException sqlException) 
		{
        	sqlException.printStackTrace();
        }
	}
	public void updateEmail(String email,String employeeId)
	{
		String emailQuery = "update Employee_Details set Email = '"+email+"' where Employee_Id = '"+employeeId+"'";
		try(Connection connection = DriverManager.getConnection(url,userName,password);
				PreparedStatement preparedStatement = connection.prepareStatement(emailQuery);) {
			preparedStatement.execute();
		}
		 catch(SQLException sqlException) 
		{
        	sqlException.printStackTrace();
        }
	}
	public void updateContact(String contact,String employeeId)
	{
		String contactQuery = "update Employee_Details set Phone_Number = '"+contact+"' where Employee_Id = '"+employeeId+"'";
		try(Connection connection = DriverManager.getConnection(url,userName,password);
				PreparedStatement preparedStatement = connection.prepareStatement(contactQuery);) {
			preparedStatement.execute();
		}
		 catch(SQLException sqlException) 
		{
        	sqlException.printStackTrace();
        }
	}
	public void deleteRecord(String employeeId) {
		String contactQuery = "delete from Employee_Details where Employee_Id = '"+employeeId+"'";
		try(Connection connection = DriverManager.getConnection(url,userName,password);
				PreparedStatement preparedStatement = connection.prepareStatement(contactQuery);) {
			preparedStatement.execute();
		}
		 catch(SQLException sqlException) 
		{
        	sqlException.printStackTrace();
        }
	}
		

}
