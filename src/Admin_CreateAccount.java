import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JRadioButton;
import javax.swing.JButton;



public class Admin_CreateAccount extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtCIN;
	private JTextField txtPassword;
	private JTextField txtConPassword;
	int gender=0;
	int role=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_CreateAccount frame = new Admin_CreateAccount();
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
	public Admin_CreateAccount() {
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		setTitle("Create Account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 836, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 11, 799, 483);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(8, 0, 0, 0));
		panel_1.setBounds(10, 11, 200, 35);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create an account");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setForeground(SystemColor.inactiveCaptionText);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(10, 0, 193, 35);
		panel_1.add(lblNewLabel);
		
		JPanel panel_Password = new JPanel();
		panel_Password.setBackground(SystemColor.activeCaption);
		panel_Password.setBounds(35, 67, 335, 75);
		panel.add(panel_Password);
		panel_Password.setLayout(null);
		
		JLabel lblName = new JLabel("First & Last Name *");
		lblName.setForeground(SystemColor.textHighlightText);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(10, 11, 142, 21);
		panel_Password.add(lblName);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtName.setBounds(10, 38, 315, 31);
		panel_Password.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblRequired = new JLabel(" ");
		lblRequired.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		lblRequired.setForeground(new Color(255, 0, 0));
		lblRequired.setBounds(155, 11, 170, 23);
		panel_Password.add(lblRequired);
		
		JPanel panel_CIN = new JPanel();
		panel_CIN.setLayout(null);
		panel_CIN.setBackground(SystemColor.activeCaption);
		panel_CIN.setBounds(422, 67, 335, 75);
		panel.add(panel_CIN);
		
		JLabel lblCIN = new JLabel("CIN *");
		lblCIN.setForeground(Color.WHITE);
		lblCIN.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCIN.setBounds(10, 11, 47, 21);
		panel_CIN.add(lblCIN);
		
		txtCIN = new JTextField();
		txtCIN.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCIN.setColumns(10);
		txtCIN.setBounds(10, 38, 315, 31);
		panel_CIN.add(txtCIN);
		
		JLabel lblRequired_3 = new JLabel(" ");
		lblRequired_3.setForeground(Color.RED);
		lblRequired_3.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		lblRequired_3.setBounds(65, 11, 260, 23);
		panel_CIN.add(lblRequired_3);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setLayout(null);
		panel_2_2.setBackground(SystemColor.activeCaption);
		panel_2_2.setBounds(35, 153, 335, 75);
		panel.add(panel_2_2);
		
		JLabel lblPassword = new JLabel("Password *");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(10, 11, 85, 21);
		panel_2_2.add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPassword.setColumns(10);
		txtPassword.setBounds(10, 38, 315, 31);
		panel_2_2.add(txtPassword);
		
		JLabel lblRequired_1 = new JLabel(" ");
		lblRequired_1.setForeground(Color.RED);
		lblRequired_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		lblRequired_1.setBounds(100, 11, 225, 23);
		panel_2_2.add(lblRequired_1);
		
		JPanel panel_ConPassword = new JPanel();
		panel_ConPassword.setLayout(null);
		panel_ConPassword.setBackground(SystemColor.activeCaption);
		panel_ConPassword.setBounds(422, 153, 335, 75);
		panel.add(panel_ConPassword);
		
		JLabel lblConPassword = new JLabel("Confirm Password *");
		lblConPassword.setForeground(Color.WHITE);
		lblConPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblConPassword.setBounds(10, 11, 138, 21);
		panel_ConPassword.add(lblConPassword);
		
		txtConPassword = new JTextField();
		txtConPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtConPassword.setColumns(10);
		txtConPassword.setBounds(10, 38, 315, 31);
		panel_ConPassword.add(txtConPassword);
		
		JLabel lblRequired_4 = new JLabel(" ");
		lblRequired_4.setForeground(Color.RED);
		lblRequired_4.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		lblRequired_4.setBounds(158, 11, 167, 23);
		panel_ConPassword.add(lblRequired_4);
		
		JPanel panel_Gender = new JPanel();
		panel_Gender.setLayout(null);
		panel_Gender.setBackground(SystemColor.activeCaption);
		panel_Gender.setBounds(422, 239, 335, 75);
		panel.add(panel_Gender);
		
		JLabel lblGender = new JLabel("Gender *");
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGender.setBounds(10, 11, 74, 21);
		panel_Gender.add(lblGender);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender = 1;
			}
		});
		rdbtnMale.setBackground(SystemColor.activeCaption);
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnMale.setBounds(48, 39, 109, 23);
		panel_Gender.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender = 2;
			}
		});
		rdbtnFemale.setBackground(SystemColor.activeCaption);
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnFemale.setBounds(159, 39, 109, 23);
		panel_Gender.add(rdbtnFemale);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnMale);
		group.add(rdbtnFemale);
		
		JLabel lblRequired_5 = new JLabel(" ");
		lblRequired_5.setForeground(Color.RED);
		lblRequired_5.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		lblRequired_5.setBounds(92, 11, 233, 23);
		panel_Gender.add(lblRequired_5);
		
		JPanel panel_Role = new JPanel();
		panel_Role.setLayout(null);
		panel_Role.setBackground(SystemColor.activeCaption);
		panel_Role.setBounds(35, 239, 335, 93);
		panel.add(panel_Role);
		
		JLabel lblRole = new JLabel("Role *");
		lblRole.setForeground(Color.WHITE);
		lblRole.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRole.setBounds(10, 11, 58, 21);
		panel_Role.add(lblRole);
		
		JRadioButton rdbtnRestaurant = new JRadioButton("Propriétaire de restaurant");
		rdbtnRestaurant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				role = 1;
			}
		});
		rdbtnRestaurant.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnRestaurant.setBackground(SystemColor.activeCaption);
		rdbtnRestaurant.setBounds(36, 39, 224, 23);
		panel_Role.add(rdbtnRestaurant);
		
		JRadioButton rdbtnResponsable = new JRadioButton("Responsable de point de vente");
		rdbtnResponsable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				role = 2;
			}
		});
		rdbtnResponsable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnResponsable.setBackground(SystemColor.activeCaption);
		rdbtnResponsable.setBounds(36, 65, 244, 23);
		panel_Role.add(rdbtnResponsable);
		
		ButtonGroup group2 = new ButtonGroup();
		group2.add(rdbtnRestaurant);
		group2.add(rdbtnResponsable);
		
		JLabel lblRequired_2 = new JLabel(" ");
		lblRequired_2.setForeground(Color.RED);
		lblRequired_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		lblRequired_2.setBounds(69, 11, 256, 23);
		panel_Role.add(lblRequired_2);
		
		JLabel lblRegistration = new JLabel("  ");
		lblRegistration.setForeground(new Color(0, 128, 0));
		lblRegistration.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistration.setBounds(202, 437, 396, 35);
		panel.add(lblRegistration);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtName.getText().equals("")) {
					lblRequired.setText("Required !");
				}else {
					lblRequired.setText("");
				}
				if(txtCIN.getText().equals("")) {
					lblRequired_3.setText("Required !");
				}else {
					lblRequired_3.setText("");
				}
				if(txtPassword.getText().equals("")) {
					lblRequired_1.setText("Required !");
				}else {
					lblRequired_1.setText("");
				}
				if(txtConPassword.getText().equals("")) {
					lblRequired_4.setText("Required !");
				}else {
					lblRequired_4.setText("");
				}
				if(role==0) {
					lblRequired_2.setText("Required !");
				}else {
					lblRequired_2.setText("");
				}
				if(gender==0) {
					lblRequired_5.setText("Required !");
				}else {
					lblRequired_5.setText("");
				}
				//Same password:
				if(txtPassword.getText().equals("")!=true && txtConPassword.getText().equals("")!=true) {
					if(txtPassword.getText().equals(txtConPassword.getText())!=true) {
						lblRequired_4.setText("Not same password !");
					}else {
						lblRequired_4.setText("");
					}
				}
				//DataBase:
				if(lblRequired.getText().equals("") && lblRequired_1.getText().equals("") && lblRequired_2.getText().equals("") && lblRequired_3.getText().equals("") && lblRequired_4.getText().equals("") && lblRequired_5.getText().equals("")) {
					Connection connection = null;
					int conteurName=0;
					int conteurCIN=0;
					String Name,CIN,Username,Password,Role,Gender;
					Name=txtName.getText();
					CIN=txtCIN.getText();
					if(role==1){
						Role="restaurant";
					}else {
						Role="distribution";
					}
					Username=Name+"@sig.com";
					Password=txtPassword.getText();
					if(gender==1){
						Gender="Male";
					}else {
						Gender="Female";
					}
					
					try {	
						connection = ConnectionDB.getConnection();
			            System.out.println("Connected to MySQL server");
			            String sql ="SELECT Name,CIN FROM Users WHERE 1";
			            PreparedStatement statement = connection.prepareStatement(sql);
			            
				        ResultSet rs = statement.executeQuery();
						while(rs.next()) {
							if(rs.getString("Name").equals(Name)) {
								conteurName=1;
							}
							if(rs.getString("CIN").equals(CIN)) {
								conteurCIN=1;
							}
						}
						rs.close();
						statement.close();
					}catch(SQLException ex) {
						ex.printStackTrace();
					}
					if(conteurCIN==1 || conteurName==1) {
						if(conteurName==1) {
							lblRequired.setText("This Name existe!");
						}else {
							lblRequired.setText("");
						}
						if(conteurCIN==1) {
							lblRequired_3.setText("This CIN existe!");
						}else {
							lblRequired_3.setText("");
						}
					}else {
						try {	
							connection = ConnectionDB.getConnection();
				            System.out.println("Connected to MySQL server");
				            String sql ="INSERT INTO Users (Name,CIN,Username,Password,Role,Gender) VALUES (?,?,?,?,?,?)";
				            PreparedStatement statement = connection.prepareStatement(sql);
				            statement.setString(1, Name);
				            statement.setString(2, CIN);
				            statement.setString(3, Username);
				            statement.setString(4, Password);
				            statement.setString(5, Role);
				            statement.setString(6, Gender);
				            
				            int rows = statement.executeUpdate();
							
							statement.close();
						}catch(SQLException ex) {
							ex.printStackTrace();
						}
						
						try {	
							connection = ConnectionDB.getConnection();
				            System.out.println("Connected to MySQL server");
				            String sql ="INSERT INTO authentification (Username,Password) VALUES (?,?)";
				            PreparedStatement statement = connection.prepareStatement(sql);
				            statement.setString(1, Username);
				            statement.setString(2, Password);
				            
				            int rows = statement.executeUpdate();
							
							statement.close();
						}catch(SQLException ex) {
							ex.printStackTrace();
						}
						//message bon
						lblRegistration.setText("This registration is done correctly!");
					}
					
				}
			}
		});
		btnRegister.setForeground(SystemColor.textHighlightText);
		btnRegister.setBackground(SystemColor.activeCaption);
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRegister.setBorder(new RoundBtn(35));
		btnRegister.setBounds(311, 376, 181, 50);
		panel.add(btnRegister);
		
		JButton btnRetourn = new JButton("Retourn");
		btnRetourn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Retourn Frame
				Frame_Admin frame = new Frame_Admin();
				frame.setVisible(true);
				dispose();
			}
		});
		btnRetourn.setForeground(Color.WHITE);
		btnRetourn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRetourn.setBorder(new RoundBtn(35));
		btnRetourn.setBackground(SystemColor.activeCaption);
		btnRetourn.setBounds(597, 11, 160, 35);
		panel.add(btnRetourn);
		
	}
}


