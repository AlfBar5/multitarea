package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

import helpers.EntityManagerLocator;

//importamos una clase para ahorrar escritura de código
import static helpers.EntityManagerLocator.*;
import model.Alumno;




//Para importar el método y ahorrar código, ver primer try
//import static helpers.ConnectionLocator.getConnection;


public class AlumnosDaoImpl implements AlumnosDao {
	
	// DATOS DE CONEXIÓN BD mySQL
	
	
	
	//metodo comprobar si existe el alumno ya en la base de datos
	@Override
	public boolean existeAlumno(String dni) {
			
		
		return EntityManagerLocator.getEntityManager().find(Alumno.class, dni)!=null;
				
				
			
			
			
	}
	
	
	//guardar un alumno
	@Override
	public boolean guardarAlumno(Alumno alumno) {
		
		try {
			
			EntityManager em=getEntityManager();
			EntityTransaction tx=em.getTransaction();
			tx.begin();
			em.persist(alumno);
			tx.commit();
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
		
	}
	
	
	
	//guardar una lista de alumnos
	@Override
	public boolean guardarAlumnos(List<Alumno> alumnos) {
		
		try {
			EntityManager em=getEntityManager();
			EntityTransaction tx=em.getTransaction();
			tx.begin();
			for(Alumno alumno:alumnos) {
				em.persist(alumno);
			}
			tx.commit();
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}
	
	
	
	//Método para sacar todos los alumnos
	@Override
	public List<Alumno> alumnos(){

		EntityManager em=getEntityManager();
		EntityTransaction tx=em.getTransaction();
		
		String jpql="select a from Alumno a";
		
		TypedQuery<Alumno> tq= em.createQuery(jpql, Alumno.class);
		
		return tq.getResultList();
		
		
	}
	
	
	
	
	//Método para sacar los alumnos de un curso específico
	@Override
	public List<Alumno> alumnos(int curso){
		
		EntityManager em=getEntityManager();
		EntityTransaction tx=em.getTransaction();
		
		
		String jpql="select a from Alumno a where a.idCurso=?1";
		
		/*
		TypedQuery<Alumno> tq= em.createQuery(jpql, Alumno.class);
		tq.setParameter(1, curso);
		return tq.getResultList();
		*/
		
		
		//De otra forma con programación funcional
		return em
		.createQuery(jpql, Alumno.class)
		.setParameter(1, curso)
		.getResultList();
		
		
	}
	
	
	////Método eliminar alumno por dni. Lógica patrón DAO. Solo ejecutamos query
	@Override
	public boolean eliminarAlumno(String dni) {
		
		
		EntityManager em=getEntityManager();
		EntityTransaction tx=em.getTransaction();
				
		String jpql="delete from Alumno a where a.dni=?1";
				
		tx.begin();
		
		int res = em
				.createQuery(jpql)
				.setParameter(1, dni)
				.executeUpdate(); 
		
		tx.commit();
		return res>0;
		//devuelve true al compararlo con >0
		//ha eliminado a uno por lo menos
		
	}
	
	
	
}

