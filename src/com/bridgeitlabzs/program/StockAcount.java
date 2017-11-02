package com.bridgeitlabzs.program;

import java.util.Scanner;

import com.bridgeitlabzs.utility.StockAcountFunction;

public class StockAcount {
	public static void main(String[] args) {
		System.out.println("Program Started");
		Scanner scanner=new Scanner(System.in);
		
		String filePath="/home/brideit/Gulab Thakur/eclip/ObjectOriented/src/com/bridgeitlabzs/utility/comercialData.json";
		boolean check=true;
		do{
			StockAcountFunction stockAccountFunction=new StockAcountFunction();
			System.out.println("Enter The number  \n 1 : Number of Record\n 2 : Create account \n 3 : Sale shares \n 4:Purchase the shares \n 5: exit");
			int option=scanner.nextInt();
			
			switch (option) {
			case 1:
				int totalAccounts=stockAccountFunction.numberOfrecord(filePath);
				System.out.println("Total Number of Accounts : "+totalAccounts);
				stockAccountFunction.dispaly(filePath);
				break;
			case 2:
				stockAccountFunction.createAccount(filePath);
				break;
			case 3:
				System.out.println("AIRTEL : @ \nVODAPHONE : # \nSONY : & \nSAMSUNG : $");
				System.out.println("Enter the Symbol of company : ");
				scanner.nextLine();
				String symbol=scanner.nextLine();
				System.out.println("Enter how much share you want to sell : ");
				long share=scanner.nextLong();
				stockAccountFunction.sell(share, symbol);
				break;
			case 4:
				System.out.println("AIRTEL : @ \nVODAPHONE : # \nSONY : & \nSAMSUNG : $");
				System.out.println("Enter the Symbol of company : ");
				scanner.nextLine();
				String symbol2=scanner.nextLine();
				System.out.println("Enter how much share you want to buy : ");
				long shareToBuy=scanner.nextLong();
				stockAccountFunction.buy(shareToBuy, symbol2);
				break;
			case 5:
				check=false;
				break;
			default:
				System.out.println("You have entered wrong ption, please enter correct option.");
				break;
			}
			
		}while(check);
		System.out.println("Program Ended ");
	}
}
