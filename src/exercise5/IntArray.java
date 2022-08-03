package exercise5;

import java.util.Arrays;

public class IntArray {

	//the int array
	private int[] tab;

	//constructor
	public IntArray(int n) {
		tab = new int[n];
	}

	/**
	 * Get the value of tab
	 *
	 * @return the value of tab
	 */
	public int getItemAt(int i) {
		if (i > tab.length || i < 0) {
			return Integer.MAX_VALUE;
		}
		return tab[i];
	}

	/**
	 * Set the value of cell i 
	 *
	 * @param index i and value v
	 */
	public void setItemAt(int i, int v) {
		if (i < tab.length) {
			tab[i] = v;
		}
	}

	//get the max value of the array
	public int getMax() {
		int[] s = Arrays.copyOf(tab, tab.length);
		Arrays.sort(s);
		return s[s.length - 1];
	}

	//get the min value of the array
	public int getMin() {
		int[] s = Arrays.copyOf(tab, tab.length);
		Arrays.sort(s);
		return s[0];
	}

	//sort the array
	public void sort() {
		Arrays.sort(tab);
	}

	//create a string representation of the array
	@Override
	public String toString() {
		String s = "{";
		for (int i = 0; i < tab.length; i++) {
			s += tab[i] ;
			if(i < tab.length-1) {
				s += ", ";
			}
		}
		s+="}";
		return s;
	}

	//get the length of the array
	public int length() {
		return tab.length;
	}

	//push a new cell into the array
	public void pushItem(int v) {
		//we need to create a new array with size incremented by 1
		this.tab = Arrays.copyOf(tab, tab.length + 1);
		//and set the value of the last cell to v
		this.tab[this.tab.length - 1] = v;
	}

	//remove the last cell from the array
	public int pullItem() {
		//take the value of the last cell for any further use (here we return it)
		int v = this.tab[this.tab.length - 1];
		//recreate a new array with the size of the current array minus 1
		this.tab = Arrays.copyOf(tab, tab.length - 1);
		return v;
	}

}
