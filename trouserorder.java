package clothingstore;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class trouser extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JLabel lblSize;
	private JLabel lblColour;
	private JLabel lblPaymentMethod;
	private JLabel lblFashion;
	private JComboBox comboBox;
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JButton btnNewButton_1;
	private JButton btnNewButton_1_1;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton_2;
	private JLabel lblColour_1;
	private JLabel lblFashion_1;
	private JLabel lblBrand;
	private JLabel lblCost;
	private JLabel lblReview;
	private JLabel lblReview_1;
	private JLabel lblStarRatings;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private int in=1;
	private JTextField textField_9;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					trouser frame = new trouser();
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
	public trouser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1294, 733);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(75, 128, 516, 104);
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
			},
			new String[] {
				"stockin", "colours", "Fashion", "price"
			}
		));
		
		btnNewButton = new JButton("see availability");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
					Statement st=con.createStatement();
					String sql="select * from trouser";
					
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
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(33, 90, 146, 21);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("No of Quantity");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel.setBounds(205, 279, 145, 21);
		contentPane.add(lblNewLabel);
		
		lblSize = new JLabel("Size");
		lblSize.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblSize.setBounds(205, 323, 145, 21);
		contentPane.add(lblSize);
		
		lblColour = new JLabel("Colour");
		lblColour.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblColour.setBounds(205, 369, 145, 21);
		contentPane.add(lblColour);
		
		lblPaymentMethod = new JLabel("Payment method");
		lblPaymentMethod.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblPaymentMethod.setBounds(205, 427, 172, 21);
		contentPane.add(lblPaymentMethod);
		
		lblFashion = new JLabel("Fashion");
		lblFashion.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblFashion.setBounds(205, 478, 172, 21);
		contentPane.add(lblFashion);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"xs", "s", "m", "l", "xl", "xxl"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setBounds(392, 323, 96, 21);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setText("1");
		textField.setColumns(10);
		textField.setBounds(458, 284, 96, 19);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(392, 374, 96, 19);
		contentPane.add(textField_1);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Cash On Delivery", "Online Payment"}));
		comboBox_1.setBounds(392, 416, 96, 21);
		contentPane.add(comboBox_1);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"boxers", "casual"}));
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_2.setBounds(392, 478, 96, 21);
		contentPane.add(comboBox_2);
		
		btnNewButton_1 = new JButton("order");
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
				    String payment=(String) comboBox_1.getSelectedItem();
				    String Fashion=(String) comboBox_2.getSelectedItem();
				   			    System.out.println(quantity+colour+payment+s1);
				  
					try {
						    
						    
						    
						    Class.forName("com.mysql.cj.jdbc.Driver");
							Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
							Statement st=con.createStatement();
							String q2= "select stockin from trouser where colours='"+colour+"'and Fashion='"+Fashion+"'";
							PreparedStatement pts1=con.prepareStatement(q2);
							String q4= "select price from trouser where colours='"+colour+"'and Fashion='"+Fashion+"'";
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
						
							
							
							String q3 = "update trouser set stockin='"+(stockin-r1)+"' where colours = '"+colour+"'and Fashion='"+Fashion+"'";
							
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
		btnNewButton_1.setBounds(361, 549, 85, 21);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_1_1 = new JButton("add to cart");
		btnNewButton_1_1.addActionListener(new ActionListener() {

				private int stockin;
				private int f1;

				public void actionPerformed(ActionEvent e) {
					
					String quantity=textField.getText();
					
					
					String s1=(String) comboBox.getSelectedItem();
				    String colour=textField_1.getText();
				    String payment=(String) comboBox_1.getSelectedItem();
				    String Fashion=(String) comboBox_2.getSelectedItem();
				    
				    System.out.println(quantity+colour+payment+s1);
				  
					try {
						    
						    
						    
						    Class.forName("com.mysql.cj.jdbc.Driver");
							Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
							Statement st=con.createStatement();
							String q2= "select stockin from trouser where colours='"+colour+"'and Fashion='"+Fashion+"'";
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
		btnNewButton_1_1.setBounds(361, 594, 85, 30);
		contentPane.add(btnNewButton_1_1);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(780, 58, 361, 332);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton_2 = new JButton("view ");
		btnNewButton_2.addActionListener(new ActionListener() {
			
				public void actionPerformed(ActionEvent e) {
					
			        String imageame=textField_1.getText();
			        String f=(String)comboBox_2.getSelectedItem();
			        f=f.trim();
			            try {
			                Class.forName("com.mysql.cj.jdbc.Driver");
			                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "Veda@2005");
			                String sql = "SELECT colours,Fashion FROM trouser WHERE colours=? and Fashion=?";
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
			                    JOptionPane.showMessageDialog(null, "trouser unavailable.");
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
			                    JOptionPane.showMessageDialog(null, "trouser unavailable");
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
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.setBounds(595, 525, 85, 21);
		contentPane.add(btnNewButton_2);
		
		lblColour_1 = new JLabel("Colour");
		lblColour_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblColour_1.setBounds(853, 447, 96, 21);
		contentPane.add(lblColour_1);
		
		lblFashion_1 = new JLabel("Fashion");
		lblFashion_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblFashion_1.setBounds(853, 478, 116, 21);
		contentPane.add(lblFashion_1);
		
		lblBrand = new JLabel("Brand");
		lblBrand.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblBrand.setBounds(853, 509, 96, 21);
		contentPane.add(lblBrand);
		
		lblCost = new JLabel("Cost");
		lblCost.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblCost.setBounds(853, 549, 61, 21);
		contentPane.add(lblCost);
		
		lblReview = new JLabel("Review1");
		lblReview.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblReview.setBounds(853, 587, 120, 21);
		contentPane.add(lblReview);
		
		lblReview_1 = new JLabel("Review2");
		lblReview_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblReview_1.setBounds(853, 624, 127, 21);
		contentPane.add(lblReview_1);
		
		lblStarRatings = new JLabel("Star Ratings");
		lblStarRatings.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblStarRatings.setBounds(830, 655, 162, 31);
		contentPane.add(lblStarRatings);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(974, 454, 96, 19);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(974, 483, 96, 19);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		textField_4.setColumns(10);
		textField_4.setBounds(974, 509, 96, 19);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		textField_5.setColumns(10);
		textField_5.setBounds(974, 549, 149, 21);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		textField_6.setColumns(10);
		textField_6.setBounds(974, 580, 216, 28);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		textField_7.setColumns(10);
		textField_7.setBounds(974, 618, 216, 28);
		contentPane.add(textField_7);
		 
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		textField_8.setColumns(10);
		textField_8.setBounds(998, 665, 125, 21);
		contentPane.add(textField_8);
		
		btnNewButton_3 = new JButton("+");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				in++;
				textField.setText(""+in);

			}
		});
		btnNewButton_3.setBounds(564, 283, 61, 21);
		contentPane.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("-");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_4.addActionListener(new ActionListener() {
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
		btnNewButton_4.setBounds(392, 279, 53, 21);
		contentPane.add(btnNewButton_4);
		
		textField_9 = new JTextField();
		textField_9.setBounds(256, 93, 96, 19);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		btnNewButton_5 = new JButton("search");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
					String query="select * from trouser where Fashion=?";
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
		btnNewButton_5.setBounds(403, 92, 85, 21);
		contentPane.add(btnNewButton_5);
		
		btnNewButton_6 = new JButton("back");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new trousers().setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton_1).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton_1,this,"Error while establishing connection failed",0);
				}
			}
		});
		btnNewButton_6.setBounds(595, 10, 85, 21);
		contentPane.add(btnNewButton_6);
	}
}
