package clothingstore;
import clothingstore.login;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Color;

public class shirt extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTable table_4;
	private JTable table_5;
	private JTable table_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					shirt frame = new shirt();
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
	public shirt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1063, 609);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.setBounds(954, 10, 85, 21);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new login().setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton,this,"Error while establishing connection failed",0);
				}
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("SHIRTS AVAILABLE");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(356, 28, 275, 31);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(356, 89, 240, 295);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new shirt1().setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton_1).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton_1,this,"Error while establishing connection failed",0);
				}
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\91934\\Downloads\\WhatsApp Image 2024-05-16 at 6.33.25 PM.jpeg"));
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(34, 86, 245, 301);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new shirt1().setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton_3).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton_3,this,"Error while establishing connection failed",0);
				}
				
			}
		});
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\91934\\Downloads\\WhatsApp Image 2024-05-16 at 6.53.04 PM.jpeg"));
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setBounds(687, 89, 230, 295);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new shirt1().setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton_4).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton_4,this,"Error while establishing connection failed",0);
				}
			}
		});
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\91934\\Downloads\\WhatsApp Image 2024-05-16 at 6.27.43 PM.jpeg"));
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("show");
		btnNewButton_5.setBounds(100, 527, 85, 21);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
					Statement st=con.createStatement();
					String sql="select *from shirt where Fashion='printed' ";
					PreparedStatement pts=con.prepareStatement(sql);
					ResultSet rs= pts.executeQuery();
					DefaultTableModel dt=(DefaultTableModel)table_4.getModel();
					dt.setRowCount(0);
					
					
					while(rs.next()) {
					Object o[]= {rs.getString("stockin"),rs.getString("colours"),rs.getString("price")};
					dt.addRow(o);
					}
				}
			
				catch(Exception ec) {
					JOptionPane.showMessageDialog(null,"it has not been registered");
					ec.printStackTrace();
				}
			}
		});
		contentPane.add(btnNewButton_5);
		
		table = new JTable();
		table.setBounds(34, 412, 1, 1);
		contentPane.add(table);
		
		table_1 = new JTable();
		table_1.setBounds(34, 424, 1, 1);
		contentPane.add(table_1);
		
		table_2 = new JTable();
		table_2.setBounds(10, 412, 1, 1);
		contentPane.add(table_2);
		
		table_3 = new JTable();
		table_3.setBounds(34, 434, 1, 1);
		contentPane.add(table_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 434, 245, 71);
		contentPane.add(scrollPane);
		
		table_4 = new JTable();
		table_4.setBackground(new Color(175, 238, 238));
		table_4.setForeground(Color.RED);
		table_4.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		table.setRowHeight(40);
		scrollPane.setViewportView(table_4);
		table_4.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"stockin", "colours", "Price"
			}
		));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(367, 434, 226, 71);
		contentPane.add(scrollPane_1);
		
		table_5 = new JTable();
		table_5.setBackground(new Color(175, 238, 238));
		table_5.setForeground(Color.RED);
		table_5.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		scrollPane_1.setViewportView(table_5);
		table_5.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"stockin", "colours", "price"
			}
		));
		
		JButton btnNewButton_5_1 = new JButton("show");
		btnNewButton_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
					Statement st=con.createStatement();
					String sql="select *from shirt where Fashion='plain' ";
					PreparedStatement pts=con.prepareStatement(sql);
					ResultSet rs= pts.executeQuery();
					DefaultTableModel dt=(DefaultTableModel)table_5.getModel();
					dt.setRowCount(0);
					
					
					//PreparedStatement pts=con.prepareStatement(login.sq1);
					
					while(rs.next()) {
					
					
					Object o[]= {rs.getString("stockin"),rs.getString("colours"),rs.getString("price")};
					dt.addRow(o);
					
					
					}
                   
					}
					
			
				catch(Exception ec) {
					JOptionPane.showMessageDialog(null,"it has not been registered");
					ec.printStackTrace();
				}
				
			}
		});
		btnNewButton_5_1.setBounds(433, 541, 85, 21);
		contentPane.add(btnNewButton_5_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(713, 434, 207, 71);
		contentPane.add(scrollPane_2);
		
		table_6 = new JTable();
		table_6.setBackground(new Color(175, 238, 238));
		table_6.setForeground(Color.RED);
		table_6.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		scrollPane_2.setViewportView(table_6);
		table_6.setModel(new DefaultTableModel(
			new Object[][] {
				{"stockin", "", ""},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"stockin", "colours", "price"
			}
		));
		
		JButton btnNewButton_5_1_1 = new JButton("show");
		btnNewButton_5_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
					Statement st=con.createStatement();
					String sql="select *from shirt where Fashion='striped' ";
					PreparedStatement pts=con.prepareStatement(sql);
					ResultSet rs= pts.executeQuery();
					DefaultTableModel dt=(DefaultTableModel)table_6.getModel();
					dt.setRowCount(0);
					
					
					//PreparedStatement pts=con.prepareStatement(login.sq1);
					
					while(rs.next()) {
					
					
					Object o[]= {rs.getString("stockin"),rs.getString("colours"),rs.getString("price")};
					dt.addRow(o);
				
					
					}
                   
					
					}
					
			
				catch(Exception ec) {
					JOptionPane.showMessageDialog(null,"it has not been registered");
					ec.printStackTrace();
				}
				
			}
		});
		btnNewButton_5_1_1.setBounds(782, 541, 85, 21);
		contentPane.add(btnNewButton_5_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\91934\\Downloads\\1.jpg"));
		lblNewLabel_1.setBounds(0, 0, 1049, 572);
		contentPane.add(lblNewLabel_1);
	}
}
