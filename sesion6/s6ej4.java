import java.util.Scanner;
  public class s6ej4{
    public static void main (String args[]){
      Scanner in = new Scanner (System.in);
      int n;
      do{
        System.out.println ("Teclee el número de filas: ");
        n = in.nextInt();
      }while ((n<=0)||(n>53));
      int ast;
      int fil;
      for (fil=1; fil<=n; fil++){
        for (int blanco=1; blanco<=(n-fil); blanco ++)
          System.out.print(" ");
        for (ast=1; ast<=fil; ast++)
          System.out.print ("*");
        System.out.println ("");
      }
    }
  }
