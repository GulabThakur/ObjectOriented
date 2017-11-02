package com.bridgeitlabzs.utility;

import java.util.Iterator;
import java.util.Scanner;

import javax.jws.Oneway;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ClinicMangmentFunction {
	Scanner scanner = new Scanner(System.in);
	Utility utility = new Utility();

	@SuppressWarnings("unchecked")
	public void addDoctore(String filepath) {
		JSONArray jsonArray = new JSONArray();
		jsonArray = utility.jsonFileReader(filepath);
		JSONObject jsonObject = new JSONObject();
		System.out.println("Please Enter the name of Doctore");
		String name = scanner.next();
		if (name.equalsIgnoreCase((String) jsonObject.get("name"))) {
			System.out.println("Please Enter the Specification ");
			String speification = scanner.next();
			System.out.println("Please enter the id ");
			String id = scanner.next();
			// store the data
			jsonObject.put("patient", 0);
			jsonObject.put("name", name);
			jsonObject.put("specialization", speification);
			jsonObject.put("id", id);
			// jsonArray.add(1, jsonObject);
			utility.jsonFileWriter(filepath, jsonArray);
		} else {
			System.out.println("You have alredy add");
		}
	}

	/**
	 * @param filePath
	 * 
	 * @Description it will print the doctor name with detail if doctor found.
	 */
	public void searchDoctor(String fileDoctoreAddress) {
		System.out.println("Please Enter the name of Doctor For search : ");
		String doctorName = scanner.nextLine();
		JSONArray jsonArray = new JSONArray();
		jsonArray = utility.jsonFileReader(fileDoctoreAddress);
		Iterator<?> iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();
		boolean check = true;
		while (iterator.hasNext()) {
			jsonObject = (JSONObject) iterator.next();
			if (doctorName.equalsIgnoreCase((String) jsonObject.get("name"))) {
				System.out.println("Doctor Name : " + jsonObject.get("name")
						+ ", ID : " + jsonObject.get("id")
						+ ", Specialization : "
						+ jsonObject.get("specialization"));
				check = false;
				break;
			}
		}
		if (check) {
			System.out.println("Doctor not found.");
		}
		System.out
				.println("-----------------------------------------------------------------------------------");
	}

	/**
	 * @param filePath
	 * 
	 * @Description it will print the patient name with detail.
	 */
	public void searchPatient(String filePastientAddress) {
		System.out.println("Enter the name of Patient to search : ");
		String doctorName = scanner.nextLine();
		JSONArray jsonArray = new JSONArray();
		jsonArray = utility.jsonFileReader(filePastientAddress);
		Iterator<?> iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();
		boolean check = true;
		while (iterator.hasNext()) {
			jsonObject = (JSONObject) iterator.next();
			if (doctorName.equalsIgnoreCase((String) jsonObject.get("name"))) {
				System.out.println("Patient Name : " + jsonObject.get("name")
						+ ", ID : " + jsonObject.get("id")
						+ ", Mobile Number : " + jsonObject.get("mobile")
						+ ", Age : " + jsonObject.get("age"));
				check = false;
				break;
			}
		}
		if (check) {
			System.out.println("Patient not found.");
		}
		System.out
				.println("-----------------------------------------------------------------------------------");
	}

	/**
	 * @param fileForPatient
	 * @param fileForDoctor
	 * 
	 * @Dscription it is used to take the appointment.
	 */
	public void takeAppointment(String fileForPatients, String fileAddress) {
		JSONArray jsonArray=new JSONArray();
		jsonArray=utility.jsonFileReader(fileForPatients);
		JSONObject object=new JSONObject();
		Iterator<?> iterator=jsonArray.iterator();
		JSONArray jsonArray2=new JSONArray();
		JSONObject jsonObject =new JSONObject();
		jsonArray2 =utility.jsonFileReader(fileAddress);
		Iterator<?> iterator2=jsonArray2.iterator();
		System.out.println("Please Enter the Name of Pesient ");
		String name=scanner.next();
		System.out.println("Please Enter the name of Doctore ");
		String docName=scanner.next();
		boolean check=false;
		while(iterator.hasNext())
		{
			object=(JSONObject) iterator.next();
			if(name.equalsIgnoreCase((String) object.get("name")))
			{
				while(iterator2.hasNext())
				{
					jsonObject=(JSONObject) iterator2.next();
					
					JSONArray jsonArray3 =(JSONArray) jsonObject.get("patient");
					if(docName.equalsIgnoreCase((String) jsonObject.get("name")))
					{
						if(jsonArray3.size()<5){
						jsonArray3.add(object);
						System.out.println("Appointment done.");
						check=true;
                        break;
						}
						else
						{
							System.out.println("Apointment is Full");
						}
					}
				}
				if(check)
				{
					utility.jsonFileWriter(fileAddress, jsonArray2);
					break;
				}
				else if(!check)
				{
					System.out.println("Invailid doctor name.");
                }
			}
		}
	}
	
	/**
	 * @param fileForDoctor
	 * 
	 * @Description This function will give you detail of remaining
	 *              appointments.
	 */
	public void doctorAvailability(String fileForDoctor) {
		JSONArray jsonArray = new JSONArray();
		jsonArray = utility.jsonFileReader(fileForDoctor);
		Iterator<?> iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();
		System.out.println("Available appointments : ");
		while (iterator.hasNext()) {
			jsonObject = (JSONObject) iterator.next();
			JSONArray jsonArrayForsize = (JSONArray) jsonObject.get("patient");
			if (jsonArrayForsize.size() < 5) {
				System.out.println("Doctor Name : " + jsonObject.get("name")
						+ ", Remaining Appointment : "
						+ (5 - jsonArrayForsize.size()));
			} else {
				System.out.println("Doctor Name : " + jsonObject.get("name")
						+ ", No Remaining Appointments");
			}
		}
		System.out
				.println("-----------------------------------------------------------------------------------");
	}

	/**
	 * @param fileForDoctor
	 * 
	 * @Description it will print full appointment report.
	 */
	public void printAppointmentReport(String fileForDoctor) {
		JSONArray jsonArray = new JSONArray();
		jsonArray = utility.jsonFileReader(fileForDoctor);
		Iterator<?> iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();
		while (iterator.hasNext()) {
			jsonObject = (JSONObject) iterator.next();
			System.out.print("Doctor " + jsonObject.get("name")
					+ " have Patients : ");
			JSONArray jsonArray2 = new JSONArray();
			jsonArray2 = (JSONArray) jsonObject.get("patient");
			Iterator<?> iterator2 = jsonArray2.iterator();
			JSONObject jsonObject2 = new JSONObject();

			while (iterator2.hasNext()) {
				jsonObject2 = (JSONObject) iterator2.next();
				System.out.print(jsonObject2.get("name") + "  ");
			}
			System.out.println();
		}
		System.out
				.println("-----------------------------------------------------------------------------------");
	}

	/**
	 * @param fileForPatients
	 */
	public void displayPasent(String fileForPatients) {
		JSONArray jsonArray = new JSONArray();
		jsonArray = utility.jsonFileReader(fileForPatients);
		Iterator<?> iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();
		String name;
		int id;
		long number;
		int age;
		while (iterator.hasNext()) {
			jsonObject = (JSONObject) iterator.next();
			name = (String) jsonObject.get("name");
			Object onj = jsonObject.get("id");
			id = Integer.parseInt(onj.toString());
			onj = jsonObject.get("mobile");
			number = Long.parseLong(onj.toString());
			onj = jsonObject.get("age");
			age = Integer.parseInt(onj.toString());
			System.out.println("Pasient name:" + name + " Id: " + id
					+ " Age : " + age + " Number :" + number);
			System.out
					.println("........................................................................");
		}
	}

	/**
	 * @param filePath
	 */
	public void displayDoctore(String filePath) {
		JSONArray jsonArray = new JSONArray();
		jsonArray = utility.jsonFileReader(filePath);
		Iterator<?> iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();
		String name;
		int id;
		String specification;
		int pesient;
		while (iterator.hasNext()) {
			jsonObject = (JSONObject) iterator.next();
			name = (String) jsonObject.get("name");
			Object onj = jsonObject.get("id");
			id = Integer.parseInt(onj.toString());
			onj = jsonObject.get("mobile");
			specification = (String) jsonObject.get("specialization");
		//	onj = jsonObject.get("patient");
			JSONArray pesient1 =(JSONArray) jsonObject.get("patient");
			System.out.println("Pasient name:" + name + " Id: " + id
					+ " Specifiction: " + specification
					+ " Number of Pesient :" + pesient1);
			System.out
					.println("........................................................................");
		}
	}

	
}
