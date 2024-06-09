package clothingstore;

import java.awt.EventQueue;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import java.awt.Toolkit;
import java.awt.Color;

public class front extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;
	private JLabel error;
    public static String us;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() { 
				try {
					front frame = new front();
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
	public front() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1351, 776);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VYNTHRA'S FASHION STORE");
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 65));
		lblNewLabel.setBounds(176, 40, 877, 103);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("username");
		lblNewLabel_1.setBackground(UIManager.getColor("Button.focus"));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(388, 290, 164, 33);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35));
		contentPane.add(lblNewLabel_1);
		
		user = new JTextField();
		user.setBounds(562, 303, 182, 22);
		contentPane.add(user);
		user.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("password");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBounds(388, 363, 149, 32);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35));
		contentPane.add(lblNewLabel_2);
		
		pass = new JPasswordField();
		pass.setBounds(562, 373, 182, 22);
		contentPane.add(pass);
		
		JButton btnNewButton = new JButton("login");
		btnNewButton.setBounds(606, 504, 85, 33);
		btnNewButton.addActionListener(new ActionListener() {
			
		public void actionPerformed(ActionEvent e) {
				try {
					int er=0;
					us = user.getText();
					String ps = pass.getText();
					System.out.println(us);
					Class.forName("com.mysql.cj.jdbc.Driver");
					System.out.println(ps);
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
					System.out.println("1");
					Statement st = con.createStatement();
					System.out.println("1");
					String sql = "Select * from access";
					System.out.println("1");
					ResultSet rs = st.executeQuery(sql);
					System.out.println("1");
					while(rs.next()){
					String username = rs.getString("Username");
					System.out.println("1-");
					String password = rs.getString("password");
					System.out.println("1-");

					if(us.equals(username) && ps.equals(password)){
						
						new login().setVisible(true);
						System.out.println("true");
						SwingUtilities.windowForComponent(btnNewButton).dispose();
						er=0;
						}
						else{
						user.setText("");
						pass.setText("");
						System.out.println("false");
						er=1;
						
						}
					}if(er==1) {
						error.setVisible(true);
						error.setText("Invalid password");
					}
					}
					catch(Exception o) {
						JOptionPane.showMessageDialog(btnNewButton, this, "Error while establishing connection failed", 0);
					}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("forgot password?");
		btnNewButton_1.setBounds(317, 620, 195, 21);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new new_password().setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton_1).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton_1,this,"Error while establishing connection failed",0);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("sign up");
		btnNewButton_2.setBounds(841, 621, 120, 21);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new signup().setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton_1).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton_1,this,"Error while establishing connection failed",0);
				}
				
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnNewButton_2);
		
		 error = new JLabel("");
		 error.setBounds(402, 450, 195, 31);
		 error.setForeground(new Color(255, 0, 0));
		contentPane.add(error);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("show password");
		rdbtnNewRadioButton.setBounds(815, 386, 189, 21);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
if(rdbtnNewRadioButton.isSelected()) {
			pass.setEchoChar((char)0);
					}
					else {
						pass.setEchoChar('*');
					}
				}
				
			
		});
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(rdbtnNewRadioButton);
		
		JLabel lblNewLabel_3 = new JLabel("VYNTRA'S FASHION APP");
		lblNewLabel_3.setFont(new Font("Algerian", Font.ITALIC, 30));
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\91934\\Pictures\\Screenshots\\Screenshot 2024-05-26 190852.png"));
		lblNewLabel_3.setBounds(0, 0, 1327, 739);
		contentPane.add(lblNewLabel_3);
	}
}
