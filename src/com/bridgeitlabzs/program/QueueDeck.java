package com.bridgeitlabzs.program;

import java.util.LinkedList;
import java.util.Queue;

import com.bridgeitlabzs.utility.Utility;

public class QueueDeck {
	public static void main(String[] args) {
		LinkedList<String> linkedList=new LinkedList<>();
		Utility utility=new Utility();
		String[] suits={"Clubs","Diamonds","Hearts","Spades"};
		String [] cards={"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
		com.bridgeitlabzs.utility.Queue<String> queue=new com.bridgeitlabzs.utility.Queue<>();
		String[] deck=utility.Deck(suits, cards);
		System.out.println("Deck OF Cards : ");
		System.out.println(">>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<n");
		System.out.print("\n----------------------------------------------------------------------------------------------------------------------");
		utility.distribute(deck);
}

}
