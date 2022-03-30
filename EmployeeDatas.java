/*Title-Employee Management System

 * Author      : Suryaprabha K
 * Created at  : 08-10-2021
 * Updated at  : 30-03-2022
 * Reviewed by : Akshaya,Jaya on 30-03-2022
 */

package employee;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Employee{
	private  String employeeID;
	private  String employeeName;
	private  String employeeEmail;
	private  String employeeDOB;
	private  String employeeDOJ;
	private String  employeeMobileNumber;
	//super keyword invokes the MainEmployee constructor
	Employee(String employeeID,String employeeName,String employeeEmail,String employeeDOB,String employeeDOJ,String employeeMobileNumber)
	{
		this.employeeID=employeeID;
		this.employeeName=employeeName;
		this.employeeEmail=employeeEmail;
		this.employeeDOB=employeeDOB;
		this.employeeDOJ=employeeDOJ;
		this.employeeMobileNumber=employeeMobileNumber;
		
	}
	//In order to access the private fields,getter methods are used.
	public String getEmployeeID()
	{
		return employeeID;
	}
	public String getEmployeeName()
	{
		return employeeName;
	}
	public String getEmployeeEmail()
	{
		return employeeEmail;
	}
	public String getEmployeeDOB()
	{
		return employeeDOB;
	}
	public String getEmployeeDOJ()
	{
		return employeeDOJ;
	}
	public String getEmployeeMobileNumber()
	{
		return employeeMobileNumber;
	}
   
	//To perform overriding 
	
    public String validateEmployeeID()
    {
    	return employeeID;
    }
    public String validateNewEmployeeID()
    {
    	return employeeID;
    }
    public String validateEmployeeName()
    {
    	return employeeName;
    }
    public String validateEmployeeEmail()
    {
    	return employeeEmail;
    }
    public String validateEmployeeDOB()
    {
    	return employeeDOB;
    }
    public String validateEmployeeDOJ()
    {
    	return employeeDOJ;
    }
    public String validateEmployeeMobileNumber()
    {
    	return employeeMobileNumber;
    }
}
public class EmployeeDatas extends Employee//child class
{
	//constructor definition
	EmployeeDatas(String employeeID,String employeeName,String employeeEmail,String employeeDOB,String employeeDOJ,String employeeMobileNumber)
	{
		super(employeeID,employeeName,employeeEmail,employeeDOB,employeeDOJ,employeeMobileNumber);//It invoke parent class Employee constructor
	}
	Scanner scannerString=new Scanner(System.in);
	Scanner scanner=new Scanner(System.in);
	
	public String validEmployeeID()//Overriding the validEmployeeID method
	{
		System.out.println("Enter the employee ID:");
		String employeeID=scannerString.nextLine();
	    if(!(employeeID.length()==7 && employeeID.matches("ACE+[0-9]{4}"))) //matches method to check the given employeeID matches with the regular expression
	    {
	    	System.out.println("EmployeeID must start with 'ACE' followed by 4 digits.Do not include any special characters");
	    	validEmployeeID();
	    }
	    return employeeID;
	}
	public String validNewEmployeeID()//Overriding the validEmployeeID method
	{
		System.out.println("Enter the new employee ID:");
		String employeeID=scannerString.nextLine();
	    if(!(employeeID.length()==7 && employeeID.matches("ACE+[0-9]{4}"))) //matches method to check the given employeeID matches with the regular expression
	    {
	    	System.out.println("EmployeeID must start with 'ACE' followed by 4 digits.Do not include any special characters");
	    	validEmployeeID();
	    }
	    return employeeID;
	}
	public String validEmployeeName()//Overriding the validEmployeeName method
	{
		System.out.println("Enter the employee name:");
		String employeeName=scannerString.nextLine();
		Pattern patternName = Pattern.compile("^[a-zA-Z]+$");
		Matcher matcherName=patternName.matcher(employeeName);
		boolean checkName = matcherName.find();
	    if(checkName==false)
	    {
	    	System.out.println("Employee name should contain only alphabets.Do not include any special characters or numerics");
	    	validEmployeeName();
	    }
	    return employeeName;
	}
	public String validEmployeeEmail()	//Overriding the validEmployeeEmail method
	{
		System.out.println("Enter the employee email:");
		String employeeEmail=scannerString.nextLine();
		if(!(employeeEmail.matches("^[a-zA-Z0-9+.]+@[a-z+.]+$")))//other pattern for employeeEmail is("[a-zA-Z0-9+.]+@[a-z]+(.com)")
		{
			System.out.println("Please enter the valid email ID.Domain name should not contain any numerics or special characters.");
			validEmployeeEmail();
		}
		return employeeEmail;
	}
	//Overriding the validEmployeeDOB method
	public String validEmployeeDOB()
	{
		System.out.println("Enter the Employee DOB:");
		String employeeDOB=scannerString.nextLine();
		SimpleDateFormat dob = new SimpleDateFormat("dd/MM/yyyy");
		dob.setLenient(false);
		try
		{
			Date dateFormat=dob.parse(employeeDOB);
			long dateCalculation=System.currentTimeMillis()-dateFormat.getTime();
			long age=(long)((long)dateCalculation/(1000.0*60*60*24*365));
			if(age>=18 && age<=60)
				return employeeDOB;
			else
			{
				System.out.println("Please enter the valid date.Example:'DD/MM/YYYY'.Age must be between 18 to 60");
				validEmployeeDOB();
			}
		}
		catch(ParseException date)
		{
			System.out.println("Please enter the valid date."/*Example:'DD/MM/YYYY'.Age must be between 18 to 60*/);
			validEmployeeDOB();
		}
		return employeeDOB;
	}
		public String validEmployeeDOJ()//Overriding the validEmployeeDOJ method
		{
			System.out.println("Enter the Employee DOJ:");
			String employeeDOJ=scannerString.nextLine();
			SimpleDateFormat doj = new SimpleDateFormat("dd/mm/yyyy");
			doj.setLenient(false);
			try
			{
				Date dateFormat=doj.parse(employeeDOJ);
				long dateCalculation=System.currentTimeMillis()-dateFormat.getTime();
				if(dateCalculation>0)
					return employeeDOJ;
				else
				{
					System.out.println("Please enter the valid date of joining.Example:'DD/MM/YYYY'.No future dates are allowed");
					validEmployeeDOJ();
				}
			}
			catch(ParseException date)
			{
				System.out.println("Please enter the valid date of joining.Example:'dd/MM/yyyy'");
				validEmployeeDOJ();
			}
			return employeeDOJ;
		}
		//Overriding the validEmployeeMobileNumber method
		public String validEmployeeMobileNumber()
		{
			System.out.println("Enter the employee mobile number:");
			String employeeMobileNumber=scannerString.nextLine();
			if(!(employeeMobileNumber.matches("(0|91)?[6-9][0-9]{9}")))
			{
				System.out.println("Please enter the valid mobile number.Mobile number should not contain any alphabets and special characters.");
				validEmployeeMobileNumber();
			}
			return employeeMobileNumber;
		}		
		
		public void employeeDetails()  //CRUD operations
		{
			int selectOption;
			do
			{
				System.out.println("********************************************");
				System.out.println("Employee Management System");
				System.out.println("********************************************");
				try
				{
					Thread.sleep(1000);
				}
				catch(InterruptedException interruptedException)
				{
					System.out.println(interruptedException);
				}
				
				System.out.println("\n1.ADD new employee details\n2.DELETE the employee details\n3.DISPLAY the employee details\n4.UPDATE the employee details\n5.EXIT\n");
				System.out.println("********************************************");
				try
				{
					Thread.sleep(1000);
				}
				catch(InterruptedException interruptedException)
				{
					System.out.println(interruptedException);
				}
				System.out.println("Enter the choice to do CRUD operations:");
				selectOption=scanner.nextInt();
				String connectionUrl="jdbc:mysql://localhost:3306/employeemanagement";
				String userName="root";
				String password="aspire@123";
				String jdbcDriver="com.mysql.cj.jdbc.Driver";
				switch(selectOption)
				{
				
				case 1://To ADD the employee Details
				{
					System.out.println("Enter the number of employee details to be added:");
					int numberOfEmployees=scanner.nextInt();
					for(int index=1;index<=numberOfEmployees;index++)
					{
						String employeeID=validEmployeeID();
						String employeeName=validEmployeeName();
						String employeeEmail=validEmployeeEmail();
						String employeeDOB=validEmployeeDOB();
						String employeeDOJ=validEmployeeDOJ();
						String employeeMobileNumber=validEmployeeMobileNumber();
						try
						{
							Class.forName(jdbcDriver);
							Connection connection=DriverManager.getConnection(connectionUrl,userName,password);
							String query="INSERT INTO employee_datas(EmployeeID,EmployeeName,EmployeeEmail,EmployeeDOB,EmployeeDOJ,EmployeeMobileNumber) VALUES(?,?,?,?,?,?)";
							PreparedStatement preparedstatement=connection.prepareStatement(query);
							preparedstatement.setString(1, employeeID);
							preparedstatement.setString(2, employeeName);
							preparedstatement.setString(3, employeeEmail);
							preparedstatement.setString(4, employeeDOB);
							preparedstatement.setString(5, employeeDOJ);
							preparedstatement.setString(6, employeeMobileNumber);
							preparedstatement.executeUpdate();
							connection.close();
						}
						catch(Exception exception)
						{
							System.out.println(exception);
						}
					}
					System.out.println("\nThe given employee details has been added successfully.");
					break;
				}
				case 2://To DELETE the employee details
				{
					System.out.println("DELETE the employee details:");
					System.out.println("Enter the employee ID to delete:");
					String employeeId=scannerString.nextLine();
					try 
					{
						
						
						Class.forName(jdbcDriver);
						Connection connection=DriverManager.getConnection(connectionUrl,userName,password);
						String query="DELETE FROM employee_datas WHERE EmployeeID=?";
						PreparedStatement preparedStatement=connection.prepareStatement(query);
						preparedStatement.setString(1,employeeId);
						int flag=preparedStatement.executeUpdate();
						if(flag>0)
						{
							System.out.println("\nThe record with the given employee ID "+employeeId+" is deleted successfully");
						}
						else
						{
							System.out.println("\nThe record with the given employee ID "+employeeId+" is not found.");
						}
						preparedStatement.close();
						connection.close();
					}
					catch(Exception exception)
					{
						System.out.println(exception);
					}
					break;
				}
				case 3://To DISPLAY the employee details
				{
					System.out.println("DISPALY the employee details:\n");
					System.out.println("Enter the employee ID to display:");
					String employeeId=scannerString.nextLine();
					try {
						
						
						Class.forName(jdbcDriver);
						Connection connection=DriverManager.getConnection(connectionUrl,userName,password);
						String query="SELECT * FROM employee_datas WHERE EmployeeID=?";
						PreparedStatement preparedStatement=connection.prepareStatement(query);
						preparedStatement.setString(1,employeeId);
						ResultSet resultSet=preparedStatement.executeQuery();
						
						if(resultSet.next()==false)
						{
							System.out.println("\nThe record with the given employee ID "+employeeId+" is not found.\n");
						}
						else
						{
							String employeeID=resultSet.getString(1);
							String employeeName=resultSet.getString(2);
							String employeeEmail=resultSet.getString(3);
							String employeeDOB=resultSet.getString(4);
							String employeeDOJ=resultSet.getString(5);
							String employeeMobileNumber=resultSet.getString(6);
							System.out.println("\n"+employeeID+":"+employeeName+"  "+employeeEmail+"  "+employeeDOB+"  "+employeeDOJ+"  "+employeeMobileNumber);
							System.out.println("\nThe record with the given employee ID "+employeeId+" is dispalyed successfully.\n");
						}
						preparedStatement.close();
						connection.close();
					}
					catch(Exception exception)
					{
						System.out.println(exception);
					}
					break;
				}
				case 4://To UPDATE the employee details
				{
					System.out.println("UPDATE the employee details:");
					System.out.println("********************************************");
					System.out.println("\n1.UPDATE the Employee ID\n2.UPDATE the Employee Name\n3.UPDATE the Employee Email\n4.UPDATE the Employee DOB\n5.UPDATE the Employee DOJ\n6.UPDATE the Employee Mobile Number\n");
					System.out.println("********************************************");
					System.out.println("Enter the choice to update the details:");
					int choice=scanner.nextInt();
					String employeeId=validEmployeeID();
					try
					{
						
						Class.forName(jdbcDriver);
						Connection connection=DriverManager.getConnection(connectionUrl,userName,password);
						switch(choice)
						{
						    case 1:
					    	{
							   String newEmployeeID=validNewEmployeeID();
							   String query="UPDATE employee_datas SET EmployeeID=(?) WHERE EmployeeID=(?)";
							   PreparedStatement preparedStatement=connection.prepareStatement(query);
							   preparedStatement.setString(1,newEmployeeID);
							   preparedStatement.setString(2,employeeId);
							   int flag=preparedStatement.executeUpdate();
							   if(flag>0)
							   {
								   System.out.println("\nThe old employeeID-"+employeeId+" is updated to new employeeID-"+newEmployeeID+" successfully");
							   }
							   else
							   {
								   System.out.println("\nThe given employeeID "+employeeId+ " is not found in the database.");
							   }
							   break;
						    }
						    case 2:
					    	{
							   String newEmployeeName=validEmployeeName();
							   String query="UPDATE employee_datas SET EmployeeName=(?) WHERE EmployeeID=(?)";
							   PreparedStatement preparedStatement=connection.prepareStatement(query);
							   preparedStatement.setString(1,newEmployeeName);
							   preparedStatement.setString(2,employeeId);
							   int flag=preparedStatement.executeUpdate();
							   if(flag>0)
							   {
								   System.out.println("\nThe old employee Name is updated to new employee Name "+newEmployeeName+" successfully");
							   }
							   else
							   {
								   System.out.println("\nThe given employeeID "+employeeId+" is not found in the database.");
							   }
							   break;
						    }
						    case 3:
					    	{
							   String newEmployeeEmail=validEmployeeEmail();
							   String query="UPDATE employee_datas SET EmployeeEmail=(?) WHERE EmployeeID=(?)";
							   PreparedStatement preparedStatement=connection.prepareStatement(query);
							   preparedStatement.setString(1,newEmployeeEmail);
							   preparedStatement.setString(2,employeeId);
							   int flag=preparedStatement.executeUpdate();
							   if(flag>0)
							   {
								   System.out.println("\nThe old employee Email is updated to new employee Email "+newEmployeeEmail+" successfully");
							   }
							   else
							   {
								   System.out.println("\nThe given employeeID "+employeeId+" is not found in the database.");
							   }
							   break;
						    }
						    case 4:
					    	{
							   String newEmployeeDOB=validEmployeeDOJ();
							   String query="UPDATE employee_datas SET EmployeeDOB=(?) WHERE EmployeeID=(?)";
							   PreparedStatement preparedStatement=connection.prepareStatement(query);
							   preparedStatement.setString(1,newEmployeeDOB);
							   preparedStatement.setString(2,employeeId);
							   int flag=preparedStatement.executeUpdate();
							   if(flag>0)
							   {
								   System.out.println("\nThe old employee DOB "+newEmployeeDOB+" is updated to new employee DOB successfully");
							   }
							   else
							   {
								   System.out.println("\nThe given employeeID "+employeeId+" is not found in the database.");
							   }
							   break;
						    }
						    case 5:
					    	{
							   String newEmployeeDOJ=validEmployeeDOJ();
							   String query="UPDATE employee_datas SET EmployeeDOJ=(?) WHERE EmployeeID=(?)";
							   PreparedStatement preparedStatement=connection.prepareStatement(query);
							   preparedStatement.setString(1,newEmployeeDOJ);
							   preparedStatement.setString(2,employeeId);
							   int flag=preparedStatement.executeUpdate();
							   if(flag>0)
							   {
								   System.out.println("\nThe old employee DOJ "+newEmployeeDOJ+" is updated to new employee DOJ successfully");
							   }
							   else
							   {
								   System.out.println("\nThe given employeeID "+employeeId+" is not found in the database.");
							   }
							   break;
						    }
						    case 6:
					    	{
							   String newEmployeeMobileNumber=validEmployeeMobileNumber();
							   String query="UPDATE employee_datas SET EmployeeMobileNumber=(?) WHERE EmployeeID=(?)";
							   PreparedStatement preparedStatement=connection.prepareStatement(query);
							   preparedStatement.setString(1,newEmployeeMobileNumber);
							   preparedStatement.setString(2,employeeId);
							   int flag=preparedStatement.executeUpdate();
							   if(flag>0)
							   {
								   System.out.println("\nThe old employee MobileNumber "+newEmployeeMobileNumber+" is updated to new employee MobileNumber successfully");
							   }
							   else
							   {
								   System.out.println("\nThe given employeeID "+employeeId+"' is not found in the database.");
							   }
							   break;
						    }
						    default://When valid choice is not given default block executes
						    {
							   System.out.println("Please select a valid option from 1 to 6.The option other than 1 to 6 is not valid");
							   break;
						    }
						}
						
					}
					catch(Exception exception)
					{
						System.out.println(exception);
					}
							break;
				}	
				case 5:
				{
					System.out.println("EXIT");
					break;
				}
				default://When valid choice is not given default block executes
				{
					System.out.println("Please select a valid option from 1 to 5.The option other than 1 to 5 is not valid");
					break;
				}		
				}
		   }while(selectOption!=5);
	  }
}