package evaluacion;

import java.util.Scanner;
public class enunciado5{

	public static boolean primoEntreAmbos(long minimo, long sucesion){
		long mcd;
		do{
			mcd=sucesion;
			
			sucesion=minimo%sucesion;
			minimo=mcd;
		}while(sucesion!=0);
		
		
		if(mcd==1)
			return true;
		else
			return false;

	}	
	public static boolean primo(long sucesion){
		
		if(sucesion==2)
			return true;
		if(sucesion%2==0)
			return false;
		for (long i=3;i<sucesion ;i+=2 ) {
			if(sucesion%i==0)
				return false;
			
		}
		return true;
	}

	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		long maximo;
		boolean raro = true;
		do{
			System.out.println("escriba un numero entero positivo");
			maximo=teclado.nextLong();
			
		}while(maximo<=0);
		for (long minimo=3;minimo<=maximo ;minimo++ ) {
			raro= true;
			for (long sucesion=2;sucesion<minimo ;sucesion++ ) {
				if(primoEntreAmbos(minimo,sucesion)){
					if (!primo(sucesion)){
						sucesion= minimo;
						raro=false;
					}
				}
					
			}
			if(raro== true)
				System.out.print(minimo+" ");

			
		}
	}
		
}
