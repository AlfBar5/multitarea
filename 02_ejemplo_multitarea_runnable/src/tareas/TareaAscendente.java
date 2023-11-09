package tareas;

public class TareaAscendente implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
				for(int i=1; i<=100; i++) {
					System.out.println("Ascendente: "+i);
					
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
