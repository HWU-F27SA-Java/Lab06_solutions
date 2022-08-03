package exercise4;

import java.util.Random;
import java.util.Scanner;

import exercise1.Sentence;


public class SentenceWordEncoder {

	public static void main(String[] args) {
		System.out.print("Do you want to encode (e/E) or decode (d/D)? ");

		System.out.print("Enter a string ...");
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		Sentence sentence = new Sentence(s);
		String op = scanner.nextLine();
		Sentence r = new Sentence("");
		switch (op.charAt(0)) {
			case 'e':
			case 'E': {
				int encodeBase = (new Random()).nextInt(100);
				System.out.println("Base: " + encodeBase);
				r = sentence.encode(encodeBase);
				break;
			}
			case 'd':
			case 'D': {
				System.out.print("Enter the base? ");
				int decodeBase =  scanner.nextInt();
				r = sentence.decode(decodeBase);
			}
		}
		System.out.println(r);
		scanner.close();

	}

}
