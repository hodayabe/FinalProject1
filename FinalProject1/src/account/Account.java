package account;

import java.time.LocalDate;

public class Account {
	static int cnt = 0;
	private final long accountNumber;
	private double balance;
	private AccountProperties accountProperties;
	private ActivityData[] activityData;
	private double intresRate;
	private double fee;
	
	
	public Account(double balance) {
		this.accountNumber = cnt++;
		setBalance(balance);
	}


	public Account(double balance, AccountProperties accountProperties,ActivityData[] activityData, double intresRate, double fee) {
		this.accountNumber = cnt++;
		this.balance = balance;
		this.accountProperties = accountProperties;
		this.activityData = activityData;
		this.intresRate = intresRate;
		this.fee = fee;
	}


	public static int getCnt() {
		return cnt;
	}


	public static void setCnt(int cnt) {
		Account.cnt = cnt;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public AccountProperties getAccountProperties() {
		return accountProperties;
	}


	public void setAccountProperties(AccountProperties accountProperties) {
		this.accountProperties = accountProperties;
	}


	public ActivityData[] getActivityData() {
		return activityData;
	}


	public void setActivityData(ActivityData[] activityData) {
		this.activityData = activityData;
	}


	public double getIntresRate() {
		return intresRate;
	}


	public void setIntresRate(double intresRate) {
		this.intresRate = intresRate;
	}


	public double getFee() {
		return fee;
	}


	public void setFee(double fee) {
		this.fee = fee;
	}


	public long getAccountNumber() {
		return accountNumber;
	}

	public double withdrawalToday() {
		double sum=0;
		boolean flagDate,flagName;
		for (int i = 0; i < this.getActivityData().length; i++) {
			flagDate=this.getActivityData()[i].getTimeStamp().toLocalDate()== LocalDate.now();
			flagName=this.getActivityData()[i].getActivityName().equals("WITHDRAWAL") ;
			if(flagDate&&flagName)
				sum+=this.getActivityData()[i].getBalanceChange();
		}
		return sum;
	}

}


