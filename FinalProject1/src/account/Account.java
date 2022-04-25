package account;


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

	private double getBalance() {
		return balance;
	}

	private void setBalance(double balance) {
		this.balance = balance;
	}

	private AccountProperties getAccountProperties() {
		return accountProperties;
	}

	private void setAccountProperties(AccountProperties accountProperties) {
		this.accountProperties = accountProperties;
	}

	private ActivityData[] getActivityData() {
		return activityData;
	}

	private void setActivityData(ActivityData[] activityData) {
		this.activityData = activityData;
	}

	private double getIntresRate() {
		return intresRate;
	}

	private void setIntresRate(double intresRate) {
		this.intresRate = intresRate;
	}

	private double getFee() {
		return fee;
	}

	private void setFee(double fee) {
		this.fee = fee;
	}

	private long getAccountNumber() {
		return accountNumber;
	}
	
	

}


