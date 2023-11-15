package principal;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ServidorListaPedidos {
	
	
	public static void main(String[] args)  {
		try {
			
			ServerSocket server=new ServerSocket(8000);
			ExecutorService executor=Executors.newCachedThreadPool();
			while(true) {
				System.out.println("Esperando llamadas...");			
				Socket socket=server.accept();
				executor.submit(new HiloLlamada(socket));			
			}
			
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	

}
