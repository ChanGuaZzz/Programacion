package Login;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Conexion.Conexion;
import Conexion.Consultas;

import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Panel_Admin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usuarioeliminar;
	private JTable tabla;
	private JLabel correos;
	private JLabel usuarios;
	private JLabel contra;
	
	Conexion conexion = new Conexion();
	Connection cn = null;
	Statement stm = null;
	ResultSet rs = null;
	
	private JTextField correoinsertar;
	private JTextField usuarioinsertar;
	private JTextField claveinsertar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Panel_Admin frame = new Panel_Admin();
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
	public Panel_Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 566);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.shadow"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titulo = new JLabel("Panel de administrador");
		titulo.setBounds(105, 11, 456, 52);
		titulo.setFont(new Font("Arial Black", Font.PLAIN, 36));
		contentPane.add(titulo);
		
		usuarioeliminar = new JTextField();
		usuarioeliminar.setBounds(581, 96, 86, 20);
		contentPane.add(usuarioeliminar);
		usuarioeliminar.setColumns(10);
		
		JButton delete = new JButton("DELETE");
		delete.setBounds(578, 144, 89, 23);
		
		
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
			
				if(!Consultas.comprobarReg(usuarioeliminar.getText())) {
				
								int respuesta= JOptionPane.showConfirmDialog(delete, "Estas seguro de eliminar el usuario " +"'"+ usuarioeliminar.getText()+"'"+ "?");
		            		
								if(respuesta==0) {
							
											Consultas.eliminar(usuarioeliminar.getText());
											
											
											Consultas.paneladmin(tabla);
						
								}
				}else {
					JOptionPane.showMessageDialog(delete, "Este Usuario no se encontro", "Eliminacion", JOptionPane.ERROR_MESSAGE);
				
			
			}}
		});
		contentPane.add(delete);
		
		JLabel usuariotext = new JLabel("Usuario");
		usuariotext.setBounds(525, 99, 46, 14);
		contentPane.add(usuariotext);
		
		tabla = new JTable();
		tabla.setFillsViewportHeight(true);
		tabla.setColumnSelectionAllowed(true);
		tabla.setCellSelectionEnabled(true);
		tabla.setBounds(26, 144, 443, 20);
		tabla.setRowSelectionAllowed(false);
		tabla.setEnabled(false);
		tabla.setSurrendersFocusOnKeystroke(true);
		tabla.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tabla.setBackground(UIManager.getColor("Button.shadow"));
		tabla.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"correo", "usuario", "contrasena"
			}
		));
		
		
		
		
		
		Consultas.paneladmin(tabla);
		
		
		
		
		contentPane.add(tabla);
		
		JButton btnNewButton = new JButton("Cerrar sesion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame inicio= new INTERFACE();
				inicio.setVisible(true);
				setVisible(false);
				
			}
		});
		btnNewButton.setBounds(24, 479, 116, 23);
		contentPane.add(btnNewButton);
		
		correos = new JLabel("Correo");
		correos.setBounds(26, 106, 80, 14);
		correos.setFont(new Font("Arial Black", Font.PLAIN, 15));
		contentPane.add(correos);
		
		usuarios = new JLabel("Usuario");
		usuarios.setBounds(177, 106, 80, 14);
		usuarios.setFont(new Font("Arial Black", Font.PLAIN, 15));
		contentPane.add(usuarios);
		
		contra = new JLabel("Contraseña");
		contra.setBounds(317, 106, 141, 14);
		contra.setFont(new Font("Arial Black", Font.PLAIN, 15));
		contentPane.add(contra);
		
		correoinsertar = new JTextField();
		correoinsertar.setBounds(581, 245, 86, 20);
		contentPane.add(correoinsertar);
		correoinsertar.setColumns(10);
		
		usuarioinsertar = new JTextField();
		usuarioinsertar.setColumns(10);
		usuarioinsertar.setBounds(581, 277, 86, 20);
		contentPane.add(usuarioinsertar);
		
		claveinsertar = new JTextField();
		claveinsertar.setColumns(10);
		claveinsertar.setBounds(581, 308, 86, 20);
		contentPane.add(claveinsertar);
		
		JButton botoninsertar = new JButton("INSERTAR");
		botoninsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(usuarioinsertar.getText().length()==0 ||correoinsertar.getText().length()==0 || claveinsertar.getText().length()==0 ) {
					JOptionPane.showMessageDialog(botoninsertar, "No hay datos para insertar", "Insertar Datos", JOptionPane.ERROR_MESSAGE);
				}else {
					
					if(correoinsertar.getText().contains("@")) {
						if(Consultas.comprobarReg(usuarioinsertar.getText())) {
							
							
							Consultas.insertar(correoinsertar.getText(), usuarioinsertar.getText(), claveinsertar.getText());
							JOptionPane.showMessageDialog(botoninsertar, "Perfecto", "Insertar Datos", JOptionPane.INFORMATION_MESSAGE);
							
							Consultas.paneladmin(tabla);
							
							}else {
								JOptionPane.showMessageDialog(botoninsertar, "El usuario ya existe", "introducir", JOptionPane.ERROR_MESSAGE);
							}
					}else {
						JOptionPane.showMessageDialog(botoninsertar, "correo incorrecto", "Insertar Datos", JOptionPane.ERROR_MESSAGE);
					
				}
					}
			}
		});
		botoninsertar.setBounds(578, 339, 89, 23);
		contentPane.add(botoninsertar);
		
		JLabel usuariotext_1 = new JLabel("Usuario");
		usuariotext_1.setBounds(525, 280, 46, 14);
		contentPane.add(usuariotext_1);
		
		JLabel correolabel = new JLabel("correo");
		correolabel.setBounds(525, 248, 46, 14);
		contentPane.add(correolabel);
		
		JLabel clavelabel = new JLabel("Clave");
		clavelabel.setBounds(525, 311, 46, 14);
		contentPane.add(clavelabel);
	}
}