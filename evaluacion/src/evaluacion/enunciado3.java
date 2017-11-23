package evaluacion;

import java.util.Scanner;

public class enunciado3 {
	
	public static long cifraMenor(long n){
		long numero=1;
		for(long i=n-1;i>0;i--){
			numero*=10;
		}
		return numero;
		
	}
	
	public static boolean esPrimo(long n){
		long a = 0;
		for(long i=1;i<(n+1);i++){
	         if(n%i==0){
	             a++;
	            }
	         }
	         if(a!=2){
	              return false;
	            }else{
	                return true;
	         }
		
	}
	
	public static boolean esPalindromo(long n){
		String numero = ""+n;
		int indiceIzq = 0;
		int indiceDer = numero.length()-1;
		boolean correcto = true;
		while(indiceIzq!=indiceDer&&correcto&&indiceIzq<numero.length()&&indiceDer>=0){
			correcto = numero.charAt(indiceIzq)==numero.charAt(indiceDer);
			indiceIzq ++;
			indiceDer--;				
		}
		return correcto;
	}

	public static void main(String[] args){

		// Recogemos los valores por pantalla
		
		Scanner in = new Scanner (System.in);
		long n;
		System.out.println ("Teclee el un número positivo: ");
		n = in.nextInt();
		long menor = cifraMenor(n);
		long mayor = cifraMenor(n+1);
		long total=0;
		for (long i=menor;i<mayor;i++){
			if(esPrimo(i)&&esPalindromo(i)){
				total ++;
			}
		}
		System.out.println(total);
		
	}
}
