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
import javax.swing.ImageIcon;

public class trousers extends JFrame {

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
					trousers frame = new trousers();
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
	public trousers() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("back");
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
		btnNewButton.setBounds(568, 0, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("boxers");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\91934\\Pictures\\Screenshots\\Screenshot 2024-05-26 171726.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new trouser().setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton,this,"Error while establishing connection failed",0);
				}

			}
		});
		btnNewButton_1.setBounds(10, 24, 313, 289);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("casual");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\91934\\Pictures\\Screenshots\\Screenshot 2024-05-26 171836.png"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new trouser().setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton,this,"Error while establishing connection failed",0);
				}

			}
		});
		btnNewButton_2.setBounds(365, 26, 254, 306);
		contentPane.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 342, 275, 77);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
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
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(388, 342, 231, 77);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
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
		
		JButton btnShow = new JButton("show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
					Statement st=con.createStatement();
					String sql="select *from trouser where Fashion='boxers' ";
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
		btnShow.setBounds(117, 429, 85, 21);
		contentPane.add(btnShow);
		
		JButton btnNewButton_4 = new JButton("show");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
					Statement st=con.createStatement();
					String sql="select *from trouser where Fashion='casual' ";
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
		btnNewButton_4.setBounds(444, 429, 85, 21);
		contentPane.add(btnNewButton_4);
	}

}
