package Person;

public class Credentials {
	//fields
	private String username;
	private String password;
	
	//Constructors
	public Credentials(String username, String password) {
		this.username=username;
		this.password=password;
	}
	
	
	//getters and setters
	public String getUsername() {
		return username;
	}
	
	
	public String getPassword() {
		return password;
	}
	
	@Override
	public String toString() {
		return "Credentials [username=" + username + ", password=" + password + "]";
	}
	
	
	
	
}

