package service;

import java.util.List;
import java.util.stream.Collectors;


import model.Item;

//para importar los métodos estáticos de la clase
//los métodos estáticos no se importan con el control + may + o
import static service.ltemsJson.*;

import static utilities.Utilidades.*;

public class ItemsServiceImpl implements ItemsService {

	
	ltemsJson itemsjson = new ltemsJson();
	
	
	
	//lista paises
	@Override
	public List<String> paises() {
		
		return getItemsJsonStream() //return stream<Items>
				.map(item->item.getNombrePais()) //Stream<String>
				.distinct()
				.toList();
				//.collect(Collectors.toList());  //convertimos el stream en lista llamando al método toList() 
		
	}


	@Override
	public double incidenciaPais(String pais) {
		return getItemsJsonStream() //return stream<Items>
				//filtro dos condiciones, el nombre pais y el indicador que es igual a cases (no "indicator": "deaths")
				.filter(it->it.getNombrePais().equals(pais)&&it.getIndicador().equals("cases"))
				.max((it1,it2)->convertirTextoFecha(it1.getFecha())
						.compareTo(convertirTextoFecha(it2.getFecha()))) //Optional
				.orElse(new Item()) //devuelvo un item() vacío para que en caso de que no haya, pues sacar un pais vacio
				//.get()
				.getIncidencia();
				
				
	}


	//primero filtramos los casos  (no muertes)
	//sumar los últimos acumulados
	//Al groupingBy le damos dos parámetros: 
	// Primero function para obtener el valor de clave (nombre del pais) y 
	// de segundo parámetro le decimos que nos quedamos con la fecha más reciente
	@Override
	public int totalAcumulados() {
		return getItemsJsonStream() //return stream<Items>
				.filter(it->it.getIndicador().equals("cases"))
				.collect(Collectors.groupingBy(it->it.getNombrePais(), Collectors.maxBy((it1,it2)->convertirTextoFecha(it1.getFecha())
						.compareTo(convertirTextoFecha(it2.getFecha()))))) //Map<String,Item>
				.values()  //Collection<Item> //solo cogo los valores
				.stream() //Stream<Item> //volver a transformarlo en un stream
				.collect(Collectors.summingInt(op->op.get().getAcumulados()));  //hacemos la suma de los acumulados de todos los países
				
	}
	
	
	
	//OTRA FORMA CON DOS MÉTODOS. HACER UN MÉTODO QUE DEVUELVA LOS MÁS RECIENTES fechaMasReciente y luego sacar el total de acumularos
	/*@Override
	public int totalAcumulados() {
		LocalDate fechaMax=fechaMasReciente();
		return locator.getJsonStream()
				.filter(it->it.getIndicador().equals("cases")&&convertirTextoFecha(it.getFecha()).equals(fechaMax))
				.collect(Collectors.summingInt(it->it.getAcumulados()));
	}

	private LocalDate fechaMasReciente() {
		return locator.getJsonStream()
				.map(it->convertirTextoFecha(it.getFecha())) //Stream<LocalDate>
				.max((f1,f2)->f1.compareTo(f2))
				.orElse(LocalDate.now());
	}*/

	
	
	
	
}
