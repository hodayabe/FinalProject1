package Person;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;
import account.Account;
import account.ActivityData;
import account.ActivityName;
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
			double monthlyIncome, Credentials credentials, BankManager manager) {

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
		System.out.println("Your account balance is: " +this.getAccount().getBalance());
	}

	
	public void produceReport(LocalDate start) {
		for (int i = 0 ; this.account.getActivityData()[i]!=null; i++) {
			if(this.account.getActivityData()[i].getTimeStamp().toLocalDate().isAfter(start) || this.account.getActivityData()[i].getTimeStamp().toLocalDate().isEqual(start)) {
				System.out.println(this.getAccount().getActivityData()[i]);
			}
		}
	}

	public void deposit() {
		System.out.println("your code is: " +getCode());
		System.out.println("How much would you like to deposit");
		double money=scan.nextDouble();
		this.getAccount().setBalance(money-countFee(money));
		this.getManager().getAccount().setBalance(countFee(money));
		System.out.println("Successful deposit");
		this.makeActivityDataAndAddToActivityData(ActivityName.DEPOSIT,money,LocalDateTime.now(),
				"DEPOSIT, time: "+ LocalDateTime.now()+", amont: "+ money);
		this.getManager().makeActivityDataAndAddToActivityData(ActivityName.DEPOSIT,money,LocalDateTime.now(),
				"DEPOSIT, time: "+ LocalDateTime.now()+", amont: "+ money);
		
	}


	public void withdrawal() {
		System.out.println("How much money to withdrawal?");
		double money=scan.nextDouble();
		while(money + this.getAccount().withdrawalToday() > this.getAccount().getAccountProperties().getMaxWithdrawalAmount() && money < this.account.getBalance()) {
			System.out.println("sory..You have exceeded the possible amount for withdrawal");
			money=scan.nextDouble();
		}
		this.getAccount().setBalance(-money-countFee(money));
		this.getManager().getAccount().setBalance(countFee(money));
		System.out.println("Successful withdrawal");
		makeActivityDataAndAddToActivityData(ActivityName.WITHDRAWAL,-money,LocalDateTime.now(),
				"WITHDRAWAL, time: "+ LocalDateTime.now()+", amont: "+ -money);
	}

	
	public void transferFunds() {
		System.out.println("Enter a Phone Number");
		long phoneNum=scan.nextLong();
		AccountOwner temp = AppManager.getOwnerByPhoneNum(phoneNum);
		System.out.println("Enter a transfer amount");
		double money=scan.nextDouble();
		if(money>2000) {
			System.out.println("sory..you canot transfer this amount ");
			return;
		}
		else {
			this.getAccount().setBalance(-money-countFee(money));
			temp.getAccount().setBalance(money);
			this.getManager().getAccount().setBalance(countFee(money));
		}
		System.out.println("Successful transferFunds");
		makeActivityDataAndAddToActivityData(ActivityName.TRANSFER,-money,LocalDateTime.now(),
				"TRANSFER, time: "+ LocalDateTime.now()+", amont: "+ -money);
	}

	public void  payBill() {
		System.out.println("selects the payee:  1-Bank, 2-phone company, 3-water company, 4-electric company");
		int payee = scan.nextInt();
		System.out.println("Enter a transfer amount");
		double money = scan.nextDouble();
		if(money>5000) {
			System.out.println("sory..you canot transfer this amount");
			return;
		}
		
		this.getAccount().setBalance(-money);
		this.getManager().getAccount().setBalance(countFee(money));
		if(payee == 1)
			this.getManager().getAccount().setBalance(money);
		System.out.println("successful withdrawal");
		makeActivityDataAndAddToActivityData(ActivityName.PAY_BILL,-money,LocalDateTime.now(),
				"PAY_BILL, time: "+ LocalDateTime.now()+", amont: "+ -money);
	}
	
	
	public void getLoan() {
		System.out.println("enter a loan amount and number of monthly payments");
		double money = scan.nextDouble();
		int month = scan.nextInt();
		
		if(money > this.getAccount().getAccountProperties().getMaxLoanAmount()) {
			System.out.println("sory..You can not take a loan in this amount");
			return;
		}
		
		if(month>60) {
			System.out.println("sory..You can not take a loan for the requested period of time");
			return;
		}
		
		this.getAccount().setBalance(money);
		this.getManager().getAccount().setBalance(countIntresRate(money)-money);
		
		System.out.println("your monthly payments is: "+money/month +
				"\r\n  successful deposit to the account\r\n successful withdrawal from the main bank ");
		makeActivityDataAndAddToActivityData(ActivityName.GET_LOAN,money,LocalDateTime.now(),
				"GET_LOAN, time: "+ LocalDateTime.now()+", amont: "+ money);
	}

	
	public double countIntresRate(double money) {
		double sum =money *(0.01 * this.getAccount().getIntresRate());
		return sum;
	}
	
 
	public int getCode() {
		Random rand = new Random();
		int code = rand.nextInt(9000)+1000;
		return code;
	}
	
	public double countFee(double money) {
		double sum =money *(0.01 * this.getAccount().getFee());
		return sum;
	}


	public void makeActivityDataAndAddToActivityData(ActivityName activityName,Double balanceChange,LocalDateTime timeStamp,String info){
		ActivityData tempActivity=new ActivityData(activityName, balanceChange, timeStamp, info);
		this.getAccount().addActivityToActivityData(tempActivity);
	}
	
	
	
	
	
	

	@Override
	public String toString() {
		return "AccountOwner [account=" + account + ", monthlyIncome=" + monthlyIncome + ", credentials=" + credentials
				+ ", bankManager=" + manager + "]";
	}





}
