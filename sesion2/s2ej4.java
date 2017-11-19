import java.util.Scanner;
public class s2ej4 {
	public static void main (String[] args){
		Scanner in = new Scanner (System.in);
		int b500, b200, b100, b50, b20, b10, b5, m2, m1;
		System.out.println ("Teclee la cantidad de euros: ");
		int euros = in.nextInt();
		if (euros >= 500) {
			b500 = euros/500;
			euros = euros%500;
			System.out.println("Billetes 500€: " + b500);
		}
		if (euros >= 200) {
			b200 = euros/200;
			euros = euros%200;
			System.out.println("Billetes 200€: " + b200);
		}
		if (euros >= 100) {
			b100 = euros/100;
			euros = euros%100;
			System.out.println("Billetes 100€: " + b100);
		}
		if (euros >= 50) {
			b50 = euros/50;
			euros = euros%50;
			System.out.println("Billetes 50€: " + b50);
		}
		if (euros >= 20) {
			b20 = euros/20;
			euros = euros%20;
			System.out.println("Billetes 20€: " + b20);
		}
		if (euros >= 10) {
			b10 = euros/10;
			euros = euros%10;
			System.out.println("Billetes 10€: " + b10);
		}
		if (euros >= 5) {
			b5 = euros/5;
			euros = euros%5;
			System.out.println("Billetes 5€: " + b5);
		}
		if (euros >= 2) {
			m2 = euros/2;
			euros = euros%2;
			System.out.println("Billetes 2€: " + m2);
		}
		if (euros >= 1) {
			m1 = euros/1;
			euros = euros%1;
			System.out.println("Billetes 1€: " + m1);
		}
	}
}
