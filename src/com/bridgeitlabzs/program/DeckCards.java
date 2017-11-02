package com.bridgeitlabzs.program;

import java.util.LinkedList;
import java.util.Scanner;

import com.bridgeitlabzs.utility.Utility;

public class DeckCards {
	public static void main(String[] args) {
		Utility utility=new Utility();
		String[] suits={"Clubs","Diamonds","Hearts","Spades"};
		String [] cards={"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
		
		String[] deck=utility.Deck(suits, cards);
		LinkedList<String> linkedList=new LinkedList<String>();
		System.out.println("Deck OF Cards : ");
		System.out.println("_______________\n");
		for(int i=0; i<deck.length; i++)
		{
		      linkedList.add(deck[i]+" ");
		}
		System.out.println(linkedList);
		System.out.print("\n----------------------------------------------------------------------------------------------------------------------");
		utility.distribute(deck);
}

}
