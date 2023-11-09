package tareas;

public class Lanzador {

	public static void main(String[] args) {

		//Creamos las dos tareas y las ponemos en ejecución concurrente
		
		TareaAscendente ta = new TareaAscendente();
		TareaDescendente td = new TareaDescendente();
				
		//poner en ejecución concurrente
		ta.start();
		td.start();
	}

}
