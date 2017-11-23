package evaluacion;

import java.util.Scanner;

public class enunciado2 {
	
	// Condiciones para que se cumpla la terna pitagorica
	public static boolean ternaPitagorica(long n1, long n2, long n3) {
		return (n1*n1+n2*n2==n3*n3)&&n1<n2&&n2<n3&&n1>0&&n2>0&&n3>0;
	}
	
	//	calculo de numeros
	public static void calculoNumero(long n1, long n2) {
		for (long i=1; i<n2;i++){
			for (long j=1; j<n2;j++){
				for (long k=1; k<n2; k++){
					if(ternaPitagorica(i, j, k)){
						if(i+j+j<=n2&&i+j+k>=n1){
							System.out.println(i+" "+j+" "+k);	
						}
					}
				}
			}
		}

	}
	
	public static void main(String[] args) {
		
		// Recogemos los valores por pantalla
		
		Scanner in = new Scanner (System.in);
		long n1;
		long n2;
		System.out.println ("Teclee el primer número: ");
		n1 = in.nextInt();
		System.out.println ("Teclee el segundo número: ");
		n2 = in.nextInt();
		
		calculoNumero(n1,n2);
	}
	
}
