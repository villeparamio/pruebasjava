package triangulos;

import java.util.Scanner;

public class ej2Examen {
	
	public static int par (int n){
		n = n / 2;
		return n;
    }
	
	public static int impar (int n){
		n = n*3+1;
		return n;
    }

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
	      int n;
	      System.out.println ("Teclee un número: ");
	      n = in.nextInt();
	      int longitud = 0;
	      while (n>1) {
	    	  if (n%2 == 0){
	    		  n = par(n);
	    	  }else {
	    		  n = impar(n);
	    	  }
	    	  longitud ++;	    	 
	      }
	      System.out.println(longitud);

	}
	

}
