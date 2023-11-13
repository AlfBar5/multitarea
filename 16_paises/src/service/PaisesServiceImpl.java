package service;

import java.util.List;

import model.Pais;
import service.locator.PaisesLocator;

public class PaisesServiceImpl implements PaisesService {
	
	
	@Override
	public List<Pais> paisesPorContienente(String continente){
		return PaisesLocator.getJsonStream()
				.filter(p->p.getContinente().equals(continente))
				.toList();
	}
	
	@Override
	public List<String> continentes(){
		return PaisesLocator.getJsonStream()
				.map(p->p.getContinente())
				.distinct()
				.toList();
	}
}
