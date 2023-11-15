package service;

import java.util.List;

import model.Pedido;

public interface PedidosService {
	
	public List<Pedido> pedidosTienda(String tienda);
	
	public void envioPedido(Pedido pedido);

}
