package tareas;

import java.util.ArrayList;

public class VolcadoLista implements Runnable{
	
	//Va a recibir dos números como parámetros en el constructor
	int a, b;
	//Va a recibir un ArrayList
	ArrayList<Integer> list;
	
	
	
	public VolcadoLista(int a, int b, ArrayList<Integer> list) {
		super();
		this.a = a;
		this.b = b;
		this.list = list;
	}
	
	
	@Override
	public void run() {
		for(int i=a;i<=b;i++) {
			//Sincronizamos para que se termine la instrucción antes de que entre otra instrucción en el hilo
			synchronized (list) { //Thread safe (no se pierden datos)
				list.add(i);
			}
			
		}
		
	}
	
	
	

}
