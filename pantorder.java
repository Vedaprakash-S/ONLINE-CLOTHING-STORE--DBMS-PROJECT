package clothingstore;
import clothingstore.front;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
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
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class pant1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JComboBox comboBox_1_1;
	private JLabel lblNewLabel_2;
	private int in=1;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pant1 frame = new pant1();
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
	public pant1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1244, 771);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_3_1 = new JButton("-");
		btnNewButton_3_1.setBackground(Color.RED);
		btnNewButton_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_3_1.addActionListener(new ActionListener() {
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
		
		JButton btnNewButton_4 = new JButton("search");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
					String query="select * from pant1 where Fashion=?";
					PreparedStatement pts=con.prepareStatement(query);
					//PreparedStatement pts=con.prepareStatement(login.sq2);
					pts.setString(1,textField_9.getText());
					ResultSet rs=pts.executeQuery();
					DefaultTableModel dt=(DefaultTableModel)table.getModel();
					dt.setRowCount(0);
					while(rs.next()) {
					
						Object o[]= {rs.getString("stockin"),rs.getString("size"),rs.getString("colours"),rs.getString("Fashion"),rs.getString("price")};
						dt.addRow(o);
						
					
					}
			}
					
				catch(Exception ex) {
					ex.printStackTrace();}
			
			}
		});
		
		JButton btnNewButton_5 = new JButton("back");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new pant().setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton_5).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton_5,this,"Error while establishing connection failed",0);
				}
			}
		});
		btnNewButton_5.setBounds(598, 15, 85, 21);
		contentPane.add(btnNewButton_5);
		btnNewButton_4.setBounds(393, 15, 85, 21);
		contentPane.add(btnNewButton_4);
		
		textField_9 = new JTextField();
		textField_9.setBounds(269, 17, 96, 19);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		btnNewButton_3_1.setBounds(330, 248, 48, 21);
		contentPane.add(btnNewButton_3_1);
		
		JButton btnNewButton_3 = new JButton("+");
		btnNewButton_3.setBackground(Color.GREEN);
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				in++;
				textField.setText(""+in);
			}
		});
		btnNewButton_3.setBounds(435, 248, 43, 31);
		contentPane.add(btnNewButton_3);
		comboBox_1_1 = new JComboBox();
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"jean", "cargo", "cotton"}));
		comboBox_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_1_1.setBounds(320, 385, 96, 21);
		contentPane.add(comboBox_1_1);
		
		JButton btnNewButton_2 = new JButton("View Pant");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.addActionListener(new ActionListener() {
			
				//private AbstractButton lblNewLabel_3;
				//private JComboBox comboBox_1_1;
				//private JOptionPane lblNewLabel_2;

				public void actionPerformed(ActionEvent e) {
					
				        String imageame=textField_1.getText();
				        String f=(String)comboBox_1_1.getSelectedItem();
				        f=f.trim();
				            try {
				                Class.forName("com.mysql.cj.jdbc.Driver");
				                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "Veda@2005");
				                String sql = "SELECT colours,Fashion FROM pant1 WHERE colours=? and Fashion=?";
				                PreparedStatement pst = con.prepareStatement(sql);
				                pst.setString(1, imageame);
				                pst.setString(2, f);
				                ResultSet rs = pst.executeQuery();

				                if (rs.next()) {
				                   
				                    
				                    // Load and display the image
				                    String imageName = rs.getString("colours").replace(" ", "") +rs.getString(2).replace(" ", "")+ ".png";
				                    ImageIcon icon = new ImageIcon("image/" + imageName);
				                    Image image = icon.getImage().getScaledInstance(lblNewLabel_2.getWidth(), lblNewLabel_2.getHeight(), Image.SCALE_SMOOTH);
				                   lblNewLabel_2.setIcon(new ImageIcon(image));

				                    // Enable the Book Ticket button
				                   
				                } else {
				                    JOptionPane.showMessageDialog(null, "pant unavailable.");
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
									textField_2.setText(fs1);
									textField_3.setText(fs2);
									textField_4.setText(fs);
									textField_5.setText(v);
									textField_6.setText(k);
									textField_7.setText(p);
									textField_8.setText(o);
									//textField_7.setText(fs1);
									//textField_8.setText(fs2);
									
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
		btnNewButton_2.setBounds(303, 459, 154, 31);
		contentPane.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(92, 46, 481, 158);
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
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"stockin", "size", "colour", "Fashion", "price"
			}
		));
		
		JButton btnNewButton = new JButton("show");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
					Statement st=con.createStatement();
					String sql="select * from pant1";
					
					PreparedStatement pts=con.prepareStatement(sql);
					ResultSet rs= pts.executeQuery();
					DefaultTableModel dt=(DefaultTableModel)table.getModel();
					dt.setRowCount(0);
					while(rs.next()) {
					
					Object o[]= {rs.getString("stockin"),rs.getString("size"),rs.getString("colours"),rs.getString("Fashion"),rs.getString("price")};
					dt.addRow(o);
					}
			}
				catch(Exception ec) {
					JOptionPane.showMessageDialog(null,"it has not been registered");
					ec.printStackTrace();
				}
			}
			
		});
		btnNewButton.setBounds(134, 21, 85, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("No Of Quantity");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(188, 246, 122, 21);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setText("1");
		textField.setBounds(388, 248, 37, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblSize = new JLabel("Size");
		lblSize.setForeground(Color.ORANGE);
		lblSize.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblSize.setBounds(200, 287, 62, 21);
		contentPane.add(lblSize);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"34", "36", "38", "40", "42", "44", "46", "48"}));
		comboBox.setBounds(320, 287, 96, 21);
		contentPane.add(comboBox);
		
		JLabel lblColour = new JLabel("Colour");
		lblColour.setForeground(Color.ORANGE);
		lblColour.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblColour.setBounds(200, 318, 71, 21);
		contentPane.add(lblColour);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(320, 320, 96, 19);
		contentPane.add(textField_1);
		
		JLabel lblPayment = new JLabel("Payment");
		lblPayment.setForeground(Color.ORANGE);
		lblPayment.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblPayment.setBounds(200, 349, 78, 21);
		contentPane.add(lblPayment);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Cash On Delivery", "Online Payment"}));
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox_1.setBounds(320, 349, 96, 21);
		contentPane.add(comboBox_1);
		
		JLabel lblFashion = new JLabel("Fashion");
		lblFashion.setForeground(Color.ORANGE);
		lblFashion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblFashion.setBounds(200, 385, 78, 21);
		contentPane.add(lblFashion);
		
		
		JButton btnNewButton_1 = new JButton("Buy Now");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {

			private int stockin;
			private int f1=0;
			private int rowsAffected;
			private int colours;
			private int size;
			private int price;
		
			public void actionPerformed(ActionEvent e) {

	
					
					String quantity=textField.getText();
				
					//String size=textField_2.getText();
					String s1=(String) comboBox.getSelectedItem();
				    String colour=textField_1.getText();
				    String payment=(String) comboBox_1.getSelectedItem();
				    String Fashion=(String) comboBox_1_1.getSelectedItem();
				   			    System.out.println(quantity+colour+payment+s1);
				  
					try {
						    
						    
						    
						    Class.forName("com.mysql.cj.jdbc.Driver");
							Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
							Statement st=con.createStatement();
							String q2= "select stockin from pant1 where colours='"+colour+"'and Fashion='"+Fashion+"'";
							PreparedStatement pts1=con.prepareStatement(q2);
							String q4= "select price from pant1 where colours='"+colour+"'and Fashion='"+Fashion+"'";
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
							String q3 = "update pant1 set stockin='"+(stockin-r1)+"' where colours = '"+colour+"'and Fashion='"+Fashion+"'";
							
						    String query = "insert into order1 values('"+quantity+"','"+s1+"','"+colour+"','"+payment+"','"+Fashion+"','"+front.us+"','"+(price*r1)+"') ";
						    
						   
						    PreparedStatement pst = con.prepareStatement(query);
						    
						    if(r1<=stockin ) {
						    pst.executeUpdate(q3);
						    rowsAffected = pst.executeUpdate();
						    f1=0;
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
		btnNewButton_1.setBounds(454, 631, 149, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("add to cart");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			
				private int stockin;
				
				private int f1;

				public void actionPerformed(ActionEvent e) {
					
					String quantity=textField.getText();
					
					
					String s1=(String) comboBox.getSelectedItem();
				    String colour=textField_1.getText();
				    String payment=(String) comboBox_1.getSelectedItem();
				    String Fashion=(String) comboBox_1_1.getSelectedItem();
				    
				    System.out.println(quantity+colour+payment+s1);
				  
					try {
						    
						    
						    
						    Class.forName("com.mysql.cj.jdbc.Driver");
							Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
							Statement st=con.createStatement();
							String q2= "select stockin from pant1 where colours='"+colour+"'and Fashion='"+Fashion+"'";
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
		btnNewButton_1_1.setBounds(200, 631, 165, 21);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\91934\\Pictures\\Screenshots\\Screenshot 2024-05-26 170913.png"));
		lblNewLabel_1.setBounds(10, 0, 700, 734);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(794, 21, 366, 395);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblColour_1 = new JLabel("Colour");
		lblColour_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblColour_1.setBounds(841, 453, 96, 21);
		contentPane.add(lblColour_1);
		
		JLabel lblFashion_1 = new JLabel("Fashion");
		lblFashion_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblFashion_1.setBounds(841, 494, 116, 21);
		contentPane.add(lblFashion_1);
		
		JLabel lblBrand = new JLabel("Brand");
		lblBrand.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblBrand.setBounds(841, 539, 96, 21);
		contentPane.add(lblBrand);
		
		JLabel lblCost = new JLabel("Cost");
		lblCost.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblCost.setBounds(841, 583, 61, 21);
		contentPane.add(lblCost);
		
		JLabel lblReview = new JLabel("Review1");
		lblReview.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblReview.setBounds(822, 614, 120, 21);
		contentPane.add(lblReview);
		
		JLabel lblReview_1 = new JLabel("Review2");
		lblReview_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblReview_1.setBounds(822, 662, 127, 21);
		contentPane.add(lblReview_1);
		
		JLabel lblStarRatings = new JLabel("Star Ratings");
		lblStarRatings.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblStarRatings.setBounds(822, 693, 162, 31);
		contentPane.add(lblStarRatings);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(991, 450, 96, 19);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(991, 494, 96, 19);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		textField_4.setColumns(10);
		textField_4.setBounds(991, 546, 96, 19);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		textField_5.setColumns(10);
		textField_5.setBounds(991, 583, 149, 21);
		contentPane.add(textField_5);
		 
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		textField_6.setColumns(10);
		textField_6.setBounds(972, 614, 216, 28);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		textField_7.setColumns(10);
		textField_7.setBounds(972, 655, 216, 28);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		textField_8.setColumns(10);
		textField_8.setBounds(994, 693, 125, 21);
		contentPane.add(textField_8);
	}
}
