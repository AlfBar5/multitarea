package model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@NoArgsConstructor
@AllArgsConstructor
@Data


@Entity
@Table(name="alumnos") //le damos el nombre de la tabla. El motor de persistencia se encarga de los insert, delete, etc



public class Alumno {
	//Ponemos estas dos anotaciones en el campo PrimaryKey. No es un campo autoincremental
	@Id
	private String dni;
	private int idCurso;
	private String nombre;
	private int edad;
	private double nota;
	
	
	
	

}
