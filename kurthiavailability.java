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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class kurthis extends JFrame {

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
					kurthis frame = new kurthis();
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
	public kurthis() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 992, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("kurthi");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\91934\\Pictures\\Screenshots\\Screenshot 2024-05-26 163330.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new kurthi().setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton,this,"Error while establishing connection failed",0);
				}

			}
		});
		btnNewButton.setBounds(107, 43, 177, 436);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Tops");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\91934\\Pictures\\Screenshots\\Screenshot 2024-05-26 163103.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new kurthi().setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton,this,"Error while establishing connection failed",0);
				}

			}
		});
		btnNewButton_1.setBounds(361, 43, 269, 436);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(95, 492, 204, 107);
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
		scrollPane_1.setBounds(389, 502, 197, 97);
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
		
		JButton btnNewButton_2 = new JButton("show");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
					Statement st=con.createStatement();
					String sql="select *from tops where Fashion='kurthi' ";
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
		btnNewButton_2.setBounds(152, 609, 85, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("show");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
					Statement st=con.createStatement();
					String sql="select *from tops where Fashion='tops' ";
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
		btnNewButton_3.setBounds(454, 630, 85, 21);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_2_1 = new JButton("back");
		btnNewButton_2_1.addActionListener(new ActionListener() {
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
		btnNewButton_2_1.setBounds(846, 28, 85, 21);
		contentPane.add(btnNewButton_2_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\91934\\Downloads\\kurthif.jpg"));
		lblNewLabel.setBounds(0, 0, 978, 673);
		contentPane.add(lblNewLabel);
	}

}
