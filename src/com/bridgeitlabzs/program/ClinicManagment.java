package com.bridgeitlabzs.program;

import java.util.Scanner;

import com.bridgeitlabzs.utility.ClinicMangmentFunction;

public class ClinicManagment {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String fileAddress="/home/brideit/Gulab Thakur/eclip/ObjectOriented/src/com/bridgeitlabzs/utility/DoctoreAddress.json";
		//System.out.println(fileAddress);
		String fileForPatients="/home/brideit/Gulab Thakur/eclip/ObjectOriented/src/com/bridgeitlabzs/utility/PesientAddress.json";
		//System.out.println(fileForPatients);
		boolean check=true;
		do {
			ClinicMangmentFunction cliniqueManagementFunctions=new ClinicMangmentFunction();
			System.out.println("Enter 1 to Search the Doctor by name.\n2 to search patient by name.\n3 to "
			+ "take appointment.\n4 to check doctor availability.\n5 to print appointment report \n6 Add Doctore \n7 Display Pasients \n 8 DisplayDoc \n 9 for Extit.");
			int option=scanner.nextInt();
			switch (option) {
			case 1:
				cliniqueManagementFunctions.searchDoctor(fileAddress);
				break;
			case 2:
				cliniqueManagementFunctions.searchPatient(fileForPatients);
				break;
			case 3:
				cliniqueManagementFunctions.takeAppointment(fileForPatients, fileAddress);
				break;
			case 4:
				cliniqueManagementFunctions.doctorAvailability(fileAddress);
				break;
			case 5:
				cliniqueManagementFunctions.printAppointmentReport(fileAddress);
				break;
			case 6:
				cliniqueManagementFunctions.addDoctore(fileAddress);
				break;
			case 7:
				cliniqueManagementFunctions.displayPasent(fileForPatients);
				break;
			case 8:
				cliniqueManagementFunctions.displayDoctore(fileAddress);
				break;
			case 9:
				check=false;
				break;
			default:
				System.out.println("You have entered wrong choise, please enter write choise.");
				break;
			}
		} while (check);
	}
}
