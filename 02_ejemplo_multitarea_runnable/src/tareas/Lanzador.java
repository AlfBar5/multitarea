package tareas;

public class Lanzador {

	public static void main(String[] args) {

		//Creamos las dos tareas y las ponemos en ejecución concurrente
		
		TareaAscendente ta = new TareaAscendente();
		TareaDescendente td = new TareaDescendente();
						
		//poner en ejecución concurrente
		//Se deben crear dos objetos Thread, indicándoles como parámetro el objeto runnable
		Thread t1= new Thread(ta);
		Thread t2 = new Thread(td);
		
		t1.start();
		t2.start();

	}

}
