package Person;

public class Credentials {
	//fields
	private String username;
	private String password;
	
	//Constructors
	public Credentials(String username, String password) {
		setUsername(username);
		setPassword(password);
	}
	
	
	//getters and setters
	public String getUsername() {
		return username;
	}
	
	private boolean isDigitOrLetter(String username) {
		for (int i = 0; i < username.length(); i++) 
			if(!Character.isDigit(username.charAt(i)) && !Character.isLetter(username.charAt(i)))
				return false;
		return true;
	}
	
	//TODO
	public void setUsername(String username) {
		if(!isDigitOrLetter(username))
				System.out.println("Unacceptable password");
			else
				this.username = username;
		
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		if(!isDigitOrLetter(username) && password.length()>4 )
			System.out.println("Unacceptable password");
		else
			this.password = password;
	}
}
