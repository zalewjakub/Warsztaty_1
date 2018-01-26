package Games;

import java.util.Random;
import java.util.Scanner;

public class Task1 {
	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			int rand = randomNumber();
			int userNumber = readNumber(scan);
			userNumber = compareNumber(scan, rand, userNumber);
			System.out.println("Brawo zgadłeś liczbę " + rand);
		}
	}

	private static int compareNumber(Scanner scan, int rand, int userNumber) {
		do {
			if (userNumber > rand) {
				System.out.println("Za dużo!");
				userNumber = readNumber(scan);
			} else if (userNumber < rand) {
				System.out.println("Za mało!");
				userNumber = readNumber(scan);
			}

		} while (userNumber != rand);
		return userNumber;
	}

	static int randomNumber() {
		Random generator = new Random();
		int a = generator.nextInt(100) + 1;
		return a;
	}

	private static int readNumber(Scanner scan) {
		int number;
		do {
			System.out.println("Zgadnij liczbę. Liczba musi być w zakresie 1 do 100");
			while (!scan.hasNextInt()) {
				System.out.println("To nie jest liczba. Podaj liczbę");
				scan.next();
			}
			number = scan.nextInt();
		} while (number < 0 || number > 100);
		return number;
	}
}
