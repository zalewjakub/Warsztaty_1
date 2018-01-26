package Games;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task2 {
	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {

			int[] readNum = readNumber(scan);
			int[] randomNum = randomNumber();
			System.out.println("Twoje liczby:");
			System.out.println(Arrays.toString(readNum));
			System.out.println("Wylosowane liczby:");
			System.out.println(Arrays.toString(randomNum));
			areYouWin(readNum, randomNum);
		}

	}

	private static void areYouWin(int[] readNum, int[] randomNum) {
		int check, win = 0;
		for (int i = 0; i < readNum.length; i++) {
			check = readNum[i];
			if ((Arrays.binarySearch(randomNum, check) >= 0)) {
				win = win + 1;
			}
		}

		if (win >= 3) {
			System.out.println("Trafiłeś " + win + "liczb");
		} else {
			System.out.println("Niestety trafiłeś tylko " + win + " liczb");
		}
	}

	static int[] randomNumber() {
		Random generator = new Random();
		int count = 0;
		int[] lottoTable = new int[6];
		int[] checkTable = new int[6];
		int number;
		do {
			do {
				number = generator.nextInt(49) + 1;
				checkTable = lottoTable.clone();
				Arrays.sort(checkTable);
			} while ((Arrays.binarySearch(checkTable, number) >= 0));
			lottoTable[count] = number;
			count = count + 1;
		} while (count != 6);
		Arrays.sort(lottoTable);
		return lottoTable;
	}

	private static int[] readNumber(Scanner scan) {
		int[] numbers = new int[6];
		int[] checkTable = new int[6];
		int number;
		for (int i = 0; i < 6; i++) {
			do {
				System.out.println("Podaj " + (i + 1) + " liczbę w zakresie 1 do 49");
				while (!scan.hasNextInt()) {
					System.out.println("To nie jest liczba. Podaj liczbę");
					scan.next();
				}
				do {
					number = scan.nextInt();
					checkTable = numbers.clone();
					Arrays.sort(checkTable);
				} while ((Arrays.binarySearch(checkTable, number) >= 0));
				numbers[i] = number;

			} while (numbers[i] <= 0 || numbers[i] >= 50);

		}
		Arrays.sort(numbers);
		return numbers;
	}
}