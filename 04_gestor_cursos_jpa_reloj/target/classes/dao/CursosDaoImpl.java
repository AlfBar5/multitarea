package dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import static helpers.EntityManagerLocator.*;

import model.Alumno;
//import helpers.ConnectionLocator;
import model.Curso;

//Para importar el método y ahorrar código
//import static helpers.ConnectionLocator.getConnection;


public class CursosDaoImpl implements CursosDao {
	
	
	// DATOS DE CONEXIÓN BD mySQL
	
	
		
	
	
	//metodo comprobar si existe curso ya en la base de datos
	@Override
	public boolean existeCurso(int idCurso) {
		
		
		return getEntityManager().find(Curso.class, idCurso)!=null;
		
		
		
	}
	
	
	
	
	
	
	

	//método volcar datos del json en la base de datos formacion
	@Override
	public boolean guardarCurso(Curso curso) {
		
		try {
			EntityManager em=getEntityManager();
			EntityTransaction tx=em.getTransaction();
			tx.begin();
			em.persist(curso);
			tx.commit();
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
		
	}
	
	
	
	//Método para ver todos los cursos para rellenar el combobox
	@Override
	public List<Curso> cursos(){
		
		//EntityManager em=getEntityManager();
				
		//Creamos el jpql. Son nombre de ENTIDADES (NO DE TABLAS)
		// ?1 -- el nñumero indica la posición del parámetro
		String jpql ="select c from Curso c";
		
		//creamos el typedQuery. Le damos el jpql y le decimos en tipo de opjeto que tiene que devolver -- Empleado
		
		return getEntityManager()
				.createQuery(jpql, Curso.class)
				.getResultList();
		
	}


	
	
	
	//Método para ver todos los cursos que se inicien entre dos fechas y sacar un listado de cursos
		@Override
		public List<Curso> cursosBusquedaFechas(LocalDate fechainicio, LocalDate fechafin){
			

			/*
			 * EntityManager em=getEntityManager();
			 */
			
			
			//Creamos el jpql. Son nombre de ENTIDADES (NO DE TABLAS)
			// ?1 -- el nñumero indica la posición del parámetro
			String jpql ="select c from Curso c where c.fechaInicio between ?1 and ?2";
			

			return getEntityManager()
					.createQuery(jpql, Curso.class)
					.setParameter(1, fechainicio)
					.setParameter(2, fechafin)
					.getResultList();
			
			
			
			
		}

	
				
	
	
	

}
