public class ejemploCrearFuncion {

	public static double mix (int a, int b, int c) {
		double resultado = a + b / (double) c;
		return resultado;
	}

	public static void main (String args []) {
		System.out.println (mix (4,1,3));
		double d = mix (10,1,3) + mix(3,2,4);
	}

}

