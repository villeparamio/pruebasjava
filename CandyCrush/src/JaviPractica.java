//package CandyCrush;

import java.util.Scanner;
import java.lang.Math;
public class JaviPractica {

    private static Scanner in;
    
    public static void main(String[] args) {
    

	int tamano = 11;
        int jugadas = 10;
        int comprobar=0;
        int dificultad=0;
        int seleccion=0;
        int puntuacion=0;
        int puntuacion2=0;
        int [][] matriz = new int [tamano][tamano];
        int [][] matrizAux = new int [tamano][tamano];
        matrizAux=matriz;
        //Instanciar el tablero fijo
        int[][] tableroFijo = new int [tamano][tamano];
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

        Scanner in=new Scanner(System.in);

        System.out.println("Elige opcion: \n1-> Nivel Facil. " +
                                                         "\n2-> Nivel Intermedio. " +
                                                         "\n3-> Nivel Dificil. " +
                                                         "\n4-> Tablero Fijo. " + 
                                                         "\n0-> Salir. "); //Men˙ Juego
        
        try{
            seleccion = Integer.parseInt(in.nextLine()); //Pedir opcion del menu al usuario.
        }catch(Exception e){
            System.out.println("Error, introduzca un nivel valido.");
        }
        
        switch (seleccion){

        case 1:
                tableroRandom(3, matriz, matrizAux);
                matrizAux=copiaMatriz(matriz, matrizAux);
                imprimeMatriz(matriz, puntuacion);
                dificultad=3;
                break;
        case 2:
                tableroRandom(4, matriz, matrizAux);
                matrizAux=copiaMatriz(matriz, matrizAux);
                imprimeMatriz(matriz, puntuacion);
                dificultad=4;
                break;

        case 3:
                tableroRandom(5, matriz, matrizAux);
                matrizAux=copiaMatriz(matriz, matrizAux);
                imprimeMatriz(matriz, puntuacion);
                dificultad=5;
                break;
        case 4:
                matriz=tableroFijo;
                matrizAux=copiaMatriz(matriz, matrizAux);
                imprimeMatriz(matriz, puntuacion);
                dificultad=3;
                break;

        case 0:
                System.out.println("Hasta la proxima! ");
                jugadas = 0;
                break;

        default:
                System.out.println("Numero no reconocido");
                jugadas=0;
                break;
        }

        System.out.println("\n");
        
        while(jugadas!=0){                  //Bucle principal en el que se desarrolla el juego.
            System.out.println("Introduzca las coordenadas que desea cambiar: ");
            
            //Entrada de coordenadas
            in = new Scanner(System.in);

            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            
            if(x1==0 && x2==0 && y1==0 && y2==0){           //Salir
                jugadas=0;
                System.out.println("Fin del juego.");
            }else if(x1==y1 && x2==y2 ||x1<1 || x2 <1 || y1<1 || y2<1 ||x1>9 || x2>9 || y1>9 || y2>9 || ((Math.abs(y1-y2)!=1)&&(Math.abs(x1-x2)!=1))){ //Jugadas invalidas.
                System.out.println("Error, introduzca jugada valida.");
                imprimeMatriz(matriz, puntuacion);
            }else{
                int aux = matrizAux[x1][y1];
                matrizAux[x1][y1] = matriz[x2][y2];
                matrizAux[x2][y2] = aux;
                puntuacion2+=compruebaPunt(matrizAux, matriz, dificultad);
                if(puntuacion2==0){                //Si no ha habido puntuacion.
                    System.out.println("Movimiento sin efecto");
                    imprimeMatriz(matriz, puntuacion);
                    System.out.println("Turnos restantes: "+jugadas);
                }else{                                      //Si se detecta jugada con puntuacion.
                    jugadas-=1;
                    puntuacion+=puntuacion2;
                    matrizAux=recolocaMatriz(matrizAux, y1, y2, dificultad);
                    matriz=matrizAux;
                    imprimeMatriz(matrizAux, puntuacion);
                    System.out.println("Turnos restantes: "+jugadas);
                    puntuacion2=1;
                    
                    while(puntuacion2!=0){                  //Por si se generan mas jugadas cuando se rellena el vector de nuevo.
                        puntuacion2=compruebaPunt(matrizAux, matriz, dificultad);
                        puntuacion+=puntuacion2;
                        matrizAux=recolocaMatriz(matrizAux, y1, y2, dificultad);
                        matriz=matrizAux;
                        if(puntuacion2!=0){
                            imprimeMatriz(matrizAux, puntuacion);
                            System.out.println("Turnos restantes: "+jugadas);
                        }
                        
                    }
                    
                }
            }
            
        }

    }



//-------------METODOS-------------

    public static void tableroRandom(int dificultad, int matriz[][], int matrizAux[][]){       //Genera el tablero aleatoriamente
        int puntuacion=1;
        while(puntuacion!=0){
            for (int i=1; i<matriz.length; i++){
                    for (int j=1; j<matriz.length; j++){
                            matriz [i][j] = (int) (Math.random()*dificultad + 1);
                    }
            }puntuacion=compruebaPunt(matrizAux, matriz, dificultad);
        }   
    }


        public static void imprimeMatriz(int matriz[][], int puntuacion){   //Imprime el tablero de juego y la puntuacion.
            System.out.println("    1. 2. 3. 4. 5. 6. 7. 8. 9.");
            for (int i = 1; i < matriz.length-1; i++) { 
                System.out.print(i+". ");
                for (int j = 1; j < matriz.length-1; j++) {
                if (matriz[i][j] == 1){
                        System.out.print (" o ");
                }
                        if (matriz[i][j] == 2){
                                System.out.print (" * ");
                        }
                                if (matriz[i][j] == 3){
                                        System.out.print (" = ");
                                }
                                        if (matriz[i][j] == 4){
                                                System.out.print (" % ");
                                        }
                                                if (matriz[i][j] == 5){
                                                        System.out.print (" $ ");
                                                }
                }System.out.println();
            }System.out.println("Puntuacion: " + puntuacion);

        }	       
        
        //Devuelve la puntuacion que se ha realizado con el movimiento.
        public static int compruebaPunt (int [][] matrizAux, int [][]matriz, int dificultad){       
            int cont1, posI, posF, columna, colS, puntuacion;
            cont1=1;
            posI=0;
            posF=0;
            puntuacion=0;
            boolean jugada=false;
            for (int i=1; i<matriz.length-1; i++){
                columna=matrizAux[1][i];
                posI=1;
                for (int j=1; j<matriz.length-1; j++){
                        colS=matrizAux[j+1][i];
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
        
        //Devuelve la matriz con los valores nuevos despues de realizar una jugada.
        public static int [][]recolocaMatriz(int[][]matrizAux, int col1, int col2, int dificultad){
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
            columna=matrizAux[1][col];
            for (int i=col; i<col+2; i++){
                for (int j=1; j<matrizAux.length-1; j++){
                        colS=matrizAux[j+1][i];
                        if(cont1==3){
                            matrizAux[j-2][i]=0;
                            matrizAux[j][i]=0;
                            matrizAux[j-1][i]=0;
                            longitud[indice][0]=3;
                            longitud[indice][1]=0;
                            if((j-2)==1){
                                longitud[indice][1]=1;
                            }
                        }if(cont1==4){
                            matrizAux[j][i]=0;
                            longitud[indice][0]=4;
                        }if(cont1==5){
                            matrizAux[j][i]=0;
                            longitud[indice][0]=5;
                        }if(cont1==6){
                            matrizAux[j][i]=0;
                            longitud[indice][0]=6;
                        }if(cont1==7){
                            matrizAux[j][i]=0;
                            longitud[indice][0]=7;
                        }if(columna==colS){
                            cont1+=1;
                        }else{
                            cont1=1;
                            columna=colS;
                        }
                }indice+=1;
                cont1=1;
                columna=matrizAux[1][col+1];
                if (longitud.length==1){
                    i+=1;
                    indice-=1;
                }
            }
            indice=0;
            int auxIn;
            for (int i=col; i<col+2; i++){
                for (int j=1; j<matrizAux.length-1; j++){
                    auxIn=j;
                    if(matrizAux[j][i]==0){
                        if(longitud[indice][0]==3 && longitud[indice][1]!=1 && matrizAux[1][i]!=0){
                           while(auxIn!=1){
                               int aux = matrizAux[auxIn-1][i];
                                matrizAux[auxIn-1][i] = matrizAux[auxIn+2][i];
                                matrizAux[auxIn+2][i] = aux;
                                auxIn-=1;
                           }
                        }if(longitud[indice][0]==4 && longitud[indice][1]!=1&& matrizAux[1][i]!=0){
                            while(auxIn!=1){
                               int aux = matrizAux[auxIn-1][i];
                                matrizAux[auxIn-1][i] = matrizAux[auxIn+3][i];
                                matrizAux[auxIn+3][i] = aux;
                                auxIn-=1;
                           }
                        }if(longitud[indice][0]==5 && longitud[indice][1]!=1&& matrizAux[1][i]!=0){
                            while(auxIn!=1){
                               int aux = matrizAux[auxIn-1][i];
                                matrizAux[auxIn-1][i] = matrizAux[auxIn+4][i];
                                matrizAux[auxIn+4][i] = aux;
                                auxIn-=1;
                           }
                        }if(longitud[indice][0]==6 && longitud[indice][1]!=1&& matrizAux[1][i]!=0){
                            while(auxIn!=1){
                               int aux = matrizAux[auxIn-1][i];
                                matrizAux[auxIn-1][i] = matrizAux[auxIn+5][i];
                                matrizAux[auxIn+5][i] = aux;
                                auxIn-=1;
                           }
                        }if(longitud[indice][0]==7 && longitud[indice][1]!=1&& matrizAux[1][i]!=0){
                            while(auxIn!=1){
                               int aux = matrizAux[auxIn-1][i];
                                matrizAux[auxIn-1][i] = matrizAux[auxIn+6][i];
                                matrizAux[auxIn+6][i] = aux;
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
            
            for(int i=1; i<matrizAux.length-1;i++){
                for (int j=1; j<matrizAux.length-1; j++){
                    if(matrizAux[i][j]==0){
                        matrizAux[i][j]=(int) (Math.random()*dificultad + 1);
                    }
                }
            }
            
            return matrizAux;
        }
        
        public static int [][]copiaMatriz(int[][]matriz,int [][]matrizAux){
            for (int i=1; i<matriz.length; i++){
                for (int j=1; j<matriz.length; j++){
                    matrizAux [i][j] = matriz[i][j];
                }
            }
            return matrizAux;
        }
}





