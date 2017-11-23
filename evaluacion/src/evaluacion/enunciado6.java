package evaluacion;
import java.util.Scanner;
public class enunciado6 {
	
	//Creamos la funcion del maximo comun divisor para calcular el minimo comun multiplo
	public static long mcd (long num1, long num2){
		long mcd,a,b;		
		if (num1>num2){	
			a=num1;
			b=num2;
		}else{
			a=num2;
			b=num1;
		}
		
		do {
			mcd=b;
			b=a%b;
			a=mcd;
		} while (b!=0);
		return mcd;
	}
	
	//Función para calcular el minimo comun multiplo
	public static long mcm (long num1, long num2){
		long mcm=0,a,b;
		if (num1>num2){
			a=num1;
			b=num2;
		}else{
			a=num2;
			b=num1;
		}
		
		mcm = (a*b)/mcd(a,b);
		return mcm;
	}
	
	public static void main(String args[]) {
	Scanner keyboard=new Scanner(System.in);
	
	long numero,numero2;
	do{
	System.out.print("Introduzca un número entero mayor que 1: ");
	numero2=keyboard.nextLong();
	System.out.print("Introduzca un número entero mayor que 1: ");
	numero=keyboard.nextLong();
	}
	while (numero2<=1||numero<=1);   //Para evitar los números menores iguales que 1 o más grandes que un long
	
	long y=1;
	long x = numero2;
	for (;x<=numero;x++){	//la tabla empieza en 2
		mcm(x,y);
		y=mcm(x,y);
		System.out.println(x+ "\t"+mcm(x,y));
		}
	keyboard.close();
	}
}