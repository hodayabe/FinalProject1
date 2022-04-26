package menue;

import java.time.LocalDate;
import java.util.Scanner;
import Person.BankManager;
import Person.Credentials;
import account.Account;
import appManager.AppManager;

public class Menue {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {

		AppManager app =new AppManager();

		while(true) {
			Menue.openAccountOrLogig();
			int opt = Integer.parseInt(sc.next());
			if(opt == 0)
				break;
			callAppManager1(app,opt);
		}
	}


	public static void openAccountOrLogig() {
		System.out.println("Please select a action you want to perform:");
		System.out.println("1. Open Account\n" + "2. Login \n" );
	}

	public static void showMenue() {
		System.out.println("Please select a action you want to perform:");
		System.out.println("1. Check Balance\n" + "2. Produce Activity Report\n"
				+ "3. Make a deposit\n" + "4. Withdrawal\n" + "5. Transfer funds\n" + "6. Pay bill\n" + "7. Get Loan"+"8. Logout");
	}


	public static void callAppManager1(AppManager app,int opt) {
		System.out.println(app.getAdministrator());
		switch(opt){
		case 0: 
			System.out.println("by by");
		case 1:
			app.OpenAccount();
			break;
		case 2: 
			app.login();
			while(true) {
				Menue.showMenue();
				opt = Integer.parseInt(sc.next());
				if(opt == 0)
					break;
				callAppManager(app,opt);

			}

		}
	}

	public static void callAppManager(AppManager app,int opt) {
		switch(opt){
		case 0: 
			System.out.println("by by");
		case 1: 
			app.getCurrUser().checkBalance();
			break;
		case 2: 
//			System.out.println("Enter a LocalDate");
//			LocalDate date =LocalDateof(2021,12,12);
			app.getCurrUser().produceReport( LocalDate.of(2020, 1, 8));
			break;
		case 3: 
			app.getCurrUser().deposit();
			break;
		case 4: 
			app.getCurrUser().withdrawal();
			break;
		case 5: 
			app.getCurrUser().transferFunds();
			break;
		case 6: 
			app.getCurrUser().payBill();
			break;
		case 7: 
			app.getCurrUser().getLoan();
			break;
		case 8: 
			app.logout();
			while(true) {
				Menue.openAccountOrLogig();
				opt = Integer.parseInt(sc.next());
				if(opt == 0)
					break;
				callAppManager1(app,opt);
				break;
			}
		}
	}
	
	
	}
