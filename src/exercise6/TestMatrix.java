package exercise6;

import java.util.Scanner;

public class TestMatrix {
	static java.util.Random rand = new java.util.Random();
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int n = 0;
		Matrix m1, m2, m3;
		do {
			n = menu();
			switch (n) {
			case 1: // addition
				System.out.println("Enter dimensions of first matrix");
				m1 = buildMatrix();
				System.out.println("Enter dimensions of second matrix");
				m2 = buildMatrix();

				m3 = m1.add(m2);
				System.out.println(m1 + " + \n" + m2 + " = \n" + m3);

				break;
			case 2: // multiplication
				System.out.println("Enter dimensions of first matrix");
				m1 = buildMatrix();
				System.out.println("Enter dimensions of second matrix");
				m2 = buildMatrix();

				m3 = m1.mul(m2);
				System.out.println(m1 + " * \n" + m2 + " = \n" + m3);

				break;
			case 3: // transpose
				System.out.println("Enter dimensions of matrix");
				m1 = buildMatrix();
				m3 = m1.transpose();
				System.out.println("trans(\n" + m1 + " =\n" + m3);
				break;
			case 4: // determinant
				System.out.println("Enter dimensions of matrix");
				m1 = buildMatrix();

				double v = m1.det();
				System.out.println("det (\n" + m1 + ") = " + v);

				break;
			case 5: // sum
			{
				System.out.print("How many matrices you want to sum?");
				int nb = input.nextInt();
				Matrix[] matrices = new Matrix[nb];
				for (int i = 0; i < nb; i++) {
					System.out.println("Enter dimensions of matrix" + (i + 1));
					matrices[i] = buildMatrix();
				}
				if (nb > 0) {
					String string= "Sum(\n";
					Matrix res = new Matrix(matrices[0].getNbRows(), matrices[0].getNbColumns());
					for (int i = 0; i < nb; i++) {
						res = res.add(matrices[i]);
						string += matrices[i] ;
						if(i < nb - 1) {
							string += ", \n";
						}
					}
					System.out.println(string + ")\n = \n" + res);
				}
				

			}
				break;
			}
		} while (n != 0);
		input.close();

	}

	//ask the user dimensions and build a random matrix
	static Matrix buildMatrix() {
		System.out.println();
		System.out.print("Rows? ");
		int x = input.nextInt();
		System.out.print("Columns? ");
		int y = input.nextInt();

		System.out.print("Min value? ");
		double min = input.nextDouble();
		System.out.print("Max value? ");
		double max = input.nextDouble();

		double[][] t = new double[x][y];

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				t[i][j] = rand.nextDouble() * (max - min) + min;
			}
		}
		return new Matrix(t);
	}

	//display a menu for the user
	static int menu() {
		System.out.println("------------------------------------------");
		System.out.println("0- Quit");
		System.out.println("1- Add two matrices");
		System.out.println("2- Multiply two matrices");
		System.out.println("3- Transpose a matrix");
		System.out.println("4- Calculate determinant");
		System.out.println("5- Sum several matrices");
		System.out.print("Enter your choice (0-5)? ");
		int c = input.nextInt();
		System.out.println("------------------------------------------");
		return c;
	}

}
