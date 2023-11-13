package service;

import java.util.List;

public interface ItemsService {
	
	//lista paises
	List<String> paises();
	
	//incidencia de cada país
	double incidenciaPais(String pais);
	
	//total casos acumulados
	int totalAcumulados();

}
