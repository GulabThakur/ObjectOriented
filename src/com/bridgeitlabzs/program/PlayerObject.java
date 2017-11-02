package com.bridgeitlabzs.program;

import java.util.Collections;

import com.bridgeitlabzs.utility.LinkedList;
import com.bridgeitlabzs.utility.Queue;
import com.bridgeitlabzs.utility.Utility;

public class PlayerObject {
	public static void main(String[] args) {
		Utility utility=new Utility();
		String[] suits={"Clubs","Diamonds","Hearts","Spades"};
		String [] cards={"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
		
		String[] deck=utility.Deck(suits, cards);
		Queue<String> queue=new Queue<String>();
		int indexOfDeck=0;
		for(int i=0; i<4; i++)
		{
			//LinkedList<String> linkList=new LinkedList<String>();
			java.util.LinkedList<String> list2=new java.util.LinkedList<>();
			for(int j=0; j<9; j++)
			{
				//linkList.add(deck[indexOfDeck]);
				list2.add(deck[indexOfDeck]);
				indexOfDeck++;
			}
			//queue.enqueue(linkList);
			//System.out.println(linkList);
		    //System.out.println(list2);
			Collections.sort(list2);
			queue.enqueue(list2);
		}
		System.out.println("-------------------------------------------");
		queue.getelement();
}
}
