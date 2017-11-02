package com.bridgeitlabzs.program;

import java.util.Scanner;

import com.bridgeitlabzs.utility.CompanyShareFunction;

public class CompanyShareLinkedList {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		boolean check=true;
		String filePath="/home/brideit/Gulab Thakur/eclip/ObjectOriented/src/com/bridgeitlabzs/utility/share.json";

		do{

			System.out.println("Please enter the Number  \n1 to display all companies shares\n2 to remove shares\n3 "
					+ "to add the shares\n4 to exit.");

			int choise=scanner.nextInt();
			CompanyShareFunction company=new CompanyShareFunction();
			switch (choise) {

			case 1:
				company.displayShares(filePath);
				break;
			case 2:
				company.removeShare(filePath);
				break;
			case 3:
				company.addShares(filePath);
				break;
			case 4:
				check=false;
				break;
			default:
				System.out.println("You have entered wrong choise, please enter correct choise.");
				break;
			}
		}while(check);

	}
}
