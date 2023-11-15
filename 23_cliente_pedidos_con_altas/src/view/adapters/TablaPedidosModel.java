package view.adapters;

import java.time.LocalDate;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Pedido;
import service.PedidosServiceFactory;

public class TablaPedidosModel extends AbstractTableModel {

	
	List<Pedido> pedidos;
	final int COLS=5;
	
	
	
	
	
	//le pedimos en el constructor que nos de todos los pedidos con el método pedidos()
	//constructor con parámetro tienda
	public TablaPedidosModel(String tienda) {

		pedidos=PedidosServiceFactory.getPedidosService().pedidosTienda(tienda);
		
	}




	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return pedidos.size();
	}
	
	
	

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return COLS;
	}
	
	
	
	@Override
	public String getColumnName(int column) {
		
		switch(column) {
			case 0:
				return "Id Pedido";
			case 1:
				return "Tienda";
			case 2:
				return "Producto";
			case 3:
				return "Fecha Pedido";
			case 4:
				return "Precio";
			default:
				return "Indeterminada";
		}
	}
	
	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		switch(columnIndex) {
		case 0:
			return pedidos.get(rowIndex).getIdPedido();
		case 1:
			return pedidos.get(rowIndex).getTienda();
		case 2:
			return pedidos.get(rowIndex).getProducto();
		case 3:
			return pedidos.get(rowIndex).getFechaPedido();
		case 4:
			return pedidos.get(rowIndex).getPrecio();
		default:
			return null;
	}
	}

	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		switch(columnIndex) {
			case 0:
				return int.class;
			case 1:
				return String.class;
			case 2:
				return String.class;
			case 3:
				return LocalDate.class;
			case 4:
				return Double.class;
			default:
				return null;
		}
	}
	
	
}
