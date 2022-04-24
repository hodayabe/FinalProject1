package Person;

import java.time.LocalDate;

import finalProject2.account.Account;

public class AccountOwner extends Person{
	//fields
	private Account account=null;
	private double monthlyIncome;
	private Credentials credentials;



	//constructors

	public AccountOwner(Account account, double monthlyIncome, Credentials credentials) {
		super();
		setAccount(account);
		setMonthlyIncome(monthlyIncome);
		setCredentials(credentials);
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
