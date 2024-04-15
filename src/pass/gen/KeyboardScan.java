package pass.gen;

import java.util.Scanner;

public class KeyboardScan {

	private int counter;
	private int reply;
	private Scanner keyboard;

	public KeyboardScan() {
		super();
		keyboard = new Scanner(System.in);
	}

	public void scanUserMessage(String message) {
		do {
			System.out.print(message);
			reply = keyboard.findWithinHorizon(".", 0).charAt(0);
			this.counter += 1;
		} while (reply != 'y' && reply != 'n');
	}

	public int getCounter() {
		return counter;
	}

	public Scanner getKeyboard() {
		return keyboard;
	}

}
