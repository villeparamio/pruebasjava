import java.awt.Point;
import java.util.Scanner;

public class candyCrush {
	
	// Constante que indica el tamaño del tablero
	static int tamanoTablero = 9;

	// Muestra el menú del juegp
	public static void menu (){
		System.out.println("Elija el tipo de tablero: ");
		System.out.println("\t1. Fácil");
		System.out.println("\t2. Intermedio");
		System.out.println("\t3. Difícil");
		System.out.println("\t4. Tablero fijo");
		System.out.println("\t0. Salir");
	}
	
	// Función que genera el tablero de juego de acuerdo a las especificaciones
	public static void generarTablero(int dificultad, int tablero[][], int tableroAux[][]){
        int puntuacion=1;
        while(puntuacion!=0){
            for (int i=1; i<tablero.length; i++){
                    for (int j=1; j<tablero.length; j++){
                            tablero [i][j] = (int) (Math.random()*dificultad + 1);
                    }
            }puntuacion=compruebaPunt(tableroAux, tablero, dificultad);
        }   
    }
	
	//Devuelve la puntuacion que se ha realizado con el movimiento.
    public static int compruebaPunt (int [][] tableroAux, int [][]tablero, int dificultad){       
    	int cont1, posI, posF, columna, colS, puntuacion;
        cont1=1;
        posI=0;
        posF=0;
        puntuacion=0;
        boolean jugada=false;
        for (int i=1; i<tablero.length-1; i++){
            columna=tableroAux[1][i];
            posI=1;
            for (int j=1; j<tablero.length-1; j++){
                    colS=tableroAux[j+1][i];
                    if(cont1==3){
                        jugada=true;
                        puntuacion+=10;
                        posF=j;
                    }if(cont1==4){
                        puntuacion+=10;
                        posF=j;
                    }if(cont1==5){
                        puntuacion+=10;
                        posF=j;
                    }if(cont1==6){
                        puntuacion+=10;
                        posF=j;
                    }if(cont1==7){
                        puntuacion+=10;
                        posF=j;
                    }if(columna==colS){
                        cont1+=1;
                    }else{
                        cont1=1;
                        columna=colS;
                        posI=j+1;
                    }
            }cont1=1;
        }if(jugada==false){
            return puntuacion=0; 
        }else{
            return puntuacion;
        }     
    }
	
	// Método que muestra el tablero de juego
	public static void mostrarTablero (int tablero[][], int puntuacion){
		System.out.println("    1. 2. 3. 4. 5. 6. 7. 8. 9.");
        for (int i = 1; i < tablero.length-1; i++) { 
            System.out.print(i+". ");
            for (int j = 1; j < tablero.length-1; j++) {
            if (tablero[i][j] == 1){
                    System.out.print (" o ");
            }
                    if (tablero[i][j] == 2){
                            System.out.print (" * ");
                    }
                            if (tablero[i][j] == 3){
                                    System.out.print (" = ");
                            }
                                    if (tablero[i][j] == 4){
                                            System.out.print (" % ");
                                    }
                                            if (tablero[i][j] == 5){
                                                    System.out.print (" $ ");
                                            }
            }System.out.println();
        }System.out.println("Puntuacion: " + puntuacion);
    }
	
	public static void comprobarTablero (int tablero[][]){
		int nfilas = tablero.length, ncolumnas = tablero[0].length, contador = 0, anterior=0;
		for (int j=1;j<ncolumnas-1;j++){
			for (int i=1;i<nfilas-1;i++){
				System.out.println(tablero[i][j]);
	        }
        }
	}
	
	// Función que recoge el primer punto por pantalla
	public static Point primerPunto () {
		Scanner in = new Scanner(System.in);
		int primero, segundo;
		do {
			System.out.println("introduzca 2 números para el primer punto");
			primero = in.nextInt();
			segundo = in.nextInt();	
		} while (primero < 1 || primero > tamanoTablero+1 || segundo < 1 || segundo > tamanoTablero+1);
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
		} while (tercero < 1 || tercero > tamanoTablero+1 || cuarto < 1 || cuarto > tamanoTablero+1);
		Point punto = new Point (tercero, cuarto);
		return punto;
	}
	
	//
	public static int [][]copiaTablero(int[][]tablero,int [][]tableroAux){
        for (int i=1; i < tablero.length; i++){
            for (int j=1; j < tablero.length; j++){
                tableroAux [i][j] = tablero[i][j];
            }
        }
        return tableroAux;
    }
    
	//Devuelve la tablero con los valores nuevos despues de realizar una jugada.
    public static int [][]recolocatablero(int[][]tableroAux, int col1, int col2, int dificultad){
        int cont1, columna, colS,col, puntuacion;
        cont1=1;
        puntuacion=0;
        int tam=2;
        int indice=0;
        if(col1<col2){
            col=col1; 
        }else if(col2<col1){
            col=col2;
        }else{
            col=col1;
        }
        int longitud[][]=new int [tam][tam];
        columna=tableroAux[1][col];
        for (int i=col; i<col+2; i++){
            for (int j=1; j<tableroAux.length-1; j++){
                    colS=tableroAux[j+1][i];
                    if(cont1==3){
                        tableroAux[j-2][i]=0;
                        tableroAux[j][i]=0;
                        tableroAux[j-1][i]=0;
                        longitud[indice][0]=3;
                        longitud[indice][1]=0;
                        if((j-2)==1){
                            longitud[indice][1]=1;
                        }
                    }if(cont1==4){
                        tableroAux[j][i]=0;
                        longitud[indice][0]=4;
                    }if(cont1==5){
                        tableroAux[j][i]=0;
                        longitud[indice][0]=5;
                    }if(cont1==6){
                        tableroAux[j][i]=0;
                        longitud[indice][0]=6;
                    }if(cont1==7){
                        tableroAux[j][i]=0;
                        longitud[indice][0]=7;
                    }if(columna==colS){
                        cont1+=1;
                    }else{
                        cont1=1;
                        columna=colS;
                    }
            }indice+=1;
            cont1=1;
            columna=tableroAux[1][col+1];
            if (longitud.length==1){
                i+=1;
                indice-=1;
            }
        }
        indice=0;
        int auxIn;
        for (int i=col; i<col+2; i++){
            for (int j=1; j<tableroAux.length-1; j++){
                auxIn=j;
                if(tableroAux[j][i]==0){
                    if(longitud[indice][0]==3 && longitud[indice][1]!=1 && tableroAux[1][i]!=0){
                       while(auxIn!=1){
                           int aux = tableroAux[auxIn-1][i];
                            tableroAux[auxIn-1][i] = tableroAux[auxIn+2][i];
                            tableroAux[auxIn+2][i] = aux;
                            auxIn-=1;
                       }
                    }if(longitud[indice][0]==4 && longitud[indice][1]!=1&& tableroAux[1][i]!=0){
                        while(auxIn!=1){
                           int aux = tableroAux[auxIn-1][i];
                            tableroAux[auxIn-1][i] = tableroAux[auxIn+3][i];
                            tableroAux[auxIn+3][i] = aux;
                            auxIn-=1;
                       }
                    }if(longitud[indice][0]==5 && longitud[indice][1]!=1&& tableroAux[1][i]!=0){
                        while(auxIn!=1){
                           int aux = tableroAux[auxIn-1][i];
                            tableroAux[auxIn-1][i] = tableroAux[auxIn+4][i];
                            tableroAux[auxIn+4][i] = aux;
                            auxIn-=1;
                       }
                    }if(longitud[indice][0]==6 && longitud[indice][1]!=1&& tableroAux[1][i]!=0){
                        while(auxIn!=1){
                           int aux = tableroAux[auxIn-1][i];
                            tableroAux[auxIn-1][i] = tableroAux[auxIn+5][i];
                            tableroAux[auxIn+5][i] = aux;
                            auxIn-=1;
                       }
                    }if(longitud[indice][0]==7 && longitud[indice][1]!=1&& tableroAux[1][i]!=0){
                        while(auxIn!=1){
                           int aux = tableroAux[auxIn-1][i];
                            tableroAux[auxIn-1][i] = tableroAux[auxIn+6][i];
                            tableroAux[auxIn+6][i] = aux;
                            auxIn-=1;
                       }
                    }
                }else{
                    auxIn=j;
                }
            }indice+=1;
            if (longitud.length==1){
                i+=1;
            }
        }
        
        for(int i=1; i<tableroAux.length-1;i++){
            for (int j=1; j<tableroAux.length-1; j++){
                if(tableroAux[i][j]==0){
                    tableroAux[i][j]=(int) (Math.random()*dificultad + 1);
                }
            }
        }
        
        return tableroAux;
    }

	public static void main(String[] args) {

		// Declaracion de variables
		Scanner in = new Scanner(System.in);
		int nMenu, jugadas = 10, comprobar = 0, seleccion = 0, dificultad = 0, puntuacion = 0, puntuacion2 = 0;
		tamanoTablero++;
		int [][] tablero = new int [tamanoTablero+1][tamanoTablero+1];
        int [][] tableroAux = new int [tamanoTablero+1][tamanoTablero+1];
        tableroAux=tablero;
        
        int[][] tableroFijo = new int [9+2][9+2];
        String tFijo= "211111111122212221323331333111111111222212213333333331112131111221222212321333331";
        int indice=0;
        int c;
        int k;
        for(int i=1; i<10; i++){
            for (int j=1; j<10; j++){
                c = Integer.parseInt(String.valueOf(tFijo.charAt(indice)) );
                indice+=1;
                tableroFijo[i][j]=c;
            }
        }


		do {
			menu();
			nMenu = in.nextInt();
		} while (nMenu < 0 || nMenu > 4);
			System.out.println("El número elegido es: " + nMenu);
			switch (nMenu) {
				case 0:
					System.out.println("Hasta luego Lucas");
					jugadas = 0;
					break;
				case 1:
					dificultad = 3;
					generarTablero(dificultad, tablero, tableroAux);
					tableroAux=copiaTablero(tablero, tableroAux);
					mostrarTablero(tablero, puntuacion);
					break;
				case 2:
					dificultad = 4;
					generarTablero(dificultad, tablero, tableroAux);
					tableroAux=copiaTablero(tablero, tableroAux);
					mostrarTablero(tablero, puntuacion);
					break;
				case 3:
					dificultad = 5;
					generarTablero(dificultad, tablero, tableroAux);
					tableroAux=copiaTablero(tablero, tableroAux);
					mostrarTablero(tablero, puntuacion);
					break;
				case 4:
					tablero = tableroFijo;
					tableroAux=copiaTablero(tablero, tableroAux);
					mostrarTablero(tablero, puntuacion);
					break;
			}
			
			while (jugadas != 0) {
				Point punto1 = new Point(primerPunto());
				Point punto2 = new Point(segundoPunto());
				
				if (punto1.x == 0 && punto1.y == 0 && punto2.x == 0 && punto2.y == 0){
					jugadas = 0;
					System.out.println("Final del juego");
				}else if(punto1.x==punto1.y && punto2.x==punto2.y
						|| punto1.x<1 || punto2.x <1
						|| punto1.y<1 || punto2.y<1
						|| punto1.x>tamanoTablero || punto2.x>tamanoTablero
						|| punto1.y>tamanoTablero || punto2.y>tamanoTablero
						|| ((Math.abs(punto1.y-punto2.y)!= 1)
						&& (Math.abs(punto1.x-punto2.x)!= 1))) { //Jugadas invalidas.
					
	                System.out.println("Error, introduzca jugada valida.");
	                mostrarTablero(tablero, puntuacion);
	            }else{
	                int aux = tableroAux[punto1.x][punto1.y];
	                tableroAux[punto1.x][punto1.y] = tablero[punto2.x][punto2.y];
	                tableroAux[punto2.x][punto2.y] = aux;
	                puntuacion2+=compruebaPunt(tableroAux, tablero, dificultad);
	                
	              //Si no ha habido puntuacion.
	                if(puntuacion2==0){
	                    System.out.println("Movimiento sin efecto");
	                    mostrarTablero(tablero, puntuacion);
	                    System.out.println("Turnos restantes: "+jugadas);
	                
	                //Si se detecta jugada con puntuacion.
	                }else{
	                    jugadas-=1;
	                    puntuacion+=puntuacion2;
	                    tableroAux=recolocatablero(tableroAux, punto1.y, punto2.y, dificultad);
	                    tablero=tableroAux;
	                    mostrarTablero(tableroAux, puntuacion);
	                    System.out.println("Turnos restantes: "+jugadas);
	                    puntuacion2=1;
	                    
	                    //Por si se generan mas jugadas cuando se rellena el vector de nuevo.
	                    while(puntuacion2!=0){
	                        puntuacion2=compruebaPunt(tableroAux, tablero, dificultad);
	                        puntuacion+=puntuacion2;
	                        tableroAux=recolocatablero(tableroAux, punto1.y, punto2.y, dificultad);
	                        tablero=tableroAux;
	                        if(puntuacion2!=0){
	                            mostrarTablero(tableroAux, puntuacion);
	                            System.out.println("Turnos restantes: "+jugadas);
	                        }
	                        
	                    }
	                }
	            }
			}
			
			in.close();
	}

}
