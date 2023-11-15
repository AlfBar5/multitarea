package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.Pedido;
import serializacion.DeserializadorFecha;


public class PedidosServiceImpl implements PedidosService {

	//String server="a13e31";
	String server="localhost";
	int port=8000;
	
	
	@Override
	public List<Pedido> pedidosTienda(String tienda) {

		Gson gson=new GsonBuilder()  //GsonBuilder
				.registerTypeAdapter(LocalDate.class, new DeserializadorFecha()) //GsonBuilder
				.create();
		
		
		try(Socket socket=new Socket(server,port);
				
				PrintStream out=new PrintStream(socket.getOutputStream());
				
				BufferedReader bf=new BufferedReader(new InputStreamReader(socket.getInputStream()))){
			
				//enviamos el nombre de la tienda al servidor de socket (20_servidor_pedidos)
				out.println(tienda); 
				
				//recibimos el json de pedidos
				String json=bf.readLine();
				System.out.println(json);
				
				return Arrays.asList(gson.fromJson(json, Pedido[].class));
				
			}
			catch(IOException ex){
				ex.printStackTrace();
				return List.of();
			}
		
		
	}

	

}
