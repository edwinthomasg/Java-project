package EmployeeManagementApplication;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Project extends ProjectDetails{
	 String userId;
	//@Method to display project details assigned to an employee
      public void showWorkingProject(ArrayList<EmployeeDetails> arrayList){
    	  int validationSuccess = 0;
    	  Scanner scanner = new Scanner(System.in);
    	  
    	  do {
	             validationSuccess = 0;
	             System.out.println("Enter emloyee id : ");
	       	     userId = scanner.next();
	              try {
	            	 Pattern pattern = Pattern.compile("ACE[0-9]{4}");
	                 Matcher match = pattern.matcher(userId);
	                 
	                 if(!(match.find() && match.group().equals(userId)) || userId.equals("ACE0000"))
	                 {
	                	 validationSuccess = 1;
	                	 throw new ValidationException("ACE followed by 4digits required (ACE0000) to be avoided, please enter valid id ...");
	                 }
	             }
	             catch(ValidationException validationexception)
	             {
	            	 System.out.println(validationexception.getMessage()); 
	             }
	             }while(validationSuccess != 0);
    	  if(arrayList.isEmpty())
	    	     System.out.println("No employee has been added");
    	  for(EmployeeDetails employee : arrayList)
    	  {
    		  if(userId.equals(employee.employeeId))
    		  {
    			  if(Integer.parseInt(employee.employeeId.substring(3,7)) >= 1000 && 
    					  Integer.parseInt(employee.employeeId.substring(3,7)) < 2000)
    				  System.out.println("BFS - Project 1");
    			  else if(Integer.parseInt(employee.employeeId.substring(3,7)) >= 2000 && 
    					  Integer.parseInt(employee.employeeId.substring(3,7)) < 3000)
    				  System.out.println("EBA Project 2");
    			  else if(Integer.parseInt(employee.employeeId.substring(3,7)) >= 3000 && 
    					  Integer.parseInt(employee.employeeId.substring(3,7)) < 4000)
    				  System.out.println("Dotnet Project 3");
    			
    		  }
    	  }
      }
}
