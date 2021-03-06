package sesionEvaluacionV1;

import java.util.Scanner;

public class enunciado1 {
	
	// Declaramos la función que calcula la sucesión

    public static long sucesion (long n) {
    	long sucesion = 1;
    	while (n > 1){
    		if (n%2 == 0) {
			n = n / 2;
			} else {
	  			n = n*3+1;
			}
			sucesion++;
    	}
    	return sucesion;
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
	      
	      // Colocamos el número más alto primero
	      long longitudMax = 0;
	      if (n1 > n2){
	    	  for (long contador = n2;n1>contador;contador++){
		    	  long sucesion = sucesion(contador);
		    	  // Si la sucesión es mayor a la longitud actual actualizamos el valor por el obtenido
		    	  if (sucesion > longitudMax) {
		    	  	longitudMax = sucesion;
		    	  }
	    	  }
	      } else if (n1 < n2) {
	    	  for (long contador = n1;n2>contador;contador++){
		    	  long sucesion = sucesion(contador);
		    	  if (sucesion > longitudMax) {
		    	  	longitudMax = sucesion;
		    	  }
	    	  }
	      } else {
		      longitudMax = sucesion(n1);
	      }	      
	      System.out.println("La longitud máxima de la cadena es: " + longitudMax);
	}

}
