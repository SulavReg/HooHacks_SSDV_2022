import java.util.*;

public class Pod {

	private String alphabet = "abcdefghijklmnopqrstuvwxyz";
	private String numbers = "0123456789";
	
	private ArrayList<User> group = new ArrayList<User>();
	private ArrayList<Alert> alerts = new ArrayList<Alert>();
	
	private String groupName; 
	private String groupID;
	
	public Pod(String groupName){
		this.groupName = groupName;
		this.groupID = createGroupID();
	}
	
	public String getgroupName() {
		return this.groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	public String getGroupID() {
		return this.groupID;
	}
	
	public void addMember(User member) {
		group.add(member);
	}
	public void removeMember(String token) {
		for(User member:this.group) {
			if(member.getToken().equals(token)) {
				this.group.remove(member);
				break;
			}
		}		
	}
	
	public String createGroupID() {
			
			String token = "";
			
			for(int i = 0; i < 6; i++) {
				int randomLetter = (int)(Math.random() * 27);
				token = token + alphabet.charAt(randomLetter);
			}
			for(int i = 0; i < 4; i++) {
				int randomNum = (int)(Math.random() * 10);
				token = token + numbers.charAt(randomNum);
			}
			
			return token;
	}
	
	public void addAlert(String notification, AlertType type, String location) {
		Alert a = new Alert(notification,type,location);
		alerts.add(a);
	}
	
	public void showRecentAlerts() {
		if(alerts.size() <= 5) {
			showAllAlerts();
		}
		else {
			for(int i = alerts.size() - 5; i < alerts.size(); i++) {
				System.out.println(alerts.get(i).toString());
			}
		}
	}
	
	public void showAllAlerts() {
		for(int i = 0; i < alerts.size(); i++) {
			System.out.println(alerts.get(i).toString());
		}
	}
	
	
}
