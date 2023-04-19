package Login;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.UIManager;
import Conexion.Consultas;

import javax.swing.JCheckBox;

public class INTERFACE extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField contraseñainicio;
	private JTextField usuarioinicio;
	
	static INTERFACE ventanaPrincipal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaPrincipal = new INTERFACE();
					ventanaPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public INTERFACE() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton boton_inicio = new JButton("Iniciar Sesion");
		boton_inicio.setFont(new Font("Arial Black", Font.PLAIN, 11));
		boton_inicio.setBounds(55, 205, 135, 23);
		boton_inicio.setVerticalAlignment(SwingConstants.BOTTOM);
		contentPane.add(boton_inicio);
		boton_inicio.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				
				 if (usuarioinicio.getText().length()==0 ||contraseñainicio.getText().length() == 0) {
	                    JOptionPane.showMessageDialog(contentPane, "Hace falta informacion", "inicio de sesion erronea", JOptionPane.ERROR_MESSAGE);
	                   
	                }else {
	                	if(usuarioinicio.getText().equals("admin")&& contraseñainicio.getText().equals("admin")) {
	                		
	                		JFrame admin= new Panel_Admin();
	                		admin.setVisible(true);
	                		setVisible(false);
	                		
	                	}else {
	                		
	            		
	            		
	                if(Consultas.comprobarDatos(usuarioinicio.getText(), contraseñainicio.getText())) {
	                	JFrame inicio= new Bienvenido();
	    				inicio.setVisible(true);
	    				setVisible(false);
	                	
	                }else {
	                	 JOptionPane.showMessageDialog(contentPane, "Usuario o contraseña incorrecto", "inicio de sesion erronea", JOptionPane.ERROR_MESSAGE);
	                }

	                	
	            }
				
	                }
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblNewLabel.setBounds(55, 83, 121, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Iniciar Sesion");
		lblNewLabel_1.setFont(new Font("Stencil", Font.PLAIN, 34));
		lblNewLabel_1.setBounds(82, 0, 289, 83);
		contentPane.add(lblNewLabel_1);
		
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblContrasea.setBounds(55, 128, 121, 14);
		contentPane.add(lblContrasea);
		
		contraseñainicio = new JPasswordField();
		contraseñainicio.setBounds(186, 126, 165, 20);
		contentPane.add(contraseñainicio);
		contraseñainicio.setEchoChar('●');
		
		
		
		usuarioinicio = new JTextField();
		usuarioinicio.setBounds(151, 81, 172, 20);
		contentPane.add(usuarioinicio);
		usuarioinicio.setColumns(10);
		
		JButton boton_registro = new JButton("Registrarme");
		boton_registro.setFont(new Font("Arial Black", Font.PLAIN, 11));
		boton_registro.setBounds(223, 205, 148, 23);
		contentPane.add(boton_registro);
		
		JButton contrasenaolvidada = new JButton("Olvide la contraseña");
		contrasenaolvidada.setForeground(Color.BLUE);
		contrasenaolvidada.setBorder(null);
		contrasenaolvidada.setBackground(null);
		
		contrasenaolvidada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame contraseña= new Olvido_contraseña();
				contraseña.setVisible(true);
				setVisible(false);
			}
		});
		contrasenaolvidada.setBackground(UIManager.getColor("CheckBox.light"));
		contrasenaolvidada.setBounds(207, 102, 172, 23);
		contentPane.add(contrasenaolvidada);
		
		JCheckBox boton_ver = new JCheckBox("Mostrar contraseña");
		
		boton_ver.addActionListener(new ActionListener() {
			boolean activado= false;
			public void actionPerformed(ActionEvent e) {
				
				if(!activado) {
					activado=true;
					contraseñainicio.setEchoChar((char)(0));
					
					
				}else {
					activado=false;
					contraseñainicio.setEchoChar('●');
					
				}
			
				
			}
		});
		boton_ver.setBounds(253, 153, 148, 23);
		contentPane.add(boton_ver);
		boton_registro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Registrarse");
				JFrame registro= new Registro();
				registro.setVisible(true);
				setVisible(false);
				
			}
		});;
		
	}
}