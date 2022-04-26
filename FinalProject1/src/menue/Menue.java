package menue;

import java.time.LocalDate;
import java.util.Scanner;

import Person.BankManager;
import Person.Credentials;
import account.Account;
import appManager.AppManager;

public class Menue {
	

	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
		AppManager app =new AppManager();
//		Account account = new Account(9000);
//		Credentials credentials = new Credentials("jon1","jon123");
//		BankManager manager=new BankManager("jon","don",12345678, LocalDate.of(2020, 1, 8),account,9000,credentials);
//		app.setAdministrator(manager);
//		app.addUsers(manager);
		
		  while(true) {
			  Menue.showMenue();
			  
		    int opt = Integer.parseInt(sc.next());
		    if(opt == 0)
		      break;
		    callAppManager(app,opt);
		  }
	}

	public static void showMenue() {
		  System.out.println("Please select a action you want to perform:");
		  System.out.println("1. Open Account\n" + "2. Login Use\n" + "3. Check Balance\n" + "4. Produce Activity Report\n"
		+ "5. Make a deposit\n" + "6. Withdrawal\n" + "7. Transfer funds\n" + "8. Pay bill\n" + "9. Get Loan");
		}
	
	
	public static void callAppManager(AppManager app,int opt) {
		System.out.println(app.getAdministrator());
		switch(opt){
		case 0: 
			System.out.println("by by");
		case 1:
			app.OpenAccount();
			System.out.println(app.getAdministrator());
			break;
		case 2: 
			app.login();
			System.out.println(app.getAdministrator());
		case 3: 
			app.getCurrUser().checkBalance();
			  break;
		  case 4: 
			  //System.out.println("Enter a LocalDate");
//			  LocalDate date =LocalDateof(2021,12,12);
			  app.getCurrUser().produceReport( LocalDate.of(2020, 1, 8));
			  break;
		  case 5: 
			  app.getCurrUser().deposit();
			  break;
		  case 6: 
			  app.getCurrUser().withdrawal();
			  break;
		  case 7: 
			  app.getCurrUser().transferFunds();
			  break;
		  case 8: 
			  app.getCurrUser().payBill();
			  break;
		  case 9: 
			  app.getCurrUser().getLoan();
			  break;
		}
	}
	
	
}
