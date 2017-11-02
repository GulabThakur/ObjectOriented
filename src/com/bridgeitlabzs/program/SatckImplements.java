package com.bridgeitlabzs.program;

import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;

import com.bridgeitlabzs.utility.Utility;

public class SatckImplements {
	Scanner scanner=new Scanner(System.in);
	Utility utility=new Utility();
	public static void main(String[] args) {
		System.out.println("Program Started ");
		String filePath="/home/brideit/Gulab Thakur/eclip/ObjectOriented/src/com/bridgeitlabzs/utility/share.json";
		//String string=
		System.out.println("Program Ended");
	}
	public void purchase(String filePath,int amount)
	{
		JSONArray jsonArray=new JSONArray();
		jsonArray=utility.jsonFileReader(filePath);
		Iterator<?> iterator=jsonArray.iterator();
	    System.out.println("Please Enter the number \n1: for #\n2: for $\n3:for @ ");
		int value =scanner.nextInt();
		
	}
	public void sale(String symbole,int amount)
	{
		
	}
}
