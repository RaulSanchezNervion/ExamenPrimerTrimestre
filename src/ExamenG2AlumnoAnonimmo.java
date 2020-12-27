/* Buenas profesor, antes de nada queria decirle que estoy
 * orgulloso de estudiar en el IES Nervion y soy fan de la
 * asigantura de programacion, y por supuesto voy a regalarle 
 * un jamon 5J
 * 
 * No he utilizado tildes en los comentarios, por cuestiones
 * de encoding.
 * 
 */

public class ExamenG2AlumnoAnonimmo {

	public static void main(String[] args) {
		System.out.println("Ejercicio 1");
		System.out.println(printPath(0, 0, 2, 0));
		System.out.println(printPath(0, 0, 13, -13));
		System.out.println(printPath(0, 0, 3, -4));
		System.out.println(printPath(0, 0, -6, 2));
		
		System.out.println();
		System.out.println("Ejercicio 2");
		printParallelogram(1,5,true);
		printParallelogram(6,3,true);
		printParallelogram(1,9,false);
		printParallelogram(4,5,false);
		
		System.out.println();
		System.out.println("Ejercicio 3");
		printNumberSeries(1);
		printNumberSeries(35);
		printNumberSeries(1001);
	}

	/***************************************************
				EJERCICIO 1
	 ******************************************************/
	
	/*
	 * Precondicion: Ninguna
	 * Postcondicion: El metodo va a imprimir por pantalla el camino mas corto en un sistema cartesiano
	 *  (unicamente pasando por los puntos con valores enteros) entre las coordenadas
	 *  ( xOrigin, yOrigin) y (xEnd, yEnd). Adicionalmente, se va a devolver el numero de pasos
	 *  de dicho camino. El resultado devuelto=max(|xOrigin-xEnd|,|yOrigin-yEnd|)
	 *  Entradas: int xOrigin, int yOrigin, int xEnd, int yEnd
	 *  Salida: int (numero de pasos)
	 *  
	 *   
	 *   NOTA: En este ejercicio, la clave estaba en darse cuenta que por cuestiones de eficiencia
	 *    se debian tratar la X y la Y por separado, en lugar de comprobar las
	 *   8 posibilidades de movimientos de forma conjunta.
	 */
	 
	public static int printPath(int xOrigin, int yOrigin, int xEnd, int yEnd) {
		int steps=0;//Inicializo el numero de pasos a cero
		System.out.println("Origin: ("+xOrigin+","+yOrigin+")");
		while(xOrigin!=xEnd || yOrigin!=yEnd) {//Mientras no hayamos llegado al destino
			xOrigin=nextStep(xOrigin,xEnd);//Modifico la x, en caso de ser necesario
			yOrigin=nextStep(yOrigin,yEnd);//Modifico la y, en caso de ser necesario
			printStep(xOrigin,yOrigin,xEnd,yEnd);//Imprimo el nuevo paso del camino
			steps++;//Incremento en uno el numero de pasos.
		}
		return steps;
	}
	
	/*
	 * Precondicion: Ninguna
	 * Postcondicion: El presente procedimiento imprime por pantalla la coordenada
	 * (xCoordinate, yCoordinate), teniendo en cuenta que si es la coordenada final (xEnd, yEnd),
	 * lo indicara añadiendo la palabra End:.
	 *  Entradas: int xCoordinate, int yCoordinate, int xEnd, int yEnd
	 *  Salida: Ninguna
	 */
	private static void printStep(int xCoordinate, int yCoordinate, int xEnd, int yEnd) {
		if (xCoordinate==xEnd && yCoordinate==yEnd) //Si es la coordenada final
			System.out.println("End: ("+xEnd+","+yEnd+")");
		else //En otro caso	
			System.out.println("("+xCoordinate+","+yCoordinate+")");
	}

	/*
	 * Precondicion: Ninguna
	 * Postcondicion: Se va a devolver el valor de la coordenada originCoordinate
	 *  reduciendo su diferencia respecto a la coordenada endCoordinate en una unidad. 
	 *  En caso de no existir diferencia, se devolvera el valor inicial de originCoordinate
	 *  Entradas: int originCoordinate, int endCoordinate
	 *  Salida: int 
	 */
	private static int nextStep(int originCoordinate, int endCoordinate) {
		if(originCoordinate>endCoordinate) {//Si la coordenada es mayor a la del destino
			originCoordinate--;//Decremento la coordenada
		}
		else {//Si la coordenada es menor o igual
			if(originCoordinate<endCoordinate) {//Si la coordenada es menor que la del destino
				originCoordinate++;//Incremento la coordenada
			}
		}
		return originCoordinate;
	}

	/***************************************************
				EJERCICIO 2
	 ******************************************************/
	
	/*
	 * Precondicion: altura y base deben ser mayores que cero, y altura no puede ser mayor de 9
	 * Postcondicion: El metodo imprime por pantalla un paralelogramo con la altura y la base
	 * indicada por los parametros altura y base. El paralelogramo estara formado por asteriscos
	 * si printAsteriscos es true, y tendra una linea discontinua a la derecha. Si printAsteriscos
	 * es false, el paralelogramos estara formado por numeros, los cuales iran decreciendo
	 * de fila en fila, siendo la ultima fila, una sucesion de unos.
	 *  Entradas: int altura, int base, boolean printAstericos
	 *  Salida: Nada
	 *  
	 *   
	 *   NOTA: En este ejercicio, habia que elegir entre duplicar codigo (ya que ambos
	 *   paralelogramos inicialmente hacen lo mismo), pero ganar eficiencia 
	 *   y legibilidad, o compartir codigo, pero perder eficiencia al evaluar continuamente
	 *   dentro del bucle que tipo de paralelogrammo se esta imprimiendo. Con Orentacion
	 *   a Objetos, y polimorfismo, no sera necesario elegir. Se podran hacer ambas cosas 
	 *   a la vez. En el caso de la solucion, se ha optado por la legibilidad y eficiencia.
	 */
	public static void printParallelogram(int altura, int base, boolean printAstericos){
		if(printAstericos) {//Si hay que imprimirlo con asteriscos
			printParallelogramAsterisk(altura,base);
		}
		else {//Si hay que imrpimirlo con numeros
			printParallelogramNumber(altura,base);
		}
	}

	/*
	 * Precondicion: altura y base deben ser mayores que cero, y altura no puede ser mayor de 9
	 * Postcondicion: El metodo imprime por pantalla un paralelogramo formado por numeros, 
	 * los cuales iran decreciendo de fila en fila, siendo la ultima fila, una sucesion de unos. La
	 * altura y la base del paralelogramo esta determinada por los parametros altura y base.
	 * Entradas: int altura, int base
	 * Salida: Nada 
	 */
	private static void printParallelogramNumber(int altura, int base) {
		for(int i=1;i<=altura;i++) {//Desde 1 hasta la altura
			printBlanks(altura-i);//Imprimo los espacios en blanco de la izquierda
			printNumbers(altura-i+1, base);//Imprimo la fila de numeros
			System.out.println();//Imprimo un salto de linea
		}
	}

	
	/*
	 * Precondicion: altura y base deben ser mayores que cero
	 * Postcondicion: El metodo imprime por pantalla un paralelogramo con la altura y la base
	 * indicada por los parametros altura y base. El paralelogramo estara formado por asteriscos, 
	 * y tendra una linea discontinua a la derecha.
	 *  Salida: Nada 
	 */
	private static void printParallelogramAsterisk(int altura, int base) {
		String asterisks=getRowAsterisks(base);//Obtenemos una cadena de astericos.
		//Lo hacemos una vez, fuera del bucle for, por cuestiones de eficiencia
		for(int i=1;i<=altura;i++) {//Desde 1 hasta la altura
			printBlanks(altura-i);//Imprimimos los espacios en blanco de la izquierda
			System.out.print(asterisks);//Imprimimos la fila de asteriscos
			printBlanks(i-1);//Imprimimos los espacios en blanco de la derecha
			System.out.println("|");//Imprimimos la linea y el salto de linea
		}
		
	}

	/*
	 * Precondicion: base tiene que ser mayor que cero
	 * Postcondicion: El metodo imprime en una misma linea
	 * el numero number repetido el numero de veces que indique el 
	 * parametro base
	 * Entradas: int number, int base
	 * Salida: Nada 
	 */
	private static void printNumbers(int number, int base) {
		String numberString=Integer.toString(number);//Pasamos number a cadena
		String stringNumbers= repeatString(numberString, base);//Repetimos numberString, base veces
		System.out.print(stringNumbers);//Imprimimos el resultado
	}
	
	

	/*
	 * Precondicion: numberBlanks>=0
	 * Postcondicion: Se va a imprimir por pantalla numberBlanks espacios en blanco
	 * Entradas: int numberBlanks
	 * Salida:Ninguna
	 */
	private static void printBlanks(int numberBlanks) {
		System.out.print(repeatString(" ", numberBlanks));//Repetimos el espacio en blanco
	}

	/*
	 * Precondicion: base>=0
	 * Postcondicion: Se va a imprimir por pantalla base asteriscos
	 * Entradas: int base
	 * Salida:Ninguna
	 */
	private static String getRowAsterisks(int base) {
		return repeatString("*",base);//Repetimos el asterisco, base veces.
	}
	
	/*
	 * Precondicion: number>=0
	 * Postcondicion: Se va a devolver una cadena, que tendra
	 * repetida la cadena string el numero de veces que indique el parametro number.
	 * Entradas: String string, int number
	 * Salida: String
	 */
	private static String repeatString(String string, int number) {
		String result="";
		for(int i=1;i<=number;i++) {//Desde 1 hasta number
			result+=string;//Concatenamos sucesivamente la cadena string
		}
		return result;
	}
	
	/***************************************************
				EJERCICIO 3
	 ******************************************************
1.    ¿Qué tipo de recursividad se realiza?
Simple y directa

2.    ¿Cuántos casos base y casos generales hay y cuáles son?
Un caso base y un caso general. Indico cada uno en el codigo:

public static void proc1(int n1) {
        if(n1==1)//Caso base
            System.out.println(n1+".");
        else {//Caso general
            System.out.print(n1+",");
            proc1(n1-1);
        }}





3.    Explica, mediante comentarios, el proceso que realiza cada método (proc1 y proc2). Escribe un método iterativo equivalente en Java a  proc1 (puedes utilizar métodos auxiliares). Recuerda que todos los elementos de tu código deben utilizar nombres autodocumentados.  

proc1 es un procedimiento recursivo el cual imprime una lista de numeros decreciente, comenzando por el valor
n1 y terminado por 1. Separa cada valor por una coma, y añade un punto al final. Para ello, si n1 es igual a 1,
imprime dicho valor y añade el punto. En caso contrario, imprime el numero seguido de una coma, y se llama a si mismo
decrementado en uno el parametro n1.
*/
	
	/*
	 * Precondicion: number>=1
	 * Postcondicion: Se va a imprimir por pantalla, la serie de numeros
	 * decreciente desde el numero number hasta el 1. Los numeros estaran separados
	 * por comas, y al final se imprimira un punto.
	 * Entradas: int number
	 * Salida: Nada
	 */
	public static void printNumberSeries(int number){
		for(int i=number;i>1;i--) {
			System.out.print(i+",");
		}
		System.out.println("1.");
	}
	
}
