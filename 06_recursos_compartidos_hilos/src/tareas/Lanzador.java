package tareas;

import java.util.ArrayList;

public class Lanzador {

	public static void main(String[] args) {

		//Creamos ArrayList
		ArrayList<Integer> lista=new ArrayList<>();
		
		//tres tareas
		
		new Thread(new VolcadoLista(1,1000,lista)).start();
		new Thread(new VolcadoLista(1001,2000,lista)).start();
		new Thread(new VolcadoLista(2001,3000,lista)).start();
		
		
		//una vez que terminen las tareas ¿Cuál es el tamaño de esa lista?
		
		//espero a que se ejecute 4 segundos
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(lista.size());
		
		//se pierden casi la mitar de los números
		//hay que mirar las condiciones de carrera

	}

}
