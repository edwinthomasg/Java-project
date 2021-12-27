package EmployeeManagementApplication;


import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public abstract class EmployeeSalary  {
    public int experience,age;
    static int currentYear = 2021; //29/09/2000
    //@Method to calculate employee age
	public void calculateAge(ArrayList<EmployeeDetails> arrayList,String userId)
	{
		if(arrayList.isEmpty())
   	     System.out.println("No employee has been added");
		for(EmployeeDetails employee : arrayList)
		{
			if(userId.equals(employee.employeeId))
			{
			  DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	          LocalDate localDate = LocalDate.now();
	          LocalDate bornDate = LocalDate.parse(employee.birthDate,dateTimeFormatter);
	          Period period = Period.between(bornDate, localDate);
		      employee.employeeAge = period.getYears();
		      System.out.println("\nEmployee age : "+employee.getEmployeeAge());
			}
		}
	}
	//@Method to calculate employee experience
	public void calculateExperience(ArrayList<EmployeeDetails> arrayList,String userId)
	{
		for(EmployeeDetails employee : arrayList)
		{
			if(userId.equals(employee.employeeId))
			{
		      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		      LocalDate localDate = LocalDate.now();
		      LocalDate joinedDate = LocalDate.parse(employee.joinDate,dateTimeFormatter);
	          Period period = Period.between(joinedDate, localDate);
		      experience = period.getYears();
		      employee.employeeExperience = experience;
		      System.out.println("\nEmployee experience : "+employee.getEmployeeExperience());
			}
		}
	}
	public abstract void incrementSalary(ArrayList<EmployeeDetails> arrayList,String userId) throws SQLException;
}
