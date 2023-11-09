package view.adapters;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.table.AbstractTableModel;

import dao.AlumnosDao;
import model.Alumno;
import service.FormacionService;
import service.FormacionServiceFactory;

public class TablaAlumnosModel extends AbstractTableModel {
	
	List<Alumno> alumnos;
	final int COLS=3;
	
	//le pedimos en el constructor que nos de todos los pedidos con el método alumnos()
	//no hace falta el constructor sin parámetros en este ejercicio
	public TablaAlumnosModel() {
		alumnos=FormacionServiceFactory.getFormacionService().alumnosCurso(0);
	}
	
	
	public TablaAlumnosModel(int idCurso) {
		alumnos= FormacionServiceFactory.getFormacionService().alumnosCurso(idCurso);
	}
	

	@Override
	public int getRowCount() {
		return alumnos.size();
	}
	@Override
	public int getColumnCount() {
		
		return COLS;
	}
	@Override
	public String getColumnName(int column) {
		
		switch(column) {
			case 0:
				return "Nombre";
			case 1:
				return "DNI";
			case 2:
				return "Nota";
			default:
				return "Indeterminada";
		}
	}
	@Override
	public Object getValueAt(int row, int column) {
		switch(column) {
			case 0:
				return alumnos.get(row).getNombre();
			case 1:
				return alumnos.get(row).getDni();
			case 2:
				return alumnos.get(row).getNota();
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
				return Double.class;
			default:
				return null;
		}
	}
		
	
	
}
