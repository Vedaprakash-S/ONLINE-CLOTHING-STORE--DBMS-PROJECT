package clothingstore;

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
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class tshirt extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tshirt frame = new tshirt();
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
	public tshirt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 718);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("roundneck");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\91934\\Pictures\\Screenshots\\Screenshot 2024-05-26 170031.png"));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new t_shirt().setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton,this,"Error while establishing connection failed",0);
				}
			}
		});
		btnNewButton.setBounds(34, 26, 276, 371);
		contentPane.add(btnNewButton);
		
		JButton btnCollar = new JButton("collar");
		btnCollar.setIcon(new ImageIcon("C:\\Users\\91934\\Pictures\\Screenshots\\Screenshot 2024-05-26 170333.png"));
		btnCollar.setForeground(Color.WHITE);
		btnCollar.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnCollar.setBackground(new Color(0, 0, 0));
		btnCollar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new t_shirt().setVisible(true);
					SwingUtilities.windowForComponent(btnCollar).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnCollar,this,"Error while establishing connection failed",0);
				}
			}
		});
		btnCollar.setBounds(360, 26, 276, 371);
		contentPane.add(btnCollar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 431, 265, 90);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"stockin", "colours", "price"
			}
		));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(410, 431, 226, 90);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"stockin", "colours", "price"
			}
		));
		
		JButton btnNewButton_1 = new JButton("show");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
					Statement st=con.createStatement();
					String sql="select *from tshirt where Fashion='roundneck' ";
					PreparedStatement pts=con.prepareStatement(sql);
					ResultSet rs= pts.executeQuery();
					DefaultTableModel dt=(DefaultTableModel)table.getModel();
					dt.setRowCount(0);
					
					
					//PreparedStatement pts=con.prepareStatement(login.sq1);
					
					while(rs.next()) {
					
					
					Object o[]= {rs.getString("stockin"),rs.getString("colours"),rs.getString("price")};
					dt.addRow(o);
					/*Object b[]= {rs.getString("colours")};
					dt.addRow(b);
					
					Object d[]= {rs.getString("price")};
					dt.addRow(d);*/
					/*Object v[]= {rs.getString("Fashion")};
					dt.addRow(v);
					Object f[]= {rs.getString("price")};
					dt.addRow(f);
					Object g[]= {rs.getString("firstname")};
					dt.addRow(g);
					Object h[]= {rs.getString("lastname")};
					dt.addRow(h);
					Object i[]= {rs.getString("contactno")};
					dt.addRow(i);
					Object j[]= {rs.getString("address")};
					dt.addRow(j);*/
					
					}
                   /*String sq2="select *from shirt where Fashion='striped' ";
					
					PreparedStatement ps=con.prepareStatement(sq2);
					//PreparedStatement ps=con.prepareStatement(login.sq1);
					ResultSet is= ps.executeQuery();
					DefaultTableModel di=(DefaultTableModel)table_5.getModel();
					dt.setRowCount(0);
					while(rs.next()) {
					
					
					Object o[]= {rs.getString("stockin"),rs.getString("colours"),rs.getString("price")};
					dt.addRow(o);
					/*Object b[]= {rs.getString("colours")};
					dt.addRow(b);*/
					
					/*Object d[]= {rs.getString("price")};
					dt.addRow(d);*/
					/*Object v[]= {rs.getString("Fashion")};
					dt.addRow(v);
					Object f[]= {rs.getString("price")};
					dt.addRow(f);
					Object g[]= {rs.getString("firstname")};
					dt.addRow(g);
					Object h[]= {rs.getString("lastname")};
					dt.addRow(h);
					Object i[]= {rs.getString("contactno")};
					dt.addRow(i);
					Object j[]= {rs.getString("address")};
					dt.addRow(j);*/
					
					}
					
			
				catch(Exception ec) {
					JOptionPane.showMessageDialog(null,"it has not been registered");
					ec.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(113, 549, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("show");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
					Statement st=con.createStatement();
					String sql="select *from tshirt where Fashion='collar' ";
					PreparedStatement pts=con.prepareStatement(sql);
					ResultSet rs= pts.executeQuery();
					DefaultTableModel dt=(DefaultTableModel)table_1.getModel();
					dt.setRowCount(0);
					
					
					//PreparedStatement pts=con.prepareStatement(login.sq1);
					
					while(rs.next()) {
					
					
					Object o[]= {rs.getString("stockin"),rs.getString("colours"),rs.getString("price")};
					dt.addRow(o);
					/*Object b[]= {rs.getString("colours")};
					dt.addRow(b);
					
					Object d[]= {rs.getString("price")};
					dt.addRow(d);*/
					/*Object v[]= {rs.getString("Fashion")};
					dt.addRow(v);
					Object f[]= {rs.getString("price")};
					dt.addRow(f);
					Object g[]= {rs.getString("firstname")};
					dt.addRow(g);
					Object h[]= {rs.getString("lastname")};
					dt.addRow(h);
					Object i[]= {rs.getString("contactno")};
					dt.addRow(i);
					Object j[]= {rs.getString("address")};
					dt.addRow(j);*/
					
					}
                   /*String sq2="select *from shirt where Fashion='striped' ";
					
					PreparedStatement ps=con.prepareStatement(sq2);
					//PreparedStatement ps=con.prepareStatement(login.sq1);
					ResultSet is= ps.executeQuery();
					DefaultTableModel di=(DefaultTableModel)table_5.getModel();
					dt.setRowCount(0);
					while(rs.next()) {
					
					
					Object o[]= {rs.getString("stockin"),rs.getString("colours"),rs.getString("price")};
					dt.addRow(o);
					/*Object b[]= {rs.getString("colours")};
					dt.addRow(b);*/
					
					/*Object d[]= {rs.getString("price")};
					dt.addRow(d);*/
					/*Object v[]= {rs.getString("Fashion")};
					dt.addRow(v);
					Object f[]= {rs.getString("price")};
					dt.addRow(f);
					Object g[]= {rs.getString("firstname")};
					dt.addRow(g);
					Object h[]= {rs.getString("lastname")};
					dt.addRow(h);
					Object i[]= {rs.getString("contactno")};
					dt.addRow(i);
					Object j[]= {rs.getString("address")};
					dt.addRow(j);*/
					
					}
					
			
				catch(Exception ec) {
					JOptionPane.showMessageDialog(null,"it has not been registered");
					ec.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(454, 549, 85, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new login().setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton_1).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton_1,this,"Error while establishing connection failed",0);
				}
			}
		});
		btnNewButton_3.setBounds(45, 636, 85, 21);
		contentPane.add(btnNewButton_3);
	}

}
