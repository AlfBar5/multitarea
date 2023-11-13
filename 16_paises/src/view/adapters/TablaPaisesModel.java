package view.adapters;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Pais;
import service.PaisesServiceFactory;

public class TablaPaisesModel extends AbstractTableModel {
	List<Pais> paises;
	final int COLS=3;
	
	public TablaPaisesModel(String continente) {
		
		paises=PaisesServiceFactory.getPaisesService().paisesPorContienente(continente);
	}
	@Override
	public int getRowCount() {
		return paises.size();
	}
	@Override
	public int getColumnCount() {
		
		return COLS;
	}
	@Override
	public String getColumnName(int column) {
		
		switch(column) {
			case 0:
				return "Pais";
			case 1:
				return "Capital";
			case 2:
				return "Población";
			default:
				return "Indeterminada";
		}
	}
	@Override
	public Object getValueAt(int row, int column) {
		switch(column) {
			case 0:
				return paises.get(row).getNombre();
			case 1:
				return paises.get(row).getCapital();
			case 2:
				return paises.get(row).getPoblacion();
			
			default:
				return null;
		}
	}
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		switch(columnIndex) {
			case 0:
				return String.class;
			case 1:
				return String.class;
			case 2:
				return Long.class;
			default:
				return null;
		}
	}
	
	
}
