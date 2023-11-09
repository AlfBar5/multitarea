package service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import dao.DaoFactory;
import dao.FicheroPedidosDao;
import dao.PedidosDao;
import model.Pedido;



public class PedidosServiceImpl implements PedidosService {

	
	
	
	@Override
	public List<Pedido> pedidosTienda(String ruta, String tienda) {
		
		//Leemos fichero json
		FicheroPedidosDao fDao=DaoFactory.getFicheroPedidosDao();
		List<Pedido> pedidosFichero=fDao.getPedidos(ruta);
		//recorremos los pedidos que llegan del fichero y les asignamos 
		//tienda
		pedidosFichero.forEach(p->p.setTienda(tienda));
		return pedidosFichero;
	
	}

	@Override
	public void guardarPedidos(List<Pedido> pedidos) {
		PedidosDao pDao=DaoFactory.getPedidosDao();
		//recorremos lista de pedidos y los guardamos
		pedidos.forEach(p->pDao.guardarPedido(p));

	}
	


	

}
