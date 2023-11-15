package service;

public class PedidosServiceFactory {
	
	public static PedidosService getPedidosService() {
		
		return new PedidosServiceImpl();
		
	}
	

}
