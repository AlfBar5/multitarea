package tareas;

import java.util.List;

import model.Pedido;
import service.PedidosService;
import service.PedidosServiceFactory;

public class Lanzador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		new Thread (new TareaPedidos("c:\\temp\\pedidos\\tienda1.json","tienda1")).start();
		new Thread (new TareaPedidos("c:\\temp\\pedidos\\tienda2.json","tienda2")).start();
		new Thread (new TareaPedidos("c:\\temp\\pedidos\\tienda3.json","tienda3")).start();
		*/
		
		String ruta1 = "c:\\\\temp\\\\pedidos\\\\tienda1.json";
		String ruta2 = "c:\\\\temp\\\\pedidos\\\\tienda2.json";
		String ruta3 = "c:\\\\temp\\\\pedidos\\\\tienda3.json";
		
		
		PedidosService service=PedidosServiceFactory.getPedidosService();
					
		/*
		new Thread(()->{			
			List<Pedido> pedidos=service.pedidosTienda(ruta1, "tienda1");
			service.guardarPedidos(pedidos);
		}).start();
			
		new Thread(()->{			
			List<Pedido> pedidos=service.pedidosTienda(ruta2, "tienda2");
			service.guardarPedidos(pedidos);
		}).start();
		
		new Thread(()->{			
			List<Pedido> pedidos=service.pedidosTienda(ruta3, "tienda3");
			service.guardarPedidos(pedidos);
		}).start();
			
		*/
		
		
		new Thread(()->service.guardarPedidos(service.pedidosTienda(ruta1, "tienda1"))).start();
		new Thread(()->service.guardarPedidos(service.pedidosTienda(ruta2, "tienda2"))).start();
		new Thread(()->service.guardarPedidos(service.pedidosTienda(ruta3, "tienda3"))).start();
		
		
	}

}
