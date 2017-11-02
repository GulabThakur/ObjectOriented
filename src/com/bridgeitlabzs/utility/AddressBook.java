package com.bridgeitlabzs.utility;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * @author GulabThakur
 * 
 */
public class AddressBook {

	Utility utility = new Utility();
	Scanner scanner = new Scanner(System.in);

	/**
	 * @param filePath
	 * @this method using for F  
	 */
	public void display(String filePath) {
		JSONArray jsonArray = new JSONArray();
		jsonArray = utility.jsonFileReader(filePath);
		Iterator<?> iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();
		while (iterator.hasNext()) {
			jsonObject = (JSONObject) iterator.next();
			String name = (String) jsonObject.get("Fname");
			String lastName = (String) jsonObject.get("Lname");
			String zip = (String) jsonObject.get("Zip");
			String address = (String) jsonObject.get("Address");
			String state = (String) jsonObject.get("State");
			String number = (String) jsonObject.get("PhoneNumber");
			String city = (String) jsonObject.get("City");
			System.out.println("<<<<<<<<<<<" + name
					+ ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.println("Candidte Name " + name + " " + lastName);
			System.out.println("Candidate Contact " + number);
			System.out.println("Candidate Address " + address);
			System.out.println("City :" + city);
			System.out.println("Satate :" + state);
			System.out.println("Pin Code :" + zip);
			System.out.println(">>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<");
		}
	}

	/**
	 * @param filePath
	 * 
	 * @Description it will write the jsonObject into the file.
	 */
	@SuppressWarnings("unchecked")
	public void addObject(String filePath) {

		JSONArray jsonArray = new JSONArray();
		jsonArray = utility.jsonFileReader(filePath);
		Iterator<?> iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();

		// Accepting the values from user.
		System.out.println("\nEnter your first name : ");
		String fname = scanner.next();
		System.out.println("\nEnter your last name : ");
		String lname = scanner.next();
		System.out.println("Enter your address : ");
		String address = scanner.next();
		System.out.println("Enter your city : ");
		String city = scanner.next();
		System.out.println("Enter your state : ");
		String state = scanner.next();
		System.out.println("Enter the zip : ");
		String zip = scanner.next();
		System.out.println("Enter your phone number : ");
		String phoneNumber = scanner.next();

		// Puting the value into the object.
		jsonObject.put("Fname", fname);
		jsonObject.put("Lname", lname);
		jsonObject.put("Address", address);
		jsonObject.put("City", city);
		jsonObject.put("State", state);
		jsonObject.put("Zip", zip);
		jsonObject.put("PhoneNumber", phoneNumber);
		jsonArray.add(jsonObject);

		// writing the jsonArray into the file.
		utility.jsonFileWriter(filePath, jsonArray);
		System.out.println("Object is Added");
	}

	/**
	 * @param filePath
	 */
	public void edit(String filePath) {

		JSONArray jsonArray = new JSONArray();
		jsonArray = utility.jsonFileReader(filePath);
		Iterator<?> iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();

		System.out
				.println("Enter the name of person, whos data you want to update : ");
		String person = scanner.nextLine();
		boolean found = true;
		while (iterator.hasNext()) {
			jsonObject = (JSONObject) iterator.next();

			if (person.equals((String) jsonObject.get("Fname"))) {
				@SuppressWarnings("unchecked")
				Set<String> keys = jsonObject.keySet();
				String keyArray[] = (String[]) keys.toArray(new String[keys
						.size()]);
				for (int i = 0; i < keyArray.length; i++) {
					System.out.println("Enter " + (i + 1) + " to "
							+ keyArray[i]);
				}
				System.out.println("Enter what you want to do edit : ");
				int key = scanner.nextInt();
				System.out.println("Enter new value : ");
				scanner.nextLine();
				String value = scanner.nextLine();
				jsonObject.put(keyArray[key - 1], value);
				utility.jsonFileWriter(filePath, jsonArray);
				System.out.println("Object is updated.");
				found = false;
			}
		}
		if (found) {
			System.out.println("Persons name is not found.");
		}

	}

	/**
	 * @param filePath
	 *            @ this method using for delete the address
	 */
	public void delete(String filePath) {
		JSONArray jsonArray = new JSONArray();
		jsonArray = utility.jsonFileReader(filePath);
		Iterator<?> iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();
		System.out.println("Enter the name of person to delete : ");
		String person2 = scanner.next();
		boolean found2 = true;
		while (iterator.hasNext()) {
			jsonObject = (JSONObject) iterator.next();
			if (person2.equals(jsonObject.get("Fname"))) {
				jsonArray.remove(jsonObject);
				found2 = false;
				System.out.println("Removed");
				break;
			}
		}
		if (found2) {
			System.out.println("Person not found.");
		}
		utility.jsonFileWriter(filePath, jsonArray);
	}

	/**
	 * @param filePath
	 *            @ this method using for Sorting address by name....
	 */
	public void sortByName(String filePath) {
		JSONArray jsonArray = new JSONArray();
		jsonArray = utility.jsonFileReader(filePath);
		Iterator<?> iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();

		String[] name = new String[jsonArray.size()];
		int index = 0;
		while (iterator.hasNext()) {
			jsonObject = (JSONObject) iterator.next();
			name[index] = (String) jsonObject.get("Fname");
			index++;
		}
		Arrays.sort(name);

		for (int i = 0; i < name.length; i++) {
			Iterator<?> iterator2 = jsonArray.iterator();
			JSONObject jsobject = new JSONObject();
			while (iterator2.hasNext()) {
				jsobject = (JSONObject) iterator2.next();
				if (name[i].equals(jsobject.get("Fname"))) {
					System.out.println(jsobject);
					System.out
							.println("-------------------------------------------------------------------------------------------------------------------------");
				}

			}
		}
	}

	/**
	 * @param filePath
	 * 
	 * @Description it will give you sorted list of objects by zip
	 */
	public void sortByZip(String filePath) {
		JSONArray jsonArray = new JSONArray();
		jsonArray = utility.jsonFileReader(filePath);
		Iterator<?> iterator = jsonArray.iterator();
		JSONObject jsonObject = new JSONObject();

		String[] name = new String[jsonArray.size()];
		int index = 0;
		while (iterator.hasNext()) {
			jsonObject = (JSONObject) iterator.next();
			name[index] = (String) jsonObject.get("Zip");
			index++;
		}
		Arrays.sort(name);

		for (int i = 0; i < name.length; i++) {
			System.out.println(name[i]);
		}
		for (int i = 0; i < name.length; i++) {
			Iterator<?> iterator2 = jsonArray.iterator();
			JSONObject jsobject = new JSONObject();
			while (iterator2.hasNext()) {
				jsobject = (JSONObject) iterator2.next();
				if (name[i].equals(jsobject.get("Zip"))) {
					System.out.println(jsobject);
					System.out
							.println("-------------------------------------------------------------------------------------------------------------------------");
					break;
				}
			}
		}
	}
}
