package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSaludo {

	public static void main(String[] args) throws IOException {

		//INTERCAMBIO DE DATOS ENTRE APLICACIONES -- SOCKET
		// SERVIDOR SOCKET
		
		//Constructor al que tenemos que dar un puerto ServerSocket(int port)
		//hay 65000 puertos, del 1000 para arriba en teoría están libres
		//para ver los puertos usados ---> cmd netstat -a
		
		//preparamos el servidor. Puerto 8000
		ServerSocket server = new ServerSocket(8000);
		
		////Le decimos que acepte llamadas con accept
		//server.accept();
		
		System.out.println("Esperando llamadas... ");
		

//para que el servidor escuche a todas las máquinas
//while(true){	
		//System.out.println("Esperando llamadas... ");
		
		try(
			
					
			//cuando alguien llama, se devuelve un objeto socket salida
			Socket socket = server.accept();
			
			//lo que viene ya son operaciones de entrada/salida. 
			// Quiero leer, es una entrada. Quiero escribir, es una salida
			//entrada ---> inputstream  --> getInputStream()
			//salida ---> outputstream  --> getOutputStream()
							
			OutputStream os = socket.getOutputStream();
			//Creo un objeto PrintStream con el constructor de la clase PrintStream al que le paso el parámetro os
			PrintStream out = new PrintStream(os);
				
			BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()))	
				
			)
		
		{
			//leemos
			String name = bf.readLine();
			
			//escribimos
			out.println("Hola "+name+", soy el servidor de sockets");
			
			//System.out.println("Enviado mensaje a "+name);
		
	}
		
	//}

	}

}
