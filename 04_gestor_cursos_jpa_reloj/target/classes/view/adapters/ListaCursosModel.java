package view.adapters;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

import dao.CursosDao;
import model.Curso;
import service.FormacionService;
import service.FormacionServiceFactory;

public class ListaCursosModel extends DefaultComboBoxModel<Curso> {
	
	
	List<Curso> cursos;
	
	public ListaCursosModel() {
		
		cursos=new ArrayList<>(FormacionServiceFactory.getFormacionService().listadoCursos());
		//añadimos todos en lugar del campo correspodiente al campo curso
		//Es decir le añadimos un registro más con el nombre de campo -TODOS-
		cursos.add(0, new Curso(0, "-TODOS-",0,0,null,null));
	}
	

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return cursos.size();
	}

	@Override
	public Curso getElementAt(int index) {
		// TODO Auto-generated method stub
		return cursos.get(index);
	}

	
	
}
