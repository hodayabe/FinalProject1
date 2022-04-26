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
	private BankManager Administrator;
	private AccountOwner currUser;
	public static AccountOwner[] users= new AccountOwner[100];
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
		int j=0,trys=0;

		//Verifies username
		do {
			System.out.println("Enter a username");
			String username = scan.nextLine();

			for (int i=0; users[i]!=null; i++) {
				flagUsername=users[i].getCredentials().getUsername().equals(username);
				if(flagUsername) {
					j=i;
					break;
				}	
			}
		}while(!flagUsername);



		//Verifies password
		do {
			System.out.println("Enter a password");
			String password = scan.nextLine();
			flagPassword=users[j].getCredentials().getPassword().equals(password);
			trys++;
		}while(trys<3 && !flagPassword);


		if(flagPassword) {
			setCurrUser(users[j]);
			if(currUser.equals(Administrator)) {
				Administrator.setAndApproveAcc();
			}
			System.out.println("Successful login");
		}
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


	public  void OpenAccount() {
		if(!flag) {
			Account account = new Account(9000);
			Credentials credentials = new Credentials("jon1","jon123");
			this.Administrator=new BankManager("jon","don",12345678, LocalDate.of(2020, 1, 8),account,9000,credentials);
			addUsers(Administrator);
			flag=true;
			return;
		}
		fillsApplicationForm();

	}



	public void logout() {
		this.currUser=null;
	}


	public static  AccountOwner getOwnerByPhoneNum(long PhoneNum) {
		for (int i = 0; i < users.length; i++) {
			if(users[i].getPhoneNumber()== PhoneNum)
				return users[i];
		}
		return null;
	}

	
	private void fillsApplicationForm() {
		String firstName,lastName,username,password;

		System.out.println("Phone Number:\r\n");
		long phoneNum=scan.nextLong();
		scan.next();
		
		do {
			System.out.println("first name: \r\n");
			firstName = scan.nextLine();
		}while(!isALLLetter(firstName));
		
		do {
			System.out.println("last name: \r\n");
			lastName= scan.nextLine();
		}while(!isALLLetter(lastName));
		
		
		do {
			System.out.println("username: {letters and digits only}:\r\n");
			username = scan.nextLine();
		}while(!isDigitAndLetter(username));
		
		
		do {
			System.out.println("password:  {4-8 chars, must contain digit and letter}:\r\n");
			password = scan.nextLine();
		}while(!isDigitAndLetter(password) || !isGoodLength(password));
		
		
		System.out.println("monthly Income:\r\n");
		int monthlyIncome=Integer.parseInt(scan.nextLine());
		
		Credentials credentials = new Credentials(username,password);
		AccountOwner newOwner = new AccountOwner(firstName,lastName,phoneNum, LocalDate.of(2020, 1, 8),
				null,monthlyIncome,credentials,Administrator);
		newOwner.getManager().addUserToApprove(newOwner);
		addUsers(newOwner);
		System.out.println("Successful OpenAccount");
	}
	
	
	public void addUsers(AccountOwner owner) {
		if(indexForApp<100) {
			users[indexForApp]=owner;
			indexForApp++;
		}
	}


	private boolean isALLLetter(String username) {
		for (int i = 0; i < username.length(); i++) 
			if(!Character.isLetter(username.charAt(i))) 
				return false;
		return true;
	}


	private boolean isDigitAndLetter(String username) {
		boolean digit=false;
		boolean latter=false;
		for (int i = 0; i < username.length(); i++) {
			if(!Character.isDigit(username.charAt(i)) && !Character.isLetter(username.charAt(i)))
				return false;
			if(Character.isDigit(username.charAt(i)))
			 digit=true;
			
			if(Character.isLetter(username.charAt(i)))
				latter=true;
		}
		
		return digit && latter;
	}


	private boolean isGoodLength(String password) {
		if(password.length()<4||password.length()>8)
				return false;
		return true;
	}

//	private LocalDate makeData() {
	//		int year=scan.nextInt();
	//		int month=scan.nextInt();
	//		int day=scan.nextInt();
	//		LocalDate ld = LocalDate.of(year,month,day);
	//		return ld;
	//	}
}



