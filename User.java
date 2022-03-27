public class User {

	private String name;
	private int age;
	private String token;
	private String location;
	private int phone;
	
	private String alphabet = "abcdefghijklmnopqrstuvwxyz";
	private String numbers = "0123456789";
	
	public User() {
		this.name = null;
		this.age = 0;
		this.location = null;
		this.phone = 0;
		this.token = createToken();
	}
	
	public User(String name,String location) {
		this.name = name;
		this.age = 0;
		this.location = location;
		this.phone = 0;
		this.token = createToken();
	}
	
	public User(String name,int age,String location,int phone) {
		
		this.name = name;
		this.age = age;
		this.location = location;
		this.phone = phone;
		this.token = createToken();
		
	}
	
	public String getName() {
		return name;
	}
	public String getToken() {
		return token;
	}
	
	public String createToken() {
		
		String token = "";
		
		for(int i = 0; i < 4; i++) {
			int randomLetter = (int)(Math.random() * 26);
			token = token + alphabet.charAt(randomLetter);
		}
		for(int i = 0; i < 2; i++) {
			int randomNum = (int)(Math.random() * 9);
			token = token + numbers.charAt(randomNum);
		}
		
		return token;
	}
	
	
}
