package clothingstore;
import clothingstore.front;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
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
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class addtocartsss extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JLabel lblSize;
	private JLabel lblColour;
	private JLabel lblPayment;
	private JLabel lblFashion;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_2;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addtocartsss frame = new addtocartsss();
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
	public addtocartsss() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 787, 673);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(66, 71, 697, 253);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"quantity", "size", "colour", "payment", "Fashion"
			}
		));
		
		JButton btnNewButton = new JButton("show");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
					Statement st=con.createStatement();
					String sql="select * from addtocart where username='"+front.us+"'";
					
					PreparedStatement pts=con.prepareStatement(sql);
					ResultSet rs= pts.executeQuery();
					DefaultTableModel dt=(DefaultTableModel)table.getModel();
					dt.setRowCount(0);
					while(rs.next()) {
					
					Object o[]= {rs.getString("quantity"),rs.getString("size"),rs.getString("colour"),rs.getString("payment"),rs.getString("Fashion")};
					dt.addRow(o);
					}
			}
				catch(Exception ec) {
					JOptionPane.showMessageDialog(null,"it has not been registered");
					ec.printStackTrace();
				}
			}
			
		});
		btnNewButton.setBounds(75, 40, 85, 21);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("Quantity");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(206, 372, 73, 21);
		contentPane.add(lblNewLabel);
		
		lblSize = new JLabel("Size");
		lblSize.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSize.setBounds(206, 409, 73, 21);
		contentPane.add(lblSize);
		
		lblColour = new JLabel("colour");
		lblColour.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblColour.setBounds(206, 442, 73, 21);
		contentPane.add(lblColour);
		
		lblPayment = new JLabel("payment");
		lblPayment.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPayment.setBounds(206, 481, 73, 21);
		contentPane.add(lblPayment);
		
		lblFashion = new JLabel("Fashion");
		lblFashion.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFashion.setBounds(206, 524, 73, 21);
		contentPane.add(lblFashion);
		
		textField = new JTextField();
		textField.setBounds(300, 376, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"xs", "m", "s", "l", "xl", "xxl", "xxxl"}));
		comboBox.setBounds(310, 412, 73, 21);
		contentPane.add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setBounds(300, 446, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(300, 485, 96, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(300, 528, 96, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("order");
		btnNewButton_1.addActionListener(new ActionListener() {
			private int stockin;
			private int rowsAffected;
			private int f1;
            private int rw;
			private PreparedStatement psr;
			private PreparedStatement pst;
			private String q3;
			private PreparedStatement psr9;
			private PreparedStatement pst9;
			private Connection con1;
			private Connection con2;
			private String quantity;
			private String s1;
			private String colour;
			private String payment;
			private String Fashion;
			private Connection pst11;
			private int rw12;
			private PreparedStatement psr11;
			public void actionPerformed(ActionEvent e) {
				quantity=textField.getText();
				
				//String size=textField_2.getText();
				s1=(String) comboBox.getSelectedItem();
			     colour=textField_1.getText();
			     payment=textField_3.getText();
			     Fashion=textField_2.getText();
			    System.out.println(quantity+colour+payment+s1+Fashion);
			  
				try {
					    
					    
					    
					    Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
						//Statement siy=con2.createStatement();
						if(Fashion.equals("striped") || Fashion.equals("plain") || Fashion.equals("printed")) {
							System.out.println(quantity+colour+payment+s1+Fashion);
							Statement siy=con.createStatement();
							String q2= "select quantity from addtocart where colour='"+colour+"' and Fashion='"+Fashion+"'";
						String qw = "select price from shirt where colours='"+colour+"' and Fashion ='"+Fashion+"'";
						//String qs = "select price from pant where colours='"+colour+"' and Fashion ='"+Fashion+"'";
						//String qp = "select price from tshirt where colours='"+colour+"' and Fashion ='"+Fashion+"'";
						
						PreparedStatement pts1=con.prepareStatement(q2);
						PreparedStatement pts3=con.prepareStatement(qw);
						ResultSet rs4= pts3.executeQuery();
						ResultSet rs= pts1.executeQuery();
						while(rs.next()&&rs4.next()) {
						rw=Integer.parseInt(rs4.getString(1));
						stockin=rs.getInt(1);}
						System.out.print(stockin);
						int r1=Integer.parseInt(quantity);
						System.out.println(r1);
				
						
						q3 = "update addtocart set quantity='"+(stockin-r1)+"' where colour = '"+colour+"'and Fashion='"+Fashion+"'";
						String q4 = "update shirt set stockin='"+(stockin-r1)+"' where colours = '"+colour+"'and Fashion='"+Fashion+"'";
					    String query = "insert into order1 values('"+quantity+"','"+s1+"','"+colour+"','"+payment+"','"+Fashion+"','"+front.us+"','"+(rw*r1)+"');";
					    
					    psr=con.prepareStatement(q4);
					    pst = con.prepareStatement(query);
						
					    if(r1<=stockin) {
					    pst.executeUpdate(q3);
					    rowsAffected = pst.executeUpdate();
					    psr.executeUpdate();
					    //pst.executeUpdate(query);
					    }
					    else {
					    	JOptionPane.showMessageDialog(null, "Out of stock");
					    	f1=1;
					    }
					    /*pst.setString(1, quantity);
					    pst.setString(2, size);
					    pst.setString(3,colour);
					    pst.setString(4, payment);*/
					    //pst.executeUpdate(query);
					/*Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
				    String query = "INSERT INTO order (`quantity`, `size`, `colour`, `payment`) VALUES (?,?,?,?);";
				    PreparedStatement pst = con.prepareStatement(query);
				    pst.setString(1, quantity);
				    pst.setString(2, size);
				    pst.setString(3,colour);
				    pst.setString(4, payment);*/
						
										    
				    
				    
				    if (rowsAffected > 0 && f1==0) {
				        JOptionPane.showMessageDialog(null, "order placed successfully");
				        setVisible(false);
				        new login().setVisible(true);
				    } else {
				        JOptionPane.showMessageDialog(null, "OOPS! order cannot be placed");
				    }
				    
				    pst.close();
				    con.close();
				}
				else if(Fashion.equals("jean") || Fashion.equals("cotton") || Fashion.equals("cargo") ){
					Statement sib=con.createStatement();
					String q9= "select quantity from addtocart where colour='"+colour+"' and Fashion='"+Fashion+"'";
					String qp = "select price from pant1 where colours='"+colour+"' and Fashion ='"+Fashion+"'";
					//String qs = "select price from pant where colours='"+colour+"' and Fashion ='"+Fashion+"'";
					//String qp = "select price from tshirt where colours='"+colour+"' and Fashion ='"+Fashion+"'";
					
					PreparedStatement pts9=con.prepareStatement(q9);
					PreparedStatement pts10=con.prepareStatement(qp);
					ResultSet rs9= pts10.executeQuery();
					ResultSet rp= pts9.executeQuery();
					while(rp.next()&&rs9.next()) {
					rw=Integer.parseInt(rs9.getString(1));
					stockin=rp.getInt(1);}
					System.out.print(stockin);
					int r1=Integer.parseInt(quantity);
					System.out.println(r1);
			
					
					q9 = "update addtocart set quantity='"+(stockin-r1)+"' where colour = '"+colour+"'and Fashion='"+Fashion+"'";
					String q10 = "update shirt set stockin='"+(stockin-r1)+"' where colours = '"+colour+"'and Fashion='"+Fashion+"'";
				    String query = "insert into order1 values('"+quantity+"','"+s1+"','"+colour+"','"+payment+"','"+Fashion+"','"+front.us+"','"+(rw*r1)+"');";
				    
				    psr9=con.prepareStatement(q10);
				    pst9 = con.prepareStatement(query);
					
				    if(r1<=stockin) {
				    pst9.executeUpdate(q9);
				    rowsAffected = pst9.executeUpdate();
				    psr9.executeUpdate();
				    //pst.executeUpdate(query);
				    }
				    else {
				    	JOptionPane.showMessageDialog(null, "Out of stock");
				    	f1=1;
				    }
				    /*pst.setString(1, quantity);
				    pst.setString(2, size);
				    pst.setString(3,colour);
				    pst.setString(4, payment);*/
				    //pst.executeUpdate(query);
				/*Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
			    String query = "INSERT INTO order (`quantity`, `size`, `colour`, `payment`) VALUES (?,?,?,?);";
			    PreparedStatement pst = con.prepareStatement(query);
			    pst.setString(1, quantity);
			    pst.setString(2, size);
			    pst.setString(3,colour);
			    pst.setString(4, payment);*/
					
					
			    
			    
			    
			    if (rowsAffected > 0 && f1==0) {
			        JOptionPane.showMessageDialog(null, "order placed successfully");
			        setVisible(false);
			        new login().setVisible(true);
			    } else {
			        JOptionPane.showMessageDialog(null, "OOPS! order cannot be placed");
			    }
			    
			    pst9.close();
			    con.close();
			}
				else if(Fashion.equals("roundneck") || Fashion.equals("collar")  ){
					Statement sib=con1.createStatement();
					String q11= "select quantity from addtocart where colour='"+colour+"' and Fashion='"+Fashion+"'";
					String qps = "select price from tshirt where colours='"+colour+"' and Fashion ='"+Fashion+"'";
					//String qs = "select price from pant where colours='"+colour+"' and Fashion ='"+Fashion+"'";
					//String qp = "select price from tshirt where colours='"+colour+"' and Fashion ='"+Fashion+"'";
					
					PreparedStatement pts11=con.prepareStatement(q11);
					PreparedStatement pts12=con.prepareStatement(qps);
					ResultSet rs12= pts12.executeQuery();
					ResultSet rp12= pts11.executeQuery();
					while(rp12.next()&&rs12.next()) {
					rw12=Integer.parseInt(rs12.getString(1));
					stockin=rp12.getInt(1);}
					System.out.print(stockin);
					int r1=Integer.parseInt(quantity);
					System.out.println(r1);
			
					
					q11 = "update addtocart set quantity='"+(stockin-r1)+"' where colour = '"+colour+"'and Fashion='"+Fashion+"'";
					String q10 = "update tshirt set stockin='"+(stockin-r1)+"' where colours = '"+colour+"'and Fashion='"+Fashion+"'";
				    String query = "insert into order1 values('"+quantity+"','"+s1+"','"+colour+"','"+payment+"','"+Fashion+"','"+front.us+"','"+(rw*r1)+"');";
				    
				    psr11=con.prepareStatement(q10);
				    pst11 = (Connection) con.prepareStatement(query);
					
				    if(r1<=stockin) {
				    ((Statement) pst11).executeUpdate(q11);
				    rowsAffected = ((PreparedStatement) pst11).executeUpdate();
				    psr.executeUpdate();
				    //pst.executeUpdate(query);
				    }
				    else {
				    	JOptionPane.showMessageDialog(null, "Out of stock");
				    	f1=1;
				    }
				    /*pst.setString(1, quantity);
				    pst.setString(2, size);
				    pst.setString(3,colour);
				    pst.setString(4, payment);*/
				    //pst.executeUpdate(query);
				/*Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
			    String query = "INSERT INTO order (`quantity`, `size`, `colour`, `payment`) VALUES (?,?,?,?);";
			    PreparedStatement pst = con.prepareStatement(query);
			    pst.setString(1, quantity);
			    pst.setString(2, size);
			    pst.setString(3,colour);
			    pst.setString(4, payment);*/
					
					
			    
			    
			    
			    if (rowsAffected > 0 && f1==0) {
			        JOptionPane.showMessageDialog(null, "order placed successfully");
			        setVisible(false);
			        new login().setVisible(true);
			    } else {
			        JOptionPane.showMessageDialog(null, "OOPS! order cannot be placed");
			    }
			    
			    pst11.close();
			    con.close();
			}
				else if(Fashion.equals("roundneck") || Fashion.equals("collar")  ){
					Statement sib=con1.createStatement();
					String q11= "select quantity from addtocart where colour='"+colour+"' and Fashion='"+Fashion+"'";
					String qps = "select price from trouser where colours='"+colour+"' and Fashion ='"+Fashion+"'";
					//String qs = "select price from pant where colours='"+colour+"' and Fashion ='"+Fashion+"'";
					//String qp = "select price from tshirt where colours='"+colour+"' and Fashion ='"+Fashion+"'";
					
					PreparedStatement pts11=con.prepareStatement(q11);
					PreparedStatement pts12=con.prepareStatement(qps);
					ResultSet rs12= pts12.executeQuery();
					ResultSet rp12= pts11.executeQuery();
					while(rp12.next()&&rs12.next()) {
					rw12=Integer.parseInt(rs12.getString(1));
					stockin=rp12.getInt(1);}
					System.out.print(stockin);
					int r1=Integer.parseInt(quantity);
					System.out.println(r1);
			
					
					q11 = "update addtocart set quantity='"+(stockin-r1)+"' where colour = '"+colour+"'and Fashion='"+Fashion+"'";
					String q10 = "update trouser set stockin='"+(stockin-r1)+"' where colours = '"+colour+"'and Fashion='"+Fashion+"'";
				    String query = "insert into order1 values('"+quantity+"','"+s1+"','"+colour+"','"+payment+"','"+Fashion+"','"+front.us+"','"+(rw*r1)+"');";
				    
				    psr11=con.prepareStatement(q10);
				    pst11 = (Connection) con.prepareStatement(query);
					
				    if(r1<=stockin) {
				    ((Statement) pst11).executeUpdate(q11);
				    rowsAffected = ((PreparedStatement) pst11).executeUpdate();
				    psr.executeUpdate();
				    //pst.executeUpdate(query);
				    }
				    else {
				    	JOptionPane.showMessageDialog(null, "Out of stock");
				    	f1=1;
				    }
				    /*pst.setString(1, quantity);
				    pst.setString(2, size);
				    pst.setString(3,colour);
				    pst.setString(4, payment);*/
				    //pst.executeUpdate(query);
				/*Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
			    String query = "INSERT INTO order (`quantity`, `size`, `colour`, `payment`) VALUES (?,?,?,?);";
			    PreparedStatement pst = con.prepareStatement(query);
			    pst.setString(1, quantity);
			    pst.setString(2, size);
			    pst.setString(3,colour);
			    pst.setString(4, payment);*/
					
					
			    
			    
			    
			    if (rowsAffected > 0 && f1==0) {
			        JOptionPane.showMessageDialog(null, "order placed successfully");
			        setVisible(false);
			        new login().setVisible(true);
			    } else {
			        JOptionPane.showMessageDialog(null, "OOPS! order cannot be placed");
			    }
			    
			    pst11.close();
			    con.close();
			}
						}
				catch (Exception e1) {
				    e1.printStackTrace();
				    // Handle any SQL errors
				}

			}
			
		});
		btnNewButton_1.setBounds(286, 574, 85, 21);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    String colour=textField_1.getText();
				String Fashion=textField_2.getText();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
					String sql="delete from addtocart WHERE Fashion='" +Fashion+ "' and colour='"+colour+"'";
					PreparedStatement pts=con.prepareStatement(sql);
					
					
					pts.execute();
					JOptionPane.showMessageDialog(null,"it has been removed");
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						//Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
						Statement st=con.createStatement();
						String sql1="select * from addtocart where username='"+front.us+"'";
						
						PreparedStatement pts1=con.prepareStatement(sql1);
						ResultSet rs= pts1.executeQuery();
						DefaultTableModel dt=(DefaultTableModel)table.getModel();
						dt.setRowCount(0);
						while(rs.next()) {
						
						Object o[]= {rs.getString("quantity"),rs.getString("size"),rs.getString("colour"),rs.getString("payment"),rs.getString("Fashion")};
						dt.addRow(o);
						}
				}
					catch(Exception ec) {
						JOptionPane.showMessageDialog(null,"it has not been registered");
						ec.printStackTrace();
					}
				}
				catch(Exception ec) {
					JOptionPane.showMessageDialog(null,"it has not been registered");
					ec.printStackTrace();
			}
			}});
		btnNewButton_2.setBounds(430, 574, 85, 21);
		contentPane.add(btnNewButton_2);
	}
}
