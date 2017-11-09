// ejercicio 29
// funcion mayusc
/*

	Entradas: carácter (letra) char
	Salidas: mayuscula correspondiente tipo char
	PRE: la entrada debe ser minuscula l es minúscula alfabeto inglés
	obs:
	bp:

	USO:
		char c;
			c=mayusc('b');
		
*/

public static char mayusc (char l){
	//Devuelve la mayuscula
	//l es una minuscula

	return (char) (l- 'a' + 'A')
}
public static main (){
	System.out.println(mayusc('b'))
}