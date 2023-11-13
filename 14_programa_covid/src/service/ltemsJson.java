package service;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;
import com.google.gson.Gson;
import model.Item;

public class ltemsJson {
	
	
	static String ruta="c:\\temp\\covid.json";
	
	//Lectura del fichero json
	public static Stream<Item> getItemsJsonStream(){
		
		
		Gson gson=new Gson();
		
		try(FileReader lectura=new FileReader(ruta);){
			
			Item[]paises=gson.fromJson(lectura, Item[].class);
			return Arrays.stream(paises);
			
		}
		catch(IOException ex) {
			
			ex.printStackTrace();
			return Stream.empty();
			
		}
	}

}
