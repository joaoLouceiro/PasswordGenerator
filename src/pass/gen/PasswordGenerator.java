package pass.gen;

import java.util.Scanner;

public class PasswordGenerator {
	
	private Scanner sc;
	
	public PasswordGenerator(Scanner sc) {
		super();
		this.sc = sc;
	}
	
	public void mainLoop() {
		Password password = new Password();
		do {
			password.setbUpCase(
					this.askCharacters("Upper case letters? (y/n)", sc));
			password.setbLowCase(
					this.askCharacters("Lower case letters? (y/n)", sc));
			password.setbNumbers(this.askCharacters("Numbers? (y/n)", sc));
			password.setbSymbols(this.askCharacters("Symbols? (y/n)", sc));
			if (!password.isCharSelected())
				System.out.println("Select one of the previous options");
		} while (!password.isCharSelected());

		do {
			System.out.println("Set the length of your password (8-32):");
			while (!sc.hasNextInt()) {
				System.out.println("Set the length of your password (8-32):");
				sc.next();
			}
			password.setLength(sc.nextInt());
		} while (password.getLength() < 8 || password.getLength() > 32);

		System.out.println(password.generatePassword());
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
