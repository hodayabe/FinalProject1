package Person;

import java.time.LocalDate;

import account.Account;


public class AccountOwner extends Person{
	//fields
	private Account account=null;
	private double monthlyIncome;
	private Credentials credentials;
	private BankManager manager;



	//constructors

	public AccountOwner(String firstName,String lastName,long phoneNumber,LocalDate bitrthDate,Account account, double monthlyIncome, Credentials credentials,BankManager manager) {
		super(firstName,lastName,phoneNumber,bitrthDate);
		setAccount(account);
		setMonthlyIncome(monthlyIncome);
		setCredentials(credentials);
		setManager(manager);
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

	}
	public void produceReport(LocalDate start) {

	}

	public void deposit() {

	}
	public void withdrawal() {

	}

	public void transferFunds() {

	}







	





}
