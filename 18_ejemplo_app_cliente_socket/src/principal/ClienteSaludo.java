package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class ClienteSaludo {

	public static void main(String[] args) throws IOException {
		
		
		//Nos conectamos con una aplicación servidor
		//Creamos el objeto socket para llamar y conectarnos al servidor de socket
		//Constructor socket(String host, int port)
		
				
		//try con recursos A13E100
		try(
		//Socket socket = new Socket("localhost", 8000);
		
		// a otro equipo de la misma red
		Socket socket = new Socket("A13E100", 8000);
		
				
		InputStream input=socket.getInputStream();
				
		//Salida		
		PrintStream out=new PrintStream(socket.getOutputStream());	
				
		//entrada
		//recupera mensaje y lo lee --->inputstream
		BufferedReader bf=new BufferedReader(new InputStreamReader(input));	
						
		
			){	
			
			//primero enviamos el nombre
			out.println("Alfredo");
			
			//y después leemos
			System.out.println(bf.readLine());
			
		
		}
		
	}

}
