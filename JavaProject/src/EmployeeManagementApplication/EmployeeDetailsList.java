package EmployeeManagementApplication;

import java.util.ArrayList;

public class EmployeeDetailsList {
	    //@Method to show employee details
        public void showDetails(String userId,ArrayList<EmployeeDetails> arrayList)
        {
        	if(arrayList.isEmpty())
	    	     System.out.println("No employee has been added");
        	 for(EmployeeDetails employee : arrayList)
	     		{
	     			if(userId.equals(employee.employeeId))
	     			{
	     			System.out.println(employee+"\n");
	     			}
	     		}
        }
}
class LocationDetails extends EmployeeDetailsList{
	//@Overiding Method to show employee location
	public void showDetails(String userId,ArrayList<EmployeeDetails> arrayList)
    {
		if(arrayList.isEmpty())
   	     System.out.println("No employee has been added");
    	 for(EmployeeDetails employee : arrayList)
     		{
     			if(userId.equals(employee.employeeId))
     			{
     				 if(Integer.parseInt(employee.employeeId.substring(3,7)) >= 1000 && 
       					  Integer.parseInt(employee.employeeId.substring(3,7)) < 2000)
       				  System.out.println("\nLocation - Chennai");
       			  else if(Integer.parseInt(employee.employeeId.substring(3,7)) >= 2000 && 
       					  Integer.parseInt(employee.employeeId.substring(3,7)) < 3000)
       				  System.out.println("\nLocation - Bangalore");
       			  else if(Integer.parseInt(employee.employeeId.substring(3,7)) >= 3000 && 
       					  Integer.parseInt(employee.employeeId.substring(3,7)) < 4000)
       				  System.out.println("\nLocation - Coimbatore");
     			}
     		}
    }
}