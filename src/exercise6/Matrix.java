package exercise6;

public class Matrix {
	int nbRows; //number of rows
	int nbColumns; //number of columns
	double [][] tab; //the two dimension array
	
	//constructor with number of rows and columns that creates the array
	public Matrix(int rows, int columns){
		nbRows = rows;
		nbColumns = columns;
		tab = new double[rows][columns]; //filled with zero
	}
	
	//constructor that takes an existing array and assign it to the tab attribute
	public Matrix(double [][] d){
		nbRows = d.length;
		nbColumns = d[0].length;
		tab = d;
	}

	//return number of rows
	public int getNbRows(){return nbRows;}
	
	//return number of columns
	public int getNbColumns(){return nbColumns;}
	
	//return array item  at i, j
	public double getComp(int i, int j){return tab[i][j];}

	//add this matrix with s and return a new matrix with the result
	public Matrix add(Matrix s)  {
		if(nbRows != s.getNbRows() || nbColumns != s.getNbColumns()){
			return null;
		}
		double [][] r = new double[nbRows][nbColumns];
		for(int i=0; i<nbRows; i++){
			for(int j=0; j<nbColumns; j++){
				r[i][j] = tab[i][j] + s.getComp(i,j);
			}
		}
		return new Matrix(r);
	}
	
	//multiply this matrix with s and return a new matrix with the result
	public Matrix mul(Matrix s)  {
		if(nbColumns != s.getNbRows()){
			return null;
		}
		double [][] r = new double[nbRows][s.getNbColumns()];
		for(int i=0; i<nbRows; i++){
			for(int j=0; j<s.getNbColumns(); j++){
				r[i][j] = 0;
				for(int k=0;k<nbColumns;k++){
					r[i][j] += tab[i][k] * s.getComp(k,j);
				}
			}
		}
		return new Matrix(r);
	}
	
	//transpose this matrix return a new matrix with the result
	public Matrix transpose(){
		double [][] r = new double[nbColumns][nbRows];
		for(int i=0; i<nbRows; i++){
			for(int j=0; j<nbColumns; j++){
				r[j][i] = tab[i][j];
			}
		}
		return new Matrix(r);
	}

	//remove line x and row y and return result as new matrix
	private Matrix sub(int x, int y){
		double [][] r = new double[nbRows-1][nbColumns-1];
		for(int i=0, ip=0; i<nbRows; i++, ip++){
			if(i == x){
				ip--;
				continue;
			}
			for(int j=0, jp=0; j<nbColumns; j++, jp++){
				if(j == y){
					jp--;
					continue;
				}
				r[ip][jp] = tab[i][j];
			}
		}
		return new Matrix(r);
	}
	
	//calculate determinant of this
	public double det() {//determinant of the matrix
		if(nbRows != nbColumns) {
			return Double.NaN;
		}
		double res = 0;
		int f = -1;
		for(int i=0; i<nbRows; i++){
			f *= -1;
			if(nbRows>2){ //development according to 1st column 
				Matrix s = this.sub(i, 0);
				
				res += f * tab[i][0] * s.det();
			}else{ //Matrix 2x2,  trivial
				res += f * tab[i][0] *tab[1-i][1];
			}
		}
		return res;
	}

	//create a string representation of the array
	public String toString(){
		//use only two digit decimal part
		java.text.DecimalFormat d = new java.text.DecimalFormat("#.00");
		String s="";
		for(int i=0; i<nbRows; i++){
			s += "| ";
			for(int j=0; j<nbColumns; j++){
				//format all values to be two digits decimal
				s += "  " + d.format(tab[i][j]);
			}
			s += " |\n";
		}
		return s;
	}

}
