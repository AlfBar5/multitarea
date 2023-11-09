package dao;

import java.time.LocalDate;

public class DaoFactory {
	
	
	public static AlumnosDao getAlumnosDao() {
		return new AlumnosDaoImpl();
	}

	
	public static CursosDao getCursosDao() {
		return new CursosDaoImpl();
	}


	
	
	
}
