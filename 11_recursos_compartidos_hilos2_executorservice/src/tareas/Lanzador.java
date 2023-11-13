package tareas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Lanzador {

	public static void main(String[] args) {

		//Creamos ArrayList
		ArrayList<Integer> lista=new ArrayList<>();
		
		//tres tareas
		ExecutorService executor=Executors.newCachedThreadPool();
		
		//con la interrogación le decimos que no sabemos lo que va a devolver
		Future<?> f1 =executor.submit(new VolcadoLista(1,1000,lista));
		Future<?> f2 =executor.submit(new VolcadoLista(1001,2000,lista));
		Future<?> f3 =executor.submit(new VolcadoLista(2001,3000,lista));
		
		//si f1 no ha terminado o no ha terminado f2 o no ha terminado f3
		//entonces no hacemos nada
		while(!f1.isDone() || !f2.isDone() || !f3.isDone()){}
		
		//cuando las tres sean true, sale del bucle y pintamos el tamaño
		System.out.println(lista.size());
		
		//el pool de hilos sigue activo
		//forzamos el cierre del pool
		executor.shutdown();

	}

}
