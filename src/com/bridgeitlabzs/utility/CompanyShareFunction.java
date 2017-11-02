package com.bridgeitlabzs.utility;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class CompanyShareFunction {
	Utility utility=new Utility();
	Scanner scanner=new Scanner(System.in);
	/**
	 * @param filePath
	 * 
	 * @Description it will display all companies shares which is available in file.
	 */
	public void displayShares(String filePath)
	{
		JSONArray jsonArray=new JSONArray();
		jsonArray=utility.jsonFileReader(filePath);
		Iterator<?> iterator=jsonArray.iterator();
		JSONObject jsonObject=new JSONObject();
		LinkedList linkedList=new LinkedList();
		while(iterator.hasNext())
		{
			jsonObject=(JSONObject) iterator.next();
			String companyName=(String) jsonObject.get("company");
			linkedList.add(companyName);
			long share= (long) jsonObject.get("share");
			linkedList.add(share);
		}
		System.out.print("Companies shares => ");
		for(int i=0; i<linkedList.size(); i++)
		{
			System.out.print(linkedList.get(i)+" : "+linkedList.get(i+1)+", ");
			i++;
		}
		System.out.println("\n---------------------------------------------------------------------------");
	}
	
	public void addShares(String filePath)
	{
		JSONArray jsonArray=new JSONArray();
		jsonArray=utility.jsonFileReader(filePath);
		Iterator<?> iterator=jsonArray.iterator();
		JSONObject jsonObject=new JSONObject();
		boolean check=true;
		System.out.println("Enter the company name : ");
		String companyName=scanner.nextLine();
		System.out.println("Enter the number of shares to add : ");
		long numberOfShare=scanner.nextLong();
		
		while(iterator.hasNext())
		{
			jsonObject=(JSONObject) iterator.next();
			if(companyName.equalsIgnoreCase((String) jsonObject.get("company")))
			{
				long finalShares=(numberOfShare+(long) jsonObject.get("share"));
				jsonObject.put("share", finalShares);
				System.out.println(numberOfShare+" shares added.");
				check=false;
			}
		}
		if(!check)
		{
			utility.jsonFileWriter(filePath, jsonArray);
		}
		else if(check)
		{
			System.out.println(companyName+" Company not found.");
		}
		System.out.println("\n---------------------------------------------------------------------------");
	}
	
	
	public void removeShare(String filePath)
	{
		JSONArray jsonArray=new JSONArray();
		jsonArray=utility.jsonFileReader(filePath);
		Iterator<?> iterator=jsonArray.iterator();
		JSONObject jsonObject=new JSONObject();
		boolean check=true;
		System.out.println("Enter the company name : ");
		String companyName=scanner.nextLine();
		System.out.println("Enter the number of shares to remove : ");
		long numberOfShare=scanner.nextLong();
		
		while(iterator.hasNext())
		{
			jsonObject=(JSONObject) iterator.next();
			if(companyName.equalsIgnoreCase((String) jsonObject.get("company")))
			{
				long finalShares=((long) jsonObject.get("share")-numberOfShare);
				jsonObject.put("share", finalShares);
				System.out.println(numberOfShare+" shares removed.");
				check=false;
			}
		}
		if(!check)
		{
			utility.jsonFileWriter(filePath, jsonArray);
		}
		else if(check)
		{
			System.out.println(companyName+" Company not found.");
		}
		System.out.println("\n---------------------------------------------------------------------------");
	}
}
