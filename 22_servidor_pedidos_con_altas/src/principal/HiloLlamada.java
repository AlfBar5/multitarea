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
import service.PedidosService;
import service.PedidosServiceFactory;


public class HiloLlamada implements Runnable  {
	
	
	final Socket socket;
	public HiloLlamada(Socket socket) {
		super();
		this.socket = socket;
	}
	
	
	@Override
	public void run() {
		//recoger el nombre de la tienda del cliente como parámetro
		//pasarle la Lista de pedidos de esa tienda
		try(socket;PrintStream out=new PrintStream(socket.getOutputStream());
			BufferedReader bf=new BufferedReader(new InputStreamReader(socket.getInputStream()));){
			
			//recogemos el nombre de tienda enviado por cliente
			String tienda=bf.readLine();
			
			//traza para ver si llega bien el parámetro de tienda
			System.out.println(tienda);
			//Recuperamos lista de pedidos
			PedidosService  service = PedidosServiceFactory.getPedidosService();
			List<Pedido> pedidos=service.pedidosTienda(tienda);
			
			//trazas para ver las cadenas json que se forman y se devuelven a la tienda cliente
			System.out.println(pedidos);
			System.out.println(serializarLista(pedidos));
			//pasamos la lista de pedidos como petición
			out.println(serializarLista(pedidos));
			
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
