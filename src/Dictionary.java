import java.security.SecureRandom;
import java.util.Scanner;
import java.io.*;
/*
 * Dictionary has a string array that is filled after the file "HangmanDictionary.txt" is scanned
 and then selects a word at random from the array.
 * @author Matthew Golden
 * @version 1.0
 * Programming Project 1- Hangman_MDG
 * Spring/2020
 */
public class Dictionary {

	private String[] wordList = new String[213]; //List of words that will be filled from "HangmanDictionary.txt"
	private SecureRandom randomNumbers = new SecureRandom();
	
	/**
	 * Empty-argument constructor - calls the readFile method.
	 * @throws IOException 
	 */
	public Dictionary() throws IOException
	{
		readFile();
	}//end constructor
	
	/**
	 * Reads file "HangmanDictionary.txt" and fills up the wordList array with words from this file.
	 * @throws IOException
	 */
	private void readFile() throws IOException
	{
		Scanner fileScan = new Scanner(new File("HangmanDictionary.txt"));
		for(int i = 0; i < 212; i++)
		{
			wordList[i] = fileScan.next();
		}
	}//end readFile
	
	/**
	 * Randomly chooses a word from the array and returns it.
	 * @return Random word chosen from wordList
	 * @throws IOException
	 */
	public String chooseWord() throws IOException 
	{
		int i = randomNumbers.nextInt(212);
		return wordList[i];
		
	}//end chooseWord
}//end class
