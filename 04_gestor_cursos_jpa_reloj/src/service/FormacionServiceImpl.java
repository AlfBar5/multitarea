package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JOptionPane;

import dao.AlumnosDao;
import dao.CursosDao;
import dao.CursosJsonDao;
import dao.DaoFactory;
import model.Alumno;
import model.Curso;

public class FormacionServiceImpl implements FormacionService {

	
	
	

	//comprobar si existe el curso
	//si no existe lo guardamos
	//comprobar si no existe el alumno
	////si no existe lo guardamos
	@Override
	public void actualizarDatos() {
		
		//instancia de cursosService
		var CursosDao= DaoFactory.getCursosDao();
		//instancia de alumnosService
		var AlumnosDao = DaoFactory.getAlumnosDao();
		
		//por cada curso comprobamos si existe y lo grabamos
		//también metemos todos los alumnos que no existan ya
		var jsonDao = new CursosJsonDao();
		jsonDao.cursos() //recorremos curso por curso
		.forEach(c->{
			if(!CursosDao.existeCurso(c.getIdCurso())) {
				// si curso no está en BD se añade
				CursosDao.guardarCurso(c);
			}
			
			
			//recorremos alumnos del curso que estamos recorriendo
			c.getAlumnos()
			.forEach(a->{
				//comprobamos si el alumno existe
				if(!AlumnosDao.existeAlumno(a.getDni())) {
					//Metemos el idcurso al objeto Alumno, que en el json no lo tiene
					a.setIdCurso(c.getIdCurso());
					AlumnosDao.guardarAlumno(a);
				}
			});
			
			
			
		});
		
		
	}
	
	
	//Lista de curso. Llamamos al método CursosDao
	@Override
	public List<Curso> listadoCursos(){
		//crear una instacia de CursosDao
		var cursosDao= DaoFactory.getCursosDao();
		return cursosDao.cursos();
		
	}
	
	
	
	
	//método de lista de alumnos. Si pasan un 0, significa que pinto todos
	@Override
	public List<Alumno> alumnosCurso(int idCurso){
		//Instanciamos un alumnosDao
		var alumnosDao= DaoFactory.getAlumnosDao();
		
		/*
		if(idCurso == 0) {
			return alumnosDao.alumnos();
		}
		return alumnosDao.alumnos(idCurso);
		
		*/
		
		//con operador ternario. Esto es lo mismo que el if else de arriba:
		return  idCurso==0?alumnosDao.alumnos(): alumnosDao.alumnos(idCurso);
		
	}
	
	
	
	
	
	
	////Método eliminar alumno por dni. Lógina de negocio. Capa Service
	@Override
	public boolean eliminarAlumno(String dni) {
		
		AlumnosDao alumnosdao = DaoFactory.getAlumnosDao();
		
		if(!alumnosdao.existeAlumno(dni)) {
			
				
			return false;
						
		}
		return alumnosdao.eliminarAlumno(dni);
		
		}
		
	
	
	//Lista de curso. Llamamos al método CursosDao
	@Override
	public List<Curso> listadoCursosPorFechas(LocalDate fechainicio, LocalDate fechafin){
			//crear una instacia de CursosDao
			var cursosDao= DaoFactory.getCursosDao();
			
			//controlar que la fechas están no están invertidas (que fechainicio es más pequeña que fechafin
			LocalDate fMin=fechainicio.isBefore(fechafin)?fechainicio:fechafin;
			LocalDate fMax=fechainicio.isBefore(fechafin)?fechafin:fechainicio;
			
			return cursosDao.cursosBusquedaFechas(fMin, fMax);
			
		}
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

