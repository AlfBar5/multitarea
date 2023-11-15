package service;

import java.util.List;

import model.Pedido;

public interface PedidosService {
	
	//pedidos por tienda
	List<Pedido> pedidosTienda(String tienda);
	
	//todos los pedidos
	List<Pedido> pedidosTienda();
	
	//alta pedidos. Recibe un objeto Pedido
	void altaPedido(Pedido pedido);

}
