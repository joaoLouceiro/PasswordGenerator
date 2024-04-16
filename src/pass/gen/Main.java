package pass.gen;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		PasswordGenerator generator = new PasswordGenerator(sc);
		generator.mainLoop();
		sc.close();
	}

}
