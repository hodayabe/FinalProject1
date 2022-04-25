package Person;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

import account.Account;
import appManager.AppManager;


public class AccountOwner extends Person{
	//fields
	private Account account=null;
	private double monthlyIncome;
	private Credentials credentials;
	private BankManager manager;
	private boolean isManager;
	static Scanner scan = new Scanner(System.in);

	//constructors

	public AccountOwner(String firstName,String lastName,long phoneNumber,LocalDate bitrthDate,Account account, 
			double monthlyIncome, Credentials credentials, BankManager manager,boolean isManager) {

		super(firstName,lastName,phoneNumber,bitrthDate);
		setAccount(account);
		setMonthlyIncome(monthlyIncome);
		setCredentials(credentials);
		if(!isManager)
			setManager(manager);
		else
			setManager(null);
	}



	//getters and setters

	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}

	public double getMonthlyIncome() {
		return monthlyIncome;
	}

	public void setMonthlyIncome(double monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	public BankManager getManager() {
		return manager;
	}

	public void setManager(BankManager manager) {
		this.manager = manager;
	}



	//methods
	public void checkBalance() {
		System.out.println("Your account balance is: " +this.getAccount().getBalance());
	}

	public void produceReport(LocalDate start) {
		for (int i = 0; i < this.getAccount().getActivityData().length; i++) {
			if(this.getAccount().getActivityData()[i].getTimeStamp().toLocalDate().isAfter(start))
				System.out.println(this.getAccount().getActivityData()[i]);
		}
	}

	public void deposit() {
		System.out.println("your code is: " +getCode());
		System.out.println("How much would you like to deposit");
		double money=scan.nextDouble();
		this.getAccount().setBalance(this.getAccount().getBalance()+money);
		System.out.println("Successful deposit");
	}


	public void withdrawal() {
		System.out.println("How much money to withdrawal?");
		double money=scan.nextDouble();
		while(money + this.getAccount().withdrawalToday() > this.getAccount().getAccountProperties().getMaxWithdrawalAmount()) {
			System.out.println("sory..You have exceeded the possible amount for withdrawal");
			money=scan.nextDouble();
		}
		this.getAccount().setBalance(this.getAccount().getBalance()-money);
		System.out.println("Successful withdrawal");
	}

	
	public void transferFunds() {
		System.out.println("Enter a Phone Number");
		long phoneNum=scan.nextLong();
		AccountOwner temp=AppManager.getOwnerByPhoneNum(phoneNum);
		System.out.println("Enter a transfer amount");
		double money=scan.nextDouble();
		if(money>2000) {
			System.out.println("sory..you canot transfer this amount ");
			return;
		}
		else {
			this.getAccount().setBalance(this.getAccount().getBalance()-money);
			temp.getAccount().setBalance(this.getAccount().getBalance()+money);
		}
		System.out.println("Successful transferFunds");
	}


	public int getCode() {
		Random rand = new Random();
		int code = rand.nextInt(9000)+1000;
		return code;
	}



	@Override
	public String toString() {
		return "AccountOwner [account=" + account + ", monthlyIncome=" + monthlyIncome + ", credentials=" + credentials
				+ ", manager=" + manager + ", isManager=" + isManager + "]";
	}

















}
