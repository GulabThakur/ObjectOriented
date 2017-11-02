package com.bridgeitlabzs.program;

import java.io.FileReader;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CommercialProgram {
	public static void main(String[] args) throws Exception {
		System.out.println("Program Started");
		JSONParser parse=new JSONParser();
		Object obj =parse.parse(new FileReader("/home/brideit/Gulab Thakur/eclip/ObjectOriented/src/com/bridgeitlabzs/utility/comercialData.json"));
		
		CommercialProgram.createData(obj);
		System.out.println("Program Ended");
	}
	public static void createData(Object object)
	{  
		boolean status=false;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Plese Enter the Name ");
		String stringName=scanner.next();
		JSONObject objJsonObject=(JSONObject) object;
		JSONArray jsonArray=(JSONArray) objJsonObject.get("stockAccount");
		for(int i=0;i<jsonArray.size();i++)
		{
			JSONObject jsonObject2=(JSONObject) jsonArray.get(i);
			String name= (String) jsonObject2.get("CustomerName");
			System.out.println(name);
			if(name.equalsIgnoreCase(stringName))
			{
				System.out.println("name already exsist......");
				status=false;
				break;
			}
			else
			{
				status =true;
			}
			
		}
		if(status)
		{
			System.out.println("Please Enter the Share ");
			JSONArray array=new JSONArray();
			JSONObject obj=new JSONObject();
			obj.put("CustomerName", stringName);
			int share=scanner.nextInt();
			obj.put("share", Integer.valueOf(share));
			System.out.println("Please Enter the price");
			int price=scanner.nextInt();
			obj.put("Price",  Integer.valueOf(price));
			array.add(obj);
			System.out.println(obj);
		}
	
	}
	public void buy(String symbol,int price)
	{
		
		
	}
	public void sale(String symbol)
	{
		
	}
	public void save()
	{
		
	}
    public void display()
    {
    	
    }
}
