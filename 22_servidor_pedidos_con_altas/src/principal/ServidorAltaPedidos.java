package principal;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ServidorAltaPedidos {
	
	
	public static void main(String[] args)  {
		try {
			
			//cambiamos el puerto a 9000
			ServerSocket server=new ServerSocket(9000);
			ExecutorService executor=Executors.newCachedThreadPool();
			while(true) {
				System.out.println("Esperando llamadas...");			
				Socket socket=server.accept();
				executor.submit(new HiloAlta(socket));			
			}
			
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	

}
