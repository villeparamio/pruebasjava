package sesionEvaluacionV1;

import java.util.Scanner;

public class enunciado1 {
	
	// Declaramos la función que actúa sobre los números pares
	
	public static long par (long n){
		n = n / 2;
		return n;
    }
	
	// Declaramos la función que actúa sobre los números impares
	
	public static long impar (long n){
		n = n*3+1;
		return n;
    }

	public static void main(String[] args) {
		
		// Recogemos los valores por pantalla
		
		Scanner in = new Scanner (System.in);
	      long n1;
	      long n2;
	      System.out.println ("Teclee el primer número: ");
	      n1 = in.nextInt();
	      System.out.println ("Teclee el segundo número: ");
	      n2 = in.nextInt();
	      
	      // colocamos el número más alto primero
	      long longitud = 0;
	      long distancia = 0;
	      if (n1 > n2){
	    	  for (long contador = n2;n1>contador;contador++){
	    		  while (contador>1) {
			    	  if (contador%2 == 0){
			    		  contador = par(contador);
			    	  }else {
			    		  contador = impar(contador);
			    	  }
		    	  }
	    		  distancia++;
	    	  }
	      } else if (n1 < n2) {
	    	  
	      } else {
		      while (n1>1) {
		    	  
		    	  if (n1%2 == 0){
		    		  n1 = par(n1);
		    	  }else {
		    		  n1 = impar(n1);
		    	  }
		    	  longitud ++;	    	 
		      } 
	      }
	      
	      
	      
	      /*// Operamos con el segundo número
	      
	      long longitudN2 = 0;
	      while (n2>1) {
	    	  if (n2%2 == 0){
	    		  n2 = par(n2);
	    	  }else {
	    		  n2 = impar(n2);
	    	  }
	    	  longitudN2 ++;	    	 
	      }*/
	      
	      // Sumamos uno para contar con el propio número en la sucesión
	      //longitudN1 = longitudN1 + 1;
	      //longitudN2 = longitudN2 + 1;

	      
	      System.out.println("distancia: " + distancia);
	      /*
	      System.out.println(n1 + " 1");
	      System.out.println(n2 + " 2");*/

	}

}