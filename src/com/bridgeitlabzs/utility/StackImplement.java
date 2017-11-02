package com.bridgeitlabzs.utility;

import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * @author GulabThakur
 *
 */
public class StackImplement {
	Utility utility=new Utility();
	Scanner scanner=new Scanner(System.in);
	/**
	 * @param shareToSell
	 * @param symbol
	 * For sale 
	 */
	public void sell(long shareToSell, String symbol)
	{
		StockAcountFunction stockAccountFunctions=new StockAcountFunction();
		String filePathForStockAccount="/home/brideit/Gulab Thakur/eclip/ObjectOriented/src/com/bridgeitlabzs/utility/comercialData.json";
		String filePathForShareFile="/home/brideit/Gulab Thakur/eclip/ObjectOriented/src/com/bridgeitlabzs/utility/stockSymbol.json";
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
	 * @param sharePrice
	 * @param shareToSell
	 * @return
	 */
	private boolean isPersonAvailable(String filePath, long sharePrice, long shareToSell)
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
					long amount=sharePrice*(long)jsonObject.get("amount");
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

}
