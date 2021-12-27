package EmployeeManagementApplication;

public class EmployeeDetails {
	       public String fullName,employeeId,birthDate,joinDate,designation,number,email,gender;
	       private double employeeSalary;
	       public int employeeAge,employeeExperience;
	       //Constructor to initialize values for an object
           public EmployeeDetails(String fullName,String employeeId,String birthDate,String joinDate,String gender,
        		   String designation,String number,String email,double defaultSalary)
           {
        	   this.fullName = fullName;
        	   this.employeeId = employeeId;
        	   this.birthDate = birthDate;
        	   this.joinDate = joinDate;
        	   this.designation = designation;
        	   this.gender = gender;
        	   this.number = number;
        	   this.email = email;
        	   this.employeeSalary = defaultSalary;
           }
           //@Method to display message when object is printed
           public String toString() 
           {
        	   return "\nEmployee Name : "+this.fullName
   					+"\nEmployee Id : "+this.employeeId+
   					"\nEmployee Designation : "+this.designation+
   					"\nEmployee Gender : "+this.gender+
   					"\nEmployee Birthdate : "+this.birthDate+
   					"\nEmployee JoinDate : "+this.joinDate+
   					"\nEmployee contact : "+this.number+
   					"\nEmployee email id : "+this.email+
   					"\nAssigned salary : "+this.employeeSalary;
           }
           //@Method to set employee salary
           public void setEmployeeSalary(double employeeSalary)
           {
        	   this.employeeSalary = employeeSalary;
           }
           //@Method to get employee salary
           public double getEmployeeSalary()
           {
        	   return this.employeeSalary;
           }
           //@Method to get employee age
           public int getEmployeeAge()
           {
        	   return this.employeeAge;
           }
           //@Method to get employee experience
           public int getEmployeeExperience()
           {
        	   return this.employeeExperience;
           }

}
