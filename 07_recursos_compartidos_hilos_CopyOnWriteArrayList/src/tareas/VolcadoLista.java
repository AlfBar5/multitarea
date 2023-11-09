package tareas;


import java.util.concurrent.CopyOnWriteArrayList;

public class VolcadoLista implements Runnable{
	
	//Va a recibir dos números como parámetros en el constructor
	int a, b;
	//Va a recibir un ArrayList
	CopyOnWriteArrayList<Integer> list;
	
	
	
	public VolcadoLista(int a, int b, CopyOnWriteArrayList<Integer> list) {
		super();
		this.a = a;
		this.b = b;
		this.list = list;
	}
	
	
	@Override
	public void run() {
		for(int i=a;i<=b;i++) {
			
				list.add(i);
						
		}
		
	}
	
	
	

}
