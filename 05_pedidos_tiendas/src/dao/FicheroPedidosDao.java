package dao;

import java.util.List;

import model.Pedido;

public interface FicheroPedidosDao {
	List<Pedido> getPedidos(String ruta);
}

