package triangulos;

import java.util.Scanner;

public class ej3Examen {
	
	public static long cuadradoSumas (int n){
		int cont = n;
		for (int i=1;cont>i;){
			cont--;
			n = n + cont;
		}
		n = n*n;
		return n;
    }
	
	public static long sumasCuadrado (int n){
		int cont = n;
		n = n*n;
		for (int i=1;cont>i;){
			cont--;
			n = n + cont*cont;
		}
		return n;
    }

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
	      int n;
	      System.out.println ("Teclee un número: ");
	      n = in.nextInt();
	      System.out.println(cuadradoSumas(n)-sumasCuadrado(n));
	      

	}
	

}
