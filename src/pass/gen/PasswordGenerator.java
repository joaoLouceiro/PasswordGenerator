package pass.gen;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PasswordGenerator {

	private static int counter;
	private Map<Integer, Integer[]> mp = new HashMap<Integer, Integer[]>();
	private static Scanner keyboard;

	public static void main(String[] args) {
		// Upper case: 65-90
		// Lower case: 97-122
		// Numbers: 48-57
		// Symbols: 33-47, 58-96, 123-126

		Integer[] upperCase = { 65, 90 }, lowerCase = { 97, 122 }, numbers = { 48, 57 }, symbols = { 33, 47 };
		keyboard = new Scanner(System.in);
		SecureRandom sr = new SecureRandom();
		String pass = "";
		PasswordGenerator passGen = new PasswordGenerator();

		do {
			passGen.askCharacters("Upper case letters? (y/n)", upperCase);
			passGen.askCharacters("Lower case letters? (y/n)", lowerCase);
			passGen.askCharacters("Numbers? (y/n)", numbers);
			passGen.askCharacters("Symbols? (y/n)", symbols);
			if (counter == 0) {
				System.out.println("Please select at least one of the options");
			}
		} while (counter == 0);

		String passLengthInput;
		Integer passLength = 0;;
		do {
			System.out.println("Set the length of your password:");
			while (!keyboard.hasNextInt()) {
				System.out.println("Please, enter a number between 1 and 32");
				keyboard.next();
			}
			passLengthInput = keyboard.next();
			passLength = Integer.parseInt(passLengthInput);
			
		} while (passLength <= 0 || passLength > 32);

		for (int i = 0; i < passLength; i++) {

			pass += (char) sr.nextInt(65, 90 + 1);
		}

		System.out.println(pass);
		keyboard.close();
	}

	private void askCharacters(String message, Integer[] charRange) {
		char reply;
		do {
			System.out.print(message);
			reply = keyboard.findWithinHorizon(".", 0).charAt(0);
		} while (reply != 'y' && reply != 'n');
		if (reply == 'y') {
			this.mp.put(PasswordGenerator.counter, charRange);
			PasswordGenerator.counter += 1;
		}
	}

}
