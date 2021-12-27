package EmployeeManagementApplication;

import java.util.ArrayList;
import java.util.Iterator;

public class UpdatedRecord {
	  //@Method to delete the record from a database
      public void editRecord(ArrayList<EmployeeDetails> arrayList,String userId)
      {
    	  if(arrayList.isEmpty())
	    	     System.out.println("No employee has been added");
    	  Iterator iterator = arrayList.iterator();
    	  UpdatedRecord updatedrecord = new UpdatedRecord();
		  Object employeeObject = updatedrecord.show(arrayList,userId);
    	  while(iterator.hasNext())
    	  {
    		  Object object = iterator.next();
    		  if(object.equals(employeeObject))
    			  iterator.remove();
    	  }
      }
      //@Method to return an object that matches given employeeId
      public Object show(ArrayList<EmployeeDetails> arrayList,String userId)
      {
    	  for(EmployeeDetails employee : arrayList)
    	  {
    		  if(userId.equals(employee.employeeId))
    		  {
    			  SqlDatabase sqlDatabase = new SqlDatabase();
    		      sqlDatabase.deleteRecord(employee.employeeId);
    			  return employee;
    		  }
    	  }
		
    	  return null;
      }
     //@Method to update new contact number for an employee
      public void editRecord(ArrayList<EmployeeDetails> arrayList,String userId,String number)
      {
    	  if(arrayList.isEmpty())
	    	     System.out.println("No employee has been added");
    	  for(EmployeeDetails employee : arrayList)
    	  {
    		  if(userId.equals(employee.employeeId))
    		  {
    			  employee.number = number;
    		  }
    		  SqlDatabase sqlDatabase = new SqlDatabase();
		      sqlDatabase.updateContact(employee.number,employee.employeeId);
    	  }
      }
    //@Method to update new email id for an employee
      public void editRecord(String email,ArrayList<EmployeeDetails> arrayList,String userId)
      {
    	  if(arrayList.isEmpty())
	    	     System.out.println("No employee has been added");
    	  for(EmployeeDetails employee : arrayList)
    	  {
    		  if(userId.equals(employee.employeeId))
    		  {
    			  employee.email = email;
    			  SqlDatabase sqlDatabase = new SqlDatabase();
    		      sqlDatabase.updateEmail(employee.email,employee.employeeId);
    		  }
    	  }
      }
}

