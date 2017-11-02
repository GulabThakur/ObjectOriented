package com.bridgeitlabzs.program;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {
	public static void main(String[] args) {
		System.out.println("Program Started");
		String fname=null;
		String name = null;
		String fullname[] = null;String number;
		try {
			BufferedReader bu=new BufferedReader(new FileReader("/home/brideit/Gulab Thakur/eclip/ObjectOriented/src/com/bridgeitlabzs/utility/message.txt"));
			String sms=bu.readLine();
			Scanner scanner=new Scanner(System.in);
			String forName="[A-Za-z]*\\s[a-zA-Z]*\\s[a-zA-Z]*";
			System.out.println("Please Enter the Full name ");
			name=scanner.nextLine();
			
				if(name.matches(forName))
				{
					fullname=name.split(" ");
					fname=fullname[0];
					System.out.println("Please Enter the number phone number ");
					String expresion="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";
					number=scanner.next();
					CharSequence input=number;
					Pattern pattern=Pattern.compile(expresion);
					Matcher matcher=pattern.matcher(input);
					if(matcher.matches()) 
					{
						String message=sms.replaceAll("<<name>>", fname);
						message=message.replaceAll("<<full name>>",name );
						message=message.replaceAll("91-xxxxxxxxxx.", number);
						
						Date date1=Calendar.getInstance().getTime();
						SimpleDateFormat date=new SimpleDateFormat("dd/MM/yyyy"); 
						String sdate=date.format(date1);
						message=message.replaceAll("01/01/2016", sdate);
						System.out.println(message);
					}
					else 
					{
						System.out.println("Please Enter the right number");
					}
				}
				else 
				{
					System.out.println("Please Enter the  name ");
				}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Program Ended");
	}
}
