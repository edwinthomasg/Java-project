package EmployeeManagementApplication;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeCredentials extends Thread {
	public String fullName,employeeId,birthDate,joinDate,designation,userId,number,email,gender;
	double defaultSalary = 30000;
	public int age;
	LocalDate bornDate,joinedDate;
	//@Method to display employee details
	public static void displayEmployeeDetails(ArrayList<EmployeeDetails> arrayList)
	{
		 System.out.println("-----------------------------------------------------------------------------Details as follows------------------------------------------------------------------------");
		for(EmployeeDetails employee : arrayList) 
			System.out.println(employee); 
	}
	//@Method to display menu to perform operations
	public static void showMenu()
	{
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	    System.out.println("1.Add employee");
	    System.out.println("2.Display employee details");
	    System.out.println("3.Set new salary");
	    System.out.println("4.Project details");
	    System.out.println("5.List all");
	    System.out.println("6.Edit details");
	    System.out.println("7.Exit");
	    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	}
	//@Method to read employee details
	public void getUserCredentials() throws InterruptedException, SQLException
	{
		
		Scanner scanner = new Scanner(System.in);
		ArrayList<EmployeeDetails> arrayList = new ArrayList<EmployeeDetails>();
		boolean loop = true;
		System.out.println();
		System.out.println(String.format("%92s","Welcome to Aspire Systems\n"));
		do {
		    int valid = 0 ;
		    showMenu();
		    System.out.println("Enter your choice : ");
		    
		    int choice = Integer.parseInt(scanner.next());//1
		    scanner.nextLine();
		    
		    switch(choice)
		    {
		    case 1 : System.out.println("-------------------------------------------------------Fill the details to register an employee into database--------------------------------------------------------");       
		    	     do
		             {
		             System.out.println("Enter employee name : ");
		             fullName = scanner.nextLine();//2
		             int alphabet[] = new int[26];
		             valid = 0;
		             try 
		             {
		             for(int iterator = 0;iterator < fullName.length() - 1;iterator++)
		               {
		            	 if(fullName.charAt(0) == ' ')
		            	 {
		            		 valid = 1;
		            		 throw new ValidationException("Name should not starts with space ,Please enter valid name ...");
		            	 }
		            	 if((fullName.charAt(iterator) >= 65 && fullName.charAt(iterator) <= 90) || 
		            			 (fullName.charAt(iterator) >= 97 && fullName.charAt(iterator) <= 122) || (fullName.charAt(iterator) == ' '))
                         {
		                   if(fullName.charAt(iterator) == fullName.charAt(iterator+1) && fullName.charAt(iterator) != ' ')
		                   {
		        	          alphabet[fullName.charAt(iterator) - 97]++;
		        	          if(alphabet[fullName.charAt(iterator) - 97] == 2)
		        	          {
		        		      valid = 1;
		        	          throw new ValidationException("Consecutive repeated characters more than two are not allowed ,Please enter valid name ...");
		        	          }
		                   }
                         }
		            	 else
		            	 {
		            		 valid = 1;
		            		 throw new ValidationException("Only alphabets are allowed (Special characters,digits) are not allowed ,Please enter valid name ...");
		                 }
		                }
		             }
		             catch(ValidationException validationexception)
		             {
		            	System.out.println(validationexception.getMessage());
		             }
		           }while(valid != 0);
		             
		             do {
		             valid = 0;
		             System.out.println("Enter employee id : ");
		             employeeId = scanner.next();
		             try {
		            	 Pattern pattern = Pattern.compile("ACE[0-9]{4}");
		                 Matcher match = pattern.matcher(employeeId);
		                 
		                 if(!(match.find() && match.group().equals(employeeId)) || employeeId.equals("ACE0000"))
		                 {
		                	 valid = 1;
		                	 throw new ValidationException("ACE followed by 4digits required (ACE0000) to be avoided, please enter valid id ...");
		                 }
		             }
		             catch(ValidationException validationexception)
		             {
		            	 System.out.println(validationexception.getMessage()); 
		             }
		             }while(valid != 0);
		             
		             do {
		             valid = 0;
		             System.out.println("Enter employee gender : choose either (M/F/T) ");
		             gender = scanner.next();
		             try 
		             {
		             if(!(gender.equals("M")) && !(gender.equals("F")) && !(gender.equals("T")) )
		             {
		            	 valid = 1;
		            	 throw new ValidationException("Please enter valid gender (M/F/T) ...");
		             }
		             }
		             catch(ValidationException validationexception)
		             {
		            	 System.out.println(validationexception.getMessage());
		             }
		             }while(valid != 0);
		            
		             do
		             {
		             System.out.println("Enter employee designation : (Developer/Analyst/Architect)");
		             designation = scanner.next();
		             int alphabet[] = new int[26];
		             valid = 0;
		             try 
		             {
		            	 if(!(designation.equalsIgnoreCase("Developer") ||designation.equalsIgnoreCase("Analyst") || 
		            			 designation.equalsIgnoreCase("Architect")))
		            	 {
		            		 valid = 1;
		            		 throw new ValidationException("Read above job roles and choose according to that");
		            	 }
		            		 
		             for(int iterator = 0;iterator < designation.length() - 1;iterator++)
		               {
		           
		            	 if((designation.charAt(iterator) >= 65 && designation.charAt(iterator) <= 90) || 
		            			 (designation.charAt(iterator) >= 97 && designation.charAt(iterator) <= 122) || (designation.charAt(iterator) == ' '))
                         {
		                   if(designation.charAt(iterator) == designation.charAt(iterator+1) && designation.charAt(iterator) != ' ')
		                   {
		        	          alphabet[designation.charAt(iterator) - 97]++;
		        	          if(alphabet[designation.charAt(iterator) - 97] == 2)
		        	          {
		        		      valid = 1;
		        	          throw new ValidationException("Consecutive repeated characters more than two are not allowed ,Please enter valid designation ...");
		        	          }
		                   }
                         }
		            	 else
		            	 {
		            		 valid = 1;
		            		 throw new ValidationException("Special characters and digits are not allowed ,Please enter valid designation ...");
		                 }
		                }
		             }
		             catch(ValidationException validationexception)
		             {
		            	System.out.println(validationexception.getMessage());
		             }
		           }while(valid != 0);
		             do {
		             valid = 0;
		             System.out.println("Enter employee Birthdate : (dd-mm-yyyy)");
		             birthDate = scanner.next(); //19-10-2015 29-10-2015 09-10-2015 
		             try {
		            	 DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			             LocalDate localDate = LocalDate.now();
			             bornDate = LocalDate.parse(birthDate,dateTimeFormatter);
			             
			             Period period = Period.between(bornDate, localDate);
			             try {
			                 if(bornDate.compareTo(localDate) <= 0)
			                 {
			                 age = period.getYears();
			                 if(age < 20 || age > 60)
			                 {
			            	 valid = 1;
			             	 throw new ValidationException("Age limit should be in 20 - 60 "); 
			                 }
			                 }
			                 else
			                 {
			                	 valid = 1;
				            	 throw new ValidationException("Birth date can't be future date ..."); 
			                	 
			                 }
			             }
			             catch(ValidationException validationexception)
			             {
			            	 valid = 1;
			            	 System.out.println(validationexception.getMessage());
			             }
		             }
		             catch(DateTimeParseException parseException)
		             {
		            	 valid = 1;
		            	 System.out.println("Invalid date format (dd-mm-yyyy) ...");
		             }
		             }while(valid != 0);
		             
		             do {
			             valid = 0;
			             System.out.println("Enter employee Joindate : (dd-mm-yyyy)");
			             joinDate = scanner.next(); //29-30-2012
			             try {
			            	 DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				             LocalDate localDate = LocalDate.now();
				             joinedDate = LocalDate.parse(joinDate,dateTimeFormatter);
				             LocalDate dateOfBirth = LocalDate.parse(birthDate,dateTimeFormatter);
				             Period period = Period.between(joinedDate, localDate);
				             Period duration = Period.between(dateOfBirth, joinedDate);
				             try {
				            	 if(joinedDate.compareTo(localDate) <= 0)
				                 {
				            	    if(duration.getYears() < 18) //19<21
				            	    {
				            	    	 valid = 1;
						            	 throw new ValidationException("Eligible once you turned 18 ...");  
				            	    }
				                 }
				                 else
				                 {
				                	 valid = 1;
					            	 throw new ValidationException("Join date can't be future date ...");  
				                 }
				             }
				             catch(ValidationException validationexception)
				             {
				            	 valid = 1;
				            	 System.out.println(validationexception.getMessage());
				             }
			             }
			             catch(DateTimeParseException parseException)
			             {
			            	 valid = 1;
			            	 System.out.println("Invalid date format (dd-mm-yyyy) ...");
			             }
			             }while(valid != 0);
		             
		             do {
		             valid = 0;
		             System.out.println("Enter employee phone number : "); //[6789]
		             number = scanner.next();
		             try {
		            	 Pattern pattern = Pattern.compile("[6789][0-9]{9}");
		                 Matcher match = pattern.matcher(number);
		                 
		                 if(!(match.find() && match.group().equals(number)))
		                 {
		                	 valid = 1;
		                	 throw new ValidationException("Contact should starts with either (6/7/8/9) and should contains only 10digits ...");
		                 }
		                
		             }
		             catch(ValidationException validationexception)
		             {
		            	 System.out.println(validationexception.getMessage());
		             }
		             }while(valid != 0);
		             do {
		             valid = 0;
		             System.out.println("Enter employee  email id : ");
		             email = scanner.next();
		             try {
		            	 Pattern pattern = Pattern.compile("[a-z]+[0-9]*@[a-z]+.com");
		                 Matcher match = pattern.matcher(email);
		                 if(!(match.find() && match.group().equals(email)))
		                 {
		                	 valid = 1;
		                	 throw new ValidationException("Email invalid username should starts with lowercase followed by digits if any, and domain should be lowercase characters ...");
		                 }
		                 String userName = email.substring(0,email.indexOf('@'));
		                 int alphabet[] = new int[26];
		                 for(int iterator = 0;iterator < userName.length() - 1;iterator++)
			               {
			                   if(userName.charAt(iterator) == userName.charAt(iterator+1))
			                   {
			        	          alphabet[userName.charAt(iterator) - 97]++;
			        	          if(alphabet[userName.charAt(iterator) - 97] == 2)
			        	          {
			        		      valid = 1;
			        	          throw new ValidationException("Consecutive repeated characters more than two are not allowed in username,Please enter valid username ...");
			        	          }
			                   }
	                    
			                }
		                 String domain = email.substring(email.indexOf('@'),email.indexOf('.'));
		                 int alphaCharacters[] = new int[26];
		                 for(int iterator = 0;iterator < domain.length() - 1;iterator++)
			               {
			                   if(domain.charAt(iterator) == domain.charAt(iterator+1))
			                   {
			                	   alphaCharacters[domain.charAt(iterator) - 97]++;
			        	          if(alphaCharacters[domain.charAt(iterator) - 97] == 2)
			        	          {
			        		      valid = 1;
			        	          throw new ValidationException("Consecutive repeated characters more than two are not allowed in domain,Please enter valid domain ...");
			        	          }
			                   }
	                    
			                }
		             }
		             catch(ValidationException validationexception)
		             {
		            	 System.out.println(validationexception.getMessage());
		             }
		             }while(valid != 0);
		             EmployeeDetails employeedetails = new EmployeeDetails(fullName,employeeId,birthDate,joinDate,gender,designation,number,email,defaultSalary);
		             arrayList.add(employeedetails);
		             
		             SqlDatabase sqlDatabase = new SqlDatabase();
		             sqlDatabase.insertDataToDatabase(fullName,employeeId,bornDate,joinedDate,gender,designation,number,email,defaultSalary);
		             Thread thread = new Thread();
		             thread.sleep(1500);
		             displayEmployeeDetails(arrayList);
		             break;
		    case 2 : 
		    	     System.out.println("1.Employee details\n2.Location details");
		    	     System.out.println("\nEnter your choice : ");
		    	     choice = Integer.parseInt(scanner.next());//1
		 		     scanner.nextLine();
		             do {
			             valid = 0;//changes
			             System.out.println("Enter employee id : ");
			             userId = scanner.next();
			             try {
			            	 Pattern pattern = Pattern.compile("ACE[0-9]{4}");
			                 Matcher match = pattern.matcher(userId);
			                 
			                 if(!(match.find() && match.group().equals(userId)) || userId.equals("ACE0000"))
			                 {
			                	 valid = 1;
			                	 throw new ValidationException("ACE followed by 4digits required (ACE0000) to be avoided, please enter valid id ...");
			                 }
			             }
			             catch(ValidationException validationexception)
			             {
			            	 System.out.println(validationexception.getMessage());
			             }
			             }while(valid != 0);
		             if(choice == 1)
		             {
		             EmployeeDetailsList employeedetailslist = new EmployeeDetailsList();
		             employeedetailslist.showDetails(userId,arrayList);//method overiding
		             }
		             else {
		             LocationDetails locationdetails = new LocationDetails();
                     locationdetails.showDetails(userId,arrayList);
		             }
		             break;
		    case 3 :  do {
			             valid = 0;
			             System.out.println("Enter employee id : ");
			             userId = scanner.next();
			             try {
			            	 Pattern pattern = Pattern.compile("ACE[0-9]{4}");
			                 Matcher match = pattern.matcher(userId);
			                 
			                 if(!(match.find() && match.group().equals(userId)) || userId.equals("ACE0000"))
			                 {
			                	 valid = 1;
			                	 throw new ValidationException("ACE followed by 4digits required (ACE0000) to be avoided, please enter valid id ...");
			                 }
			             }
			             catch(ValidationException validationexception)
			             {
			            	 System.out.println(validationexception.getMessage());
			             }
			             }while(valid != 0);
		             SalaryDetails salarydetails = new SalaryDetails();
		             salarydetails.calculateAge(arrayList,userId);
		             salarydetails.calculateExperience(arrayList,userId);
		             salarydetails.incrementSalary(arrayList,userId);                     
		             break;
		    case 4 : Project project = new Project();
		             project.showWorkingProject(arrayList);
		    	     break;
		    case 5 : for(EmployeeDetails employee : arrayList)
		             {
		    	       System.out.println(employee+"\n");
		             }
		             break;
		    case 6 : boolean editLoop = true,updateLoop = true;
		             UpdatedRecord updatedRecord = new UpdatedRecord();
		    	     do {
		    	     editLoop = true;
		    	     System.out.println("1.Delete record of an employee");
		             System.out.println("2.Update record of an employee");
		             System.out.println("\nEnter your choice : ");
		    	     choice = Integer.parseInt(scanner.next());//1
		 		     scanner.nextLine();
		 		     
		 		     if(choice == 1)
		 		    	 {
		 		    	 do {
			                   valid = 0;
			                   System.out.println("Enter employee id : ");
			                   userId = scanner.next();
			                    try {
			            	     Pattern pattern = Pattern.compile("ACE[0-9]{4}");
			                     Matcher match = pattern.matcher(userId);
			                 
			                     if(!(match.find() && match.group().equals(userId)) || userId.equals("ACE0000"))
				                 {
				                	 valid = 1;
				                	 throw new ValidationException("ACE followed by 4digits required (ACE0000) to be avoided, please enter valid id ...");
				                 }
			                    }
			                    catch(ValidationException validationexception)
			                    {
			            	    System.out.println(validationexception.getMessage());
			                    }
			                    }while(valid != 0);
		 		                
		 		                updatedRecord.editRecord(arrayList,userId);
		 		                
		 		    	 }
		 		     else if(choice == 2)
		 		    	 {
			 			       do {
			 		             valid = 0;
			 		             System.out.println("Enter employee id : ");
			 		             userId = scanner.next();
			 		             try {
			 		            	 Pattern pattern = Pattern.compile("ACE[0-9]{4}");
			 		                 Matcher match = pattern.matcher(userId);
			 		                 
			 		                if(!(match.find() && match.group().equals(userId)) || userId.equals("ACE0000"))
					                 {
					                	 valid = 1;
					                	 throw new ValidationException("ACE followed by 4digits required (ACE0000) to be avoided, please enter valid id ...");
					                 }
			 		             }
			 		             catch(ValidationException validationexception)
			 		             {
			 		            	 System.out.println(validationexception.getMessage()); 
			 		             }
			 		             }while(valid != 0);
		 		    	       do {
		 		    	       System.out.println("1.Update phone number ");
			                   System.out.println("2.Update email id ");
			                   updateLoop = true;
			              
			                   System.out.println("\nEnter your choice : ");
					    	   choice = Integer.parseInt(scanner.next());//1
					 		   scanner.nextLine();
					 		   if(choice == 1)
					 		   {
					 			
					 		   	 do {
						             valid = 0;
						             System.out.println("Enter employee phone number : "); //[6789]
						             number = scanner.next();
						             try {
						            	 Pattern pattern = Pattern.compile("[6789][0-9]{9}");
						                 Matcher match = pattern.matcher(number);
						                 
						                 if(!(match.find() && match.group().equals(number)))
						                 {
						                	 valid = 1;
						                	 throw new ValidationException("Contact should starts with either (6/7/8/9) and should have only 10digits ...");
						                 }
						                
						             }
						             catch(ValidationException validationexception)
						             {
						            	 System.out.println(validationexception.getMessage());
						             }
						             }while(valid != 0);
					 			  updatedRecord.editRecord(arrayList,userId,number);
					 		   }
					 		   else if(choice == 2)
					 		   { 
					 			   do {
						             valid = 0;
						             System.out.println("Enter employee  email id : ");
						             email = scanner.next();
						             try {
						            	 Pattern pattern = Pattern.compile("[a-z]+[0-9]*@[a-z]+.com"); //edwin@gmail.com
						                 Matcher match = pattern.matcher(email);
						                 if(!(match.find() && match.group().equals(email)))
						                 {
						                	 valid = 1;
						                	 throw new ValidationException("Email invalid username should starts with lowercase followed by digits if any, and domain should be lowercase characters ...");
						                 }
						                 String userName = email.substring(0,email.indexOf('@'));
						                 int alphabet[] = new int[26];
						                 for(int iterator = 0;iterator < userName.length() - 1;iterator++)
							               {
							                   if(userName.charAt(iterator) == userName.charAt(iterator+1))
							                   {
							        	          alphabet[userName.charAt(iterator) - 97]++;
							        	          if(alphabet[userName.charAt(iterator) - 97] == 2)
							        	          {
							        		      valid = 1;
							        	          throw new ValidationException("Consecutive repeated characters more than two are not allowed in username,Please enter valid username ...");
							        	          }
							                   }
					                    
							                }
						                 String domain = email.substring(email.indexOf('@'),email.indexOf('.'));
						                 int alphaCharacters[] = new int[26];
						                 for(int iterator = 0;iterator < domain.length() - 1;iterator++)
							               {
							                   if(domain.charAt(iterator) == domain.charAt(iterator+1))
							                   {
							                	   alphaCharacters[domain.charAt(iterator) - 97]++;
							        	          if(alphaCharacters[domain.charAt(iterator) - 97] == 2)
							        	          {
							        		      valid = 1;
							        	          throw new ValidationException("Consecutive repeated characters more than two are not allowed in domain,Please enter valid domain ...");
							        	          }
							                   }
					                    
							                }
						                 
						             }
						             catch(ValidationException validationexception)
						             {
						            	 System.out.println(validationexception.getMessage());
						             }
						             }while(valid != 0);
					 			  updatedRecord.editRecord(email,arrayList,userId);
					 		   }
					 		   else
					 		   {
					 		   System.out.println("---------------------------------------------------------------------------Enter valid choice(1/2)----------------------------------------------------------------------");
					 		   updateLoop = false;
					 		   }
					 		   }while(updateLoop != true);
		 		    	 }
		 		     else
		 		     {
		             System.out.print("---------------------------------------------------------------------------Enter valid choice(1/2)----------------------------------------------------------------------");
		 		     editLoop = false;
		 		     }
		 		     }while(editLoop != true);
		 		     break;
		    case 7 : loop = false;
		             break;
		    default : System.out.println("----------------------------------------------------------------Enter valid choice(1/2/3/4/5/6/7)--------------------------------------------------------------------------------");
		    }
		    
		}while(loop != false);
	}
}
