package com.bridgeitlabzs.program;

import java.util.Scanner;

public class StockReport {
	  static int number=0;
	  public static void main(String[] args) {
		System.out.println("Program Started ");
		Scanner scanner=new Scanner(System.in);
		System.out.println("Please Enter the number of Stock store");
		
		try {
		 number=scanner.nextInt();
		} catch (Exception e) {
			System.out.println("Please enter the Number ");
		}
		String name[]=new String[number];
		int shar[]=new int[number];
		int price[] =new int[number];
		System.out.println(">...................................................<");
		for(int i=0;i<number;i++) 
		{
			System.out.println("Please Enter the name");
			try {
				name[i]=scanner.next();
			} catch (Exception e) {
			 System.out.println("Please Enter the name ");
			}
			System.out.println("Please Enter the share");
			try {
				shar[i]=scanner.nextInt();
			} catch (Exception e) {
				System.out.println("Please enter the number");
			}
			System.out.println("Please Enter the price per share");
			try {
				price[i]=scanner.nextInt();
			} catch (Exception e) {
				System.out.println("Please Enter the number");
			}
			System.out.println("Store the sucessfully ");
		}
		System.out.println(">...................................................<");
		System.out.println(">............Detail of Candidte is .................<");
		StockReport.printDetail(name, shar, price);
		System.out.println(">............Total stock is ........................<");
		StockReport.calculation(shar, price);
		System.out.println("Program Ended ");
	}
  public static void printDetail(String name[],int shar[],int price[]) 
	{ 
	    int value=0; 
		for(int i=0;i<name.length;i++) 
		{
			value=shar[i]*price[i];
			System.out.println((i+1)+" ->Candidate Name :"+name[i]);
			System.out.println("Total share :"+shar[i]);
			System.out.println("Price of share :"+price[i]);
			System.out.println("Total value is:"+value);
		}
	}
  public static void calculation(int shar[],int price[]) 
  {  
	  int totalvalue=0,count=0;
	  for(int i=0;i<number;i++)
	  {  
		  count=totalvalue;
		  totalvalue=shar[i]*price[i];
		  count+=count+totalvalue;
		 
	  }
	  System.out.println("Total stock is "+count);
  }
}
