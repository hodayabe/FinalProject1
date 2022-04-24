package appManager;

import Person.AccountOwner;
import Person.Credentials;

public class AppManager {

	//fields
	private AccountOwner currUser;
	private AccountOwner[] users;
	


	//Constructors
	public AppManager(AccountOwner currUser, AccountOwner[] users) {

		setCurrUser(currUser);
		setUsers(users);
	}



	//getters and setters
	public AccountOwner getCurrUser() {
		return currUser;
	}


	public void setCurrUser(AccountOwner currUser) {
		this.currUser = currUser;
	}

	public AccountOwner[] getUsers() {
		return users;
	}

	public void setUsers(AccountOwner[] users) {
		for (int i = 0; i < users.length; i++) {
			this.users[i]=users[i];
		}
	}


	//methods

	public void login(String username, String password){
		for (int i = 0; i < users.length; i++) {
			boolean flagUsername=users[i].getCredentials().getUsername().equals(username);
			boolean flagPassword=users[i].getCredentials().getPassword().equals(password);
			if(flagUsername && flagPassword)
				setCurrUser(users[i]);
		}
	}

	
	public void login(long phoneNumber) {

	}

	public void OpenAccount() {

	}

	public void logout() {

	}

	public AccountOwner getOwnerByPhoneNum(long PhoneNum) {

		return null;
	}





}
