package tareas;

import java.util.List;

public class TareaMultiplicar implements Runnable {

	private int numero;
	
	//constructor sobrecarga con parametro número
	public TareaMultiplicar(int numero){
		
		this.numero=numero;
		
	}
	
	
	
	@Override
	public void run() {
		
		for(int i=1; i<=10; i++) {
			System.out.println(numero+"x"+i+"="+numero*i);
			
			//Dormir tarea 100 milisegundos
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

	}
	
	

	

}
