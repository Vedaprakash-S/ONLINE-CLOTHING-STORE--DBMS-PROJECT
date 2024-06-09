package clothingstore;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;

public class new_password extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField newpass1;
	private JPasswordField confirmpass;
	private JTextField userf;
	private JTextField captcha;
	private JLabel error;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new_password frame = new new_password();
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
	public static String create() {
        Random rand = new Random();
        int length = 7 + (Math.abs(rand.nextInt()) % 3); // Fixed typo random -> rand, added closing parenthesis for Math.abs
        StringBuffer captcha = new StringBuffer(); // Fixed typo capt -> captcha
        for (int i = 0; i < length; i++) {
            int base = Math.abs(rand.nextInt()) % 62; // Fixed typo random -> rand
            int charNumber = 0; // Fixed typo charn -> charNumber
            char charN; // Added missing variable declaration char charN
            if (base < 26) {
                charN = (char) (65 + base); // Fixed typo char -> charN
            } else if (base < 52) {
                charN = (char) (97 + (base - 26)); // Fixed typo char -> charN, added missing parenthesis
            } else {
                charN = (char) (48 + (base - 52)); // Fixed typo char -> charN, changed -- to -
            }
            captcha.append(charN); // Fixed typo capatacha -> captcha, char -> charN
        }
        return captcha.toString(); // Fixed typo capatacha -> captcha
    }
	public new_password() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 758, 677);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Should contain one uppercase and three lowercase and one number");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(199, 272, 462, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_2_1 = new JLabel("Enter the Given Captcha");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(26, 345, 226, 19);
		contentPane.add(lblNewLabel_2_1);
		
		error = new JLabel("");
		error.setBounds(253, 499, 296, 54);
		contentPane.add(error);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setBounds(275, 389, 148, 24);
		contentPane.add(lblNewLabel_4_1);
		
		JButton btnNewButton_1 = new JButton("Generate Captcha");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			
			private JLabel lblNewLabel_4;
			private String captcha;

			public void actionPerformed(ActionEvent e) {
				captcha = create();
				lblNewLabel_4_1.setText(captcha);
			}
		});
		btnNewButton_1.setBounds(113, 389, 152, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Update Password");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(235, 82, 249, 41);
		contentPane.add(lblNewLabel);
		
		newpass1 = new JPasswordField();
		newpass1.setBounds(278, 246, 145, 19);
		contentPane.add(newpass1);
		
		JLabel lblNewLabel_2 = new JLabel("Confirm Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(54, 289, 170, 19);
		contentPane.add(lblNewLabel_2);
		
		confirmpass = new JPasswordField();
		confirmpass.setBounds(278, 292, 145, 19);
		contentPane.add(confirmpass);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String passwordField=captcha.getText();
				try {
					int y=0;
					int et=0;
					int i=1;
					String us1 = userf.getText();
					String np = newpass1.getText();	
					String cp = confirmpass.getText();
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con1 = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","Veda@2005");
					Statement st1 = con1.createStatement();
					String sql1 =  "Select * from access";
					ResultSet res1 = st1.executeQuery(sql1);
					String input = np;
					int inputLen = input.length();
					int uppercount=0;
					int lowercount=0;
		        	int digitcount=0;
					for(int j =0; j < inputLen ; j++)
					{
						char ch = input.charAt(j);
						if (Character.isUpperCase(ch))
							uppercount++;
						else if (Character.isLowerCase(ch))
							lowercount++;
						else if (Character.isDigit(ch))
							digitcount++;
						else
							y++;
					}
					System.out.print(uppercount);
					System.out.print(lowercount);
					System.out.print(digitcount);
					System.out.print(np);
					while(res1.next()) {
						String use1 = res1.getString("username");
						System.out.print("1");
						
						/*if(us1.equals(use1) && np.equals(cp) && uppercount >= 1 && lowercount >= 3 && digitcount >=1 ) {
							et=1;
							String sql2 = "update access set password = '"+np+"' where username = '"+use1+"'";
							PreparedStatement pts = con1.prepareStatement(sql2);
							System.out.print(np);
						    pts.setValueAt(np,sql2,0);
						    System.out.print(i);
							pts.setInt(1,i);
							System.out.println(sql2);
							System.out.println("2");
							pts.executeUpdate(sql2);
							System.out.print("success");
							JOptionPane.showMessageDialog(btnNewButton_1, " data updated", "updated", -1);
					while(res1.next()) {
						String use1 = res1.getString("username");
						System.out.print("1");
					int c = 0;
					while(res2.next()) {
						c = res2.getInt(1);
						
					}*/
					//c=c+2;
					//while(res1.next()) {
						//String use1 = res1.getString("username");
						//if(us!=use1 && uppercount >= 1 && lowercount >= 3 && digitcount >=1) {
							//ed =1 ;
							//String sql3 = "insert into access values('"+c+"','"+us+"','"+np+"')";
							//PreparedStatement pts = con.prepareStatement(sql3);
							//pts.executeUpdate(sql3);
					
						
		
						
							
						
						if(us1.equals(use1) && np.equals(cp)&& uppercount >= 1 && lowercount >= 3 && digitcount >=1) {
								if((lblNewLabel_4_1.getText()).equals(passwordField))	{					
								
							
							String sql2 = "update access set password = '"+np+"' where username = '"+us1+"'";
							PreparedStatement pts = con1.prepareStatement(sql2);
							System.out.print(np);
							et =1 ;
						    /*pts.setValueAt(np,sql2,0);
						    System.out.print(i);
							pts.setInt(1,i);
							System.out.println("2");
							System.out.println(sql2);*/
							pts.executeUpdate(sql2);
							System.out.print("success");
							JOptionPane.showMessageDialog(btnNewButton, " data updated", "updated", -1);
							try {
								front newframe = new front();
							    newframe.setVisible(true);
								SwingUtilities.windowForComponent(btnNewButton).dispose();
								
							}
							catch(Exception a)
							{
								JOptionPane.showMessageDialog(btnNewButton, this, "Error while establishing connection failed", 0);
							}
						}
					
							
						
						else {
							JOptionPane.showMessageDialog(null, "captcha doesn't match");
						}
						
					
						
						
						}
						else {
							
							userf.setText("");
						     newpass1.setText("");
						     confirmpass.setText("");
						}
						i++;
						
					}
					if(et==0) {
						error.setText("Invalid password or username");
					}
						}
						
						
						
					
						
					
				
					catch(Exception os)
					{
						System.out.print(os);
						JOptionPane.showMessageDialog(btnNewButton, this, "Error while establishing connection failed", 0);
					}
				
			}
		});
		btnNewButton.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 25));
		btnNewButton.setBounds(310, 423, 113, 35);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(101, 243, 123, 19);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("username");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(101, 188, 123, 19);
		contentPane.add(lblNewLabel_1_1);
		
		userf = new JTextField();
		userf.setBounds(278, 191, 145, 19);
		contentPane.add(userf);
		userf.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Show password");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					newpass1.setEchoChar((char)0);
							}
							else {
								newpass1.setEchoChar('*');
							}
			}
		});
		rdbtnNewRadioButton.setBounds(471, 242, 103, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Show password");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					confirmpass.setEchoChar((char)0);
							}
							else {
								newpass1.setEchoChar('*');
							}
			}
		});
		rdbtnNewRadioButton_1.setBounds(471, 310, 103, 21);
		contentPane.add(rdbtnNewRadioButton_1);
		
		captcha = new JTextField();
		captcha.setColumns(10);
		captcha.setBounds(278, 345, 145, 19);
		contentPane.add(captcha);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\91934\\Downloads\\newpass.jpg"));
		lblNewLabel_3.setBounds(0, 0, 744, 640);
		contentPane.add(lblNewLabel_3);
	}
}
