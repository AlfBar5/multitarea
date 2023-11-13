package tareas;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Lanzador {

	public static void main(String[] args) {

		//Creamos las dos tareas y las ponemos en ejecución concurrente
		
		//TareaAscendente ta = new TareaAscendente();
		//TareaDescendente td = new TareaDescendente();
						
		ExecutorService executor=Executors.newCachedThreadPool();
		
		executor.submit( new TareaAscendente());
		executor.submit( new TareaDescendente());
		
		

	}

}
