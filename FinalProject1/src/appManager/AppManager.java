package appManager;

import java.util.Scanner;

import Person.AccountOwner;

public class AppManager {

	static Scanner scan = new Scanner(System.in);
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

	public void login(){
		boolean flagUsername=false,flagPassword;
		int i=0,cnt=0;

		//Verifies username
		do {
			System.out.println("Enter a username");
			String username = scan.nextLine();
			for (; i < users.length; i++) {
				flagUsername=users[i].getCredentials().getUsername().equals(username);
				if(flagUsername)
					break;
			}
		}while(flagUsername);

		
		//Verifies password
		do {
			System.out.println("Enter a password");
			String password = scan.nextLine();
			flagPassword=users[i].getCredentials().getPassword().equals(password);
			cnt++;
		}while(cnt<3);


		if(flagPassword)
			setCurrUser(currUser);
		else
			System.out.println("the account");

	}


	public void login(long phoneNumber) {

	}

	public void OpenAccount() {

	}

	public void logout() {
		this.currUser=null;
	}

	public AccountOwner getOwnerByPhoneNum(long PhoneNum) {

		return null;
	}



	private void fillsApplicationForm() {
		System.out.println("Enter a Phone number");
		currUser.setPhoneNumber(0);

	}





}
