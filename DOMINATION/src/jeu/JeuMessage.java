 
package jeu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JeuMessage {
	static Scanner reader = new Scanner(System.in);
	
	
	public static int recupereInt(String value) {
		
		int message = 0;
		boolean a = false;
		
		while (!a) {
			System.out.println(" " + value);
			message = reader.nextInt();
			a = true;
			reader.nextLine();
		}

		return message;
	}

	public static String recupereString(String value) {

		String message = null;
		boolean a = false;
		
		while (!a) {
			System.out.println(" " + value);
			message = reader.nextLine();
			
			try {
				if (message.equals("N") || message.equals("S") || message.equals("E") || message.equals("O")
					|| message.equals("I"))
						a = true;
					else {
						System.out.print("Mauvaise entrée, réessayez.");
					}
			} catch (InputMismatchException e) {
				// TODO Auto-generated catch block
			}
		

		}
		return message;
	}
	


}
