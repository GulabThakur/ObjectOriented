package com.bridgeitlabzs.program;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class InventoryManagmentProgram {
		public static void main(String[] args) {
			int share1,price,value;
			JSONParser parse=new JSONParser();
		    try {
				Object object=parse.parse(new FileReader("/home/brideit/Gulab Thakur/eclip/ObjectOriented/src/com/bridgeitlabzs/utility/InventoryMang.json"));
				JSONObject jsonObject=(JSONObject) object;
				JSONArray jsonArray=(JSONArray) jsonObject.get("company");
			for(int i=0;i<jsonArray.size();i++)
			{
				JSONObject jsonObject2=(JSONObject) jsonArray.get(i);
				String name=(String) jsonObject2.get("companyName");
				//System.out.println(name);
				Object share=  jsonObject2.get("share");
				share1=Integer.parseInt(share.toString());
				//System.out.println(share1);
				Object price1=  jsonObject2.get("price");
				price=Integer.parseInt(price1.toString());
				//System.out.println(price);
				value=(price*share1);
				System.out.println(">>>>>>>>>>>>>Company Name "+name+"<<<<<<<<<<<<<<<<<<");
				System.out.println("<<<<<<<<<<<<<<<<<Detail is>>>>>>>>>>>>>>>>>>>>>>>>>>");
				System.out.println("Comapny Share is "+share1);
				System.out.println("Company Share Price is "+price);
				System.out.println("Comapnty Total Value of Share is "+value);
				System.out.println("<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<>>>>>>>");
			}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
