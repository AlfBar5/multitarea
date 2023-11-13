package principal;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class Lanzador {

	public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
		
		//lanzar dos tareas que se ejecuten concurrentemente. 
		//una de ellas calculará la suma de todos los números entre
		//1 y 100, la otra el factorial de un número.
		//Al finalizar las tareas, el programa prncipal muestra los resultados
		ExecutorService executor=Executors.newCachedThreadPool();
		
		//suma
		CompletableFuture<Integer> f1=CompletableFuture.supplyAsync(()->{
			return IntStream.rangeClosed(1, 100).sum();
			/*
			int suma=0;
			for(int i=1;i<=100;i++) {
				suma+=i;
				try {
					Thread.sleep(100);
				}
				catch(Exception ex) {}
			}
			return suma;
			*/
		},executor);
		
		//llamada asíncrona
		//sacamos el resultado cuando esté completado:
		//r es resultado, e es error (si se produjese)
		f1.whenCompleteAsync((r,e)->System.out.println("Suma: "+r));
		
		
		//factorial 6
		CompletableFuture<Integer> f2=CompletableFuture.supplyAsync(()->{
			return IntStream.rangeClosed(1, 6).reduce(1,(a,b)->a*b);
			/*
			int multi=1;
			for(int i=1;i<=6;i++) {
				multi*=i;
				try {
					Thread.sleep(100);
				}
				catch(Exception ex) {}
			}
			return multi;
			*/
		},executor);

		
		
		//llamada asíncrona
		//sacamos el resultado cuando esté completado:
		//r es resultado, e es error (si se produjese)
		f2.whenCompleteAsync((r,e)->System.out.println("Factorial: "+r));
		
		//el pool de hilos sigue activo
		//forzamos el cierre del pool
		executor.shutdown();
		
		//esperar a que pulsemos una tecla y enter (para poder ver el resultado)
		System.in.read();
		
	}

} 