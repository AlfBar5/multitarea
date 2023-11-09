package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import model.Curso;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.DefaultComboBoxModel;

import view.adapters.ListaCursosModel;
import view.adapters.TablaAlumnosModel;

public class JConsultaCursos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tbAlumnos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JConsultaCursos frame = new JConsultaCursos();
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
	public JConsultaCursos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeleccionarCurso = new JLabel("SELECCIONAR CURSO:");
		lblSeleccionarCurso.setFont(new Font("Verdana Pro", Font.BOLD, 12));
		lblSeleccionarCurso.setBounds(10, 11, 179, 22);
		contentPane.add(lblSeleccionarCurso);
		
		//COMBOBOX itemStateChanged
		JComboBox cbCursos = new JComboBox();
		cbCursos.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//if(cbCursos.getSelectedIndex()==0) {
												
					//tbAlumnos.setModel(new TablaAlumnosModel(cbCursos.getSelectedItem().toString()));
					//casting para transformar a curso
					Curso curso=(Curso)cbCursos.getSelectedItem();
					//cargamos el table model con el id curso seleccionado
					tbAlumnos.setModel(new TablaAlumnosModel(curso.getIdCurso()));
					
				//}else {
				//	tbAlumnos.setModel(new TablaAlumnosModel(cbCursos.getSelectedItem().toString()));
					
				//}
				
			}
		});
		cbCursos.setBounds(208, 12, 179, 22);
		contentPane.add(cbCursos);
		
		JLabel lblAlumnos = new JLabel("ALUMNOS:");
		lblAlumnos.setFont(new Font("Verdana Pro", Font.BOLD, 12));
		lblAlumnos.setBounds(10, 61, 135, 22);
		contentPane.add(lblAlumnos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 94, 404, 156);
		contentPane.add(scrollPane);
		
		tbAlumnos = new JTable();
		scrollPane.setViewportView(tbAlumnos);
		
		//SALIR
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JConsultaCursos.this.dispose();
			}
		});
		btnSalir.setFont(new Font("Verdana", Font.BOLD, 12));
		btnSalir.setBounds(301, 61, 89, 23);
		contentPane.add(btnSalir);
		
		//asociamos el view.adapter ListaCursosModel al combobox cbCursos
		//PARA QUE DESDE EL PRINCIPIO APAREZCA LA LISTA DE CURSOS EN EL COMBOBOX
		cbCursos.setModel(new ListaCursosModel());
		
			
		//ponemos visible la ventana
		this.setVisible(true);
	}
}
