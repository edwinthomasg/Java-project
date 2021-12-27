package EmployeeManagementApplication;

import java.sql.SQLException;
import java.util.ArrayList;

public class SalaryDetails extends EmployeeSalary {
	//@Method to increment salary for employee based on their experience
	public void incrementSalary(ArrayList<EmployeeDetails> arrayList,String userId) throws SQLException
	{
		for(EmployeeDetails employee : arrayList)
		{
			if(userId.equals(employee.employeeId))
			{
		      if(employee.getEmployeeExperience() == 2)
		    	  employee.setEmployeeSalary(employee.getEmployeeSalary() +  (employee.getEmployeeSalary() * 0.2));
		      else  if(employee.getEmployeeExperience() == 4)
		    	  employee.setEmployeeSalary(employee.getEmployeeSalary() +  (employee.getEmployeeSalary() * 0.4));
		      else  if(employee.getEmployeeExperience() == 6)
		    	  employee.setEmployeeSalary(employee.getEmployeeSalary() +  (employee.getEmployeeSalary() * 0.6));
		      else if(employee.getEmployeeExperience() > 6 && employee.getEmployeeExperience() % 2 == 0)
		    	  employee.setEmployeeSalary(employee.getEmployeeSalary() +  (employee.getEmployeeSalary() * 0.8));
		      else
		    	  System.out.println("\nYou are not eligible for salary increment");
		      SqlDatabase sqlDatabase = new SqlDatabase();
		      sqlDatabase.updateSalary(employee.getEmployeeSalary(),employee.employeeId);
			}
		}
	}
}
