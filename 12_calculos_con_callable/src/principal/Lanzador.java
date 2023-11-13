package principal;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class Lanzador {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// lanzar dos tareas que se ejecuten concurrentemente
		// una de ellas calculará la suma de todos los números entre 1 y 100
		// la otra el factorial de un número cualquiera
		// al finalizar las tareas, el programa principal muestra el resultado
		
		
		ExecutorService executor=Executors.newCachedThreadPool();
		
		//Tarea 1 - la suma de todos los números entre 1 y 100
		Future<Integer> f1 =executor.submit(()->{
			return IntStream.rangeClosed(1,100).sum();
		});
		
		// Tarea 2 - factorial del número 6
		Future<Integer> f2 =executor.submit(()->{
			return IntStream.rangeClosed(1,6).reduce(1,(a,b)->a*b);
		});
		
		//
		while(!f1.isDone() || !f2.isDone()) {
			System.out.println("Esperando resultados...");
		}
		
		
		
		System.out.println("Suma: "+f1.get());
		System.out.println("Factorial: "+f2.get());
		
		
		//el pool de hilos sigue activo
		//forzamos el cierre del pool
		executor.shutdown();

	}

}
