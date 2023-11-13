package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import view.adapters.ListaContinentesModel;
import view.adapters.TablaPaisesModel;

public class JPaises extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tbPaises;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JPaises frame = new JPaises();
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
	public JPaises() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccione Continente:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(97, 22, 178, 26);
		contentPane.add(lblNewLabel);
		
		JComboBox cbContinentes = new JComboBox();
		cbContinentes.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String continente= cbContinentes.getSelectedItem().toString();
				tbPaises.setModel(new TablaPaisesModel(continente));
			}
		});
		cbContinentes.setBounds(97, 59, 151, 22);
		contentPane.add(cbContinentes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(93, 139, 328, 115);
		contentPane.add(scrollPane);
		
		tbPaises = new JTable();
		scrollPane.setViewportView(tbPaises);
		
		cbContinentes.setModel(new ListaContinentesModel());
	}
}
