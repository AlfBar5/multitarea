package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.FormacionServiceFactory;
import view.adapters.TablaCursosModel;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.awt.event.ActionEvent;

public class JConsultaFechasCursos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtF1;
	private JTextField txtF2;
	private JTable tbCursos;

	

	/**
	 * Create the frame.
	 */
	public JConsultaFechasCursos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtF1 = new JTextField();
		txtF1.setBounds(55, 38, 86, 20);
		contentPane.add(txtF1);
		txtF1.setColumns(10);
		
		txtF2 = new JTextField();
		txtF2.setColumns(10);
		txtF2.setBounds(303, 38, 86, 20);
		contentPane.add(txtF2);
		
		JButton btnCursos = new JButton("BUSCAR CURSOS");
		btnCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				var service = FormacionServiceFactory.getFormacionService();
				//metemos un trycatch por si alguien mete mal la fecha
				try {
					
					//parseamos las dos fechas
					var f1=LocalDate.parse(txtF1.getText());
					var f2=LocalDate.parse(txtF2.getText());
					
					tbCursos.setModel(new TablaCursosModel(f1,f2));
					
				//buscar en la ayuda la excepción del método parse	
				}catch(DateTimeParseException ex){
					ex.printStackTrace();
					JOptionPane.showMessageDialog(JConsultaFechasCursos.this, "Error en las fechas");
				}
				
				
			}
		});
		btnCursos.setBounds(112, 77, 177, 23);
		contentPane.add(btnCursos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 123, 414, 127);
		contentPane.add(scrollPane);
		
		tbCursos = new JTable();
		scrollPane.setViewportView(tbCursos);
		
		JLabel lblNewLabel = new JLabel("Fecha Inicio");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel.setBounds(54, 11, 103, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblFechaFin = new JLabel("Fecha Fin");
		lblFechaFin.setFont(new Font("Verdana", Font.BOLD, 12));
		lblFechaFin.setBounds(299, 13, 103, 16);
		contentPane.add(lblFechaFin);
		
		this.setVisible(true);
	}
}
