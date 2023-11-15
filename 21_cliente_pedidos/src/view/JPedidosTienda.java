package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import service.PedidosServiceFactory;
import view.adapters.TablaPedidosModel;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class JPedidosTienda extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTienda;
	private JTable tbPedidos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JPedidosTienda frame = new JPedidosTienda();
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
	public JPedidosTienda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre tienda:");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 22, 105, 24);
		contentPane.add(lblNewLabel);
		
		txtTienda = new JTextField();
		txtTienda.setBounds(136, 23, 133, 24);
		contentPane.add(txtTienda);
		txtTienda.setColumns(10);
		
		JButton btnVerPedidos = new JButton("VER PEDIDOS");
		btnVerPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Lleno el jtable
				tbPedidos.setModel(new TablaPedidosModel(txtTienda.getText()));
				
				
			}
		});
		btnVerPedidos.setFont(new Font("Verdana", Font.BOLD, 12));
		btnVerPedidos.setBounds(290, 23, 134, 23);
		contentPane.add(btnVerPedidos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 69, 414, 181);
		contentPane.add(scrollPane);
		
		tbPedidos = new JTable();
		scrollPane.setViewportView(tbPedidos);
	}
}
