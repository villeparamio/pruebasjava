
public class imprimirHoras {

	public static void printTime (int hora, int min) {
		System.out.println (hora+":"+min);
	}

	public static void main (String args []) {
		int h = (int) Math.floor ( Math.random() *24);
		int m = (int) Math.floor ( Math.random() *60);
		pintTime (h, m);
		printTime (12, 23);
	}

}

