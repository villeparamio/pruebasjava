import java.awt.Point;
import java.util.Scanner;

public class candyCrush {
	
	// Constante que indica el tamaño del tablero
	static final int tamañoTablero = 9;

	// Muestra el menú del juegp
	public static void menu (){
		System.out.println("Elija el tipo de tablero: ");
		System.out.println("\t1. Fácil");
		System.out.println("\t2. Intermedio");
		System.out.println("\t3. Difícil");
		System.out.println("\t4. Tablero fijo");
		System.out.println("\t0. Salir");
	}

	// Función que genera el tablero fijo
	public static int[][] tableroFijo () {
		int tablero [][] =     {{0,0,0,0,0,0,0,0,0,0,0},
								{0,2,1,1,1,1,1,1,1,1,0},
								{0,1,2,2,2,1,2,2,2,1,0},
								{0,3,2,3,3,3,1,3,3,3,0},
								{0,1,1,1,1,1,1,1,1,1,0},
								{0,2,2,2,2,1,2,2,1,3,0},
								{0,3,3,3,3,3,3,3,3,1,0},
								{0,1,1,2,1,3,1,1,1,1,0},
								{0,2,2,1,2,2,2,2,1,2,0},
								{0,3,2,1,3,3,3,3,3,1,0},
								{0,0,0,0,0,0,0,0,0,0,0}};
		return tablero;
	}
	
	// Función que genera el tablero de juego de acuerdo a las especificaciones
	public static int[][] generarTablero (int n){
		
		int tablero[][] = new int[tamañoTablero+2][tamañoTablero+2];
    
        for(int i=1; i<tablero.length-1; i++) {
            for(int j=1; j<tablero[0].length-1; j++) {  // recorro la matriz
                tablero[i][j] = (int) (Math.random()*n+1);  //relleno aleatoriamente
            }
        }
        return tablero;
	}
	
	// Método que muestra el tablero de juego
	public static void mostrarTablero (int tablero[][]){
        
        int nfilas = tablero.length, ncolumnas = tablero[0].length;
    	System.out.println("       1  2  3  4  5  6  7  8  9");
    	
		for (int i=0;i<nfilas;i++){
			if (i <= tamañoTablero && i > 0){
				System.out.print(" "+ i +" ");
			} else {
				System.out.print("   ");
			}
            for (int j=0;j<ncolumnas;j++){
            		
        		switch (tablero[i][j]) {
            	case 1:
            		System.out.print(" @ ");
            		break;
            	case 2:
            		System.out.print(" # ");
            		break;
            	case 3:
            		System.out.print(" $ ");
            		break;
            	case 4:
            		System.out.print(" € ");
            		break;
            	case 0:
            		System.out.print(" ~ ");
        		}
            }
            System.out.println("");
        }
        System.out.println("");
		
    }
	
	public static void comprobarTablero (int tablero[][]){
		int nfilas = tablero.length, ncolumnas = tablero[0].length, contador = 0, anterior=0;
		for (int j=1;j<ncolumnas-1;j++){
			for (int i=1;i<nfilas-1;i++){
				System.out.println(tablero[i][j]);
	        }
        }
	}
	
	public static int[][] intercambiar(int tablero[][]){
		Point punto1, punto2;
		do {
			System.out.println("Introduzca un intercambio válido");
			punto1 = new Point(primerPunto());
			punto2 = new Point(segundoPunto());
		} while (((punto1.x)+1 != punto2.x && (punto1.x)-1 != punto2.x && punto1.x != punto2.x)||
				 ((punto1.y)+1 != punto2.y && (punto1.y)-1 != punto2.y && punto1.y != punto2.y));
		int c1, c2;
		c1 = tablero[punto1.x][punto1.y];
		c2 = tablero[punto2.x][punto2.y];
		tablero[punto2.x][punto2.y] = c1;
		tablero[punto1.x][punto1.y] = c2;
		mostrarTablero(tablero);
		return tablero;
	}
	
	// Función que recoge el primer punto por pantalla
	public static Point primerPunto () {
		Scanner in = new Scanner(System.in);
		int primero, segundo;
		do {
			System.out.println("introduzca 2 números para el primer punto");
			primero = in.nextInt();
			segundo = in.nextInt();	
		} while (primero < 1 || primero > tamañoTablero+1 || segundo < 1 || segundo > tamañoTablero+1);
		Point punto = new Point (primero, segundo);
		return punto;
	}

	//Función que recoge el segundo punto por pantalla
	public static Point segundoPunto () {
		Scanner in = new Scanner(System.in);
		int tercero, cuarto;
		do {
			System.out.println("introduzca 2 números para el segundo punto");
			tercero = in.nextInt();
			cuarto = in.nextInt();
		} while (tercero < 1 || tercero > tamañoTablero+1 || cuarto < 1 || cuarto > tamañoTablero+1);
		Point punto = new Point (tercero, cuarto);
		return punto;
	}

	public static void main(String[] args) {

		// Declaracion de variables
		Scanner in = new Scanner(System.in);
		int nMenu, colores, puntos, movimientos = 0;


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
					int[][] tablero1 = generarTablero(colores);
					mostrarTablero(tablero1);
					tablero1 = intercambiar(tablero1);
					break;
				case 2:
					colores = 4;
					int[][] tablero2 = generarTablero(colores);
					mostrarTablero(tablero2);
					break;
				case 3:
					colores = 5;
					int[][] tablero3 = generarTablero(colores);
					mostrarTablero(tablero3);
					break;
				case 4:
					int[][] tablero4 = tableroFijo();
					mostrarTablero(tablero4);
					comprobarTablero(tablero4);
					Point punto1 = new Point(primerPunto());
					Point punto2 = new Point(segundoPunto());
					System.out.println("Primer punto es: "+ punto1.x + " " + punto1.y);
					System.out.println("Segundo punto es: "+ punto2.x + " " + punto2.y);
					break;
			}
			in.close();
	}

}
