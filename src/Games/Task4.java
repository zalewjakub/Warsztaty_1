package Games;

import java.util.Random;
import java.util.Scanner;

public class Task4 {

	public static void main(String[] args) {
		int typeOfDice = 0, howManyRoll = 0, diceModification = 0;
		String dice;
		int[] dices = { 3, 4, 6, 8, 10, 12, 20, 100 };
		System.out.println("Kod kostki w formacie xDy+z, x = gdzie:\n" + "\n" + "    x – liczba rzutów kośćmi,\n"
				+ "    y – rodzaj kostek, których należy użyć (D3, D4, D6, D8,  D10, D12, D20, D100),\n"
				+ "    z – liczba, którą należy dodać (lub odjąć) do wyniku rzutów (opcjonalnie).\n" + "");
		try (Scanner scan = new Scanner(System.in)) {

			do {
				try {
					dice = getInfo(scan);
					typeOfDice = Integer.parseInt((dice.substring(dice.indexOf('D') + 1, dice.indexOf('+'))));
					howManyRoll = Integer.parseInt((dice.substring(0, dice.indexOf('D'))));
					diceModification = Integer.parseInt((dice.substring(dice.indexOf('+') + 1, dice.length())));
					checkTypeOfDice(typeOfDice, dices);
				} catch (NumberFormatException e) {
					System.out.println("Wprowadziłeś nieprawidłowy format kostki");
				}
			} while (howManyRoll < 1 || checkTypeOfDice(typeOfDice, dices) == 0);

			System.out.println(randomDiceRoll(typeOfDice, howManyRoll) + diceModification);
		}
	}

	private static int checkTypeOfDice(int typeOfDice, int[] dices) {
		int corectDice = 0;
		for (int i = 0; i < dices.length; i++) {

			if (dices[i] == typeOfDice) {
				corectDice = corectDice + 1;
				return corectDice;
			}
		}
		return corectDice;
	}

	static String getInfo(Scanner scan) {
		String diceString;

		do {
			do {
				System.out.println("Wprowadź prawidłowy kot kostki");
				diceString = scan.nextLine();
			} while (!(diceString.contains("D")) || (!(diceString.contains("+"))));
		} while (diceString.isEmpty());
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
