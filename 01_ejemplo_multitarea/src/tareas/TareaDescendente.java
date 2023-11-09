package tareas;

public class TareaDescendente extends Thread {

	@Override
	public void run() {
		
		for(int i=100;i>=1;i--) {
			System.out.println("Descendente: "+i);
			
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
