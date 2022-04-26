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
				System.out.println("**********");
				System.out.println(users[i]);
				System.out.println("**********");
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
		System.out.println("Enter a Phone Number:\r\n"
				+ "first name:\r\n"
				+ "last name:\r\n"
				+ "bitrthDate:{yyyy,dd,mm,}:\r\n"
				+ "Enter a new user name: {letters and digits only}:\r\n"
				+ "Enter a new password:  {4-8 chars, must contain digit and letter}:\r\n"
				+"monthly Income\r\n");
		long phoneNum=scan.nextLong();
		scan.next();
		String firstName = scan.nextLine();
		String lastName = scan.nextLine();
		String username = scan.nextLine();
		String password = scan.nextLine();
		int monthlyIncome=Integer.parseInt(scan.nextLine());
		Credentials credentials = new Credentials(username,password);

//		if(!flag) {
//			Account account = new Account(9000);
//			//this.Administrator = new BankManager(firstName,lastName,phoneNum,birthDate,account,monthlyIncome,credentials);
//			this.Administrator = new BankManager(firstName,lastName,phoneNum, LocalDate.of(2020, 1, 8),account,monthlyIncome,credentials);
//			addUsers(Administrator);
//			flag=true;
//		}
//		else {
			AccountOwner newOwner = new AccountOwner(firstName,lastName,phoneNum, LocalDate.of(2020, 1, 8),
					null,monthlyIncome,credentials,Administrator);
			newOwner.getManager().addUserToApprove(newOwner);
			addUsers(newOwner);
//		}
		System.out.println("Successful OpenAccount");
	}


     //TODO
	private LocalDate ReceivesDateFromUser() {
		int year=scan.nextInt();
		int month=scan.nextInt();
		int day=scan.nextInt();
		LocalDate ld = LocalDate.of(year,month,day);
		return ld;
	}


	public void addUsers(AccountOwner owner) {
		if(indexForApp<100) {
			users[indexForApp]=owner;
			indexForApp++;
		}
	}



}



