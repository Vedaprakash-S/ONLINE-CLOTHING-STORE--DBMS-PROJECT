package clothingstore;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class sorl extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtContactUsAlso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					sorl frame = new sorl();
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
	public sorl() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 908, 667);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new front().setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton,this,"Error while establishing connection failed",0);
				}
			}
		}); 
		
		txtContactUsAlso = new JTextField();
		txtContactUsAlso.setBackground(new Color(143, 188, 143));
		txtContactUsAlso.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtContactUsAlso.setText("CONTACT US ALSO IN:www.vyntra.com");
		txtContactUsAlso.setBounds(504, 587, 366, 33);
		contentPane.add(txtContactUsAlso);
		txtContactUsAlso.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("SHOPPING ::))");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_2_1.setBounds(362, 428, 375, 69);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2 = new JLabel("HAVE A HAPPPIEEE");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_2.setBounds(85, 374, 375, 69);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("WELCOME TO VYNTRA FASHION STORE");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBackground(SystemColor.controlShadow);
		lblNewLabel_1.setFont(new Font("Algerian", Font.PLAIN, 35));
		lblNewLabel_1.setBounds(132, 55, 617, 78);
		contentPane.add(lblNewLabel_1);
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 20));
		btnNewButton.setBounds(362, 224, 127, 33);
		contentPane.add(btnNewButton);
		
		JButton btnSignup = new JButton("Create New Account");
		btnSignup.setForeground(Color.BLACK);
		btnSignup.setBackground(Color.WHITE);
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new signup().setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton,this,"Error while establishing connection failed",0);
				}
			}
		});
		btnSignup.setFont(new Font("Tahoma", Font.ITALIC, 20));
		btnSignup.setBounds(322, 295, 232, 33);
		contentPane.add(btnSignup);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\91934\\Downloads\\login2.jpg"));
		lblNewLabel.setBounds(0, 0, 894, 630);
		contentPane.add(lblNewLabel);
	}
}
