package dao;

import java.time.LocalDate;
import java.util.List;

import model.Curso;

public interface CursosDao {

	//metodo comprobar si existe curso ya en la base de datos
	boolean existeCurso(int idCurso);

	//método volcar datos del json en la base de datos formacion
	boolean guardarCurso(Curso curso);

	//Método para ver todos los cursos para rellenar el combobox
	List<Curso> cursos();
	
	//
	List<Curso> cursosBusquedaFechas(LocalDate fechainicio, LocalDate fechafin);
	

}