package triangulos;

import java.util.Scanner;

public class s6ej6 {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
	      int n;
	      do{
	        System.out.println ("Teclee un número: ");
	        n = in.nextInt();
	      }while ((n<=0)||(n>53));
	      
	      
	      int ast;
	      int fil=1;
	      int i = 1;
	      while (i<=n){
	        ast = 1;
	        while (ast<=fil && i<=n){
	        	ast++;
	        	if (i<10)
	        		System.out.print(i+"    ");
	        	else
	        		if (i<100)
	        			System.out.print(i+"   ");
	        		else
	            		if (i<1000)
	            			System.out.print(i+"  ");
	            		else
	            			System.out.print(i+" ");
	           i++;
	        }
	        System.out.println ("");
	        fil++;
	      }

	}

}
