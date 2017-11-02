package com.bridgeitlabzs.utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class CliniceManagment {
	   Scanner scanner=new Scanner(System.in);
	   Utility utility=new Utility();
		public void addDoctore(String filePath)
		{
			
			//Store data from user 
			System.out.println("Please Enter Specialization");
			String specilist=scanner.next();
			System.out.println("Enter the Doctore Name");
			String name=scanner.next();
			System.out.println("Doctore id ");
			int id=scanner.nextInt();
			System.out.println("Avilable ");
			int number=scanner.nextInt();
			//create json array
			JSONArray jsonarray=new JSONArray();
			jsonarray=utility.jsonFileReader(filePath);
			Iterator<?> iterator=jsonarray.iterator();
			JSONObject jsonObject=new JSONObject();
			//store the data into object
			jsonObject.put("DoctoreId", id);
			jsonObject.put("DoctoreName", name);
			jsonObject.put("Specilist", specilist);
			jsonObject.put("Avilable" ,number);
			//Store object into Json array
			jsonarray.add(jsonObject);
			
			//Write data into json file..
			utility.jsonFileWriter(filePath, jsonarray);
			
		}
		public void addPasente(String filePath)
		{
			//Store the data for 
			System.out.println("Please Enter the Name Of Patients");
			String name=scanner.next();
			System.out.println("Please Enter the age of Patients");
			int age=scanner.nextInt();
			System.out.println("Please Enter the Id of Patients");
			int id=scanner.nextInt();
			System.out.println("Please Enter the your Patients");
			String typeOfissue=scanner.next();
			long logEvent=System.currentTimeMillis();
			Date date = new Date(logEvent);
			DateFormat formatter = new SimpleDateFormat("HH:mm:ss:SSS");
			DateFormat dateInstance = SimpleDateFormat.getDateInstance();
			System.out.println(dateInstance.format(Calendar.getInstance().getTime()));

			String dateFormatted = formatter.format(date);
			System.out.println(dateFormatted);
		}
}
