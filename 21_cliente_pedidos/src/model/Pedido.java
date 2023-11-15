package model;


import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Pedido {
	
	private int idPedido;
	private String producto;
	private String tienda;
	private LocalDate fechaPedido;
	private double precio;

}
