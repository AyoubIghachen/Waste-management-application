import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;


public class DashBord extends JFrame {
	
	public static String User_now="";
	
	//ImageIcon imageWall = new ImageIcon("image\\wall.png");

	private JPanel contentPane;
	private JLabel lblError;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashBord frame = new DashBord();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//Select Table : ------------
	public static int Select_authentification(String Valeur1,String Valeur2) {
		Connection connection = null;
			try {	
				connection = ConnectionDB.getConnection();
	            System.out.println("Connected to MySQL server");
	            String sql ="SELECT * FROM users WHERE 1";
	            PreparedStatement statement = connection.prepareStatement(sql);
				
		        ResultSet rs = statement.executeQuery();
				while(rs.next()) {
					if(rs.getString("Username").equals(Valeur1) && rs.getString("Password").equals(Valeur2)) {
						if(rs.getString("Role").equals("administrateur")) {
							return 1;
						}else if(rs.getString("Role").equals("restaurant")) {
							return 2;
						}else {
							return 3;
						}
					}
				}
				rs.close();
				statement.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return 0;
	}

	
	//----------

	/**
	 * Create the frame.
	 */
	public DashBord() {
		
		setTitle("DashBord");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 11, 799, 483);
		contentPane.add(panel);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setBounds(239, 74, 101, 25);
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("RomanD", Font.BOLD, 14));
		panel.add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(239, 110, 312, 39);
		txtUsername.setColumns(10);
		panel.add(txtUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(239, 188, 101, 25);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("RomanD", Font.BOLD, 14));
		panel.add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(239, 224, 312, 39);
		panel.add(txtPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(264, 330, 127, 45);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtUsername.getText();
				String pass = String.valueOf(txtPassword.getPassword());
				if(username.equals("") || pass.equals("")) {
					lblError.setText("Please enter Username and Password");
				}
				else {
					int n = DashBord.Select_authentification(username, pass);
					if(n == 1) {
						// Frame Admin
						Frame_Admin frame = new Frame_Admin();
						frame.setVisible(true);
						System.out.println("Frame Admin");
						User_now = username;
						dispose();
					}
					else if(n == 2) {
						// Frame Restaurant
						Frame_Restaurant frame = new Frame_Restaurant();
						frame.setVisible(true);
						System.out.println("Frame Restaurant");
						User_now = username;
						dispose();
					}
					else if(n == 3) {
						// Frame Distribution
						Frame_Distribution frame = new Frame_Distribution();
						frame.setVisible(true);
						System.out.println("Frame Distribution");
						User_now = username;
						dispose();
					}
					else {
						lblError.setText("Incorrect Username Or Password");
						txtUsername.setText("");
						txtPassword.setText("");
					}
				}
			}
		});
		panel.setLayout(null);
		btnLogin.setForeground(SystemColor.textHighlightText);
		btnLogin.setFont(new Font("Batang", Font.BOLD, 16));
		btnLogin.setBorder(new RoundBtn(35));
		btnLogin.setBackground(SystemColor.activeCaption);
		panel.add(btnLogin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(413, 330, 127, 45);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setForeground(SystemColor.textHighlightText);
		btnCancel.setFont(new Font("Batang", Font.BOLD, 16));
		btnCancel.setBorder(new RoundBtn(35));
		btnCancel.setBackground(SystemColor.activeCaption);
		panel.add(btnCancel);
		
		lblError = new JLabel("");
		lblError.setBackground(SystemColor.activeCaption);
		lblError.setFont(new Font("Gisha", Font.BOLD, 15));
		lblError.setForeground(Color.RED);
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setBounds(212, 410, 382, 40);
		panel.add(lblError);
		
		/*
		 JLabel LabelPic = new JLabel("");
		LabelPic.setHorizontalAlignment(SwingConstants.CENTER);
		LabelPic.setBounds(10, 11, 779, 461);
		panel.add(LabelPic);
		
		LabelPic.setIcon(imageWall);
		*/
	}
	
	
}



