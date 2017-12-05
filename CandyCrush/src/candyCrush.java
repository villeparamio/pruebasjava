import java.util.Scanner;
import java.awt.Point;

public class candyCrush {
	
	// Muestra el menú del juegp
	public static void menu (){
		System.out.println("Elija el tipo de tablero: ");
		System.out.println("\t1. Fácil");
		System.out.println("\t2. Intermedio");
		System.out.println("\t3. Difícil");
		System.out.println("\t4. Tablero fijo");
		System.out.println("\t0. Salir");		
	}
	
	public static void tableroFijo () {
		// Función que muestra el tablero fijo
		
		String tablero [][] =  {{"-","-","-","-","-","-","-","-","-","-","-"},
								{"|","2","1","1","1","1","1","1","1","1","|"},
								{"|","1","2","2","2","1","2","2","2","1","|"},
								{"|","3","2","3","3","3","1","3","3","3","|"},
								{"|","1","1","1","1","1","1","1","1","1","|"},
								{"|","2","2","2","2","1","2","2","1","3","|"},
								{"|","3","3","3","3","3","3","3","3","1","|"},
								{"|","1","1","2","1","3","1","1","1","1","|"},
								{"|","2","2","1","2","2","2","2","1","2","|"},
								{"|","3","2","1","3","3","3","3","3","1","|"},
								{"|","-","-","-","-","-","-","-","-","-","|"}};
		
		int nfilas = tablero.length, ncolumnas = tablero[0].length;  
		for (int i=0;i<nfilas;i++){
            for (int j=0;j<ncolumnas;j++){
                System.out.print(tablero[i][j]+ " ");
            }
            System.out.println("");
        }
        System.out.println("");
	}
	
	public static Point primerPunto () {
		Scanner in = new Scanner(System.in);
		int primero, segundo;
		do {
			System.out.println("introduzca 2 números para el primer punto");
			primero = in.nextInt();
			segundo = in.nextInt();			
		} while (primero < 1 || primero > 10 || segundo < 1 || segundo > 10);
		Point punto = new Point (primero, segundo);
		in.close();
		return punto;
	}
	
	public static Point segundoPunto () {
		Scanner in = new Scanner(System.in);
		int tercero, cuarto;
		do {
			System.out.println("introduzca 2 números para el segundo punto");
			tercero = in.nextInt();
			cuarto = in.nextInt();			
		} while (tercero < 1 || tercero > 10 || cuarto < 1 || cuarto > 10);
		Point punto = new Point (tercero, cuarto);
		in.close();
		return punto;
	}
	
	public static void main(String[] args) {
		
		// Declaracion de variables
		Scanner in = new Scanner(System.in);
		int nMenu, colores;
		
		
		do {
			menu();
			nMenu = in.nextInt();
		} while (nMenu < 0 || nMenu > 4);
			System.out.println("El número elegido es: " + nMenu);
			switch (nMenu) {
				case 0:
					System.out.println("Hasta luego Lucas");
					break;
				case 1:
					colores = 3;
					break;
				case 2:
					colores = 4;
					break;
				case 3:
					colores = 5;
					break;
				case 4:
					tableroFijo();
					Point punto1 = new Point(primerPunto());
					Point punto2 = new Point(segundoPunto());
					System.out.println("Primer punto es: "+ punto1.x + " " + punto1.y);
					System.out.println("Segundo punto es: "+ punto2.x + " " + punto2.y);
					break;
			}		
			in.close();
	}

}
