import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
/*
 * Hangman instantiates a dictionary object to choose a word. It also load and writes a win/loss record off a file,
 also has playGame method which is the game itself.
 * @author Matthew Golden
 * @version 1.0
 * Programming Project 1- Hangman_MDG
 * Spring/2020
 */
public class Hangman {
	
	private int roundWins = 0;//Amount of wins in a round
	private int roundLosses = 0;//Amount of losses in a round
	private int W;//Single win count after each game to add to total win/loss file
	private int L;//Single loss count after each game to add to total win/loss file
	
	private String currentWord;//Value of random word chosen from dictionary
	private Dictionary dict = new Dictionary();//Dictionary object used to select word
	
	/**
	 * Instantiates the Dictionary object from which you can choose words for
	 your game.
	 * @throws IOException
	 */
	public Hangman() throws IOException 
	{
		currentWord = dict.chooseWord();
	}//end constructor
	
	/**
	 * Loads the win/loss record from a file
	 * @throws IOException
	 */
	private void loadWL() throws IOException 
	{
		Scanner fileScan = new Scanner(new File("WL.txt"));
		while (fileScan.hasNextInt()) 
		{
			int win = fileScan.nextInt();
			int loss = fileScan.nextInt();
			System.out.println("All time number of wins: " + win + " All time number of losses: " + loss);
		}
	}//end loadWL

	/** 
	 * Writes the total win/loss record to a file.
	 * @throws IOException
	 */
	private void writeWL() throws IOException 
	{	
		Scanner fileScan = new Scanner(new File("WL.txt"));
		
		int win = fileScan.nextInt();
		int loss = fileScan.nextInt();
		int totalWin = win + W;
		int totalLoss = loss + L;
		
		FileWriter wr = new FileWriter("WL.txt", false);
		wr.write(" " + totalWin + " " + totalLoss);
		wr.close();
	}//end writeWL
	
	/**
	 * Implements the main game loop for the game.
	 * @throws IOException
	 */
	public void playGame() throws IOException 
	{
		int guesses = 5;
		ArrayList<Character> word = new ArrayList<Character>();
		for(int j = 0; j < currentWord.length(); j++)
			word.add('_');
		Scanner scan = new Scanner(System.in);
		System.out.println("\tWould You Like to Play Hangman Y/N?");
		char chr = scan.next().charAt(0);
		
		while(chr == 'Y' || chr == 'y') //Loop for the game
		{
			W = 0;
			L = 0;
			System.out.println("\nYou have " + guesses + " incorrect guesses left.");
			if (guesses > 0) 
			{
				for(int i = 0; i < word.size(); i++) 
				{
					System.out.print(word.get(i) + " ");
				}
				System.out.print("\nWhat is your guess? ");
				String guessWord = scan.next();
				if (guessWord.equals(currentWord)) 
				{
					roundWins++;
					W++;
					System.out.println("\nYou guessed the correct word! You won!");
					System.out.println("You have won " + roundWins + " times this round. You have lost " + roundLosses + " times this round.");
					writeWL();
					loadWL();
					System.out.println("\n\tWould You Like to Play Again? Y/N?");
					chr = scan.next().charAt(0);
					currentWord = dict.chooseWord();
					word.clear();
					for(int i = 0; i < currentWord.length(); i++)
						word.add('_');
					guesses = 5;
				}
				else
				{
					char guess = guessWord.charAt(0);
					int g = 0;
					for(int k = 0; k < currentWord.length(); k++) 
					{
						if (guess == currentWord.charAt(k)) 
						{
							word.set(k, guess);
							g++;
						}
					}
					if(g == 0)
					{
						guesses --;
					}
					String wordCheck = "";
					for (Character i : word) 
					{
						wordCheck += i;
					}
					if (wordCheck.equals(currentWord)) 
					{
						System.out.println("\n" + currentWord);
						roundWins++;
						W++;
						System.out.println("\nYou won!");
						System.out.println("You have won " + roundWins + " times this round. You have lost " + roundLosses + " times this round.");
						writeWL();
						loadWL();
						System.out.println("\n\tWould You Like to Play Again? Y/N?");
						chr = scan.next().charAt(0);
						currentWord = dict.chooseWord();
						word.clear();
						for(int l = 0; l < currentWord.length(); l++)
							word.add('_');
						guesses = 5;
					}
				}
			}
			else {
				roundLosses++;
				L++;
				System.out.println("\nYou are out of guesses. You lost.\nThe word was " + currentWord);
				System.out.println("You have won " + roundWins + " times this round. You have lost " + roundLosses + " times this round.");
				writeWL();
				loadWL();
				System.out.println("\n\tWould You Like to Play Again? Y/N?");
				chr = scan.next().charAt(0);
				currentWord = dict.chooseWord();
				word.clear();
				for(int l = 0; l < currentWord.length(); l++)
					word.add('_');
				guesses = 5;
			
			}
		}
		if(chr != 'Y' || chr != 'y')
		{
			System.out.println("\n\t<<END>>");
			
		}
	}//playGame
}//end class
