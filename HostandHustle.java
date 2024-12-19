package Wait_List_Project;
import java.util.*;

public class HostAndHustle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		String name;
		String number;
		String time;
		int key; 
		WaitTable ourTable = new WaitTable(17);
		System.out.println("Welcome to Host and Hustle!");	
		// this while loop will continue adding people to the waitlist
		
		System.out.println("Would you like to: ");
		System.out.println("1. Make a reservation");
		System.out.println("2. Add a name to the waitlist");
		System.out.println("3. View the table list");
		System.out.println("4. Take a name off the wait list");
		System.out.println("5. Exit");
		System.out.println("Please type the number: ");
		String reservation = scan.nextLine();
		int parsedNum = Integer.parseInt(reservation);
		
		while(parsedNum != 5) {
			
			if(parsedNum == 1) {
				System.out.println("What is your name?");
				name = scan.nextLine();
				System.out.println("What is your phone number?");
				number = scan.nextLine();
				System.out.println("What time would you like your reservation to be?");
				time = scan.nextLine();
				key = changeNumber(time);
				
				//make person object
				//call time change function to change time
				Person newPerson = new Person(name, number);
				
				//adds name to next available space in queue			
				int newTime = ourTable.insertPerson(key, newPerson);
				// call reverse time functions
				
				//adds persons name in hash table and gets the time()
				System.out.println("Thank you. Your reservation has been set for: " + getTime(newTime));	//inserts time
			} 
			
			else if(parsedNum == 2) {
				
					System.out.println("Name?");
					name = scan.nextLine();
					System.out.println("Phone number");
					number = scan.nextLine();
					System.out.println("What time is it?");
					time = scan.nextLine();
					key = changeNumber(time);
					
					//make person object
					//call time change function to change time
					Person newPerson = new Person(name, number);
					int newTime = ourTable.insertPerson(key, newPerson);
					
					// call reverse time functions
					
					//adds name to next available space in queue
					System.out.println("Thank you. Your table should be ready at: " + getTime(newTime)); //inserts time
				
	
			}
			
			else if(parsedNum == 3) {
				System.out.println();
				System.out.println();

				ourTable.displayTable();
			}
			else if(parsedNum == 4) {
				System.out.println("What time is it?");
				time = scan.nextLine();
				key = changeNumber(time);
				Person removedPerson = ourTable.delete(key);
				System.out.println(removedPerson.getName() + "'s table is ready.");
				System.out.println(removedPerson.getName() + "'s phone number is: " + removedPerson.getNumber());

			}
			
			System.out.println("----------------------");
			System.out.println();
			
			System.out.println("Would you like to: ");
			System.out.println("1. Make a reservation");
			System.out.println("2. Add a name to the waitlist");
			System.out.println("3. View the table list");
			System.out.println("4. Take a name off the wait list");
			System.out.println("5. Exit");
			System.out.println("Please type the number: ");
			reservation = scan.nextLine();
			parsedNum = Integer.parseInt(reservation);
		}
		
		scan.close();
	
	}


	//converts time to hashTable number for search
	public static int changeNumber(String s) {
			String[] time = {"5:00", "5:15", "5:30", "5:45",
						"6:00", "6:15", "6:30", "6:45",
						"7:00", "7:15", "7:30", "7:45",
						"8:00", "8:15", "8:30", "8:45",
						"9:00"};
			int key = 0;
			for(int i = 0; i < time.length; i++) {
				if(s.equals(time[i])){
					key = i;
				}
			}
			return key;
		}


	public static String getTime(int key) {
		String[] hours = {"5:00", "5:15", "5:30", "5:45",
				 	"6:00", "6:15", "6:30", "6:45",
				 	"7:00", "7:15", "7:30", "7:45",
					 "8:00", "8:15", "8:30", "8:45",
					 "9:00"};
		String time = hours[key];
		return time;
	}


}
