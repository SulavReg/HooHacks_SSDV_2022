import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// the main control hub, essentially
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Welcome to the AlertMe system. Please enter your name, age, location, and phone number");
		
		System.out.println("Enter your full name: ");
		String name = in.nextLine();
		
		System.out.println("Enter your age: ");
		int age = in.nextInt();
		
		System.out.println("Enter your location: ");
		String location = in.next();
		
		System.out.println("Enter your Phone Number: ");
		int number = in.nextInt();
		
		User myself = new User(name,age,location,number);

		System.out.println("Would you like to create a new Pod (1) or join an existing one (2)?: ");
		number = in.nextInt();
		
		if(number == 1) {
			System.out.println("What would you like the name of your new group to be?: ");
			name = in.next();
			Pod newGroup = new Pod(name);
			newGroup.addMember(myself);
			
			number = 0;
			while (number != 7) {
				System.out.println("Choose an option below");
				System.out.println("1: Add a member to your group");
				System.out.println("2: Alert your group and those within your proximity");
				System.out.println("3: Show recent alerts");
				System.out.println("4: Show all alerts");
				System.out.println("5: Exit");
				
				number = in.nextInt();
				
				if(number == 1) {
					System.out.println("What is the name of the user you want to add?: ");
					name = in.next();
					System.out.println("Which city are they located in?: ");
					location = in.next();
					User newUser = new User(name,location);
					newGroup.addMember(newUser);
				}
				else if(number == 2) {
					System.out.println("Where is the incident?: ");
					location = in.next();
					System.out.println("Was the alert a bombing (1), military movement (2), shooting (3), theft (4), or an assault (5)?: ");
					int alert_num = in.nextInt();
					System.out.println("Please describe the alert in words: ");
					String message = in.next();
					
					
					if(alert_num == 1) {
						newGroup.addAlert(message,AlertType.BOMBING,location);
					}
					else if(alert_num == 2) {
						newGroup.addAlert(message,AlertType.MILITARY_MOVEMENT,location);
					}
					else if(alert_num == 3) {
						newGroup.addAlert(message,AlertType.SHOOTING,location);
					}
					else if(alert_num == 4) {
						newGroup.addAlert(message,AlertType.THEFT,location);
					}
					else if(alert_num == 5) {
						newGroup.addAlert(message,AlertType.ASSAULT,location);
					}
					
					
				}
				else if(number == 3) {
					newGroup.showRecentAlerts();
				}
				else if(number == 4) {
					newGroup.showAllAlerts();
				}
				else {
					break;
				}

			} // end of while loop			
		}
		else if (number == 2) {
		
			//needs implementation for multiple groups
			
		}
		 
		 
		 
	}

}
