package tareas;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Lanzador {

	public static void main(String[] args) {
		
		
		Scanner sc= new Scanner(System.in);
		
		// ahora podemos llamar a los métodos o funciones de la clase Scanner
		// el método para leer lo introducido por teclado se llama nexLine() y devuelve un string
		
		System.out.println("Escribe un número: ");
		//El objeto sc usa el método nextLine(). Y lo guardamos en la variable de tipo string nombre
		int numero1 = Integer.parseInt(sc.nextLine());
		
		System.out.println("Escribe un segundo número: ");
		int numero2 = Integer.parseInt(sc.nextLine());
		System.out.println("Escribe un tercer número: ");
		int numero3 = Integer.parseInt(sc.nextLine());
		
		
		ExecutorService executor=Executors.newCachedThreadPool();
		
		executor.submit(new TareaMultiplicar(numero1));
		executor.submit(new TareaMultiplicar(numero2));
		executor.submit(new TareaMultiplicar(numero3));
		
		
		

	}

}
