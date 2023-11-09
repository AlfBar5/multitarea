package service;

import java.util.List;

import model.Pedido;

public interface PedidosService {

	List<Pedido> pedidosTienda(String ruta, String tienda);
	
	void guardarPedidos(List<Pedido> pedidos);
	
	
}
