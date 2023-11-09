package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.AlumnosDao;
import service.FormacionService;
import service.FormacionServiceFactory;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JEliminarAlumno extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDni;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	//CONSTRUCTOR
	public JEliminarAlumno() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEliminarAlumno = new JLabel("ELIMINAR ALUMNO");
		lblEliminarAlumno.setFont(new Font("Verdana Pro", Font.BOLD, 13));
		lblEliminarAlumno.setBounds(37, 26, 158, 17);
		contentPane.add(lblEliminarAlumno);
		
		JLabel lblNewLabel_1 = new JLabel("DNI:");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_1.setBounds(76, 97, 65, 24);
		contentPane.add(lblNewLabel_1);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(155, 94, 191, 33);
		contentPane.add(txtDni);
		
		//SALIR
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//cerrar esta ventana
				JEliminarAlumno.this.dispose();
			}
		});
		btnSalir.setFont(new Font("Verdana", Font.BOLD, 12));
		btnSalir.setBounds(30, 198, 89, 23);
		contentPane.add(btnSalir);
		
		
		//PATRÓN DAO, aquí ponemos todos los mensajes de ok o ko
		JButton btnEliminar = new JButton("ELIMINAR ALUMNO");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//var service = new FormacionService();
				var service =FormacionServiceFactory.getFormacionService();
				String mensaje;
				
				if(service.eliminarAlumno(txtDni.getText())){
					mensaje="Alumno eliminado satisfactoriamente";
				}else {
					mensaje="No se encuentra el dni";
				}
				JOptionPane.showMessageDialog(JEliminarAlumno.this,mensaje);
				//JEliminarAlumno.this.dispose();
				
			}
		});
		btnEliminar.setFont(new Font("Verdana", Font.BOLD, 12));
		btnEliminar.setBounds(220, 198, 191, 23);
		contentPane.add(btnEliminar);
		
		
		
		
		//ponemos visible la ventana
		this.setVisible(true);
		
	}
}
