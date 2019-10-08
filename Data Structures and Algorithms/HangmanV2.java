/*
 * Name: Tyler Cromack 
 * Course Number: CSC-220  
 * Course Name: Data Structures
 * Problem Number: Hangman Game
 * 
 * This program will take a user's input then play a game of hangman in order to guess the word.
 */

import java.util.Scanner;

public class HangmanV2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Welcome to HangMan V2.0!");
		System.out.println("Enter the phrase to be used:");
		
		String phrase = input.nextLine();
		phrase = phrase.trim();
		phrase = phrase.replaceAll(" ", "  ");
		phrase = phrase.toUpperCase();
		String hiddenPhrase = phrase.replaceAll("[A-Z]", "_ "); // replace the letters with an underscore and a space
		String guess;
		String guessed = "";
		char letter;
		int incorrect = 0;
		boolean guessedHasGuess;
		boolean phraseHasGuess;

		System.out.println("Okay, let's play! You have 5 tries to guess the phrase.");

		while (incorrect < 5 && hiddenPhrase.contains("_")) {

			System.out.println(hiddenPhrase);
			System.out.print("\nYou have " + incorrect + " incorrect guesses so far.\n");
			
			if (incorrect == 1) {
				System.out.println("____________");
				System.out.println("      |     ");
				System.out.println("      O     ");
				System.out.println("            ");
				System.out.println("            ");
				System.out.println("            ");
				System.out.print("\n");
			} else if (incorrect == 2) {
				System.out.println("____________");
				System.out.println("      |     ");
				System.out.println("      O     ");
				System.out.println("      |     ");
				System.out.println("            ");
				System.out.println("            ");
				System.out.print("\n");
			} else if (incorrect == 3) {
				System.out.println("____________");
				System.out.println("      |     ");
				System.out.println("      O     ");
				System.out.println("     -|-    ");
				System.out.println("            ");
				System.out.println("            ");
				System.out.print("\n");
			} else if (incorrect == 4) {
				System.out.println("____________");
				System.out.println("      |     ");
				System.out.println("      O     ");
				System.out.println("     -|-    ");
				System.out.println("      |     ");
				System.out.println("            ");
				System.out.print("\n");
			}

			System.out.println("Guess a letter:");
			guess = input.nextLine();
			guess = guess.toUpperCase(); // make guess uppercase in order to compare characters
			letter = guess.charAt(0); // take the first letter as guessed letter

			guessedHasGuess = (guessed.indexOf(letter)) != -1;
			guessed += letter; // stores every letter guessed
			System.out.print("\n");
			if (guessedHasGuess == true) { // if statement begins
				System.out.println("You guessed " + letter + " already.\n");
				if (incorrect > 0) {
					incorrect--;
				}

			}

			if (phraseHasGuess = (phrase.indexOf(letter)) != -1) {
				System.out.println(letter + " is in the phrase.\n");
				for (int i = 0; i < phrase.length(); i++) {
					if (phrase.charAt(i) == letter && hiddenPhrase.charAt(i) != letter) {

						hiddenPhrase = hiddenPhrase.replaceAll("_ ", "_");
						hiddenPhrase = hiddenPhrase.substring(0, i) + letter + hiddenPhrase.substring(i + 1);
					}

				}

				hiddenPhrase = hiddenPhrase.replaceAll("_", "_ "); // replace unguessed letters with a space after them

			} else {
				System.out.println(letter + " is in not the phrase.\n"); //It must be incorrect
				incorrect++;
			}

		}

		if (incorrect == 5) {
			System.out.println("___________");
			System.out.println("     |     ");
			System.out.println("     O     ");
			System.out.println("    -|-    ");
			System.out.println("     |     ");
			System.out.println("    / \\    ");
			System.out.print("\nGame Over, too many guesses. The phrase is: " + phrase);
		} else {
			System.out.println("The phrase is: " + phrase + "\nCongratulations, you win!"); //It must be solved if not incorrect
		}

		input.close();
	}

}