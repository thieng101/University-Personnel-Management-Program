/*COP3330 - Professor Boustique
  Project 2
  Author: Hong Thy Nguyen
  COP3330-0001 F2F: Heng Hong
  COP3330-0V03 Online: Tianci
 */
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;


abstract class Person{
	private String FullName;
	private String Id;
	
	public Person(String Name, String ID) {
		this.FullName = Name;
		this.Id = ID;
	}
	public Person(String ID) {
		this.Id = ID;
	}
	
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		FullName = fullName;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	
	
	public abstract void print();
	
}
class Personnel{
	public Person [] list;
	private int i = 0;
	
	public Personnel() {
		list = new Person[100];
	}
	
	public void AddPerson(Person object) {
		list[i] = object;
		i++;
	}

	public Person[] getList() {
		return list;
	}

	public void setList(Person[] list) {
		this.list = list;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
	

	
}
class Student extends Person{
	double  GPA;
	private int CredHours;
	private double CreFee = 236.45;
	private int AddFee = 52;
	private double totalPayment;

	public Student(String Name, String ID, double GPA, int CredHours) {
		super(Name,ID);
		this.GPA = GPA;
		this.CredHours = CredHours;
		
	}
	
	public Student(String ID) {
		super(ID);
	}
	
	public int getCredHours() {
		return CredHours;
	}

	public void setCredHours(int credHours) {
		CredHours = credHours;
	}

	public double getGPA() {
		return GPA;
	}

	public void setGPA(double gPA) {
		GPA = gPA;
	}

	public Person searchStu(String InputId,Personnel object) {
		Person[] list = object.getList();
		Person founded = null;
		
		for(int i = 0; i < object.getI(); i++ ) {
			if(list[i].getId().equals(InputId)) {
					founded = list[i];
				}
		}
		return founded;
	}
	
	@Override
	public void print() {
		int CredH = getCredHours();
		totalPayment = (CreFee * CredH) + AddFee;
		System.out.println("Here is the tuition invoice for " + getFullName());
		System.out.println("--------------------------------------------------");
		System.out.println(getFullName() + "\t\t\t" + getId());
		System.out.println("Credit Hours:" + CredH + "\t(" +"$" + CreFee + "/" + "credit hour)" );
		System.out.println("Fees:" + "$" + AddFee);
		
		if(getGPA() >= 3.85 ) {
			double discount = totalPayment * 0.25;
			totalPayment = totalPayment * 0.75;
			System.out.println("Total payment:" + String.format("%.2f", totalPayment) + "\t\t($" + String.format("%.2f", discount) + " discount applied)");
		}
		else
			System.out.println("Total payment:" + "$" + String.format("%.2f", totalPayment) + "\t\t($0 discount applied)");
		System.out.println("--------------------------------------------------");
	}
	
	

	@Override
	public String toString() {
		return "1. " + super.getFullName() + "\n" + "ID: " + super.getId() +"\n" + 
				"GPA: " + GPA + "\n" + "Credit hours: " + CredHours ;
	}
	
	
	
}

abstract class Employee extends Person{
	private String Name;
	private String ID;
	private String Rank;
	private String Department;
	
	public Employee(String Name, String ID) {
		super(Name, ID);
	}

	public Employee(String iD2) {
		super(iD2);
	}
	
}


class Faculty extends Employee{
	private String Name;
	private String ID;
	private String Rank;
	private String Department;
		
	public Faculty(String Name, String ID) {
		super(Name, ID);
	}
	
	public Faculty(String ID) {
		super(ID);
	}
	
	public Faculty(String Name, String ID, String Rank, String Department) {
		super(Name,ID);
		this.Name = Name;
		this.ID = ID;
		this.Rank = Rank;
		this.Department = Department;
	}
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getRank() {
		return Rank;
	}

	public void setRank(String rank) {
		Rank = rank;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}
	
	public Person searchFac(String InputId,Personnel object) {
		Person[] list = object.getList();
		Person member = null;
		
		for(int i = 0; i < object.getI(); i++ ) {
			if(list[i].getId().equals(InputId)) {
					member = list[i];
				}
			}
		return member;
	}
	
	@Override
	public void print() {
		System.out.println("--------------------------------------------------");
		System.out.println(getFullName() + "\t\t\t" + getId());
		System.out.println(getDepartment() + " Department, "  + getRank());
		System.out.println("--------------------------------------------------");
	}

	@Override
	public String toString() {
		return "1. " + super.getFullName() + "\n" + "ID: " + super.getId() +"\n" + 
				Rank + "," + Department;
	}
	
	

	
}

class Staff extends Employee{
	private String Department;
	private String Status;
	
	public Staff(String Name, String ID) {
		super(Name, ID);
	}

	public Staff(String Name, String ID, String Department, String Status) {
		super(Name,ID);
		this.Department = Department;
		this.Status = Status;
		
	}

	public Staff(String tempID) {
		super(tempID);
	}
	

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
	

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public Person searchSta(String InputID, Personnel object) {
		Person[] list = object.getList();
		Person member = null;
		
		for(int i = 0; i < object.getI(); i++ ) {
			if(list[i].getId().equals(InputID)) 
					member = list[i];
		}
		return member;
			
	}
	
	public void print() {
		System.out.println("--------------------------------------------------");
		System.out.println(getFullName() + "\t\t\t" + getId());
		
		if(getStatus().equals("f") || getStatus().equals("F") )
			System.out.println(getDepartment() + " Department, "  + "\tFull Time");
		else
			System.out.println(getDepartment() + " Department, " + "\tPart Time");
		System.out.println("--------------------------------------------------");
	}

	@Override
	public String toString() {
		return "1. " + super.getFullName() + "\n" + "ID: " + super.getId() +"\n" + 
				Department + "," + Status;
	}
	
	
	
}


//create a class called IDException extends Exception
//put id arraylist in that class
//every time enter a new id add to that class
//check with the new one

class IdException extends Exception{
	

	public IdException(String msg) {
		super(msg);
	}

}

class SortGPA implements Comparator<Student>{
	@Override
	public int compare(Student o1,Student o2) {
		if(o1.getGPA() < o2.getGPA()) {
			return 1;
		}else if(o1.getGPA() > o2.getGPA()) {
			return -1;
		}else {
			return 0;
		}
		
	}
}

class SortCreHours implements Comparator<Student>{
	@Override
	public int compare(Student o1,Student o2) {
		if(o1.getCredHours() < o2.getCredHours()) {
			return 1;
		}else if(o1.getCredHours() > o2.getCredHours()) {
			return -1;
		}else {
			return 0;
		}
		
	}
}




public class Main {
	

	public static final String capitalize(String str) {
		if(str == null || str.length() == 0) return str;
		return str.substring(0,1).toUpperCase() + str.substring(1);
	}
	
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	public static boolean isNumeric2(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        int d = Integer.parseInt(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	
	
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		String Name;
		String ID;
		String Rank;
		String GPA;
		String CredHours;
		
		Personnel peopleList = new Personnel();
		ArrayList<Student> studentList = new ArrayList<Student>();
		ArrayList<Faculty> facultyList = new ArrayList<Faculty>();
		ArrayList<Staff> staffList = new ArrayList<Staff>();
		
		ArrayList<String> IDList = new ArrayList<String>();
		
		System.out.println("\t\tWelcome to my Personnel Management Program");
		System.out.println("Choose one of the options");
		
		while(true) {
			System.out.println("1.- Enter the information of a faculty");
			System.out.println("2.- Enter the information of a student");
			System.out.println("3.- Print tuition invoice for a student");
			System.out.println("4.- Print faculty information");
			System.out.println("5.- Enter the information of a staff member");
			System.out.println("6.- Print the information of a staff member");
			System.out.println("7.- Exist Program");
			 
			switch(input.nextLine()) {
			
			case "1": 
				System.out.println("Enter the faculty info:");
				System.out.println("\t\tName of the faculty:");
	
				Name = input.nextLine();
				
				System.out.println("\t\tID:");
				ID = input.nextLine();
				
				
				while(true) {
					try {
						if(IDList.contains(ID)) {
							throw new IdException("Id is duplicated, enter different one:");
						}
						else if(!ID.matches("[a-z]{2}[0-9]{4}")) {
							throw new IdException("Id is in wrong format, enter different one:");
						}
						else{
							break;
						}
						  
					}
					catch(IdException e){
						System.out.println(e.getMessage());
						ID = input.nextLine();
					}
				}
				
				IDList.add(ID);
								
				System.out.println("\t\tRank:");
				
				Rank = input.nextLine();
				
				while (!(Rank.equals("Professor") || Rank.equals("Adjunct")))
				{
	              System.out.println("\t\t\t\"" + Rank + "\" is invalid");
	              System.out.println("\t\tRank: ");
	              Rank = input.nextLine();
	            }
				
				System.out.println("\t\tDepartment:");
				
				String Department = input.nextLine();
				
		
				while (!(Department.equalsIgnoreCase("Mathematics") || Department.equalsIgnoreCase("Engineering") || Department.equalsIgnoreCase("Sciences")))
				{
		            System.out.println("\t\t\t\"" + Department + "\" is invalid");
		            System.out.println("\t\tDepartment: ");
		            Department = input.nextLine();
					
				}
				
				Department = Department.toLowerCase();
				Department = capitalize(Department);
	
				Faculty person = new Faculty(Name,ID,Rank,Department);
				peopleList.AddPerson(person);
				facultyList.add(person);
				
				//System.out.println("Total Id added " + peopleList.getI());
				System.out.println("Faculty added!\n");
				
				break;
				
			case "2":
				System.out.println("Enter the student info:");
				System.out.println("\n \t\tName of Student:");

				Name = input.nextLine();
				
				System.out.println("\t\tID:");
				ID = input.nextLine();
				
				
				while(true) {
					try {
						if(IDList.contains(ID)) {
							throw new IdException("Id is duplicated, enter different one:");
						}
						else if(!ID.matches("[a-z]{2}[0-9]{4}")) {
							throw new IdException("Id is in wrong format, enter different one:");
						}
						else{
							break;
						}
						  
					}
					catch(IdException e){
						System.out.println(e.getMessage());
						ID = input.nextLine();
					}
				}
				
				
				IDList.add(ID);
	
				System.out.println("\t\tGpa:");
				GPA = input.nextLine();
				
				while(true) {
					if((isNumeric(GPA)) == false) { 
						System.out.println("\t\tInvalid GPA. Try again");
						System.out.println("\t\tGpa:");
						GPA = input.nextLine();
					}else 
					{
						break;
					}
				}
				
				System.out.println("\t\tCredit hours:");
				CredHours = input.nextLine();
				
				while(true) {
					if((isNumeric2(CredHours)) == false) {
						System.out.println("\t\tInvalid credit hours. Please input an int");
						System.out.println("\t\tCredit hours:");
						CredHours= input.nextLine();
					}else
					{
						break;
					}
				}

				
				Student person1 = new Student(Name,ID,Double.parseDouble(GPA),Integer.parseInt(CredHours));
				peopleList.AddPerson(person1);
				studentList.add(person1);
				
				System.out.println("Student added!\n");
				break;
				
			case "3":
				System.out.println("Enter the student's ID:");
				String tempID = input.nextLine();
				
				Student Stu = new Student(tempID);
				Person founded = Stu.searchStu(tempID,peopleList);
				if(founded != null) {
					founded.print();;
					System.out.println();
				}
				else
					System.out.println("No student matched!\n");
					
				break;
				
			case "4":
				System.out.println("Enter the Faculty's ID:");
				String tempID1 = input.nextLine();
				
				Faculty Fac = new Faculty(tempID1);
				Person Founded1 = Fac.searchFac(tempID1,peopleList);
				if(Founded1 != null) {
					Founded1.print();;
					System.out.println();
				}
				else
					System.out.println("No faculty matched!\n");
				break;
				
			case "5":
				System.out.println("\t\tName of the staff member: ");
				Name = input.nextLine();
				
				System.out.println("\t\tEnter the id: ");
				ID = input.nextLine();
				
				
				while(true) {
					try {
						if(IDList.contains(ID)) {
							throw new IdException("Id is duplicated, enter different one:");
						}
						else if(!ID.matches("[a-z]{2}[0-9]{4}")) {
							throw new IdException("Id is in wrong format, enter different one:");
						}
						else{
							break;
						}
						  
					}
					catch(IdException e){
						System.out.println(e.getMessage());
						ID = input.nextLine();
					}
				}
				
				IDList.add(ID);

				System.out.println("\t\tDepartment:  ");
				String Department1 = input.nextLine();
				
				while (!(Department1.equalsIgnoreCase("Mathematics") || Department1.equalsIgnoreCase("Engineering") || Department1.equalsIgnoreCase("Sciences")))
				{
		            System.out.println("\t\t\t\"" + Department1 + "\" is invalid");
		            System.out.println("\t\tDepartment: ");
		            Department1 = input.nextLine();
					
				}
				
				Department1 = Department1.toLowerCase();
				Department1 = capitalize(Department1);

				System.out.println("\t\tStatus, Enter P for Part Time, or Enter F for Full Time: ");
				String Status = input.nextLine();
				while (!(Status.equalsIgnoreCase("P") || Status.equalsIgnoreCase("F")))
				{
		            System.out.println("\t\t\t\"" + Status + "\" is invalid");
		            System.out.println("\t\tStatus: ");
		            Status = input.nextLine();
					
				}
				
				if(Status.equalsIgnoreCase("P")){
					Status = "Part Time";
				}else {
					Status = "Full Time";
				}
					
				
				
				Staff Sta = new Staff(Name,ID,Department1,Status);
				peopleList.AddPerson(Sta);
				staffList.add(Sta);
				
				//System.out.println("Total Id added " + peopleList.getI());
		        System.out.println("Staff member added!\n");
		        break;
		        
			case "6":
				System.out.println("Enter the Staff's ID:");
				String tempID11 = input.nextLine();
				
				Staff Sta1 = new Staff(tempID11);
				Person Founded3 = Sta1.searchSta(tempID11,peopleList);
				if(Founded3 != null) {
					Founded3.print();;
					System.out.println();
				}
				else
					System.out.println("No staff matched!\n");
				break;
				
			case "7":
				System.out.println("Would you like to create the report? (Y/N)");
				
				String answer = input.nextLine();
				
				while(true) {
					if(answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("N")) {
						break;
					}
					else {
						System.out.println("Please give valid input");
						System.out.println("Would you like to create the report? (Y/N) ");
						answer = input.nextLine();
					}
					
				}
				
				
				if(answer.equalsIgnoreCase("Y")) {
					System.out.println("Would you like to sort your students by (1) gpa or (2) credit hours:");
					int answer2 = input.nextInt();
					
					//check answer 2
					while(true) {
						if(answer2 == 1 || answer2 == 2) {
							break;
						}
						else {
							System.out.println("Please give valid input");
							System.out.println("Would you like to sort your students by (1) gpa or (2) credit hours:");
							answer2 = input.nextInt();
							
						}
						
					}
					
					if(answer2 == 1){
						Collections.sort(studentList,new SortGPA());
						
						//get to-date date
						SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
						Date date = new Date();
						String line = sdf.format(date);

						FileWriter writer = new FileWriter("report.txt");
						writer.write("Reported created on " + line + "\n");
						writer.append("**********************\n");
						
						int size1 = facultyList.size();
						int size2 = studentList.size();
						int size3 = staffList.size();
						
						
						//write faculty member
						writer.append("Faculty Members\n");
						writer.append("-------------------\n");
						
						for(int i = 0; i < size1; i++) {
							String str = facultyList.get(i).toString();
							writer.append(str);
							writer.append("\n");
							writer.append("\n");
						}
						
						//write staff member
						writer.write("Staff Members\n");
						writer.append("-------------------\n");
						for(int i = 0; i < size3; i++) {
							String str2 = staffList.get(i).toString();
							writer.append(str2);
							writer.append("\n");
							writer.append("\n");
						}
						
						
						
						//write student
						
						writer.append("Students (Sorted by gpa)\n");
						writer.append("-------------------\n");
						
						
						for(int i = 0; i < size2; i++) {
							String str3 = studentList.get(i).toString();
							writer.append(str3);
							writer.append("\n");
							writer.append("\n");
						}
						
						
						writer.close();
						
						System.out.println("\nReport created and saved on your hard drive!");
						System.out.println("\nGoodbye!");						
					    
					    System.exit(0);
					}
					else {
						Collections.sort(studentList,new SortCreHours());
						
						//get to-date date
						SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
						Date date = new Date();
						String line = sdf.format(date);

						FileWriter writer = new FileWriter("report.txt");
						writer.write("Reported created on " + line + "\n");
						writer.append("**********************\n");
						
						int size1 = facultyList.size();
						int size2 = studentList.size();
						int size3 = staffList.size();
						
						
						//write faculty member
						writer.append("Faculty Members\n");
						writer.append("-------------------\n");
						
						for(int i = 0; i < size1; i++) {
							String str = facultyList.get(i).toString();
							writer.append(str);
							writer.append("\n");
							writer.append("\n");
						}
						
						//write staff member
						writer.write("Staff Members\n");
						writer.append("-------------------\n");
						for(int i = 0; i < size3; i++) {
							String str2 = staffList.get(i).toString();
							writer.append(str2);
							writer.append("\n");
							writer.append("\n");
						}
						
						
						//write student
						
						writer.append("Students (Sorted by credit hours)\n");
						writer.append("-------------------\n");
						
						
						for(int i = 0; i < size2; i++) {
							String str3 = studentList.get(i).toString();
							writer.append(str3);
							writer.append("\n");
							writer.append("\n");
						}
						
						writer.close();
						System.out.println("\nReport created and saved on your hard drive!");
						System.out.println("\nGoodbye!");
						
						System.exit(0);
					}
					
				}
				else {
					System.out.println("\nGoodbye!");
					System.exit(0);
				}
				
			default:
				System.out.println("Invalid entry- please try again\n");
		        break;
			   
			}
		}

	}

}