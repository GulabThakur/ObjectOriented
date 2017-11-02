package com.bridgeitlabzs.utility;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

/**
 * @author GulabThakur
 * @author 
 *
 */
public class Utility {

	/**
	 * @author GulabThakur
	 * @param filePath
	 * @return array 
	 * for accept file path using for 
	 */
	public JSONArray jsonFileReader(String filePath)  {
		File file=new File(filePath);
		JSONArray jSonArray=null;
		try {
			FileReader fileReader=new FileReader(file);
			JSONParser jSonParser=new JSONParser();
			jSonArray=new JSONArray();
			jSonArray=(JSONArray) jSonParser.parse(fileReader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jSonArray;
	}

	/**
	 * @author GulabThakur
	 * @param filePath
	 * @param jsonArray
	 * @ using writing json file 
	 */
	public void jsonFileWriter(String filePath, JSONArray jsonArray) {
		FileWriter fileWriter=null;
		try {
			fileWriter=new FileWriter(filePath);
			fileWriter.write(JSONValue.toJSONString(jsonArray));
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param suits
	 * @param cards
	 * @return
	 */
	public static String[] Deck(String[] suits, String[] cards) {
      String[] deck = new String[suits.length * cards.length];
		
		for (int i = 0; i < cards.length; i++) 
		{
			for (int j = 0; j < suits.length; j++) 
			{
				deck[suits.length*i + j] = cards[i] + "=>" + suits[j];
			}
		}

		// shuffle
		for (int i = 0; i < deck.length; i++) 
		{
			int r = i + (int) (Math.random() * (deck.length-i));
			String temp = deck[r];
			deck[r] = deck[i];
			deck[i] = temp;
		}
		return deck;
	}

	/**
	 * @param deck
	 * this method is used for distribute cards
	 */
	public void distribute(String[] deck) {
		int indexOfDeck=0;
		String [][] deckOfcard=new String[4][9];
		for(int i=0; i<4; i++)
		{
			for(int j=0; j<9; j++)
			{
				deckOfcard[i][j]=deck[indexOfDeck];
				indexOfDeck++;
			}
		}
		for(int i=0; i<4; i++)
		{
			System.out.print("\nPlayer "+(i+1)+" : ");
			for(int j=0; j<9; j++)
			{
				System.out.print(deckOfcard[i][j]+", ");
			}
			System.out.print("\n----------------------------------------------------------------------------------------------------------------------");
		}
	}

}
