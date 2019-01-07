 
package jeu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JeuMessage {
	static Scanner reader = new Scanner(System.in);

	public static String recupereString(String value) {

		String message = null;
		boolean a = false;
		while (!a) {
			System.out.println(" " + value);

			try {
				message = reader.nextLine();
				if (message.equals("N") || message.equals("S") || message.equals("E") || message.equals("O")
						|| message.equals("I"))
					a = true;
				else
					System.out.print("Mauvaise entrée, réessayez.");
			} catch (InputMismatchException e) {
				System.out.print("Mauvaise entrée, réessayez.");
			}

		}

		return message;
	}

	public static int recupereInt(String value) {
		int message = 0;
		boolean a = false;
		while (!a) {
			System.out.println(" " + value);
			try {
				message = reader.nextInt();
				a = true;
			} catch (InputMismatchException e) {
				System.out.print("Mauvaise entrée, réessayez.");
			}
			reader.nextLine();
		}

		return message;
	}
}
