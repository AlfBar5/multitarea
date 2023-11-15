package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServidorSaludo {

	public static void main(String[] args){

		//INTERCAMBIO DE DATOS ENTRE APLICACIONES -- SOCKET
		// SERVIDOR SOCKET
		
		//Constructor al que tenemos que dar un puerto ServerSocket(int port)
		//hay 65000 puertos, del 1000 para arriba en teoría están libres
		//para ver los puertos usados ---> cmd netstat -a
		try{		
				//preparamos el servidor. Puerto 8000
				ServerSocket server = new ServerSocket(8000);
				//ServerSocket server = new ServerSocket("localhost", 8000);
													
				//objeto que se encarga de lanzar las tareas
				ExecutorService executor = Executors.newCachedThreadPool();
				
				//para que el servidor escuche a todas las máquinas
				while(true){	
					
						System.out.println("Esperando llamadas... ");
							
						//cuando alguien llama, se devuelve un objeto socket salida
						Socket socket = server.accept();
							
						executor.submit(new HiloLlamada(socket));				
						}
					
					}
					catch(IOException ex){
				
							ex.printStackTrace();
				
			
					}
			
			}

	}




