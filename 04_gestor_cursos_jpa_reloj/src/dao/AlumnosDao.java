package dao;

import java.util.List;

import model.Alumno;

public interface AlumnosDao {

	//metodo comprobar si existe el alumno ya en la base de datos
	boolean existeAlumno(String dni);

	//guardar un alumno
	boolean guardarAlumno(Alumno alumno);

	//guardar una lista de alumnos
	boolean guardarAlumnos(List<Alumno> alumnos);

	//Método para sacar todos los alumnos
	List<Alumno> alumnos();

	//Método para sacar los alumnos de un curso específico
	List<Alumno> alumnos(int curso);

	////Método eliminar alumno por dni. Lógica patrón DAO. Solo ejecutamos query
	boolean eliminarAlumno(String dni);

}