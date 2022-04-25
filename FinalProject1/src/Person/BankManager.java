package Person;

import java.time.LocalDate;
import java.util.Arrays;

import account.Account;
import account.AccountProperties;
import account.ActivityData;

public class BankManager extends AccountOwner {

	private AccountOwner[] usersToApprove;
	static int indexForAccount=0;
	
	
	public BankManager(String firstName, String lastName, long phoneNumber, LocalDate bitrthDate, Account account,
			double monthlyIncome, Credentials credentials) {
		
		super(firstName, lastName, phoneNumber, bitrthDate, account, monthlyIncome, credentials, null,true);
		
		usersToApprove=new AccountOwner[100];
	}

	
	
	public AccountOwner[] getUsersToApprove() {
		return usersToApprove;
	}



	public void setUsersToApprove(AccountOwner[] usersToApprove) {
		for (int i = 0; i < usersToApprove.length; i++) {
			this.usersToApprove[i] = usersToApprove[i];
		}
	}

	
	public void setAndApproveAcc() {
		for (int i = 0; this.usersToApprove[i]!=null; i++) {
			AccountProperties tempAccProperties = AccountProperties.DecidesAccountType(this.usersToApprove[i].getMonthlyIncome());
			Account tempAcc =new Account(usersToApprove[i].getMonthlyIncome(),tempAccProperties,null,tempAccProperties.getIntresRateMax(),tempAccProperties.getFeeMax());
			usersToApprove[i].setAccount(tempAcc);
		}
		this.usersToApprove=null;
	}
			
	public void addUserToApprove(AccountOwner owner) {
		if(indexForAccount<100) {
			usersToApprove[indexForAccount]=owner;
			indexForAccount++;
		}
		System.out.println(this);
	}
			
	public void produceReport(LocalDate start) {
		
	}



	@Override
	public String toString() {
		return super.toString();
	}




	



	

	
}
