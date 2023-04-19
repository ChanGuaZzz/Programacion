package Login;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Olvido_contraseña extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField correore;
	private JTextField usuariore;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Olvido_contraseña frame = new Olvido_contraseña();
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
	public Olvido_contraseña() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textInactiveText);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Recuperar Contraseña");
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 21));
		lblNewLabel.setBounds(80, 11, 256, 29);
		contentPane.add(lblNewLabel);
		
		correore = new JTextField();
		correore.setBounds(155, 99, 204, 20);
		contentPane.add(correore);
		correore.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Correo electronico");
		lblNewLabel_1.setBounds(45, 100, 107, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Usuario");
		lblNewLabel_1_1.setBounds(45, 64, 107, 18);
		contentPane.add(lblNewLabel_1_1);
		
		usuariore = new JTextField();
		usuariore.setColumns(10);
		usuariore.setBounds(104, 63, 204, 20);
		contentPane.add(usuariore);
		
		JButton btnNewButton = new JButton("Enviar Codigo de recuperacion");
		btnNewButton.setBounds(115, 179, 193, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Atras");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame ventanaPrincipal= new INTERFACE();
				setVisible(false);
				ventanaPrincipal.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(10, 227, 89, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Pantalla emergente");
				boolean correcto= false;
				
				
				if (usuariore.getText().length()==0 ||correore.getText().length()==0 ) {
                    JOptionPane.showMessageDialog(contentPane, "Hace falta informacion ", "inicio de sesion erronea", JOptionPane.ERROR_MESSAGE);
                }else {
                	for (int i = 0; i <correore.getText().length(); i++) {
                        if (correore.getText().charAt(i) == '@') {
                            correcto = true;
                            break;
                        }}
                	if(!correcto) {
                		JOptionPane.showMessageDialog(contentPane, "correo incorrecto", "recuperacion erronea", JOptionPane.ERROR_MESSAGE);
                		
                	}
                	else {
                		
                	
                	JOptionPane.showMessageDialog(btnNewButton, "Codigo Enviado", "Recuperacion", JOptionPane.INFORMATION_MESSAGE);
                	JFrame inicio= new INTERFACE();
    				inicio.setVisible(true);
    				setVisible(false);
                	}
            }
				
				
			}
		});
	}
}