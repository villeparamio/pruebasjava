package triangulos;

import java.util.Scanner;
  public class s6ej5{
    public static void main (String args[]){
      Scanner in = new Scanner (System.in);
      int n;
      do{
        System.out.println ("Teclee el número de filas: ");
        n = in.nextInt();
      }while ((n<=0)||(n>53));
      int ast;
      int fil;
      int i = 1;
      for (fil=1; fil<=n; fil++){
        for (ast=1; ast<=fil; ast++){
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
        System.out.println ();
      }
    }
  }
  
