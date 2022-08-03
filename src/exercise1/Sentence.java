package exercise1;

import exercise2.Word;

public class Sentence {
    private String value;

   //constructor
    public Sentence(String s){
        value = s;
    }
    
    //get the string value
    public String getValue() {
        return value;
    }

    //get the next index of space starting from start
    public int nextSpaceIndex(int start){
        int n = value.indexOf(' ', start);
        return n;
    }

    //return a string representation of the sentence
    public String toString(){
        return value;
    }
    
    //check if this sentence is equal to obj
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(!(obj instanceof Sentence)) return false;
        Sentence m = (Sentence) obj;
        return this.value.equals(m.getValue());
     }
     

    //exercise 2
    public Word extractWord(int i, int j){
        String s = value.substring(i, j);
        Word m = new Word(s);
        return m;
    }
    //exercise 2
    public Word extractWord(int i){
        return extractWord(i, value.length());
    }


     //exercise 4
    public  Sentence encode(int base) {
    	String result = "";
        int prev = 0;
        int next = -1;
        do{
            next = this.nextSpaceIndex(next+1);
            if(next>=0){
                Word m = this.extractWord(prev, next);
                m = m.encode(base);
                if(!result.equals("")) {
                	result += " ";
                }
                result += m;
                prev = next;
            }
        }while(next >= 0);
        Word m = this.extractWord(prev+1);
        m = m.encode(base);
        if(!result.equals("")) {
        	result += " ";
        }
        result += m;
        return new Sentence(result);
    }
    
    //exercise 4
    public  Sentence decode(int base) {
    	String result = "";
        int prev = 0;
        int next = -1;
        do{
            next = this.nextSpaceIndex(next+1);
            if(next>=0){
                Word m = this.extractWord(prev, next);
                m = m.decode(base);
                if(!result.equals("")) {
                	result += " ";
                }
                result += m;
                prev = next;
            }
        }while(next >= 0);
        Word m = this.extractWord(prev+1);
        m = m.decode(base);
        if(!result.equals("")) {
        	result += " ";
        }
        result += m;
        return new Sentence(result);
    }
    
 
}
