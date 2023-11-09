package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import service.FormacionService;
import service.FormacionServiceFactory;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.InputMethodListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.awt.event.InputMethodEvent;

public class JOperacionesCursos extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	JLabel lbReloj = new JLabel("");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JOperacionesCursos frame = new JOperacionesCursos();
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
	public JOperacionesCursos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 162, 30);
		contentPane.add(menuBar);
		
		JMenu menuC = new JMenu("Menú Cursos");
		menuBar.add(menuC);
		
		JMenuItem menuActualizar = new JMenuItem("Actualizar Cursos");
		menuActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//instanciar FicheroService
				//var service = new FormacionService();
				var service =FormacionServiceFactory.getFormacionService();
				service.actualizarDatos();
				
			}
		});
		menuC.add(menuActualizar);
		
		JMenuItem menuConsulta = new JMenuItem("Consultar Cursos");
		menuConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JConsultaCursos();
			}
		});
		menuC.add(menuConsulta);
		
		JMenuItem menuEliminar = new JMenuItem("Eliminar Alumno");
		menuEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new JEliminarAlumno();
			}
		});
		menuC.add(menuEliminar);
		
		JMenuItem menuCursos = new JMenuItem("Buscador de cursos por fecha");
		menuCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new JConsultaFechasCursos();
			}
		});
		menuC.add(menuCursos);
		
		
		
		lbReloj.setFont(new Font("Verdana", Font.BOLD, 16));
		lbReloj.setBounds(141, 124, 173, 36);
		contentPane.add(lbReloj);
		
		//lapro
		new Thread(this).start();
	}

	@Override
	public void run() {
		//bucle infinito
		while(true) {
			var time=LocalTime.now();
			lbReloj.setText(time.toString());
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}
