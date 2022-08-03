package exercise1;

import java.util.Scanner;

public class SpaceCounter {

	public static void main(String[] args) {
        System.out.println("Enter a text ...");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Sentence sentence = new Sentence(s);
        int ns_spaces = 0;
        int n = -1;
        System.out.println("Space at positions: ");
        do {
            n = sentence.nextSpaceIndex(n + 1);
            if (n >= 0) {
                ns_spaces++;
                System.out.print(n + ", ");
            }
        } while (n >= 0);
        System.out.println();
        System.out.println("Number of spaces: \n" + ns_spaces);

        scanner.close();
	}

}
