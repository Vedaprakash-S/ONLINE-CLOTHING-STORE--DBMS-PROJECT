package clothingstore;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	 private ImageIcon[] images;
	  private JLabel imgslider_1;
	private JTextField txtSearchHere;
	
	private int currentIndex = 0;
    private Timer timer;
	static String sq1;
	static String sq2;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1336, 777);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("shirt");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\91934\\Downloads\\shirts.jpeg"));
		btnNewButton.setBounds(10, 109, 222, 601);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new shirt().setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton,this,"Error while establishing connection failed",0);
				}
			}
		});
		contentPane.setLayout(null);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					if(comboBox_1.getSelectedItem()== "Shirt" ){
					sq1="select * from shirt";
					sq2="select * from shirt where Fashion=?";
					new shirt().setVisible(true);
					SwingUtilities.windowForComponent(comboBox_1).dispose();
				}
					else if(comboBox_1.getSelectedItem()== "Pant" ){
						sq1="select * from pant";
						sq2="select * from pant where Fashion=?";
						new pant().setVisible(true);
						SwingUtilities.windowForComponent(comboBox_1).dispose();
					}
					else if(comboBox_1.getSelectedItem()== "T Shirt" ){
						new t_shirt().setVisible(true);
						SwingUtilities.windowForComponent(comboBox_1).dispose();
					}
					else if(comboBox_1.getSelectedItem()== "Kurthi" ){
						new kurthi().setVisible(true);
						SwingUtilities.windowForComponent(comboBox_1).dispose();
					}
					else {
						new trousers().setVisible(true);
						SwingUtilities.windowForComponent(comboBox_1).dispose();
					}
						
					}
				catch(Exception o) {
					JOptionPane.showMessageDialog(comboBox_1,this,"Error while establishing connection failed",0);
				}
				
				
			}
		});
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(comboBox_1_1.getSelectedItem()== "login" ){
					new front().setVisible(true);
					SwingUtilities.windowForComponent(comboBox_1_1).dispose();
				}
					else if(comboBox_1_1.getSelectedItem()== "signup" ){
						new signup().setVisible(true);
						SwingUtilities.windowForComponent(comboBox_1_1).dispose();
					}
				
					else {
						new profile().setVisible(true);
						SwingUtilities.windowForComponent(comboBox_1_1).dispose();
					}
						
					}
				catch(Exception o) {
					JOptionPane.showMessageDialog(comboBox_1,this,"Error while establishing connection failed",0);
				}
				
				
			}
		});
		comboBox_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"login", "signup", "profile"}));
		comboBox_1_1.setBounds(661, 36, 85, 25);
		contentPane.add(comboBox_1_1);
		
		JButton btnNewButton_6_1 = new JButton("Offers");
		btnNewButton_6_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_6_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_6_1.setBounds(527, 36, 85, 21);
		contentPane.add(btnNewButton_6_1);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Fashion", "Shirt", "Pant", "T shirt", "Kurthi", "Trousers"}));
		comboBox_1.setBounds(384, 36, 103, 25);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"category", "Men", "Women", "Kids"}));
		comboBox.setBounds(243, 36, 96, 25);
		contentPane.add(comboBox);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1_1_1 = new JButton("kurthi");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new kurthis().setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton_1_1_1).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton_1_1_1,this,"Error while establishing connection failed",0);
				}
				
			}
		});
		btnNewButton_1_1_1.setIcon(new ImageIcon("C:\\Users\\91934\\Downloads\\kurthi.jpeg"));
		btnNewButton_1_1_1.setBounds(1058, 24, 264, 740);
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_2 = new JButton("profile");
		btnNewButton_2.setBounds(786, 35, 116, 21);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new profile().setVisible(true);
					SwingUtilities.windowForComponent(btnNewButton_2).dispose();
				}
				catch(Exception o) {
					JOptionPane.showMessageDialog(btnNewButton_2,this,"Error while establishing connection failed",0);
				}
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(btnNewButton_2);
		 //File directory = new File("image");
	       // File[] imageFiles = directory.listFiles();
	        //images = new ImageIcon[imageFiles.length];

	        //for (int i = 0; i < imageFiles.length; i++) {
	        //    images[i] = new ImageIcon(imageFiles[i].getAbsolutePath());
	     //   }
	        
	        JPanel panel = new JPanel();
	        panel.setBounds(0, -4, 1322, 766);
	        contentPane.add(panel);
	        panel.setLayout(null);
	        
	       
	         imgslider_1 = new JLabel("");
	         imgslider_1.setBounds(266, 139, 729, 363);
	         
	           imgslider_1.setBorder(null);
	           imgslider_1.setHorizontalAlignment(SwingConstants.CENTER);
	           panel.add(imgslider_1);
	        
	       
	        
	        JButton btnNewButton_1_1_2 = new JButton("trousers");
	        btnNewButton_1_1_2.setBounds(803, 512, 192, 228);
	        panel.add(btnNewButton_1_1_2);
	        btnNewButton_1_1_2.setIcon(new ImageIcon("C:\\Users\\91934\\Downloads\\shorts1.jpeg"));
	        btnNewButton_1_1_2.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		try {
	        			new trousers().setVisible(true);
	        			SwingUtilities.windowForComponent(btnNewButton_1_1_2).dispose();
	        		}
	        		catch(Exception o) {
	        			JOptionPane.showMessageDialog(btnNewButton_1_1_2,this,"Error while establishing connection failed",0);
	        		}
	        		
	        		 
	        	}
	        });
	        btnNewButton_1_1_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
	        
	        JButton btnNewButton_6 = new JButton("About Us");
	        btnNewButton_6.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        	}
	        });
	        btnNewButton_6.setBounds(94, 42, 109, 21);
	        panel.add(btnNewButton_6);
	        btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 15));
	        
	        JButton btnNewButton_2_1 = new JButton("orders");
	        btnNewButton_2_1.setBounds(920, 70, 116, 21);
	        panel.add(btnNewButton_2_1);
	        btnNewButton_2_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		try {
	        			new orderplaced().setVisible(true);
	        			SwingUtilities.windowForComponent(btnNewButton_2_1).dispose();
	        		}
	        		catch(Exception o) {
	        			JOptionPane.showMessageDialog(btnNewButton_2_1,this,"Error while establishing connection failed",0);
	        		}
	        	}
	        });
	        btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
	        
	        JButton btnNewButton_3 = new JButton("Go to cart");
	        btnNewButton_3.setBounds(939, 488, 113, 21);
	        panel.add(btnNewButton_3);
	        btnNewButton_3.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		try {
	        			new addtocartsss().setVisible(true);
	        			SwingUtilities.windowForComponent(btnNewButton_3).dispose();
	        		}
	        		catch(Exception o) {
	        			JOptionPane.showMessageDialog(btnNewButton_3,this,"Error while establishing connection failed",0);
	        		}

	        	}
	        });
	        btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 16));
	        
	        JButton btnNewButton_5 = new JButton("SEARCH");
	        btnNewButton_5.setBounds(554, 109, 109, 21);
	        panel.add(btnNewButton_5);
	        btnNewButton_5.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		String search=txtSearchHere.getText();
	        		try {
	        			String shirt;
	        			Class.forName("com.mysql.cj.jdbc.Driver");
	        			Connection con1 = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
	        			if(search.equals("shirt"))
	        			{
	        				new shirt().setVisible(true);
	        				SwingUtilities.windowForComponent(btnNewButton_5).dispose();
	        			}
	        			
	        			else if(search.equals("pant")){
	        				new pant().setVisible(true);
	        				SwingUtilities.windowForComponent(btnNewButton_5).dispose();
	        			
	        				
	        			}

	        			else if(search.equals("tshirt")){
	        				new tshirt().setVisible(true);
	        				SwingUtilities.windowForComponent(btnNewButton_5).dispose();
	        			
	        				
	        			}

	        			else if(search.equals("trouser")){
	        				new trousers().setVisible(true);
	        				SwingUtilities.windowForComponent(btnNewButton_5).dispose();
	        			
	        				
	        			}

	        			else if(search.equals("kurthi")){
	        				new kurthi().setVisible(true);
	        				SwingUtilities.windowForComponent(btnNewButton_5).dispose();
	        			
	        				
	        			}
	        			
	        			else {
	        				JOptionPane.showMessageDialog(null,"OOPS NO SEARCH FOUND");
	        			}
	        		}
	        		catch(Exception et) {}
	        	
	        		
	        }
	        });
	        btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
	        
	        txtSearchHere = new JTextField();
	        txtSearchHere.setBounds(424, 113, 96, 19);
	        panel.add(txtSearchHere);
	        txtSearchHere.setColumns(10);
	        
	        JButton btnNewButton_1 = new JButton("pant");
	        btnNewButton_1.setBounds(266, 512, 222, 228);
	        panel.add(btnNewButton_1);
	        btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\91934\\Downloads\\pant.jpeg"));
	        btnNewButton_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		try {
	        			new pant().setVisible(true);
	        			SwingUtilities.windowForComponent(btnNewButton_1).dispose();
	        		}
	        		catch(Exception o) {
	        			JOptionPane.showMessageDialog(btnNewButton_1,this,"Error while establishing connection failed",0);
	        		}
	        		
	        	}
	        });
	        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
	        
	        JButton btnNewButton_1_1 = new JButton("t shirt");
	        btnNewButton_1_1.setBounds(522, 512, 197, 228);
	        panel.add(btnNewButton_1_1);
	        btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\91934\\Downloads\\tshirt.jpeg"));
	        btnNewButton_1_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		try {
	        			new tshirt().setVisible(true);
	        			SwingUtilities.windowForComponent(btnNewButton_1_1).dispose();
	        		}
	        		catch(Exception o) {
	        			JOptionPane.showMessageDialog(btnNewButton_1_1,this,"Error while establishing connection failed",0);
	        		}
	        	}
	        });
	        btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
	        
	        JLabel lblNewLabel_2 = new JLabel("New label");
	        lblNewLabel_2.setBounds(0, 0, 1322, 766);
	        panel.add(lblNewLabel_2);
	        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\91934\\Downloads\\in.jpg"));
	        
	        JButton btnNewButton_4 = new JButton("Home");
	        btnNewButton_4.setBounds(22, 716, 85, 25);
	        panel.add(btnNewButton_4);
	        btnNewButton_4.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		try {
	        			new sorl().setVisible(true);
	        			SwingUtilities.windowForComponent(btnNewButton_4).dispose();
	        		}
	        		catch(Exception o) {
	        			JOptionPane.showMessageDialog(btnNewButton_4,this,"Error while establishing connection failed",0);
	        		}
	        		
	        	}
	        });
	        btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 15));
	        
	    

	        
	        File directory = new File("ad");
	        File[] imageFiles = directory.listFiles();
	        images = new ImageIcon[imageFiles.length];

	        for (int i = 0; i < imageFiles.length; i++) {
	            images[i] = new ImageIcon(imageFiles[i].getAbsolutePath());
	        }

	        
	        startSlideshow();
	    }

	    private void startSlideshow() {
	        timer = new Timer(900, new ActionListener() {
	            
	           

				public void actionPerformed(ActionEvent e) {
	                currentIndex = (currentIndex + 1) % images.length;
	                imgslider_1.setIcon(images[currentIndex]);
	            }
	        });
	        timer.start(); 
	}
}
