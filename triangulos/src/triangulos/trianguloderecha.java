package triangulos;

import java.util.Scanner;
  public class trianguloderecha{
    public static void main (String args[]){
      Scanner in = new Scanner (System.in);
      int n;
      do{
	        System.out.println ("Teclee un número de filas: ");
	        n = in.nextInt();
	  }while ((n<=0)||(n>53));
      int fil;
      int num;
      for (fil=1; fil<=n; fil++){
        for (int b=1; b<=(n-fil); b++){
        	System.out.print("  ");
        }
        num = fil;
        for (int i=1;i<=fil;i++){
        	System.out.print(num%10+" ");
        	num ++;
        }
        for (int i=1;i<=fil-1;i++){
        	System.out.print(num%10+" ");
        	num--;
        }
        System.out.println();
      }
    }
  }
  
