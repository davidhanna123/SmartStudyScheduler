package BusinessLogic;

import java.time.LocalDate;
import java.util.Scanner;

public class Add_Homework {
	
	public static Homework addHomework() { 
		Scanner sc = new Scanner(System.in);
		Homework hw = new Homework();
		
		//Get Task from user
		System.out.print("Name the task: ");
		String task = sc.nextLine(); 
		
		//Get course code from user
		System.out.print("Course code: ");
		String course = sc.nextLine();
		
		//Gets completion time from user
		System.out.println("How long will this task take to complete?");
		System.out.print("Hour: ");
		int hour = sc.nextInt();
		System.out.print("Minute: ");
		int min = sc.nextInt();
		
		//Creates either an Assignment or Homework object based on user input
		System.out.println("Does this task have a due date? (Y/N)"); 
		sc.nextLine();
		char assignmentCheck = sc.next().charAt(0);
	
		if (assignmentCheck == 'Y') {	
			
			//Gets due date from user
			System.out.println("When is the due date?");
			System.out.print("Year: ");
			int year = sc.nextInt(); 
			System.out.print("Month(int): ");
			int month = sc.nextInt(); 
			System.out.print("Day of Month: ");
			int dayOfMonth = sc.nextInt();
			System.out.print("Day of Week: ");
			sc.nextLine();
			String dayOfWeek = sc.nextLine();
			
			//Creates new Assignment object
			LocalDate date = LocalDate.of(year, month, dayOfMonth);
			hw = new Assignment(task, course, hour, min, date, dayOfWeek);
		}
		
		else { 
			//Creates new Homework object
			hw = new Homework(task, course, hour, min);
		}
		
		//Close scanner and return created Homework object
		sc.close();
		return hw;
	}
}
