
import java.util.Scanner;

public class davpara {
	
	//Creamos la función para hayar el minimo común multiplo
	public static long mcm (long n1, long n2) {
		long mcm=0,a,b;
		if (n1 > n2){
			a = n1;
			b = n2;
		} else {
			a = n2;
			b = n1;
		}
		
		mcm = (a * b) / mcd(a, b);
		return mcm;
	}
	
	//Creamos la función del máximo común divisor
	public static long mcd (long n1, long n2){
		long mcd, a, b;		
		if (n1 > n2) {
			a = n1;
			b = n2;
		} else {
			a = n2;
			b = n1;
		}
		
		do {
			mcd = b;
			b = a % b;
			a = mcd;
		} while (b != 0);
		return mcd;
	}
	
	//Creamos la función que calcula todos los números y se queda con el último
	public static long calcular (long n1, long n2) {
		long y = 1;
		long mostrar = 0;
		for (long x = n1; x <= n2; x++){
			mcm(x, y);
			y = mcm(x, y);
			mostrar = mcm(x, y);
			}
		return mostrar;
	}

	public static void main (String[] args) {
		
		//Recogemos los valores por pantalla
		Scanner in = new Scanner(System.in);
		long n1, n2;
		
		//Comprobamos que los números sean positivos
		do {
			System.out.print("Introduzca el primer número: ");
			n1 = in.nextLong();
			System.out.print("Introduzca el segundo número: ");
			n2 = in.nextLong();
		} while (n1 <= 1 || n2 <= 1);
		
		//Mostramos en pantalla el último número calculado
		System.out.println(calcular(n1, n2));
		in.close();
	}

}
