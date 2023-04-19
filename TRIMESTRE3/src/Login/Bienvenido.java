package Login;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Checkbox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Bienvenido extends JFrame {

	private JPanel contentPane;
	/**
	 * @wbp.nonvisual location=61,309
	 */
	private final JLabel label = DefaultComponentFactory.getInstance().createLabel("New JGoodies label");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bienvenido frame = new Bienvenido();
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
	public Bienvenido() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido");
		lblNewLabel.setBounds(109, 83, 205, 52);
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 47));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Cerrar sesion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame inicio= new INTERFACE();
				inicio.setVisible(true);
				setVisible(false);
				
			}
		});
		btnNewButton.setBounds(10, 227, 116, 23);
		contentPane.add(btnNewButton);
	}
}
