package com.bridgeitlabzs.program;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DataMangment {
			public static void main(String[] args) {
				JSONParser parse=new JSONParser();
				long totalValue=0;
				try {
					Object obj=parse.parse(new FileReader("/home/brideit/Gulab Thakur/eclip/ObjectOriented/src/com/bridgeitlabzs/utility/managment.json"));
					JSONObject jsonObj=(JSONObject) obj;
					JSONArray obj1=(JSONArray) jsonObj.get("rice");
					JSONArray obj2=(JSONArray) jsonObj.get("wheate");
					JSONArray obj3=(JSONArray) jsonObj.get("pulse");
					//System.out.println(obj1);
					//System.out.println(obj2);
					//System.out.println(obj3);
					System.out.println("print rice invendore ");
					for(int i=0;i<obj1.size();i++) 
					{
						JSONObject jObj=(JSONObject) obj1.get(i);
						String name=(String) jObj.get("propertyname");
						System.out.println("Item_Name-->"+name);
					    Object price= jObj.get("price");
					    int prices=Integer.parseInt(price.toString());
						System.out.println("Price-->"+prices);
						Object weight= jObj.get("weight");
						int wieghts=Integer.parseInt(weight.toString());
						System.out.println("weight-->"+weight);
						System.out.println("Total value-->"+wieghts*prices);
						totalValue+=totalValue+((long)weight*prices);
						
						System.out.println();
					}
					System.out.println("Total value is :"+totalValue);
					System.out.println("Invendore of wheat");
					for(int i=0;i<obj2.size();i++) 
					{
						JSONObject jObj=(JSONObject) obj2.get(i);
						String name=(String) jObj.get("propertyname");
						System.out.println("Item_Name-->"+name);
					    Object price= jObj.get("price");
					    int prices=Integer.parseInt(price.toString());
						System.out.println("Price-->"+prices);
						Object weight= jObj.get("weight");
						int wieghts=Integer.parseInt(weight.toString());
						System.out.println("weight-->"+weight);
						System.out.println("Total value-->"+wieghts*prices);
						//totalValue+=(long)weight*prices;
						System.out.println();
					}
					//System.out.println("Total value is :"+totalValue);
					System.out.println("Invenver of pulse");
					for(int i=0;i<obj3.size();i++) 
					{
						JSONObject jObj=(JSONObject) obj3.get(i);
						String name=(String) jObj.get("propertyname");
						System.out.println("Item_Name-->"+name);
					    Object price= jObj.get("price");
					    int prices=Integer.parseInt(price.toString());
						System.out.println("Price-->"+prices);
						Object weight= jObj.get("weight");
						int wieghts=Integer.parseInt(weight.toString());
						System.out.println("weight-->"+weight);
						System.out.println("Total value-->"+wieghts*prices);
					//	totalValue+=totalValue+((long)weight*prices);
						System.out.println();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Total value is :"+totalValue);
				
			}
}
