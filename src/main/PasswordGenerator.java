package main;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PasswordGenerator {
	
	private Scanner sc;
	private int[] rUpCase = { 65, 90 }, rLowCase = { 97, 122 },
			rNumbers = { 48, 57 }, rSymbols = { 33, 47 };

	
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

		System.out.println(this.generatePassword(password));
	}
	
	private String generatePassword(Password password) {
		String out = "";
		List<int[]> rangeMatrix = new ArrayList<int[]>();
		if (password.isbUpCase())
			rangeMatrix.add(rUpCase);
		if (password.isbLowCase())
			rangeMatrix.add(rLowCase);
		if (password.isbNumbers())
			rangeMatrix.add(rNumbers);
		if (password.isbSymbols())
			rangeMatrix.add(rSymbols);
		SecureRandom sr = new SecureRandom();
		for (int i = 0; i < password.getLength(); i++) {
			int typeRnd = sr.nextInt(0, rangeMatrix.size());
			int lowRange = rangeMatrix.get(typeRnd)[0];
			int upperRange = rangeMatrix.get(typeRnd)[1];
			out += (char) sr.nextInt(lowRange, upperRange + 1);
		}
		return out;
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
