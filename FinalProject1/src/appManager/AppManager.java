package appManager;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import Person.AccountOwner;
import Person.BankManager;
import Person.Credentials;
import account.Account;
import account.AccountProperties;
import account.ActivityData;

public class AppManager {

	static Scanner scan = new Scanner(System.in);
	//fields
	private  BankManager Administrator;
	private AccountOwner currUser;
	private AccountOwner[] users= new AccountOwner[100];
	static int indexForApp=0;
	private boolean flag =false;
	

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
	
	public  BankManager getAdministrator() {
		return Administrator;
	}



	public void setAdministrator(BankManager administrator) {
		Administrator = administrator;
	}


	//methods

	public void login(){

		//TODO timer
		boolean flagUsername=false,flagPassword;
		int i=0,trys=0;

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
			trys++;
		}while(trys<3);


		if(flagPassword)
			setCurrUser(currUser);
		else {
			System.out.println("sory....the account is locked for 30 minutes");

		}
	}


	public void login(long phoneNumber) {
		for (int i = 0; i < users.length; i++) {
			if(users[i].getPhoneNumber()== phoneNumber) {
				setCurrUser(currUser);
				return;
			}
		}
		System.out.println("The phone number is not in the system");
	}



	public void OpenAccount() {
		//TODO check if the user is exist;
		fillsApplicationForm();

	}



	public void logout() {
		this.currUser=null;
	}


	public AccountOwner getOwnerByPhoneNum(long PhoneNum) {

		return null;
	}



	private void fillsApplicationForm() {
		System.out.println("Enter a Phone Number:\r\n"
				+ "first name:\r\n"
				+ "last name:\r\n"
				+ "bitrthDate:{yyyy,dd,mm,}:\r\n"
				+ "Enter a new user name: {letters and digits only}:\r\n"
				+ "Enter a new password:  {4-8 chars, must contain digit and letter}:\r\n"
				+"monthly Income\r\n");
		long phoneNum=scan.nextLong();
		String firstName = scan.nextLine();
		scan.nextLine();
		String lastName = scan.nextLine();
		LocalDate birthDate=ReceivesDateFromUser();
		String username = scan.nextLine();
		scan.nextLine();
		String password = scan.nextLine();
		int monthlyIncome = scan.nextInt();
		
		
		Credentials credentials = new Credentials(username,password);
		
		if(!flag) {
			Account account = new Account(9000);
			this.Administrator = new BankManager(firstName,lastName,phoneNum,birthDate,account,monthlyIncome,credentials);
			addUsers(Administrator);
		}
		 
		 AccountOwner newOwner = new AccountOwner(firstName,lastName,phoneNum,birthDate,null,monthlyIncome,credentials,Administrator,false);
		 newOwner.getManager().addUserToApprove(newOwner);
		 newOwner.getManager().setAndApproveAcc();
		 addUsers(newOwner);
	}

	
	private LocalDate ReceivesDateFromUser() {
		LocalDate ld = LocalDate.of(scan.nextInt(), scan.nextInt(), scan.nextInt());
		return ld;
	}


	public void addUsers(AccountOwner owner) {
		if(indexForApp<100) {
			users[indexForApp]=owner;
			indexForApp++;
		}
	}
	
	

}



