import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
	private String name;
	private String department;
	private String email;
	private String phoneNumber;
	private String officeLocation;
	private double salary;
	private int yearsOfService;
	private ArrayList<Employee> employeeList;
	private ArrayList<Project> projectList;
	private int numberOfEmployees;
	private int numberofProjects;
	private static Manager insteance;

	private Manager (){}
	
	public static Manager getInsteance(String name, String department, String email, String phoneNumber, String officeLocation, double salary,int yearsOfService ) {
		if(insteance==null) {  
			insteance=new Manager();
			insteance.setName(name);
			insteance.setDepartment(department);
			insteance.setEmail(email);
			insteance.setPhoneNumber(phoneNumber);
			insteance.setOfficeLocation(officeLocation);
			insteance.setSalary(salary);
			insteance.setYearsOfService(yearsOfService);
			insteance.setSalary(salary);
			insteance.numberOfEmployees=0;
			insteance.numberofProjects=0;
			insteance.employeeList=new ArrayList<Employee>();
			insteance.projectList=new ArrayList<Project>();
		}
		return insteance;
	}
	
	  public String getName() {
	  return name;}
	
	  public void setName(String name) {
	  this.name = name;}
	
	  public String getDepartment() {
	  return department;}
	
	  public void setDepartment(String department) {
	  this.department = department;}
	
	  public String getEmail() {
	  return email;}
	
	  public void setEmail(String email) {
	  this.email = email;}
	
	  public String getPhoneNumber() {
	  return phoneNumber;}
	
	  public void setPhoneNumber(String phoneNumber) {
	  this.phoneNumber = phoneNumber;}
	
	  public String getOfficeLocation() {
	  return officeLocation;}
	
	  public void setOfficeLocation(String officeLocation) {
	  this.officeLocation = officeLocation;}
	
	  public double getSalary() {
	  return salary;}
	
	  public void setSalary(double salary) {
	  this.salary = salary;}
	
	  public int getYearsOfService() {
	  return yearsOfService;}
	
	  public void setYearsOfService(int yearsOfService) {
	  this.yearsOfService = yearsOfService;}
	
	  public ArrayList<Employee> getEmployeeList() {
	  return employeeList;}
	  
	  public ArrayList<Project> getProjectList() {
		  return projectList;
	  }
	
	  public void addEmployee(String name, String title) {
		  insteance.numberOfEmployees++;
		  employeeList.add(new Employee(name,title));
	  }
	
	  public void addProject(String name, String dueDate) {
		  insteance.numberofProjects++;
		  projectList.add(new Project(name,dueDate));
	  }
	
	  public void removeEmployee(String name) {
		  int removedEmplyees=0;
		  for(int i=0;i<insteance.numberOfEmployees;i++) {
			  if(name.equalsIgnoreCase(employeeList.get(i).getName())) {
				  employeeList.remove(i);
				  insteance.numberOfEmployees--;
				  removedEmplyees++;
			  }
		  }
		  if(removedEmplyees==0) {
			  System.out.println("No Employee is found with the name "+name);
		  }else {
			  System.out.println(removedEmplyees+" Employee/Employees is/are found with the name "+name);
		  }
	  }
	
	  public void removeProject(String name) {
		  int removedProjects=0;
		  for(int i=0;i<insteance.numberofProjects;i++) {
			  if(name.equalsIgnoreCase(projectList.get(i).getName())) {
				  projectList.remove(i);
				  insteance.numberofProjects--;
				  removedProjects++;
			  }
		  }
		  if(removedProjects==0) {
			  System.out.println("No Project is found with the name "+name);
		  }else {
			  System.out.println(removedProjects+" Project/Projects is/are found with the name "+name);
		  }
		  
		  
		  
	  }
	  
	  public String employeeListtoString() {
		  String str="";
		  for(Employee emp: employeeList) {
			  str+=emp+"\n";
			}
		  return str;
	  }
	  
	  
	  public String projectListtoString() {
		  String str="";
		  for(Project pro:projectList) {
			  str+=pro+"\n";
			}
		  return str;
	  }
	
	  public String toString() {
		  String str="Manager\n" +
	                "Name=" + name + '\n' +
	                "Department=" + department + '\n' +
	                "Email=" + email + '\n' +
	                "Phone Number=" + phoneNumber + '\n' +
	                "Office Location='" + officeLocation + '\n' +
	                "Salary=" + salary +'\n' +
	                "Years Of Service=" + yearsOfService + '\n'
	                ;
		  str+="Employees:\n"+employeeListtoString();
		  str+="PRojects:\n"+projectListtoString();
		  return str;
	  }
	
}
