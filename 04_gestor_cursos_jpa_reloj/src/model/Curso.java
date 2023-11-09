package model;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name="cursos") //le damos el nombre de la tabla. El motor de persistencia se encarga de los insert, delete, etc

public class Curso {
	
	//Ponemos estas dos anotaciones en el campo PrimaryKey. No es AutoIncremental
	@Id
	private int idCurso;
	private String curso;
	private int duracion;
	private double precio;
	private LocalDate fechaInicio;
	
	//necesario para leer los alumnos del json y guardarlos en una lista
	//hay que decirle que la ignore en la PERSISTENCIA, porque no es una entidad de la base de datos
	@Transient
	private List<Alumno> alumnos;
	
	
	
	/*
	//constructor sobrecarga con 3 parámetros (sin idCurso)
	public Curso(String nombre, int duracion, double precio) {
		super();
		this.nombre= nombre;
		this.duracion= duracion;
		this.precio = precio;
		
	}
	*/

	//para que se vea el objeto producto y no el objeto hashmodel
	//CAm:  
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return curso;
		}
	
	
}



