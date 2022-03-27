public class Alert {
	
	private String notification;
	private AlertType type; 
	private String location;
	
	public Alert() {
		this.notification = null;
		this.type = null;
		this.location = null;
	}
	
	public Alert(String notification, AlertType type, String location) {
		this.notification = notification;
		this.type = type;
		this.location = location;
	}
	
	// Setters and getters for alerts
	public AlertType getAlert() {
		return this.type;
	}
	public void setAlert(AlertType type) {
		this.type = type;
	}
	
	// Setters and getters for notification
	public String getLocation() {
		return this.notification;
	}
	public void setLocation(String notification) {
		this.notification = notification;
	}
	
	// Setters and getters for notification
	public String getNotification() {
		return this.location;
	}
	public void setNotification(String location) {
		this.location = location;
	}
	
	public String toString() {
		return "Alert: " + getAlert() + " - Location: " + getLocation() + " - Notification: " + getNotification();
	}
	
}
