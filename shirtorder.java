package clothingstore;
import clothingstore.login;
import clothingstore.front;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.JTextPane;


public class shirt1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JScrollPane scrollPane;
	
	private JTextField textField;
	private JComboBox comboBox;
	private JComboBox comboBox_2;
	private JButton btnSearch;
	private JTextField textField_2;
	private JButton btnBack;
	private JLabel lblNewLabel_2;
	private JTextField textField_3;
	private JLabel lblNewLabel_1;
	private JComboBox comboBox_3_1;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JLabel lblBrand;
	private JLabel lblCost;
	private JLabel lblReview;
	private JLabel lblReview_1;
	private JLabel lblStarRatings;
	private JLabel lblFashion_1;
	private JLabel lblColour_1;
	private JTextField textField_1;
	private JTextField textField_4;
	private int in=1;
	private JButton btnNewButton_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					shirt1 frame = new shirt1();
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
	public shirt1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1098, 751);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("show");
		btnNewButton.setBounds(50, 42, 85, 21);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
					Statement st=con.createStatement();
					String sql="select * from shirt";
					
					PreparedStatement pts=con.prepareStatement(sql);
					//PreparedStatement pts=con.prepareStatement(login.sq1);
					ResultSet rs= pts.executeQuery();
					DefaultTableModel dt=(DefaultTableModel)table_1.getModel();
					dt.setRowCount(0);
					while(rs.next()) {
					
					Object o[]= {rs.getString("stockin"),rs.getString("colours"),rs.getString("Fashion"),rs.getString("price")};
					dt.addRow(o);
					}
			}
				catch(Exception ec) {
					JOptionPane.showMessageDialog(null,"it has not been registered");
					ec.printStackTrace();
				}
			}
		});
		contentPane.setLayout(null);
		JButton btnNewButton_2 = new JButton("+");
		btnNewButton_2.setBackground(Color.GREEN);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				in++;
				textField.setText(""+in);
			}
		});
		btnNewButton_3 = new JButton("-");
		btnNewButton_3.setBackground(Color.RED);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(in<=1) {
					in=1;
					textField.setText(""+in);
				}
				else {
					in--;
					textField.setText(""+in);
				}
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_3.setBounds(284, 306, 45, 30);
		contentPane.add(btnNewButton_3);
		btnNewButton_2.setBounds(398, 306, 55, 30);
		contentPane.add(btnNewButton_2);
		
		
		comboBox_3_1 = new JComboBox();
		comboBox_3_1.setBounds(287, 480, 107, 26);
		comboBox_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_3_1.setModel(new DefaultComboBoxModel(new String[] {"striped", "plain", "printed"}));
		contentPane.add(comboBox_3_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(298, 401, 96, 19);
		textField_3.setColumns(10);
		contentPane.add(textField_3);
		
		JButton btnSelect = new JButton("View Shirt");
		btnSelect.setBounds(287, 558, 111, 21);
		btnSelect.addActionListener(new ActionListener() {
			

			private AbstractButton t1;
			private AbstractButton lblNewLabel_3;

		public void actionPerformed(ActionEvent e) {
				
			        String imageame=textField_3.getText();
			        String f=(String)comboBox_3_1.getSelectedItem();
			        f=f.trim();
			            try {
			                Class.forName("com.mysql.cj.jdbc.Driver");
			                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "Veda@2005");
			                String sql = "SELECT colours,Fashion FROM shirt WHERE colours=? and Fashion=?";
			                PreparedStatement pst = con.prepareStatement(sql);
			                pst.setString(1, imageame);
			                pst.setString(2, f);
			                ResultSet rs = pst.executeQuery();

			                if (rs.next()) {
			                   
			                    
			                    // Load and display the image
			                    String imageName = rs.getString("colours").replace(" ", "") +rs.getString(2).replace(" ", "")+ ".png";
			                    ImageIcon icon = new ImageIcon("image/" + imageName);
			                    Image image = icon.getImage().getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH);
			                   lblNewLabel_1.setIcon(new ImageIcon(image));

			                    // Enable the Book Ticket button
			                   
			                } else {
			                    JOptionPane.showMessageDialog(null, "shirt unavailable.");
			                    clearLabels();
			                     // Disable the Book Ticket button
			                }
			                con.close();
			            } catch (Exception ex) {
			                ex.printStackTrace();
			                JOptionPane.showMessageDialog(null, "Error occurred while searching");
			                clearLabels();
			                // Disable the Book Ticket button
			            }
			            try {
			                Class.forName("com.mysql.cj.jdbc.Driver");
			                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "Veda@2005");
			                String sql = "SELECT * FROM review WHERE colours=? and Fashion=?";
			               //String sql = "select * from review where colours = 'white' and Fashion = 'plain'";
			                PreparedStatement pst = con.prepareStatement(sql);
			                pst.setString(1, imageame);
			                pst.setString(2, f);
			                ResultSet rs = pst.executeQuery();

			                if (rs.next()) {
			                	String fs1=rs.getString("colours");
			                	String fs2=rs.getString("Fashion");
			                	String fs=rs.getString("brand");
								String v=rs.getString("cost");
								String k=rs.getString("review1");
								String p=rs.getString("review2");
								String o=rs.getString("starratings");
								textField_5.setText(fs);
								textField_6.setText(v);
								textField_7.setText(k);
								textField_8.setText(p);
								textField_9.setText(o);
								textField_1.setText(fs1);
								textField_4.setText(fs2);
								
								} 
			                else {
			                    JOptionPane.showMessageDialog(null, "shirt unavailable");
			                    clearLabels();
			                     // Disable the Book Ticket button
			                }
			                con.close();
			            } catch (Exception ex) {
			                ex.printStackTrace();
			                JOptionPane.showMessageDialog(null, "Error occurred while searching.");
			                clearLabels();
			                // Disable the Book Ticket button
			            }
			            
		}

			private void clearLabels() {
				// TODO Auto-generated method stub
				
			}
			
			
		});
		btnSelect.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(btnSelect);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(btnNewButton);
		
		table = new JTable();
		table.setBounds(73, 131, 1, 1);
		contentPane.add(table);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 138, 532, 112);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table_1.setBackground(new Color(255, 255, 255));
		table_1.setRowHeight(20);
		scrollPane.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"stockin", "colour", "fashion", "price"
			}
		));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
			Statement st=con.createStatement();
			String sql="select * from shirt";
			
			PreparedStatement pts=con.prepareStatement(sql);
			//PreparedStatement pts=con.prepareStatement(login.sq1);
			ResultSet rs= pts.executeQuery();
			DefaultTableModel dt=(DefaultTableModel)table_1.getModel();
			dt.setRowCount(0);
			while(rs.next()) {
			
			Object o[]= {rs.getString("stockin"),rs.getString("colours"),rs.getString("Fashion"),rs.getString("price")};
			dt.addRow(o);
			}
	}
		catch(Exception ec) {
			JOptionPane.showMessageDialog(null,"it has not been registered");
			ec.printStackTrace();
		}
		
		JLabel lblNewLabel = new JLabel("No of Quantity");
		lblNewLabel.setBounds(105, 310, 154, 21);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		contentPane.add(lblNewLabel);
		
		JLabel lblSize = new JLabel("Size");
		lblSize.setBounds(128, 357, 145, 21);
		lblSize.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		contentPane.add(lblSize);
		
		JLabel lblPaymentMethod = new JLabel("Payment method");
		lblPaymentMethod.setBounds(73, 438, 200, 21);
		lblPaymentMethod.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		contentPane.add(lblPaymentMethod);
		
		JLabel lblColour = new JLabel("Colour");
		lblColour.setBounds(128, 396, 145, 21);
		lblColour.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		contentPane.add(lblColour);
		
		JButton btnNewButton_1 = new JButton("Buy Now");
		btnNewButton_1.setBackground(Color.GREEN);
		btnNewButton_1.setBounds(398, 627, 134, 25);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			



			private int stockin;
			private int f1=0;
			private int rowsAffected;
			private int price;

			public void actionPerformed(ActionEvent e) {
				
				String quantity=textField.getText();
			
				//String size=textField_2.getText();
				String s1=(String) comboBox.getSelectedItem();
			    String colour=textField_3.getText();
			    String payment=(String) comboBox_2.getSelectedItem();
			    String Fashion=(String) comboBox_3_1.getSelectedItem();
			   			    System.out.println(quantity+colour+payment+s1);
			  
				try {
					    
					    
					    
					    Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
						Statement st=con.createStatement();
						String q2= "select stockin from shirt where colours='"+colour+"'and Fashion='"+Fashion+"'";
						PreparedStatement pts1=con.prepareStatement(q2);
						String q4= "select price from shirt where colours='"+colour+"'and Fashion='"+Fashion+"'";
						PreparedStatement pts2=con.prepareStatement(q4);
						
						ResultSet rs= pts1.executeQuery();
						
						ResultSet sr= pts2.executeQuery();
						while(rs.next()) {
						stockin=rs.getInt(1);}
						while(sr.next()){
							price=sr.getInt(1);}
						
						System.out.print(stockin);
						int r1=Integer.parseInt(quantity);
						System.out.println(r1);
					
						
						
						String q3 = "update shirt set stockin='"+(stockin-r1)+"' where colours = '"+colour+"'and Fashion='"+Fashion+"'";
						String query = "insert into order1 values('"+quantity+"','"+s1+"','"+colour+"','"+payment+"','"+Fashion+"','"+front.us+"','"+(price*r1)+"');";
					   // String q5 = "update order1 set price='"+(price*r1)+"' where colours = '"+colour+"'and Fashion='"+Fashion+"'and price='"+price+"'";
						
					    
					   
					    PreparedStatement pst = con.prepareStatement(query);
					    if(r1<=stockin) {
					    pst.executeUpdate(q3);
					    rowsAffected = pst.executeUpdate();
					    f1=0;
					   // pst.executeUpdate(q5);
					   // rowsAffected = pst.executeUpdate();
					    
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
				} catch (Exception e1) {
				    e1.printStackTrace();
				    // Handle any SQL errors
				}

			}
		});
		contentPane.add(btnNewButton_1);
		
		
		
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setText(""+in);
		textField.setBounds(339, 306, 55, 28);
		textField.setColumns(10);
		contentPane.add(textField);
		
		JButton btnNewButton_1_1 = new JButton("Add to Cart");
		btnNewButton_1_1.setBackground(Color.ORANGE);
		btnNewButton_1_1.setBounds(177, 622, 120, 30);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			private int stockin;
			private int f1;

			public void actionPerformed(ActionEvent e) {
				
				String quantity=textField.getText();
				
				
				String s1=(String) comboBox.getSelectedItem();
			    String colour=textField_3.getText();
			    String payment=(String) comboBox_2.getSelectedItem();
			    String Fashion=(String) comboBox_3_1.getSelectedItem();
			    
			    System.out.println(quantity+colour+payment+s1);
			  
				try {
					    
					    
					    
					    Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
						Statement st=con.createStatement();
						String q2= "select stockin from shirt where colours='"+colour+"'and Fashion='"+Fashion+"'";
						PreparedStatement pts1=con.prepareStatement(q2);
						ResultSet rs= pts1.executeQuery();
						while(rs.next()) {
						stockin=rs.getInt(1);}
						System.out.print(stockin);
						int r1=Integer.parseInt(quantity);
						System.out.println(r1);
						//String q3 = "update shirt set stockin='"+(stockin-r1)+"' where colours = '"+colour+"'and Fashion ='"+Fashion+"'";
						
					    String query = "insert into addtocart values('"+quantity+"','"+s1+"','"+colour+"','"+payment+"','"+Fashion+"','"+front.us+"');";
					    PreparedStatement pst=con.prepareStatement(query);
					   
					    
					    if(r1<=stockin) {
					    //pst.executeUpdate(q3);
					    f1=0;
					    // pst.executeUpdate(query);
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
				    
				    
				    int rowsAffected = pst.executeUpdate();
				    if (rowsAffected > 0 && f1==0) {
				        JOptionPane.showMessageDialog(null, "added to cart successfukky");
				        setVisible(false);
				        new login().setVisible(true);
				    } else {
				        JOptionPane.showMessageDialog(null, "unable to add to cart");
				    }
				    
				    pst.close();
				    con.close();
				} catch (Exception e1) {
				    e1.printStackTrace();
				    // Handle any SQL errors
				}

			}
		});
		contentPane.add(btnNewButton_1_1);
		
		comboBox = new JComboBox();
		comboBox.setBounds(298, 361, 96, 21);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"XS", "S", "M", "L", "XL", "XXL"}));
		contentPane.add(comboBox);
		
		JLabel lblFashion = new JLabel("Fashion");
		lblFashion.setBounds(116, 481, 172, 21);
		lblFashion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		contentPane.add(lblFashion);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(298, 442, 96, 21);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Cash on Delivery", "Online Payment"}));
		contentPane.add(comboBox_2);
		
		btnSearch = new JButton("search");
		btnSearch.setBounds(321, 44, 85, 21);
		btnSearch.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
			
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
					String query="select * from shirt where Fashion=?";
					PreparedStatement pts=con.prepareStatement(query);
					//PreparedStatement pts=con.prepareStatement(login.sq2);
					pts.setString(1,textField_2.getText());
					ResultSet rs=pts.executeQuery();
					DefaultTableModel dt=(DefaultTableModel)table_1.getModel();
					dt.setRowCount(0);
					while(rs.next()) {
					
						Object o[]= {rs.getString("stockin"),rs.getString("colours"),rs.getString("Fashion"),rs.getString("price")};
						dt.addRow(o);
						
					
					}
			}
					
				catch(Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null,"no search found");}}}
			
				
			
		);
		
			
		
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(btnSearch);
		
		textField_2 = new JTextField();
		textField_2.setBounds(207, 45, 96, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		btnBack = new JButton("back");
		btnBack.setBounds(565, 10, 85, 21);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new shirt().setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton_1).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton_1,this,"Error while establishing connection failed",0);
				}
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(btnBack);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(10, 0, 661, 714);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\91934\\Downloads\\shirtss.jpg"));
		contentPane.add(lblNewLabel_2);
		
		 lblNewLabel_1 = new JLabel("");
		 lblNewLabel_1.setBackground(Color.CYAN);
		 lblNewLabel_1.setBounds(704, 10, 366, 414);
		contentPane.add(lblNewLabel_1);
textField_5 = new JTextField();
textField_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
textField_5.setBounds(854, 541, 96, 19);
contentPane.add(textField_5);
textField_5.setColumns(10);
textField_6 = new JTextField();
textField_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
textField_6.setBounds(855, 577, 149, 21);
contentPane.add(textField_6);
textField_6.setColumns(10);
textField_7 = new JTextField();
textField_7.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
textField_7.setBounds(854, 606, 216, 28);
contentPane.add(textField_7);
textField_7.setColumns(10);
textField_8 = new JTextField();
textField_8.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
textField_8.setBounds(854, 646, 216, 28);
contentPane.add(textField_8);
textField_8.setColumns(10);
textField_9 = new JTextField();
textField_9.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
textField_9.setBounds(854, 683, 125, 21);
contentPane.add(textField_9);
textField_9.setColumns(10);
JLabel lblNewLabel_3 = new JLabel("");
lblNewLabel_3.setBounds(866, 356, 120, 30);
contentPane.add(lblNewLabel_3);
lblBrand = new JLabel("Brand");
lblBrand.setBounds(736, 541, 96, 21);
lblBrand.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
contentPane.add(lblBrand);
lblCost = new JLabel("Cost");
lblCost.setBounds(746, 577, 61, 21);
lblCost.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
contentPane.add(lblCost);
lblReview = new JLabel("Review1");
lblReview.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
lblReview.setBounds(723, 613, 120, 21);
contentPane.add(lblReview);
lblReview_1 = new JLabel("Review2");
lblReview_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
lblReview_1.setBounds(723, 647, 127, 21);
contentPane.add(lblReview_1);
lblStarRatings = new JLabel("Star Ratings");
lblStarRatings.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
lblStarRatings.setBounds(682, 673, 162, 31);
contentPane.add(lblStarRatings);
lblFashion_1 = new JLabel("Fashion");
lblFashion_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
lblFashion_1.setBounds(727, 501, 116, 21);
contentPane.add(lblFashion_1);
lblColour_1 = new JLabel("Colour");
lblColour_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
lblColour_1.setBounds(736, 458, 96, 21);
contentPane.add(lblColour_1);
textField_1 = new JTextField();
textField_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
textField_1.setColumns(10);
textField_1.setBounds(854, 458, 96, 19);
contentPane.add(textField_1);
textField_4 = new JTextField();
textField_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
textField_4.setColumns(10);
textField_4.setBounds(854, 507, 96, 19);
contentPane.add(textField_4);
	}
}
