package model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name="pedidos") //le damos el nombre de la tabla. El motor de persistencia se encarga de los insert, delete, etc

public class Pedido {

	//Ponemos estas dos anotaciones en el campo PrimaryKey. La segunda es que el campo es AutoIncremental
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPedido;
	private String tienda;
	private String producto;
	private LocalDate fechaPedido;
	private double precio;
	
	
}
