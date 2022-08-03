package exercise2;

import java.util.Scanner;
import exercise1.Sentence;

public class WordInverter {

	public static void main(String[] args) {
	       System.out.print("Enter a sentence ...");
	       Scanner scanner = new Scanner(System.in);
	        String s = scanner.nextLine();
	        Sentence sentence = new Sentence(s);
	        int prev = 0;
	        int next = -1;
	        do{
	            next = sentence.nextSpaceIndex(next+1);
	            if(next>=0){
	                Word m = sentence.extractWord(prev, next);
	                m = m.mirror();
	                System.out.print(m + " ");
	                prev = next;
	            }
	        }while(next >= 0);
	        Word m = sentence.extractWord(prev);
	        m = m.mirror();
	        System.out.println(m + " ");
	        scanner.close();
	}

}
