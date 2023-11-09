package service;

import java.time.LocalDate;
import java.util.List;

import model.Alumno;
import model.Curso;

public interface FormacionService {

	//comprobar si existe el curso
	//si no existe lo guardamos
	//comprobar si no existe el alumno
	////si no existe lo guardamos
	void actualizarDatos();

	//Lista de curso. Llamamos al método CursosDao
	List<Curso> listadoCursos();

	//método de lista de alumnos. Si pasan un 0, significa que pinto todos
	List<Alumno> alumnosCurso(int idCurso);

	////Método eliminar alumno por dni. Lógina de negocio. Capa Service
	boolean eliminarAlumno(String dni);
	
	//Lista de curso. Llamamos al método CursosDao
	List<Curso> listadoCursosPorFechas(LocalDate fechainicio, LocalDate fechafin);

}