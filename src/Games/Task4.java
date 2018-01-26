package Games;

import static java.lang.String.format;

import java.util.Random;
import java.util.Scanner;

public class Task4 {
	public static void main(String[] args) {
		int typeOfDice, howManyRoll, diceModification;
		String dice;
		dice = getInfo();
		typeOfDice = Character.getNumericValue(dice.charAt(2));
		howManyRoll = Character.getNumericValue(dice.charAt(0));
		diceModification = Character.getNumericValue(dice.charAt(4));
		System.out.println(randomDiceRoll(typeOfDice, howManyRoll) + diceModification);

	}

	static String getInfo() {
		String diceString;
		try (Scanner scan = new Scanner(System.in)) {
			do {
				do {
					System.out.println("Podaj kod kostki");
					diceString = scan.nextLine();
				} while (!(diceString.contains("D")) || (!(diceString.contains("+"))));
			} while (diceString.isEmpty());
		}
		return diceString;
	}

	static int randomDiceRoll(int type, int howMany) {
		int sum = 0;
		Random generator = new Random();
		for (int i = 0; i < howMany; i++) {
			sum = sum + generator.nextInt(type) + 1;
		}

		return sum;
	}

}
