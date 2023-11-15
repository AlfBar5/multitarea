package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Pedido;
import service.PedidosService;
import service.PedidosServiceFactory;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class JAltaPedido extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtProducto;
	private JTextField txtTienda;
	private JTextField txtFecha;
	private JTextField txtPrecio;
	private JLabel lblNewLabel;
	private JLabel lblTienda;
	private JLabel lblFecha;
	private JLabel lblPrecio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JAltaPedido frame = new JAltaPedido();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JAltaPedido() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtProducto = new JTextField();
		txtProducto.setBounds(171, 24, 86, 20);
		contentPane.add(txtProducto);
		txtProducto.setColumns(10);
		
		txtTienda = new JTextField();
		txtTienda.setColumns(10);
		txtTienda.setBounds(171, 55, 86, 20);
		contentPane.add(txtTienda);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(171, 86, 86, 20);
		contentPane.add(txtFecha);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(171, 124, 86, 20);
		contentPane.add(txtPrecio);
		
		JButton btnEnviar = new JButton("Enviar Pedido");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//pedimos a la factoría una implementación de pedidosService
				PedidosService service = PedidosServiceFactory.getPedidosService();
						
				//Creamos un objeto pedido y le pasamos los datos. el idPedido como 0
				Pedido pedido = new Pedido(
						0,
						txtProducto.getText(),
						txtTienda.getText(),
						LocalDate.parse(txtFecha.getText()),
						Double.parseDouble(txtPrecio.getText())
						);
				
				//le pasamos el objeto pedido al método envioPedido
				service.envioPedido(pedido);
				
			}
		});
		btnEnviar.setBounds(168, 174, 130, 20);
		contentPane.add(btnEnviar);
		
		lblNewLabel = new JLabel("PRODUCTO:");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel.setBounds(47, 27, 89, 17);
		contentPane.add(lblNewLabel);
		
		lblTienda = new JLabel("TIENDA:");
		lblTienda.setFont(new Font("Verdana", Font.BOLD, 12));
		lblTienda.setBounds(47, 58, 89, 17);
		contentPane.add(lblTienda);
		
		lblFecha = new JLabel("FECHA:");
		lblFecha.setFont(new Font("Verdana", Font.BOLD, 12));
		lblFecha.setBounds(47, 89, 89, 17);
		contentPane.add(lblFecha);
		
		lblPrecio = new JLabel("PRECIO:");
		lblPrecio.setFont(new Font("Verdana", Font.BOLD, 12));
		lblPrecio.setBounds(47, 127, 89, 17);
		contentPane.add(lblPrecio);
	}
}
