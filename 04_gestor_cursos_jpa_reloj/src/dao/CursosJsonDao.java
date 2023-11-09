package dao;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.Curso;
import serializacion.DeserializadorFecha;

public class CursosJsonDao {
	
	
	//método stream de cursos leer fichero json y guardar en stream
	private Stream<Curso> getCursos(){
		
		//con fechas hay que sobreescribir
		String ruta="c:\\temp\\cursosfecha.json";


		
		//Creamos el Gson para que pase por el deserializador
		//hay que usar el objeto de la clase DeserializadorFecha para convertir el LocalDate
		Gson gson= new GsonBuilder()
				.registerTypeAdapter(LocalDate.class, new DeserializadorFecha()) //GsonBuilder
				.create(); //Gson
		
		
		
		//PARA PODER PASAR LA FECHA COMO LOCALDATE, TENEMOS QUE HACER UN
		//DESERIALIZADOR PERSONALIZADO
		//QUE LE DIGAMOS COMO SE CONVIERTE CADA CAMPO
		//ESTA EN LA CLASE
		
		try(FileReader reader=new FileReader(ruta);){
			Curso[] cursos=gson.fromJson(reader, Curso[].class);
			return Arrays.stream(cursos);
			
		}
		
		catch(IOException ex) {
			ex.printStackTrace();
			return Stream.empty();
		}
		
		
	}
	
	
	
	
	//método stream de cursos, lista de cursos
	public List<Curso> cursos(){
		return getCursos() //Stream<Curso>
				.collect(Collectors.toList());
		
	
		
	}
	

	
	
	
	
} 