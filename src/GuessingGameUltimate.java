//Filename GuessingGameUltimate.java
//Licensed under GNU GPL v3
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.util.Random;
public class GuessingGameUltimate {
	public static void main(String[] args) {
		int willUserPlayAgainInteger = 0; //Will the user play again?
		boolean willUserPlayAgainBoolean = true; 
	while (willUserPlayAgainBoolean == true) {
		String title = "Guessing Game Ultimate"; //The title for the program
		String[] gameOptions = new String[] {"Integer", "Character", "Decimal"}; //Array of gamemode options
		String[] characterOptions = new String[] {"Single Case", "Double Case"}; //Array of character mode gamemode options
		int userDifficultyLevel = JOptionPane.showOptionDialog(null, "Pick a game mode!\nInteger: Only integer values! [Easy]\nCharacter: A letter of the alphabet! [Normal]\nDecimal: The answer can include decimal places! [Extreme]",
				title, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
				gameOptions, gameOptions[1]);
		String userDifficultyOptionString = null; //User's second gamemode option as a string
		int userDifficultyOptionInteger = 0; //User's second gamemode option as an integer
		String numberGuessString = null; //The user's guess as a string
		int numberGuessInteger = 0; //The user's guess as an integer
		double numberGuessDecimal = 0.00; //The user's guess as a double
		boolean isGameOptionAcceptable = false; //Whether or not the user's game option can be used
		boolean isResponseAcceptable = false; //Whether or not the user's guess can be used
		int randomizedInteger = 0; //Randomized integer
		double randomizedDecimal = 0.00; //Randomized decimal
		double randomizedDecimalWithSpecificPlaces = 0.00; //Randomized decimal with correct decimal places
		char userInputCharacter = 0; //The user's guess for a letter
		boolean isGuessCorrect = false; //Whether or not the user guessed correct
		int decimalPlaces = 0; //Number of decimal places for decimal mode as an integer
		char randomizedCharacter = (char) 0; //Randomizes a character
		//userDifficultyLevel will be 0 for integer, 1 for character, and 2 for decimal
		/** Code for Integer game mode */
		if (userDifficultyLevel == 0) {
			while (isGameOptionAcceptable == false) {
				userDifficultyOptionString = JOptionPane.showInputDialog(null, "What difficulty do you want?\nPlease enter an integer from 5 to 100 for best results.\nDo not enter a number less than or equal to zero.\nThis number specifies the maximum possible value.\nFor example, 9 will make numbers from 1 to 9 possible.\n100 will make 1 to 100 possible.\nEven 2158564218 can be used, but it's not suggested.",
						title, JOptionPane.QUESTION_MESSAGE); //Prompts user for a gamemode type
				userDifficultyOptionInteger = Integer.parseInt(userDifficultyOptionString); //Parses the gamemode string to an integer
				isGameOptionAcceptable = (userDifficultyOptionInteger > 0); //Checks to see if user inputted a positive value
				if (isGameOptionAcceptable == false) {
					JOptionPane.showMessageDialog(null, "What are you, stupid? You input " + userDifficultyOptionInteger + ".\nThat's a negative number you moron!\nPick another number!", title, JOptionPane.ERROR_MESSAGE);
				}
				else if (isGameOptionAcceptable == true) {
					break;
				}
			}
		//Continuation of Integer Game Mode code
		randomizedInteger = 1 + (int) (Math.random() * userDifficultyOptionInteger); //Randomizes an integer
		while (isResponseAcceptable == false) {
			numberGuessString = JOptionPane.showInputDialog(null, "Input a number from 1 to " + userDifficultyOptionInteger, title, JOptionPane.QUESTION_MESSAGE);
			numberGuessInteger = Integer.parseInt(numberGuessString); //Parses the user's guess
			isResponseAcceptable = (numberGuessInteger >= 1 && numberGuessInteger <= userDifficultyOptionInteger); //Checks to see if the response is between 1 and the user's difficulty
			if (isResponseAcceptable == false) {
				JOptionPane.showMessageDialog(null, "What are you, stupid?\nYou input " + numberGuessInteger + "!\nThat is not in between 1 and " + userDifficultyOptionInteger + "!\n Try again!",
						title, JOptionPane.ERROR_MESSAGE);
			}
			else if (isResponseAcceptable == true) {
				break;
			}
		}
		
		isGuessCorrect = (numberGuessInteger == randomizedInteger); //Compares the user's guess to the random integer
		if (isGuessCorrect == true) {
			JOptionPane.showMessageDialog(null, "Great job!\nYou guessed " + numberGuessInteger + ", which is correct!\nAs a reward, \"Rocket Man\" Kim Jung Un will\nnot fire a nuke at the United States!",
					title, JOptionPane.INFORMATION_MESSAGE);
		}
		else if (isGuessCorrect == false) {
			JOptionPane.showMessageDialog(null, "Boo! You suck!\nYou guessed " + numberGuessInteger + ", which is wrong!\nThe correct answer was " + randomizedInteger + "!\nSince you failed, the United States will fall to the communist regime!",
					title, JOptionPane.ERROR_MESSAGE);
		}
		} //Closes the integer game mode
		/** Code for Character game mode */
		if (userDifficultyLevel == 1) {
			userDifficultyOptionInteger = JOptionPane.showOptionDialog(null, "Select a character mode!\nSingle Case: Uses only uppercase letters, so you have a 1 in 26 chance. [Easy]\nDouble Case: Your option and the answer can be uppercase or lowercase, resulting in a 1 in 52 chance! [Hard]", title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, characterOptions, characterOptions[1]);
			//userDifficultyOptionInteger will be 0 for single case, 1 for double case
			while (isResponseAcceptable == false) {
				numberGuessString = JOptionPane.showInputDialog(null, "Please input a letter.", title, JOptionPane.QUESTION_MESSAGE);
				userInputCharacter = numberGuessString.charAt(0);
				isResponseAcceptable = Character.isLetter(userInputCharacter); //Checks to see if the user input a letter
				if (isResponseAcceptable == true) {
					break;
				}
				else if (isResponseAcceptable == false) {
					JOptionPane.showMessageDialog(null, "What are you, stupid? You input \"" + userInputCharacter + "\", which is not a letter!\nPut in a letter this time!", title, JOptionPane.ERROR_MESSAGE);
				}
			}
			Random randomCharacter = new Random();
			randomizedCharacter = (char) (randomCharacter.nextInt(26) + 'A'); //Generates a random character
			if (userDifficultyOptionInteger == 0) {
				randomizedCharacter = Character.toUpperCase(randomizedCharacter);
				userInputCharacter = Character.toUpperCase(userInputCharacter); //Makes user guess and random character uppercase				
			}
			else if (userDifficultyOptionInteger == 1) {
				randomizedInteger = 1 + (int) Math.random(); //Randomizes 0 for lowercase or 1 for uppercase
				if (randomizedInteger == 0) {
					randomizedCharacter = Character.toLowerCase(randomizedCharacter);
				}
				else if (randomizedInteger == 1) {
					randomizedCharacter = Character.toUpperCase(randomizedCharacter);
				}
			}
			isGuessCorrect = (userInputCharacter == randomizedCharacter); //Checks to see if user guessed correctly
			if (isGuessCorrect == true) {
				JOptionPane.showMessageDialog(null, "Nice job! You guessed \"" + userInputCharacter + "\", which is correct!\nYou win a free copy of Bonzi Buddy!", title, JOptionPane.INFORMATION_MESSAGE);
			}
			else if (isGuessCorrect == false) {
				JOptionPane.showMessageDialog(null, "Boo! You suck!\nYou guessed \"" + userInputCharacter + "\", which is wrong!\nThe correct answer is \"" + randomizedCharacter + "\"!\nSince you failed, your computer is being hacked!", title, JOptionPane.ERROR_MESSAGE);
			}
		} //Closes the character game mode
		/**Code for Decimal Game Mode*/
		if (userDifficultyLevel == 2) {
			while (isGameOptionAcceptable == false) {
				userDifficultyOptionString = JOptionPane.showInputDialog(null, "What difficulty do you want?\nPlease enter an integer from 5 to 20 for best results.\nDo not enter a number less than or equal to zero.\nThis number specifies the maximum possible value.\nFor example, 9 will make numbers from 1 to 9 possible.\n100 will make 1 to 100 possible.\nEven 2158564218 can be used, but it's not suggested.",
						title, JOptionPane.QUESTION_MESSAGE); //Prompts user for a gamemode type
				userDifficultyOptionInteger = Integer.parseInt(userDifficultyOptionString); //Parses difficulty
				userDifficultyOptionString = JOptionPane.showInputDialog(null, "How many decimal places do you want?\nPlease enter an positive nonzero integer.",
						title, JOptionPane.QUESTION_MESSAGE); //Prompts user decimal places
				decimalPlaces = Integer.parseInt(userDifficultyOptionString); //Parses decimal places
				isGameOptionAcceptable = (userDifficultyOptionInteger > 0 && decimalPlaces > 0);
				if (isGameOptionAcceptable == true) {
					break;
				}
				else if (isGameOptionAcceptable == false) {
					JOptionPane.showMessageDialog(null, "What are you, stupid? One of your numbers are bad!\nGo back and fix it you moron!", title, JOptionPane.ERROR_MESSAGE);
					}
			}
			
			randomizedDecimal = 1 + (Math.random() * userDifficultyOptionInteger); //randomizes a decimal
			DecimalFormat specificSpaces = new DecimalFormat();
			specificSpaces.setMinimumFractionDigits(decimalPlaces);
			specificSpaces.setMaximumFractionDigits(decimalPlaces);
			randomizedDecimalWithSpecificPlaces = Double.parseDouble(specificSpaces.format(randomizedDecimal));
			while (isResponseAcceptable == false) {
				numberGuessString = JOptionPane.showInputDialog(null, "Input a decimal value from 1 to " + userDifficultyOptionInteger, title, JOptionPane.QUESTION_MESSAGE);
				numberGuessDecimal = Double.parseDouble(specificSpaces.format(Double.parseDouble(numberGuessString)));
				isResponseAcceptable = (numberGuessDecimal > 0 && numberGuessDecimal < userDifficultyOptionInteger);
				if (isResponseAcceptable == true) {
					break;
				}
				else if (isResponseAcceptable == false) {
					JOptionPane.showMessageDialog(null, "What are you, stupid?\nYou input " + numberGuessDecimal + "!\nThat is not in between 1 and " + userDifficultyOptionInteger + "!\nFix that you moron!", title, JOptionPane.ERROR_MESSAGE);
					}
			}
			isGuessCorrect = (randomizedDecimalWithSpecificPlaces == numberGuessDecimal);
			if (isGuessCorrect == true) {
				JOptionPane.showMessageDialog(null, "Wow! You are a wizard!\nYou guessed " + numberGuessDecimal + ", which is correct!\nYou just won 400 ROBUX!", title, JOptionPane.INFORMATION_MESSAGE);
			}
			else if (isGuessCorrect == false) {
				JOptionPane.showMessageDialog(null, "Boo! You suck!\nYou guessed " + numberGuessDecimal + ", which is wrong!\nThe right answer was " + randomizedDecimalWithSpecificPlaces + "!\nSince you lost, your computer will explode!", title, JOptionPane.ERROR_MESSAGE);
						}
		} //Closes the decimal game mode
		willUserPlayAgainInteger = JOptionPane.showOptionDialog(null, "Do you want to play again?", title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		//willUserPlayAgain will be 1 for yes, and 0 for no
		willUserPlayAgainBoolean = (willUserPlayAgainInteger == 0);
	} //Closes the loop
	}
} //End of program
