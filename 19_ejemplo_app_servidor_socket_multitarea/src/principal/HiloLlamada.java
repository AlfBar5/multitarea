package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

//la clase imprementa runnable
public class HiloLlamada implements Runnable {

	//para que cierre el socket
	final Socket socket;
	
	
	public HiloLlamada(Socket socket) {
		super();
		this.socket = socket;

	}




	@Override
	public void run() {

		//operaciones de entrada/salida. 
		// Quiero leer, es una entrada. Quiero escribir, es una salida
		//entrada ---> inputstream  --> getInputStream()
		//salida ---> outputstream  --> getOutputStream()
		
		//try con recursos, al salir del try el objeto se cierra solo
		//todo lo que hay entre paréntesis hace un .close(), aunque no lo veamos
		try(socket;
			PrintStream out = new PrintStream(socket.getOutputStream());
				BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));){
				out.println("Hola "+bf.readLine()+", bienvenido al servidor de sockets");
			
		}	
		catch(IOException ex) {
		
			ex.printStackTrace();
		

		}

	}
	
}
