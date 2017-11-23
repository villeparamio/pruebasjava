package evaluacion;

import java.util.Scanner;

public class enunciado6 {
	
	public static long mcd(long n1, long n2){
        long a = Math.max(n1, n2);
        long b = Math.min(n1, n2);
        long res;        
        do {
            res = b;
            b = a%b;
            a = res;
        } while (b!=0);
        return res;
	}
	
    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       System.out.println("Ingrese el primer número");
       long n1 = scan.nextInt();
       System.out.println("Ingrese el segundo número");
       long n2 = scan.nextInt();
       System.out.println(mcd(n1, n2));
        
    }
}
