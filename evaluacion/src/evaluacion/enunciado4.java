package evaluacion;

import java.util.Scanner;
public class enunciado4{

	public static long selector(long n1){
		long suma=1;

		for(int i=2;i<=(n1/2);i++){
			if(n1%i==0){
				suma+= i;
			}
		}
		if(suma==n1)
			return 1;
		if(suma<n1)
			return 2;
		else
			return 3;

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long num1,num2,tipoNumero=0, perfecto=0, deficiente=0, abundante=0;
		do{
			System.out.println ("Teclee el primer número: ");
			num1 = in.nextInt();
			System.out.println ("Teclee el segundo número: ");
			num2 = in.nextInt();
		}while((num1<=0)||(num2<=0));
		if(num1==1){
			deficiente++;
			num1++;
		}
		for (;num1<=num2;num1++) {
		tipoNumero=selector(num1);
			if(tipoNumero==1)
				perfecto++;
			if(tipoNumero==2)
				deficiente++;
			if(tipoNumero==3)
				abundante++;	
		}
		

		System.out.println("hay "+perfecto+" numeros perfectos "+deficiente+" numeros deficientes y "+ abundante+" numeros abundantes");
	}
}
