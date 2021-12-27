/*Title - Employee Management System
	 Description - Used to add an employee,display the employee details,setting new salary,project details,updating the details entered
	 Author - Edwin 
	 Created at - 04/10/2021
	 Updated at - 25/10/2021
	 Reviewed by - Akshaya 
	*/

package EmployeeManagementApplication;
import java.sql.SQLException;

	public class EmployeeManagement {
		
		public static void main(String[] args) throws InterruptedException, SQLException {
			EmployeeCredentials employeeCredentials = new EmployeeCredentials();
			employeeCredentials.getUserCredentials();
		}
		
	}


