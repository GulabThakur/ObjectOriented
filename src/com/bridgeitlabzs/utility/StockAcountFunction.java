package com.bridgeitlabzs.utility;

import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class StockAcountFunction {
	Utility utility=new Utility();
	Scanner scanner=new Scanner(System.in);
	int count=0;
	/**
	 * @param filePath
	 * @return
	 * @this method we call for check the how many account holder in json file
	 */
	public int numberOfrecord(String filePath)
	{
		JSONArray jsonArray=new JSONArray();
		jsonArray=utility.jsonFileReader(filePath);
		Iterator<?> iterator=jsonArray.iterator();
		JSONObject jsonObject=new JSONObject();
		while(iterator.hasNext())
		{
			jsonObject=(JSONObject)iterator.next();
			count++;
		}
		return count;
		
	}
	/**
	 * @param filePath
	 * @return this method is using for show total detail of each account holder
	 */
	public void dispaly(String filePath)
	{
		JSONArray jsonArray=new JSONArray();
		jsonArray=utility.jsonFileReader(filePath);
		Iterator<?> iterator=jsonArray.iterator();
		JSONObject jsonObject=new JSONObject();
		
		while(iterator.hasNext())
		{
			jsonObject=(JSONObject)iterator.next();
			long share=(long) jsonObject.get("shares");
			long amount=(long) jsonObject.get("amount");
			String name=(String) jsonObject.get("name");
			System.out.println("Acount Holder Name "+name);
			System.out.println("Total Share "+share);
			System.out.println("Avilavel Amount "+amount);
			
		}
		
	}
	
	/**
	 * @param filePath
	 * @description this method we using for create new Account holder in json file
	 */
	public void createAccount(String filePath)
	{
		try{
			System.out.println("Enter your name : ");
			String name=scanner.nextLine();
			System.out.println("Enter the starting balance of account : ");
			long balance=scanner.nextLong();
			System.out.println("Enter number of shares : ");
			long shares=scanner.nextLong();

			JSONArray jsonArray=new JSONArray();
			jsonArray=utility.jsonFileReader(filePath);
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("name", name);
			jsonObject.put("amount", balance);
			jsonObject.put("shares", shares);
			jsonArray.add(jsonObject);

			utility.jsonFileWriter(filePath, jsonArray);
		}catch (ClassCastException e) {
			System.out.println("You have entered wrong key.");
		}
	}
	
	/**
	 * @param shareToSell
	 * @param symbol
	 * @Description This method will sell the shares of the company whose symbol is given by you.
	 */
	public void sell(long shareToSell, String symbol)
	{
		StockAcountFunction stockAccountFunctions=new StockAcountFunction();
		String filePathForStockAccount="/home/brideit/Gulab Thakur/eclip/ObjectOriented/src/com/bridgeitlabzs/utility/comercialData.json";
		String filePathForShareFile="/home/brideit/Gulab Thakur/eclip/ObjectOriented/src/com/bridgeitlabzs/utility/share.json";
		JSONArray jsonArray=new JSONArray();
		jsonArray=utility.jsonFileReader(filePathForShareFile);
		Iterator<?> iterator=jsonArray.iterator();
		JSONObject jsonObject=new JSONObject();
		boolean checktransaction=false;
		while(iterator.hasNext())
		{
			jsonObject=(JSONObject)iterator.next();
			if(symbol.equals((String)jsonObject.get("symbol")))
			{
				long totalShareInCompany=(long) jsonObject.get("share");
				long sharePrice=(long) jsonObject.get("price");
				boolean checkSell=stockAccountFunctions.isPersonAvailable(filePathForStockAccount, sharePrice, shareToSell);
				if(checkSell)
				{
					long finalShare=totalShareInCompany+shareToSell;
					jsonObject.put("share", finalShare);
					checktransaction=true;
					System.out.println("Your "+shareToSell+" shares has been selled.");
					break;
				}
				
			}
		}
		if(checktransaction)
		{
			utility.jsonFileWriter(filePathForShareFile, jsonArray);
		}
		else if(!checktransaction)
		{
			System.out.println("Your selling is not complete.");
		}
	}
	
	/**
	 * @param filePath
	 * @param shareValue
	 * @param sharePrice
	 * @param shareToSell
	 * @return it will return true if sell is success full otherwise it will return false.
	 */
	boolean isPersonAvailable(String filePath, long sharePrice, long shareToSell)
	{
		JSONArray jsonArray=new JSONArray();
		jsonArray=utility.jsonFileReader(filePath);
		Iterator<?> iterator=jsonArray.iterator();
		JSONObject jsonObject=new JSONObject();
		System.out.println("Enter your name : ");
		String name=scanner.nextLine();
		boolean checkPerson=false;
		boolean checkSell=false;
		while(iterator.hasNext())
		{
			jsonObject=(JSONObject)iterator.next();
			if(name.equalsIgnoreCase((String) jsonObject.get("name")))
			{
				checkPerson=true;
				long share=(long) jsonObject.get("shares");
				if(share>=shareToSell)
				{
					long finalShare=share-shareToSell;
					// tomroww this on echeck;
					long amount=sharePrice*shareToSell;
					long finalAmount=amount+(long)jsonObject.get("amount");
					jsonObject.put("shares", finalShare);
					jsonObject.put("amount", finalAmount);
					checkSell=true;
					break;
				}
				else
				{
					System.out.println("You doesn't have "+shareToSell+" shares to sell.");
				}
			}
		}
		if(checkPerson)
		{
			utility.jsonFileWriter(filePath, jsonArray);
		}
		else if(!checkPerson)
		{
			System.out.println(name+" you doesn't have account, please first create account.");
		}
		return checkSell;
	}
	
	/**
	 * @param amount
	 * @param symbol
	 * 
	 * @Description this method will buy the shares of company by the symbol of an company which is given by you.
	 */
	public void buy(long shareToBuy, String symbol)
	{
		StockAcountFunction stockAccountFunctions=new StockAcountFunction();
		String filePathForStockAccount="/home/brideit/Gulab Thakur/eclip/ObjectOriented/src/com/bridgeitlabzs/utility/comercialData.json";
		String filePathForShareFile="/home/brideit/Gulab Thakur/eclip/ObjectOriented/src/com/bridgeitlabzs/utility/share.json";
		JSONArray jsonArray=new JSONArray();
		jsonArray=utility.jsonFileReader(filePathForShareFile);
		Iterator<?> iterator=jsonArray.iterator();
		JSONObject jsonObject=new JSONObject();
		boolean checktransaction=false;
		boolean check=false;
		while(iterator.hasNext())
		{
			jsonObject=(JSONObject) iterator.next();
			if(symbol.equals((String)jsonObject.get("symbol")))
			{
				
				long totalShareOfCompany=(long)jsonObject.get("share");
				long sharePrice=(long) jsonObject.get("price");
				check=stockAccountFunctions.isPersonAvailable2(filePathForStockAccount, sharePrice, shareToBuy, totalShareOfCompany);
				if(check)
				{
					long finalshare=(long)jsonObject.get("share")-shareToBuy;
					jsonObject.put("share", finalshare);
					System.out.println("Share has been bought.");
					checktransaction=true;
					break;
				}
			}
		}
		if(!checktransaction)
		{
			System.out.println("Your buying is not done.");
		}
		else if(check)
		{
			utility.jsonFileWriter(filePathForShareFile, jsonArray);
		}
	}
	
	private boolean isPersonAvailable2(String filePath, long sharePrice, long shareToBuy, long totalShareOfCompany)
	{
		long amount1=sharePrice*shareToBuy;
		JSONArray jsonArray=new JSONArray();
		jsonArray=utility.jsonFileReader(filePath);
		Iterator<?> iterator=jsonArray.iterator();
		JSONObject jsonObject=new JSONObject();
		System.out.println("Enter your name : ");
		String name=scanner.nextLine();
		boolean checkPerson=false;
		boolean checkBuy=false;
		while(iterator.hasNext())
		{
			jsonObject=(JSONObject)iterator.next();
			if(name.equalsIgnoreCase((String) jsonObject.get("name")))
			{
				checkPerson=true;
				long share=(long) jsonObject.get("shares");
				long totalAmountOfPerson=(long)jsonObject.get("amount");
				if(share>=shareToBuy && totalAmountOfPerson>=amount1)
				{
					long finalShare=share+shareToBuy;
					
					long finalAmount=(long)jsonObject.get("amount")-amount1;
					jsonObject.put("shares", finalShare);
					jsonObject.put("amount", finalAmount);
					checkBuy=true;
					break;
				}
				else
				{
					System.out.println("You doesn't have "+shareToBuy+" shares to sell.");
				}
			}
		}
		if(checkBuy)
		{
			utility.jsonFileWriter(filePath, jsonArray);
		}
		else if(!checkPerson)
		{
			System.out.println(name+" you doesn't have account, please first create account.");
		}
		return checkBuy;
	}
	
}
