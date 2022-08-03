package exercise3;

public class MyStringTest {

	public static void main(String[] args) {
		String inputString = "Hello World!";
		System.out.println(inputString);
		//get the array of char codes
		char[] charArray = MyString.getCharCodeArray( inputString);
		//create the string of char codes separate by comma
		String stringOfCharCodes = MyString.getStringOfCharCodes(charArray);
		System.out.println(stringOfCharCodes);
		
		//extract the array of chars
		char[] chars = MyString.stringBytesToCharArray(stringOfCharCodes);
		//recreate the string for the string of char codes
		String outputString = MyString.getString(chars);
		System.out.println(outputString);
		
	}

}
