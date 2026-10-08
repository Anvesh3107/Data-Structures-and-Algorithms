import java.util.Random;
import java.util.Scanner;

public class Assignment1Task2 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		System.out.print("Enter the value of n: ");
		int n = scanner.nextInt();
		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = random.nextInt(100);
		}
		System.out.println("Array generated successfully.");
		int maximum = findMaximum(numbers);
		System.out.println("Maximum value: " + maximum);

		int sum = calculateSum(numbers);
		System.out.println("Sum of elements: " + sum);

		boolean duplicates = hasDuplicates(numbers);
		System.out.println("Contains duplicates: " + duplicates);

		scanner.close();
	}
	public static int findMaximum(int[] numbers) {
		int max = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] > max) {
				max = numbers[i];
			}
		}
		return max;
	}
	public static int calculateSum(int[] numbers) {
		int sum = 0;
		for (int number : numbers) {
			sum += number;
		}
		return sum;
	}
	public static boolean hasDuplicates(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] == numbers[j]) {
					return true;
				}
			}
		}
		return false;
	}
}

