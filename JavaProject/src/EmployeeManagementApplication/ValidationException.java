package EmployeeManagementApplication;

public class ValidationException extends Exception {
	    //@Method to throw an exception
        public ValidationException(String message)
         {
        	 super(message);
         }
}
