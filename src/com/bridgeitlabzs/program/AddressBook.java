package com.bridgeitlabzs.program;

import java.util.Scanner;

public class AddressBook {
	
	public static void main(String[] args) {
		System.out.println("Program Started");
		String filePath="/home/brideit/Gulab Thakur/eclip/ObjectOriented/src/com/bridgeitlabzs/utility/AddressBook.json";
		Scanner scanner=new Scanner(System.in);
		boolean check=true;
		com.bridgeitlabzs.utility.AddressBook addressBookFunctions=new com.bridgeitlabzs.utility.AddressBook();
		addressBookFunctions.display(filePath);
		
		  do{
			System.out.print("Enter 1 to Add , 2 to Update, 3 to delete , 4 Sort By name , 5 to sort by zip , 6 to exit : ");
			int choise=scanner.nextInt();
            switch (choise) {
			case 1:
				addressBookFunctions.addObject(filePath);
				break;
			case 2:
				addressBookFunctions.edit(filePath);
				break;
			case 3:
				addressBookFunctions.delete(filePath);
				break;
			case 4:
				addressBookFunctions.sortByName(filePath);
				break;
			case 5:
				addressBookFunctions.sortByZip(filePath);
				break;
			case 6:
				check=false;
				break;
			default:
				System.out.println("you have entered wrong choise, please entered once again.");
				break;
			}
		}while(check);
		System.out.println("Program Ended ");
	}

}
