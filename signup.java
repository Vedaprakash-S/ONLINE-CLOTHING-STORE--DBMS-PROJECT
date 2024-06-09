package clothingstore;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.Color;

public class signup extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField newuser;
	private JPasswordField newpass;
	private JPasswordField cpass;
	private JTextField user;
	private JPasswordField pass;
	private JPasswordField pass1;
	private JButton btnNewButton1;
	private JLabel error;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signup frame = new signup();
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
	public signup() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("username");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(43, 154, 106, 22);
		getContentPane().add(lblNewLabel);
		
		user = new JTextField();
		user.setBounds(210, 159, 96, 19);
		getContentPane().add(user);
		user.setColumns(10);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPassword.setBounds(43, 244, 106, 22);
		getContentPane().add(lblPassword);
		
		pass = new JPasswordField();
		pass.setBounds(210, 249, 84, 19);
		getContentPane().add(pass);
		
		JLabel lblConfirmPassword = new JLabel("confirm password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblConfirmPassword.setBounds(43, 333, 197, 22);
		getContentPane().add(lblConfirmPassword);
		
		pass1 = new JPasswordField();
		pass1.setBounds(234, 333, 84, 19);
		getContentPane().add(pass1);
		
		JButton btnNewButton = new JButton("create");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.setBounds(309, 399, 116, 21);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("back");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(64, 402, 85, 21);
		getContentPane().add(btnNewButton_1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Show Password");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton_1.isSelected()) {
					newpass.setEchoChar((char)0);
							}
							else {
								newpass.setEchoChar('*');
							}
			}
		});
		 
		 JLabel lblNewLabel_3 = new JLabel("Should contain one uppercase,three lowercase and one number");
		 lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		 lblNewLabel_3.setForeground(Color.WHITE);
		 lblNewLabel_3.setBounds(87, 249, 585, 25);
		 contentPane.add(lblNewLabel_3);
		
		 error = new JLabel("");
		 error.setBounds(234, 443, 221, 21);
		 contentPane.add(error);
		rdbtnNewRadioButton_1.setBounds(445, 212, 103, 21);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Show Password");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					cpass.setEchoChar((char)0);
							}
							else {
								cpass.setEchoChar('*');
							}
			}
		});
		rdbtnNewRadioButton.setBounds(445, 280, 103, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		JLabel lblNewLabel_1 = new JLabel("username");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_1.setBounds(87, 138, 101, 23);
		contentPane.add(lblNewLabel_1);
		
		newuser = new JTextField();
		newuser.setBounds(234, 144, 172, 19);
		contentPane.add(newuser);
		newuser.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("password");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_1_1.setBounds(87, 207, 101, 23);
		contentPane.add(lblNewLabel_1_1);
		
		newpass = new JPasswordField();
		newpass.setBounds(238, 213, 168, 19);
		contentPane.add(newpass);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("confirm password");
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_1_1_1.setBounds(32, 275, 172, 23);
		contentPane.add(lblNewLabel_1_1_1);
		
		cpass = new JPasswordField();
		cpass.setBounds(238, 279, 168, 23);
		contentPane.add(cpass);
		
		JButton btnNewButton1;
		btnNewButton1 = new JButton("create");
		btnNewButton1.addActionListener(new ActionListener() {
			private int y;

			public void actionPerformed(ActionEvent e) {
				int et=0;
				try{String us = newuser.getText();
				
				String np = newpass.getText();
				String cp=cpass.getText();
				if(np.equals(cp)) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
				System.out.println("1");
				Statement st = con.createStatement();
				String sql2 = "select count(*) as COUNT from access";
				PreparedStatement ps2 = con.prepareStatement(sql2);
				ResultSet res2 = ps2.executeQuery();
				String sql = "SELECT * FROM access";
				ResultSet res1 = st.executeQuery(sql);
				int c = 0;
				String input = np;
				int inputLen = input.length();
				int uppercount=0;
				int lowercount=0;
	        	int digitcount=0;
				for(int j =0; j < inputLen ; j++)
				{
					char ch = input.charAt(j);
					if (Character.isUpperCase(ch))
						uppercount++;
					else if (Character.isLowerCase(ch))
						lowercount++;
					else if (Character.isDigit(ch))
						digitcount++;
					else
						y++;
				}
				System.out.print(uppercount);
				System.out.print(lowercount);
				System.out.print(digitcount);
				System.out.print(np);
				
				
				while(res2.next()) {
					c = res2.getInt(1);
					
				}
				c=c+2;
				while(res1.next()) {
					String use1 = res1.getString("username");
					if(!us.equals(use1) && np.equals(cp)&& uppercount >= 1 && lowercount >= 3 && digitcount >=1) {
						String sql3 = "insert into access values('"+us+"','"+np+"')";
						
						PreparedStatement pts = con.prepareStatement(sql3);
						pts.executeUpdate(sql3);
						JOptionPane.showMessageDialog(null, "Successfully inserted");
					
					
						try {
							front newframe = new front();
						    newframe.setVisible(true);
							SwingUtilities.windowForComponent(btnNewButton1).dispose();
							break;
						}
						catch(Exception a)
						{
							JOptionPane.showMessageDialog(btnNewButton1, this, "Error while establishing connection failed", 0);
						}
						
					}
					else {
						newuser.setText("");
						newpass.setText("");
					}
				}}
				else {
					JOptionPane.showMessageDialog( null, "password mismatch");
				}
				if(et==0) {
					error.setText("Invalid password or username");
				}
			}
					
				
				
				catch(Exception r) {
					JOptionPane.showMessageDialog(null, "username exists");
								}
				
			}
		});
		btnNewButton1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnNewButton1.setBounds(422, 373, 115, 21);
		contentPane.add(btnNewButton1);
		
		JButton btnNewButton_11 = new JButton("back");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new front().setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton_11).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton_11,this,"Error while establishing connection failed",0);
				}
			}
		});
		btnNewButton_11.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_11.setBounds(117, 373, 115, 21);
		contentPane.add(btnNewButton_11);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\91934\\Downloads\\signup.jpg"));
		lblNewLabel_2.setBounds(0, -43, 696, 575);
		contentPane.add(lblNewLabel_2);
	}
}
