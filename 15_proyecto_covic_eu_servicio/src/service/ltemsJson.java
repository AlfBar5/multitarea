package service;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Arrays;
import java.util.stream.Stream;
import com.google.gson.Gson;
import model.Item;

public class ltemsJson {
	
	//Cambiamos la ruta a la url del servicio web
	static String ruta="https://opendata.ecdc.europa.eu/covid19/nationalcasedeath/json/";
	
	//Lectura del fichero json
	public static Stream<Item> getItemsJsonStream(){
		
		
		Gson gson=new Gson();
				
		//Creo objeto request. Representa una petición HTTP 
		HttpRequest request = HttpRequest.newBuilder() //el builder genera propiedades o configuraciones antes de crear el objeto final
				.uri(URI.create(ruta)) //nuevo buidir le damos la ruta
				.GET()  //Builder, tipo de llamada que voy a hacer: GET
				.build(); //genera el build u objeto final.
		
		
		//Creo un segundo objeto, el que se usa para hacer las llamadas
		//HttpClient. Se emplea para lanzar peticiones HTTP
		//Se configura también a través de un builder, aunque tiene menos configuración
		HttpClient client = HttpClient.newBuilder()
				.version(Version.HTTP_1_1) //builder, para decirle que versión o protocolo de http vamos a utilizar
				.build();
		
		
		//Lanzamos la llamada. 
		//Para enviar una petición utilizamos el método send del objeto HttpClient
		//Devuelve el tercer objeto en discordia, el httpRequest
		//Devuelve un BodyHandlers. Es una interfaz, que tiene unos métodos estáticos que te dan una implementación (de muchos tipos de datos)
		//escogo la respuesta (string) y la trato como cadena de caracteres (ofString)
		
		try {
		HttpResponse response = client.send(request, BodyHandlers.ofString());
		
		//La cadena de caracteres la recojo como si fuese un json
		//La cadena json está en el cuerpo de la respuesta
		//y se recupera de la siguiente manera
		//String json=response.body().toString();
		
		//tenemos que pasar los datos a fromjson. Este método está muy sobrecargado, tiene muchas posibilidades
		//y una es que le demos el chorro como cadena de caracteres
		
			String json = response.body().toString();
			Item[] items = gson.fromJson(json, Item[].class);
			return Arrays.stream(items);
			
		}catch(IOException | InterruptedException ex){
			ex.printStackTrace(); //que muestre la traza
			return Stream.empty(); //que devuelva un stream vacio
		}
	}

}
