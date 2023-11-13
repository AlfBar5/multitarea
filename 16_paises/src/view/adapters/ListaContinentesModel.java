package view.adapters;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

import service.PaisesServiceFactory;

public class ListaContinentesModel extends DefaultComboBoxModel<String> {
	List<String> continentes;
	public ListaContinentesModel() {
		continentes=new ArrayList<>(PaisesServiceFactory.getPaisesService().continentes());
		
	}
	@Override
	public int getSize() {
		return continentes.size();
	}
	@Override
	public String getElementAt(int index) {
		return continentes.get(index);
	}
	
	
}
