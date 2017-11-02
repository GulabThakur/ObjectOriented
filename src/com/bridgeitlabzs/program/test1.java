package com.bridgeitlabzs.program;

import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.bridgeitlabzs.utility.Utility;

public class test1 {
	           public static void main(String[] args) {
			   String string="/home/brideit/Gulab Thakur/eclip/ObjectOriented/src/com/bridgeitlabzs/utility/managment.json"; 
			  test1.printData(string);
			   }
				/**
				 * @param filePath
				 * @author GulabThakur
				 */
	           public static void printData1(String filepath)
	           {
	        	   Utility utility=new Utility();
	        	   long totalValue=0,sum=0,sum1=0;
					JSONParser parse=new JSONParser();
					JSONArray joArray=new JSONArray();
					joArray=utility.jsonFileReader(filepath);
					JSONObject jsonObject=new JSONObject();
					Iterator<?> iterator=joArray.iterator(); 
					int i=0,j=0;
					while(iterator.hasNext())
					{
						jsonObject=(JSONObject) joArray.get(i);
						i++;
						JSONArray jsonArray=new JSONArray();
						Iterator<?> iratore1=jsonArray.iterator();
						while(iratore1.hasNext())
						{
							JSONObject obj=(JSONObject) jsonObject.get(jsonArray);
							String name=(String) obj.get("propertyname");
							System.out.println("Item_Name-->"+name);
						    Object price= obj.get("price");
						    int prices=Integer.parseInt(price.toString());
							System.out.println("Price-->"+prices);
							Object weight= obj.get("weight");
							int wieghts=Integer.parseInt(weight.toString());
							System.out.println("weight-->"+weight);
							System.out.println("Total value-->"+wieghts*prices);
							
						}
					}
	        	   
	           }
				/**
				 * @param filePath
				 * this method use for print data
				 */
				public static void printData(String filePath )
				{
					long totalValue=0,sum=0,sum1=0;
					JSONParser parse=new JSONParser();
					try {
						Object obj=parse.parse(new FileReader(filePath));
						JSONObject jsonObj=(JSONObject) obj;
						JSONArray obj1=(JSONArray) jsonObj.get("rice");
						JSONArray obj2=(JSONArray) jsonObj.get("wheate");
						JSONArray obj3=(JSONArray) jsonObj.get("pulse");
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
							sum=((long)weight*prices);
							sum1=sum1+sum;
							totalValue=totalValue+sum;
							System.out.println();
						}
						System.out.println("Total value is :"+sum1);
						System.out.println(">>>>>>>>>>><<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>.>>>>>>");
						System.out.println("Invendore of wheat");
						sum1=0;
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
							sum=((long)weight*prices);
							totalValue=totalValue+sum;
							sum1=sum1+sum;
							System.out.println();
						}
						System.out.println("Total value is :"+sum1);
						System.out.println(">>>>>>>>>>><<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>.>>>>>>");
						System.out.println("Invenver of pulse");
						sum1=0;
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
							sum=((long)weight*prices);
							totalValue=totalValue+sum;
							sum1=sum1+sum;
							System.out.println();
						}
						System.out.println("Total value is :"+sum1);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Grand Total value is :"+totalValue);
				System.out.println(">>>>>>>>>>><<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>.>>>>>>");
				}
	}


