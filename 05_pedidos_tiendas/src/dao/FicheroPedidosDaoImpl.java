package dao;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.Pedido;
import serializacion.DeserializadorFecha;

public class FicheroPedidosDaoImpl implements FicheroPedidosDao {
	
	private Stream<Pedido> pedidosFichero(String ruta){		
		
		//usando deserializacion
		Gson gson=new GsonBuilder()//GsonBuilder
				.registerTypeAdapter(LocalDate.class, new DeserializadorFecha()) //GsonBuilder
				.create(); 
		
		try(FileReader reader=new FileReader(ruta);){
			Pedido[] pedidos=gson.fromJson(reader, Pedido[].class);
			return Arrays.stream(pedidos);
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return Stream.empty();
		}
	}
	@Override
	public List<Pedido> getPedidos(String ruta) {
		return pedidosFichero(ruta)
				.toList();
	}

}

