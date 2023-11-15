package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;


import javax.persistence.EntityManager;

import helpers.EntityManagerLocator;
import model.Pedido;
import serializacion.DeserializadorFecha;
import service.PedidosService;
import service.PedidosServiceFactory;


public class HiloAlta implements Runnable  {
	
	
	final Socket socket;
	
	public HiloAlta(Socket socket) {
		super();
		this.socket = socket;
	}
	
	
	@Override
	public void run() {
		
		//recogemos el alta de pedido desde la tienda en formato json
		//Creamos el Gson para que pase por el deserializador
		
		//hay que usar el objeto de la clase DeserializadorFecha para convertir el LocalDate
		Gson gson= new GsonBuilder()
				.registerTypeAdapter(LocalDate.class, new DeserializadorFecha()) //GsonBuilder
				.create(); //Gson
		
		//declaramos método altapedidos de PedidosServiceImpl a través del factory
		PedidosService service = PedidosServiceFactory.getPedidosService();
		
		
		try(socket;PrintStream out=new PrintStream(socket.getOutputStream());
			BufferedReader bf=new BufferedReader(new InputStreamReader(socket.getInputStream()));){
			
			//leemos el alta de pedido de tienda enviado por cliente
			String json=bf.readLine();
			//traza para comprobar
			//System.out.println(json);
			
			//lo deserializamos para convertirlo en objeto Pedido
			Pedido pedido = gson.fromJson(json, Pedido.class);
			
			//llamamos al método altapedidos de PedidosServiceImpl a través del factory
			service.altaPedido(pedido);
					
			//EN UNA LINEA
			//convertimos json a objeto Pedido en una linea
			//método altapedidos de PedidosServiceImpl a través del factory
			//service.altaPedido(gson.fromJson(json, Pedido.class));
									
			//traza mensaje alta
			System.out.println("Alta producida");		
			
			
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		
		
		
	}
	

	
	//Serializar json formateando fecha
	//Este método transforma la lista de pedidos en una cadena JSON
	public static String serializarLista(List<Pedido> pedidos) {
		final Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonSerializer<LocalDate>() {@Override
			public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
				return new JsonPrimitive(src.format(DateTimeFormatter.ISO_LOCAL_DATE)); // "yyyy-mm-dd"
			}
	    }).create();
		//llamamos al método toArray y le pasamos un array vacio
		return gson.toJson(pedidos.toArray(new Pedido[0]),Pedido[].class);
		
		//Otra forma
		//return gson.toJson(pedidos,new TypeToken<List<Pedido>>(){}.getType());		
	}

	
	

}
