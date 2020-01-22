import java.io.*;
/*
 * This application instantiates a hangman object to play the game.
 * @author Matthew Golden
 * @version 1.0
 * Programming Project 1- Hangman_MDG
 * Spring/2020
 */
public class HangmanApplication {

	public static void main(String[] args) throws IOException   
	{
		// TODO Auto-generated method stub

		Hangman hang = new Hangman();
		hang.playGame();
	}//end main method
}//end class
