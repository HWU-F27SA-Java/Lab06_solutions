package exercise5;

import java.util.Random;
import java.util.Scanner;

public class TestIntArray {

	public static void main(String[] args) {
        Random r = new Random();
        System.out.print("Enter the size of the array: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        IntArray t = new IntArray(n);
        
        for(int i=0; i<t.length();i++){
            t.setItemAt(i, r.nextInt(100));
        }
        int max = t.getMax();
        int min= t.getMin();
        System.out.println("Original:\n\t" + t);
        System.out.println("Min=" + min + ", Max= " + max);    
       
        t.sort();
        System.out.println("Sorted:\n\t" + t);
        
        //push a random int at the end
        int push = r.nextInt(100);
        System.out.println("Pushing :\n\t"+ push);
        t.pushItem(push);
        System.out.println("After pushing item:\n\t" + t);
        t.sort();
        System.out.println("Sorted:\n\t" + t);
        //pull the last item
        int lastInt = t.pullItem();
        System.out.println("Pulled :\n\t"+ lastInt);
        System.out.println("After pulling item:\n\t"+ t);
       
        input.close();

	}

}
