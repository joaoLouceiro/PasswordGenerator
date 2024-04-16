package pass.gen;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PasswordGenerator {

	public static void main(String[] args) {
		PasswordGenerator generator = new PasswordGenerator();
		Password pass = new Password();
		Scanner sc = new Scanner(System.in);
		int length = 0;

		do {
			pass.setbUpCase(
					generator.askCharacters("Upper case letters? (y/n)", sc));
			pass.setbLowCase(
					generator.askCharacters("Lower case letters? (y/n)", sc));
			pass.setbNumbers(generator.askCharacters("Numbers? (y/n)", sc));
			pass.setbSymbols(generator.askCharacters("Symbols? (y/n)", sc));
			if (!pass.isCharSelected())
				System.out.println("Select one of the previous options");
		} while (!pass.isCharSelected());

		do {
			System.out.println("Set the length of your password (8-32):");
			// Verify that the input is of type INT;
			while (!sc.hasNextInt()) {
				System.out.println("Set the length of your password (8-32):");
				sc.next();
			}
			length = sc.nextInt();
			// Verify that input is within expected range;
		} while (length < 8 || length > 32);

		pass.setLength(length);

		sc.close();
	}

	private boolean askCharacters(String message, Scanner sc) {
		char reply;
		do {
			System.out.print(message);
			reply = sc.findWithinHorizon(".", 0).charAt(0);
		} while (reply != 'y' && reply != 'n');
		return reply == 'y';
	}

}
