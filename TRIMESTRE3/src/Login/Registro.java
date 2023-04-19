package Login;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Conexion.Consultas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Registro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nombrereg;
	private JTextField apellidoreg;
	private JTextField correoreg;
	private JTextField usuarioreg;
	static Registro registro;
	private JPasswordField contraseñareg;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registro = new Registro();
					registro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 11));
		lblNewLabel.setBounds(10, 58, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel tituloreg = new JLabel("Registrarme");
		tituloreg.setBounds(109, 11, 219, 33);
		tituloreg.setFont(new Font("Stencil", Font.PLAIN, 32));
		contentPane.add(tituloreg);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 11));
		lblApellido.setBounds(20, 83, 46, 14);
		contentPane.add(lblApellido);
		
		JLabel lblNewLabel_1 = new JLabel("Correo Electronico");
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(10, 152, 126, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblUsuarioEnPantalla = new JLabel("Usuario en pantalla");
		lblUsuarioEnPantalla.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 11));
		lblUsuarioEnPantalla.setBounds(10, 177, 126, 14);
		contentPane.add(lblUsuarioEnPantalla);
		
		nombrereg = new JTextField();
		nombrereg.setBounds(76, 55, 86, 20);
		contentPane.add(nombrereg);
		nombrereg.setColumns(10);
		
		apellidoreg = new JTextField();
		apellidoreg.setColumns(10);
		apellidoreg.setBounds(76, 80, 86, 20);
		contentPane.add(apellidoreg);
		
		correoreg = new JTextField();
		correoreg.setColumns(10);
		correoreg.setBounds(124, 149, 219, 20);
		contentPane.add(correoreg);
		
		JLabel lblNewLabel_2 = new JLabel("Contraseña");
		lblNewLabel_2.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(10, 199, 138, 14);
		contentPane.add(lblNewLabel_2);
		
		usuarioreg = new JTextField();
		usuarioreg.setColumns(10);
		usuarioreg.setBounds(124, 174, 117, 20);
		contentPane.add(usuarioreg);
		
		JButton registrar = new JButton("Registrar");
		registrar.setBounds(335, 227, 89, 23);
		contentPane.add(registrar);
		
		
		registrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				
				boolean correcto= false;
				if (usuarioreg.getText().length()==0 ||contraseñareg.getText().length() == 0||nombrereg.getText().length() == 0||apellidoreg.getText().length() == 0||correoreg.getText().length() == 0) {
                    JOptionPane.showMessageDialog(contentPane, "Hace falta informacion ", "Registro de Usuario", JOptionPane.ERROR_MESSAGE);
                }else {
                	
                	if(usuarioreg.getText().equals("admin")&& contraseñareg.getText().equals("admin")){
    					JOptionPane.showMessageDialog(contentPane, "Esto es imposible ", "Registro de Usuario", JOptionPane.ERROR_MESSAGE);
    					
    				}else {
    					
    				
				
                	
                	for (int i = 0; i <correoreg.getText().length(); i++) {
                        if (correoreg.getText().charAt(i) == '@') {
                            correcto = true;
                            break;
                        }}
                	if(!correcto) {
                		JOptionPane.showMessageDialog(contentPane, "correo incorrecto", "recuperacion erronea", JOptionPane.ERROR_MESSAGE);
                		
                	}
                	else {
                		
            
                		
                		int respuesta= JOptionPane.showConfirmDialog(registrar, "Estas seguro de los datos?");
                		
                		if(respuesta==0) {
                			if(Consultas.comprobarReg(usuarioreg.getText())) {
                			
                			Consultas.insertar(correoreg.getText(),usuarioreg.getText(),contraseñareg.getText());
                		
                		JOptionPane.showMessageDialog(contentPane, "Se ha registrado", "Registro de Usuario", JOptionPane.INFORMATION_MESSAGE);
                    	JFrame inicio= new INTERFACE();
        				inicio.setVisible(true);
        				setVisible(false);
        				}else {
        					JOptionPane.showMessageDialog(registrar, "Usuario en uso", "Error de registro", JOptionPane.ERROR_MESSAGE);
        				}
                			
                		}
                			
                	}
                	
                	
            }
                }
			}
		});
		
		contraseñareg = new JPasswordField();
		contraseñareg.setBounds(124, 202, 146, 20);
		contentPane.add(contraseñareg);
		
		JButton atras = new JButton("Atras");
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame ventanaPrincipal= new INTERFACE();
				setVisible(false);
				ventanaPrincipal.setVisible(true);
				
				
			}
		});
		atras.setBounds(10, 227, 89, 23);
		contentPane.add(atras);
		
		JButton verClave = new JButton("Mostrar Clave");
		verClave.setBounds(280, 205, 109, 14);
		contentPane.add(verClave);
		
		verClave.addActionListener(new ActionListener() {
			boolean activado= false;
			public void actionPerformed(ActionEvent e) {
				
				if(!activado) {
					activado=true;
					contraseñareg.setEchoChar((char)(0));
					
					
				}else {
					activado=false;
					contraseñareg.setEchoChar('●');
					
				}
			
				
			}
		});
		
		
	}
}