/* Buenas profesor, antes de nada queria decirle que estoy
 * orgulloso de estudiar en el IES Nervion y soy fan de la
 * asigantura de programacion, y por supuesto voy a regalarle 
 * un jamon 5J
 * 
 * No he utilizado tildes en los comentarios, por cuestiones
 * de encoding.
 * 
 */



public class ExamenG1AlumnoAnonimo {

	public static void main(String[] args) {
		System.out.println("Ejercicio 1");
		primeFactorDecomposition(2);
		primeFactorDecomposition(24255);
		
		System.out.println();
		System.out.println("Ejercicio 2");
		printPyramid(5, true);
		printPyramid(6, false);
		
		System.out.println();
		System.out.println("Ejercicio 3");
		printRectangle(4, 5);
		printRectanglePro(2,3);
		
	}
	
	/***************************************************
						EJERCICIO 1
	 ******************************************************/
	
	
	/*
	 * Precondicion: number debe ser un numero mayor de 1
	 * Postcondicion: El procedimiento va a imprimir por la salida estandar la
	 * descomposicion en factores primos de number, mostrando para cada factor
	 * el exponente al que esta elevado, excepto si el exponente es 1. 
	 * Entrada: int number
	 * Salida: Nada
	 * 
	 * NOTA: En este ejercicio, no era necesario comprobar si un numero era primo, ya que
	 * se cumple que al dividir el numero, el siguiente numero por el que va a ser 
	 * divisible va a ser otro numero primo.
	 */
	public static void primeFactorDecomposition(int number) {
		int factor=2;//Comenzamos a intentar descomponer number por el numero 2
		int exponent=0;//exponente va a indicar cuantas veces se divide number por el mismo factor 
		while(number>1) {//Mientras podamos seguir dividiendo el numero
			while(number%factor==0) {//Mientras sea divisible por el mismo factor 
				number=number/factor;//Dividimos el numero por factor
				exponent++;//Aumentamos el exponente
			}//El bucle termina cuando ya no se puede dividir mas veces por el mismo factor
			printFactor(factor,exponent,number);//Imprimimos el resultado
			factor++;//Incrementamos factor para probar con el siguiente 
			exponent=0;//Reiniciamos el exponente a cero
		}
		System.out.println();//Imprimimos un salto de linea final
	}
	
	/*
	 * Precondicion: Ninguna
	 * Postcondicion: El procedimiento imprime por pantalla factor elevado a exponente, 
	 * con el siguiente formato: factor^exponent. Si el exponente es 1, solo se
	 * mostrara factor. Adicionalmente, si number no es 1, se añade el simbolo de multiplicacion
	 * al final, ya que no se trata del ultimo resultado. 
	 * Entrada: int factor, int exponent, int number
	 * Salida: Ninguna
	 */
	private static void printFactor(int factor, int exponent,int number) {
		if(exponent>=1) {//Si el exponente es mayor que uno, hay que imprimir el resultado
			System.out.print(factor);
			if(exponent>1) {//Si el exponente es mayor que uno, hay que indicar el exponente
				System.out.print("^"+exponent);
			}
			if(number>1) {//Si number no es uno, el numero se va a seguir descomponiendo
				System.out.print("*");//Se añade un signo de multiplicacion a la derecha
			}
		}
		
		
	}

	/***************************************************
						EJERCICIO 2
	 ******************************************************/

	/*
	 * Precondicion: altura debe ser mayor o igual que 1
	 * Postcondicion: Se va a imprimir por pantalla una priramide con la altura indicada por el
	 * parametro altura, e invertida si el booleano invertida es true, y normal, si es false.
	 * En cada fila, se mostrara una sucesión de numeros decreciente hasta el numero 1.
	 * Entradas: int altura, boolean invertida.
	 * Salida:Ninguna
	 * 
	 * * NOTA: En este ejercicio, la clave estaba en darse cuenta que ambas piramides
	 * hacen lo mismo pero de arriba a abajo, o de abajo arriba. Por lo que
	 * deben llamar al mismo metodo, solo que con un bucle que va incrementando el valor
	 * o decrementandolo.
	 */
	public static void printPyramid(int altura, boolean invertida){
		if(invertida) {//Si tenemos que imprimir la piramide invertida
			printInvertedPyramid(altura);//Imprime una priramide invertida
		}
		else {//En caso de tener que imprimir la piramide recta.
			printRightPyramid(altura);//Imprime una piramide recta
		}
	}

	/*
	 * Precondicion: altura debe ser mayor o igual que 1
	 * Postcondicion: Se va a imprimir por pantalla una piramide con la altura indicada por el
	 * parametro altura, e invertida.
	 * En cada fila, se mostrara una sucesión de numeros decreciente hasta el numero 1.
	 * Entradas: int altura.
	 * Salida:Ninguna
	 */
	private static void printInvertedPyramid(int altura) {
		for(int i=altura; i>=1;i--) {//Vamos decrementando la altura hasta llegar a 1
			printRowPyramid(altura-i,i);//Imprimimos la fila, con 'altura-i' espacios en blanco
			//e 'i' numeros.
		}
	}

	/*
	 * Precondicion: altura debe ser mayor o igual que 1
	 * Postcondicion: Se va a imprimir por pantalla una priramide con la altura indicada por el
	 * parametro altura, recta.
	 * En cada fila, se mostrara una sucesión de numeros decreciente hasta el numero 1.
	 * Entradas: int altura.
	 * Salida:Ninguna
	 */
	private static void printRightPyramid(int altura) {
		for(int i=1; i<=altura;i++) {//Vamos aumentando la altura hasta llegar a la altura indicada
			printRowPyramid(altura-i,i);//Imprimimos la fila, con 'altura-i' espacios en blanco
			//e 'i' numeros.
		}
	}

	/*
	 * Precondicion: numberBlanks>=0 y numberRow>=1
	 * Postcondicion: Se va a imprimir por pantalla una fila con numberBlanks espacios en blanco a la
	 * izquierda, y con una sucesion de numeros decreciente a la derecha, que comienza en numberRow 
	 * y termina en 1.
	 * Entradas: int numberBlanks, int numberRow
	 * Salida:Ninguna
	 */
	private static void printRowPyramid(int numberBlanks, int numberRow) {
		printBlanks(numberBlanks);//Imprime los espacios en blanco
		printNumbers(numberRow);//Imprime la sucesion de numeros
		System.out.println();//Imprime un salto de linea
	}


	/*
	 * Precondicion: numberRow>=1
	 * Postcondicion: Se va a imprimir por pantalla una sucesion de numeros decreciente,
	 *  que comienza en numberRow y termina en 1.
	 * Entradas: int numberRow
	 * Salida:Ninguna
	 */
	private static void printNumbers(int numberRow) {
		for(int i=numberRow;i>=1;i--) {//decrementamos i desde numberRow hasta 1
			System.out.print(i);//Vamos imprimiendo el numero i.
		}
	}


	/*
	 * Precondicion: numberBlanks>=0
	 * Postcondicion: Se va a imprimir por pantalla numberBlanks espacios en blanco
	 * Entradas: int numberBlanks
	 * Salida:Ninguna
	 */
	private static void printBlanks(int numberBlanks) {
		for(int i=1;i<=numberBlanks;i++) {//Incrementamos i desde 1 hasta numberBlanks
			System.out.print(" ");//Imprimimos un espacio en blanco
		}
	}



	/***************************************************
						EJERCICIO 3
	******************************************************
1.    ¿Qué tipo de recursividad se realiza?
Simple y directa

2.    ¿Cuántos casos base y casos generales hay y cuáles son?
 Un caso base y un caso general. Indico cada uno en el codigo:
 
 public static void proc1(int n1, int n2) {
    if(n1==1) //En este caso se aplica el caso base
        proc2(n2);
    else { //En este caso se aplica el caso general
        proc2(n2);
        System.out.print("\r\n");
        proc1(n1-1,n2);
    }
}
 
 
 
3.    Explica, mediante comentarios, el proceso que realiza cada método (proc1 y proc2). Escribe un método iterativo equivalente en Java a  proc1 (puedes utilizar métodos auxiliares). Recuerda que todos los elementos de tu código deben utilizar nombres autodocumentados.  

proc1 es un procedimiento recursivo el cual dibuja un rectangulo de n1 lineas de n2 asteriscos cada una. Para ello,
en el caso de que n1 sea igual a 1, imprime una linea de n2 asteriscos llamando a proc2(n2). Para el
resto de casos, imprime la linea llamando a proc2(n2), imprime un salto de linea, y se llama a si mismo
decrementando en uno el parametro n1.


El procedimiento proc2, por su parte, imprime n2 asteriscos en la misma linea, utilizando para ello un bucle
for que va desde 0 hasta n2 (sin incluir)

	 */

	/*
	 * Precondicion: height>0 y width>0
	 * Postcondicion: Imprime por la salida estandar un rectangulo con el numero de filas
	 * marcado por el parametro height, teniendo cada una el numero de asteriscos
	 * que indica el parametro width.
	 * Entrada: int height, int width
	 * Salida: Ninguna
	 * 
	 */
	
	public static void printRectangle(int height, int width) {
		for(int i=1;i<=height;i++) {
			printRowRectangle(width);
			System.out.println();
		}
	}


	/*
	 * Precondicion: width>0
	 * Postcondicion: Imprime por la salida estandar una fila con el numeros de asteriscos
	 * que indica el parametro width.
	 * Entrada: int height, int width
	 * Salida: Ninguna
	 * 
	 */
	private static void printRowRectangle(int width) {
		for(int i=1;i<=width;i++)
			System.out.print('*');
	}
	
	/**
	 * Debido a que el tamaño de las filas del rectangulo siempre es el mismo, no 
	 * tiene sentido que se ejecute un bucle for por cada linea. Es por ello
	 * que a continuacion muestro una version, alternativa y mejorada del anterior
	 * metodo.
	 * 
	 * Precondicion: width>0
	 * Postcondicion: Imprime por la salida estandar una fila con el numeros de asteriscos
	 * que indica el parametro width.
	 * Entrada: int height, int width
	 * Salida: Ninguna
	 */
	public static void printRectanglePro(int height, int width) {
		String row=getRow(width);//Obtengo una cadena de width asteriscos
		for(int i=1;i<=height;i++) {//Por cada fila
			System.out.println(row);//Imprimo la cadena de astericos obtenida anteriormente
		}
	}

	 /** Precondicion: width>0
	 * Postcondicion: Devuelve una cadena que contiene tantos astericos como marca el
	 * parametro width.
	 * Entrada: int width
	 * Salida: String 
	 */
	private static String getRow(int width) {
		String asteriskString="*";
		String row=asteriskString.repeat(width);
		return row;
	}


	
	
	
}

