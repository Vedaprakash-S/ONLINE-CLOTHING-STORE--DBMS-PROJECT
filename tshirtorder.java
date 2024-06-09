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
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class t_shirt extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox comboBox_2;
	private JComboBox comboBox_1;
	private JComboBox comboBox;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private int in=1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					t_shirt frame = new t_shirt();
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
	public t_shirt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 666);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.setBounds(569, 530, 85, 21);
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
		
		JButton btnNewButton_4 = new JButton("BACK");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				new tshirt().setVisible(true);
				SwingUtilities.windowForComponent(btnNewButton).dispose();
			}
			 catch(Exception o) {
				JOptionPane.showMessageDialog(btnNewButton,this,"Error while establishing connection failed",0);
			
			}}
		});
		btnNewButton_4.setBounds(542, 34, 85, 21);
		contentPane.add(btnNewButton_4);
		
		textField_9 = new JTextField();
		textField_9.setBounds(260, 35, 96, 19);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("search");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
					String query="select * from tshirt where Fashion=?";
					PreparedStatement pts=con.prepareStatement(query);
					//PreparedStatement pts=con.prepareStatement(login.sq2);
					pts.setString(1,textField_9.getText());
					ResultSet rs=pts.executeQuery();
					DefaultTableModel dt=(DefaultTableModel)table.getModel();
					dt.setRowCount(0);
					while(rs.next()) {
					
						Object o[]= {rs.getString("stockin"),rs.getString("colours"),rs.getString("Fashion"),rs.getString("price")};
						dt.addRow(o);
						
					
					}
			}
					
				catch(Exception ex) {
					ex.printStackTrace();}
			}
		});
		btnNewButton_3.setBounds(403, 34, 85, 21);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_2_1 = new JButton("+");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				in++;
				textField.setText(""+in);
				
			}
		});
		btnNewButton_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_2_1.setBounds(447, 256, 54, 21);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_2 = new JButton("-");
		btnNewButton_2.addActionListener(new ActionListener() {
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
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_2.setBounds(344, 256, 49, 21);
		contentPane.add(btnNewButton_2);
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(806, 19, 338, 367);
		contentPane.add(lblNewLabel_2);
		
		
		JButton btnNewButton_1_1_1 = new JButton("view tshirt");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {

			private AbstractButton lblNewLabel_3;
				public void actionPerformed(ActionEvent e) {
					String imageame=textField_1.getText();
			        String f=(String)comboBox_1.getSelectedItem();
			        f=f.trim();
			            try {
			                Class.forName("com.mysql.cj.jdbc.Driver");
			                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "Veda@2005");
			                String sql = "SELECT colours,Fashion FROM tshirt WHERE colours=? and Fashion=?";
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
								
								
								}
			                else {
			                    JOptionPane.showMessageDialog(null, "pantt unavailable");
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
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_1_1_1.setBounds(509, 568, 85, 30);
		contentPane.add(btnNewButton_1_1_1);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 65, 592, 131);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
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
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"stockin", "colours", "Fashion", "price"
			}
		));
		
		JButton btnShow = new JButton("show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
					Statement st=con.createStatement();
					String sql="select * from tshirt";
					
					PreparedStatement pts=con.prepareStatement(sql);
					//PreparedStatement pts=con.prepareStatement(login.sq1);
					ResultSet rs= pts.executeQuery();
					DefaultTableModel dt=(DefaultTableModel)table.getModel();
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
		btnShow.setBounds(101, 34, 85, 21);
		contentPane.add(btnShow);
		
		JLabel lblNewLabel = new JLabel("No of Quantity");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel.setBounds(189, 252, 145, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblSize = new JLabel("Size");
		lblSize.setForeground(Color.WHITE);
		lblSize.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblSize.setBounds(211, 303, 145, 21);
		contentPane.add(lblSize);
		
		JLabel lblColour = new JLabel("Colour");
		lblColour.setForeground(Color.WHITE);
		lblColour.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblColour.setBounds(200, 365, 145, 21);
		contentPane.add(lblColour);
		
		JLabel lblPaymentMethod = new JLabel("Payment method");
		lblPaymentMethod.setForeground(Color.WHITE);
		lblPaymentMethod.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblPaymentMethod.setBounds(162, 413, 172, 21);
		contentPane.add(lblPaymentMethod);
		
		JLabel lblFashion = new JLabel("Fashion");
		lblFashion.setForeground(Color.WHITE);
		lblFashion.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblFashion.setBounds(184, 464, 172, 21);
		contentPane.add(lblFashion);
		
		textField = new JTextField();
		textField.setText("1");
		textField.setColumns(10);
		textField.setBounds(403, 257, 34, 20);
		contentPane.add(textField);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"xs", "s", "m", "l", "xl", "xxl"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setBounds(366, 304, 96, 21);
		contentPane.add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(373, 370, 96, 19);
		contentPane.add(textField_1);
		
		 comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Cash On Delivery", "Online Payment"}));
		comboBox_2.setBounds(373, 417, 96, 21);
		contentPane.add(comboBox_2);
		
	 comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"roundneck", "collar"}));
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_1.setBounds(373, 466, 96, 21);
		contentPane.add(comboBox_1);
		
		JButton btnNewButton_1 = new JButton("order");
		btnNewButton_1.addActionListener(new ActionListener() {
			

				private int stockin;
				private int f1=0;
				private int rowsAffected;
				private int price;

				public void actionPerformed(ActionEvent e) {
					
					String quantity=textField.getText();
				
					//String size=textField_2.getText();
					String s1=(String) comboBox.getSelectedItem();
				    String colour=textField_1.getText();
				    String payment=(String) comboBox_2.getSelectedItem();
				    String Fashion=(String) comboBox_1.getSelectedItem();
				   			    System.out.println(quantity+colour+payment+s1);
				  
					try {
						    
						    
						    
						    Class.forName("com.mysql.cj.jdbc.Driver");
							Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
							Statement st=con.createStatement();
							String q2= "select stockin from tshirt where colours='"+colour+"'and Fashion='"+Fashion+"'";
							PreparedStatement pts1=con.prepareStatement(q2);
							String q4= "select price from tshirt where colours='"+colour+"'and Fashion='"+Fashion+"'";
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
						
							
							
							String q3 = "update tshirt set stockin='"+(stockin-r1)+"' where colours = '"+colour+"'and Fashion='"+Fashion+"'";
							
						    String query = "insert into order1 values('"+quantity+"','"+s1+"','"+colour+"','"+payment+"','"+Fashion+"','"+front.us+"','"+(price*r1)+"');";
						   // String q5 = "update order1 set price='"+(price*r1)+"' where colours = '"+colour+"'and Fashion='"+Fashion+"'and price='"+price+"'";
							
						    
						   
						    PreparedStatement pst = con.prepareStatement(query);
						    if(r1<=stockin) {
						    pst.executeUpdate(q3);
						    rowsAffected = pst.executeUpdate();
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
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(289, 513, 85, 21);
		contentPane.add(btnNewButton_1);
		
		
		JButton btnNewButton_1_1 = new JButton("add to cart");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			
				private int stockin;
				private int f1;

				public void actionPerformed(ActionEvent e) {
					
					String quantity=textField.getText();
					
					
					String s1=(String) comboBox.getSelectedItem();
				    String colour=textField_1.getText();
				    String payment=(String) comboBox_2.getSelectedItem();
				    String Fashion=(String) comboBox_1.getSelectedItem();
				    
				    System.out.println(quantity+colour+payment+s1);
				  
					try {
						    
						    
						    
						    Class.forName("com.mysql.cj.jdbc.Driver");
							Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
							Statement st=con.createStatement();
							String q2= "select stockin from tshirt where colours='"+colour+"'and Fashion='"+Fashion+"'";
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
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_1_1.setBounds(300, 568, 85, 30);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\91934\\Pictures\\Screenshots\\Screenshot 2024-05-26 165527.png"));
		lblNewLabel_1.setBounds(0, 0, 674, 629);
		contentPane.add(lblNewLabel_1);
		
		
		
		JLabel lblColour_1 = new JLabel("Colour");
		lblColour_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblColour_1.setBounds(832, 400, 96, 21);
		contentPane.add(lblColour_1);
		
		JLabel lblFashion_1 = new JLabel("Fashion");
		lblFashion_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblFashion_1.setBounds(823, 431, 116, 21);
		contentPane.add(lblFashion_1);
		
		JLabel lblBrand = new JLabel("Brand");
		lblBrand.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblBrand.setBounds(832, 462, 96, 21);
		contentPane.add(lblBrand);
		
		JLabel lblReview = new JLabel("Review1");
		lblReview.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblReview.setBounds(808, 524, 120, 21);
		contentPane.add(lblReview);
		
		JLabel lblReview_1 = new JLabel("Review2");
		lblReview_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblReview_1.setBounds(800, 557, 127, 21);
		contentPane.add(lblReview_1);
		
		JLabel lblStarRatings = new JLabel("Star Ratings");
		lblStarRatings.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblStarRatings.setBounds(777, 588, 162, 31);
		contentPane.add(lblStarRatings);
		
		JLabel lblCost = new JLabel("Cost");
		lblCost.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblCost.setBounds(832, 493, 61, 21);
		contentPane.add(lblCost);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(951, 407, 96, 19);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(949, 438, 96, 19);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		textField_4.setColumns(10);
		textField_4.setBounds(951, 469, 96, 19);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		textField_5.setColumns(10);
		textField_5.setBounds(938, 498, 149, 21);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		textField_6.setColumns(10);
		textField_6.setBounds(925, 526, 216, 28);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		textField_7.setColumns(10);
		textField_7.setBounds(925, 564, 216, 28);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		textField_8.setColumns(10);
		textField_8.setBounds(949, 600, 125, 21);
		contentPane.add(textField_8);
	}
}
