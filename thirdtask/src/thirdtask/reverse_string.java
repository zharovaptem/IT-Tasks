package thirdtask;

import java.util.Scanner;

public class reverse_string {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Ваша строка - ");
		String text = scan.next();
		scan.close();
		String reverse_text = reverseSrting(text);
		System.out.println("Строка до изменения - " + text);
		System.out.println("Строка после изменения - " + reverse_text);
		if(text.equals(reverse_text)) {
			System.out.println("Данная строка является палиндромом");
		}
		else {
			System.out.println("Данная строка не является палиндромом");
		}
	}
	private static String reverseSrting(String text) {
		return new StringBuilder(text).reverse().toString();
	}
}
