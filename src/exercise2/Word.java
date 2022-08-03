package exercise2;

import exercise3.MyString;

public class Word {
	//attribute
	private String value;

	//constructor
	public Word(String value) {
		this.value = value;
	}

	//get the string value of this word
	public String getValue() {
		return value;
	}

	//return a string value of this word
	public String toString() {
		return this.value;
	}
	
	//exercise 2
	//invert the word
	public Word mirror() {

		String r = "";
		for (int i = value.length() - 1; i >= 0; i--) {
			r = r + value.charAt(i);
		}

		return new Word(r);
	}
	
	//exercise 4
	//encode the word by inverting and adding a base to each character code
	public Word encode(int base) {
		Word m = this.mirror();
		String s = m.getValue();
		//get the array of chars
		char[] chars = MyString.getCharCodeArray(s);
		
		//encode by adding the base
		for(int i=0; i<chars.length;i++) {
			chars[i] = (char) ((chars[i]+base) & 0xFF);
		}
		//create string with comma separate char codes
		String res = MyString.getStringOfCharCodes(chars);
		
		return new Word(res);
	}
	
	//exercise 5
	//decode word by subtracting base and inverting the string
	public Word decode(int base) {
		String s = this.getValue();
		//get the array of chars (take off the :)
		char[] chars= MyString.stringBytesToCharArray(s);
		
		//decode by subtracting the base
		for(int i=0; i<chars.length;i++) {
			chars[i] = (char) ((chars[i] - base) & 0xFF);
		}
		//recreate string from chars
		String res = MyString.getString(chars);
		
		return new Word(res).mirror();
	}
}
