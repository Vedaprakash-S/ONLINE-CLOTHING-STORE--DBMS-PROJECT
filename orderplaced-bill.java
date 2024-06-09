package clothingstore;
import clothingstore.front;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class orderplaced extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JButton btnBill;
	private JTable table_3;
	private JButton btnBill_1;
	private JTable table_2;
	private JLabel lblNewLabel;
	private JButton btnNewButton_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextArea textArea;
	private JButton btnNewButton_2;
	private JButton btnPrint;
	private JButton btnClear;
	private JButton btnExit;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					orderplaced frame = new orderplaced();
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
	public orderplaced() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1323, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(344, 10, 0, 0);
		contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 49, 554, 130);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		scrollPane.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, "payment", null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"quantity", "size", "colour", "payment", "Fashion", "price", "firstname", "lastname", "contactno", "address"
			}
		));
		
		JButton btnNewButton = new JButton("show");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {


					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
					Statement st=con.createStatement();
					String sql="select * from order1 natural join profile where username='"+front.us+"'";
					
					PreparedStatement pts=con.prepareStatement(sql);
					ResultSet rs= pts.executeQuery();
					DefaultTableModel dt=(DefaultTableModel)table_1.getModel();
					dt.setRowCount(0);
					while(rs.next()) {
					
					Object o[]= {rs.getString("quantity"),rs.getString("size"),rs.getString("colour"),rs.getString("payment"),rs.getString("Fashion"),rs.getString("price"),rs.getString("firstname"),rs.getString("lastname"),rs.getString("contactno"),rs.getString("address")};
					dt.addRow(o);
					
					}
			}
				catch(Exception ec) {
					JOptionPane.showMessageDialog(null,"it has not been registered");
					ec.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(44, 23, 85, 21);
		contentPane.add(btnNewButton);
		
		btnBill = new JButton("bill");
		btnBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
				Statement st=con.createStatement();
				String sql="select count(Fashion),sum(quantity),sum(price)from order1 natural join profile where username='"+front.us+"'";
				//String tp="select firstname from login.profile where username='"+front.us+"'";
				
				PreparedStatement pts=con.prepareStatement(sql);
				//PreparedStatement pts3=con.prepareStatement(tp);
				ResultSet rs= pts.executeQuery();
				//ResultSet rs4= pts3.executeQuery();
				
				
				DefaultTableModel dt=(DefaultTableModel)table_3.getModel();
				dt.setRowCount(0);
				while(rs.next()) {
					
				Object s[]= {rs.getString("count(Fashion)")};
				dt.addRow(s);
				Object o[]= {rs.getString("sum(quantity)")};
				dt.addRow(o);
				Object g[]= {rs.getString("sum(price)")};
				dt.addRow(g);
				
					String f=rs.getString("count(Fashion)");
					String v=rs.getString("sum(quantity)");
					String k=rs.getString("sum(price)");
					//String pvr=rs.getString("firstname");
					
					textField.setText(f);
					textField_1.setText(v);
					textField_2.setText(k);
					//textField_3.setText(pvr);
					
					
					
			   
				
				}
		}
			catch(Exception ec) {
				JOptionPane.showMessageDialog(null,"it has not been registered");
				ec.printStackTrace();
			}
					
					
			}
		});
		btnBill.setBounds(186, 18, 85, 21);
		contentPane.add(btnBill);
		
		table_3 = new JTable();
		table_3.setRowHeight(30);
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
			},
			new String[] {
				"New column"
			}
		));
		table_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		table_3.setBounds(330, 270, 194, 90);
		contentPane.add(table_3);
		
		btnBill_1 = new JButton("billpage");
		btnBill_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new billllll().setVisible(true);
					SwingUtilities.windowForComponent(btnBill_1).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnBill_1,this,"Error while establishing connection failed",0);
				}
			}
		});
		btnBill_1.setBounds(384, 23, 85, 21);
		contentPane.add(btnBill_1);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{"Total variety of items"},
				{"Total items purchased"},
				{"Total price"},
			},
			new String[] {
				"New column"
			}
		));
		table_2.setRowHeight(30);
		table_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		table_2.setBounds(112, 270, 226, 90);
		contentPane.add(table_2);
		
		lblNewLabel = new JLabel("Bill Summary");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(238, 228, 124, 21);
		contentPane.add(lblNewLabel);
		
		btnNewButton_1 = new JButton("online payment");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new onlinepayment().setVisible(true);
					SwingUtilities.windowForComponent(btnBill_1).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnBill_1,this,"Error while establishing connection failed",0);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_1.setBounds(465, 381, 124, 21);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(299, 463, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(299, 505, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(299, 556, 96, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Total variety of items");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(100, 466, 189, 21);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Total items purchased");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(100, 508, 189, 27);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Total Price");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(147, 556, 124, 19);
		contentPane.add(lblNewLabel_3);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(737, 23, 524, 643);
		contentPane.add(scrollPane_1);
		
		textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		textArea.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 14));
		textArea.setBorder(new LineBorder(new Color(0,0,0),4));
		
		btnNewButton_2 = new JButton("ADD RECORD");
		btnNewButton_2.addActionListener(new ActionListener() {
			private String cp;
			

			public void actionPerformed(ActionEvent e) {
				textArea.append("\n\n\n"+
						"Phone NO:7806854324\t\t\twww.vyntra.com\n"+
						"Fax:0427-23567\t\t\temail:vyntra23@gmail.com\n\n\n"+
						"\t\tVYNTRA'S FASHION LIMITED\n\n");
				/*try {
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
							Statement st=con.createStatement();
							String sql="select *from profile where username='"+front.us+"'";
							PreparedStatement pts=con.prepareStatement(sql);
							//PreparedStatement pts3=con.prepareStatement(tp);
							ResultSet rs= pts.executeQuery();
					while(rs.next()) {
						String h="Firstname:\t\t\t\t\t\t"+rs.getString(1)+"\n";
						String c="Lastname:\t\t\t\t\t\t"+rs.getString(2)+"\n";
						String hc="Contactno:\t\t\t\t\t\t"+rs.getString(3)+"\n";
						String ch="Lastname:\t\t\t\t\t\t\t"+rs.getString(4)+"\n";
						
						textArea.append(h);
						textArea.append(c);
						textArea.append(hc);
						textArea.append(ch);
					}}
					catch(Exception er) {
						er.printStackTrace();
					}*/
						
textArea.append(		"\t\t     BILL SUMMARY\n\n"+
						"Reference NO: \t\t\t vyntra1234" +
						"\n=======================================================\n\n");
try {
	Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
			Statement st=con.createStatement();
			String sql="select *from profile where username='"+front.us+"'";
			PreparedStatement pts=con.prepareStatement(sql);
			//PreparedStatement pts3=con.prepareStatement(tp);
			ResultSet rs= pts.executeQuery();
	while(rs.next()) {
		String h=" Firstname:\t\t\t\t"+rs.getString(1)+"\n";
	
		String c=" Lastname:\t\t\t\t"+rs.getString(2)+"\n";
		String hc=" Contactno:\t\t\t\t"+rs.getString(3)+"\n";
		String ch=" Address:\t\t\t\t"+rs.getString(4)+"\n";
		
		textArea.append(h);
		textArea.append(	"-------------------------------------------------------\n");
		
		
		textArea.append(c);
		textArea.append(	"-------------------------------------------------------\n");
		
		textArea.append(hc);
		textArea.append(	"-------------------------------------------------------\n");
		
		textArea.append(ch);
		textArea.append(	"-------------------------------------------------------\n");
		
	}}
	catch(Exception er) {
		er.printStackTrace();
	}
SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
Calendar cp= Calendar.getInstance();
cp.setTime(new Date());
cp.add(Calendar.DATE, 5);
String output=sdf.format(cp.getTime());
System.out.println(output);
textArea.append(		
		" Total variety of items:\t\t"+textField.getText()+"\n"+
		"-------------------------------------------------------\n"+
		
		" Total no of items:\t\t\t"+textField_1.getText()+"\n"+
		"-------------------------------------------------------\n"+
		" Total price:\t\t\t\t"+textField_2.getText()+"\n"+
		"-------------------------------------------------------\n"+
		"Delivered on:\t\t\t\t"+output+"\n\n"+
		"=========================================================\n\n\n\n\n"
	
		);
textArea.append("              Purchase Summary\n\n\ns");

textArea.append("Quantity  Size  Colour	   Payment	    Fashion   Price\n");
try {
	Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
			Statement st=con.createStatement();
			String sql="select *from order1 where username='"+front.us+"'";
			PreparedStatement pts=con.prepareStatement(sql);
			//PreparedStatement pts3=con.prepareStatement(tp);
			ResultSet rs= pts.executeQuery();
	while(rs.next()) {
		String h=rs.getString(1)+"	  "+rs.getString(2)+"	 "+rs.getString(3)+"    "+rs.getString(4)+"   "+rs.getString(5)+"	"+rs.getString("price")+"\n";
		textArea.append(	"-------------------------------------------------------\n");
		String c="size:  "+rs.getString(2)+"\n";
		String hc="Colour:\t\t\t  "+rs.getString(3)+"\n";
		String ch="Payment:\t\t\t  "+rs.getString(4)+"\n";
		String hcf="Fashion:\t\t\t  "+rs.getString(5)+"\n";
		String chv="Price:\t\t\t  "+rs.getString("price")+"\n";
		textArea.append(h);
		//textArea.append(	"-------------------------------------------------------\n");
		
		/*textArea.append(c);
		textArea.append(	"-------------------------------------------------------\n");
		
		textArea.append(hc);
		textArea.append(	"-------------------------------------------------------\n");
		
		textArea.append(ch);
		textArea.append(	"-------------------------------------------------------\n");
		
		textArea.append(hcf);
		textArea.append(	"-------------------------------------------------------\n");
		
		textArea.append(chv);
		textArea.append(	"-------------------------------------------------------\n");*/
		
		;
	}}
	catch(Exception er) {
		er.printStackTrace();
	}

textArea.append(		
						
						"=========================================================\n\n\n\n\n"+
						"\t\tTHANK YOU FOR YOUR SHOPPING :))\n"+
						"\t Stay connected with us to enjoy the deals\n"
						
						);
						
						
						
						
				/*try {
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
							Statement st=con.createStatement();
							String sql="select *from profile where username='"+front.us+"'";
							PreparedStatement pts=con.prepareStatement(sql);
							//PreparedStatement pts3=con.prepareStatement(tp);
							ResultSet rs= pts.executeQuery();
					while(rs.next()) {
						String h="Quantity:\t\t\t  "+rs.getString(1)+"\n";
						String c="size:\t\t\t  "+rs.getString(2)+"\n";
						String hc="Colour:\t\t  "+rs.getString(3)+"\n";
						String ch="Payment:\t\t  "+rs.getString(4)+"\n";
						String hcf="Fashion:\t\t  "+rs.getString(5)+"\n";
						String chv="Price:\t\t  "+rs.getString(6)+"\n";
						textArea.append(h);
						textArea.append(c);
						textArea.append(hc);
						textArea.append(ch);
						textArea.append(hcf);
						textArea.append(chv);
					}}
					catch(Exception er) {
						er.printStackTrace();
					}*/
				
				/*try {
				Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
						Statement st=con.createStatement();
						String sql="select *from order1 where username='"+front.us+"'";
						PreparedStatement pts=con.prepareStatement(sql);
						//PreparedStatement pts3=con.prepareStatement(tp);
						ResultSet rs= pts.executeQuery();
				while(rs.next()) {
					String h="Quantity:"+rs.getString(1)+"\n";
					String c="size:"+rs.getString(2);
					String hc="Colour:\t\t\t"+rs.getString(3)+"\n";
					String ch="Payment:\t\t\t"+rs.getString(4)+"\n";
					String hcf="Fashion:\t\t\t"+rs.getString(5)+"\n";
					String chv="Price:\t\t\t"+rs.getString(6)+"\n";
					textArea.append(h);
					textArea.append(c);
					textArea.append(hc);
					textArea.append(ch);
					textArea.append(hcf);
					textArea.append(chv);
					;
				}}
				catch(Exception er) {
					er.printStackTrace();
				}*/
				
			}
		});
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Calendar c= Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, 5);
		String output=sdf.format(c.getTime());
		System.out.println(output);
		btnNewButton_2.setBounds(208, 630, 85, 21);
		contentPane.add(btnNewButton_2);
		
		btnPrint = new JButton("PRINT");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.print();
				}
				catch(PrinterException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnPrint.setBounds(327, 630, 85, 21);
		contentPane.add(btnPrint);
		
		btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				
			}
		});
		btnClear.setBounds(465, 630, 85, 21);
		contentPane.add(btnClear);
		
		btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				frame=new JFrame();
				if(JOptionPane.showConfirmDialog(frame, "confirm want to exit","Print System",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
					System.exit(0);
				}
			}
		});
		btnExit.setBounds(579, 630, 85, 21);
		contentPane.add(btnExit);
	}
}
