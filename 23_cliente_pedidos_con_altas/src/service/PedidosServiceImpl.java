package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Type;
import java.net.Socket;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import model.Pedido;
import serializacion.DeserializadorFecha;


public class PedidosServiceImpl implements PedidosService {

	//String server="a13e31";
	String server="localhost";
	//dos puertos, una para recibir la lista de pedidos (8000) y otro para enviar el Pedido (9000)
	int port=8000;
	int port2=9000;
	
	
	//pasamos el nombre de la tienda al servidor cliente
	//recibimos el json de pedidos de esa tienda y la pasamos a Lista de pedidos de esa tienda
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

	
	
	//envio pedido para ALTA. Se recibe un objeto pedido. Convertir pedido a json y mandarlo al servidor cliente a ServidorAltaPedidos
	@Override
	public void envioPedido(Pedido pedido) {
		
		
		
		//Creamos el Gson para que pase por el deserializador
		//hay que usar el objeto de la clase DeserializadorFecha para convertir el LocalDate
		Gson gson=new GsonBuilder()  //GsonBuilder
				.registerTypeAdapter(LocalDate.class, new DeserializadorFecha()) //GsonBuilder
				.create();
		
		//try con recursos, se cierran los objetos solos en cuanto salen del try
		try(Socket socket=new Socket(server,port2);			
				PrintStream out=new PrintStream(socket.getOutputStream());
				BufferedReader bf=new BufferedReader(new InputStreamReader(socket.getInputStream()))){
			
				//recibimos un objeto Pedido como parámetro
				//lo pasamos a json con el método que transforma un pedido (único) a json
				out.println(serializarPedido(pedido));
				
				//enviamos el json a (20_servidor_pedidos /ServidorAltaPedidos / HiloAlta )
				out.println(pedido);
		
		
		

		}
		catch(IOException ex){
			ex.printStackTrace();
			
		}

	}
	
	
	

	//Serializar json formateando fecha
	//Este método transforma Un PEDIDO ÚNICO en una cadena JSON
	public static String serializarPedido(Pedido pedido) {
		final Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonSerializer<LocalDate>() {@Override
			public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
				return new JsonPrimitive(src.format(DateTimeFormatter.ISO_LOCAL_DATE)); // "yyyy-mm-dd"
			}
	    }).create();
		//llamamos al método un pedido vacio
		return gson.toJson(pedido, Pedido.class);
		
				
	}
	
	

}
