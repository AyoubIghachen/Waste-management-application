import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;



public class Distribution_EnvoyerMessage extends JFrame {
	String User=DashBord.User_now;
	
	public static int ID_Message=NbrRowTable()+1;

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblDestinataire;
	private JLabel lblMessage;
	private JTextField txtDestinataire;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Distribution_EnvoyerMessage frame = new Distribution_EnvoyerMessage();
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
	public Distribution_EnvoyerMessage() {
		setTitle("Envoyer un message");
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
		
		JLabel lblRegistration = new JLabel("  ");
		lblRegistration.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistration.setBounds(212, 437, 396, 35);
		panel.add(lblRegistration);
		
		lblNewLabel = new JLabel("Envoyer un message");
		lblNewLabel.setForeground(SystemColor.window);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 21, 779, 37);
		panel.add(lblNewLabel);
		
		lblDestinataire = new JLabel("Destinataire (Username) :");
		lblDestinataire.setForeground(new Color(240, 255, 240));
		lblDestinataire.setFont(new Font("Eras Demi ITC", Font.PLAIN, 17));
		lblDestinataire.setBounds(69, 117, 221, 30);
		panel.add(lblDestinataire);
		
		lblMessage = new JLabel("Message :");
		lblMessage.setForeground(new Color(240, 255, 240));
		lblMessage.setFont(new Font("Eras Demi ITC", Font.PLAIN, 17));
		lblMessage.setBounds(69, 169, 130, 30);
		panel.add(lblMessage);
		
		txtDestinataire = new JTextField();
		txtDestinataire.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDestinataire.setBounds(300, 117, 315, 31);
		txtDestinataire.setColumns(10);
		panel.add(txtDestinataire);
		
		JTextArea txtAreaMessage = new JTextArea();
		txtAreaMessage.setBounds(172, 174, 443, 164);
		panel.add(txtAreaMessage);
		
		JButton btnEnvoyer = new JButton("Envoyer");
		btnEnvoyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(User.equals("")) {
					lblRegistration.setForeground(new Color(255, 0, 0));
					lblRegistration.setText("You must connect!");
				}else {
					String Destinataire =txtDestinataire.getText();
					String Message = txtAreaMessage.getText();
					
					if(Destinataire.equals("")||Message.equals("")) {
						lblRegistration.setForeground(new Color(255, 0, 0));
						lblRegistration.setText("You must fill all fields!");
					}else {
						Connection connection = null;
						//Verifier Destinataire:
						int verify=0;
						try {	
							connection = ConnectionDB.getConnection();
				            System.out.println("Connected to MySQL server");
				            String sql ="SELECT Username FROM authentification WHERE 1";
				            PreparedStatement statement = connection.prepareStatement(sql);
				            
					        ResultSet rs = statement.executeQuery();
							while(rs.next()) {
								if(rs.getString("Username").equals(Destinataire)&&Destinataire.indexOf("restaurant")!= -1) {
									verify=1;
								}
							}
							rs.close();
							statement.close();
						}catch(SQLException ex) {
							ex.printStackTrace();
						}
						//***
						if(verify==0) {
							lblRegistration.setForeground(new Color(255, 0, 0));
							lblRegistration.setText("The Username is incorrect!");
						}else {
							try {	
								connection = ConnectionDB.getConnection();
					            System.out.println("Connected to MySQL server");
					            String sql ="INSERT INTO Message (ID,User,Destinataire,Message) VALUES (?,?,?,?)";
					            PreparedStatement statement = connection.prepareStatement(sql);
					            statement.setInt(1, ID_Message);
					            statement.setString(2, User);
					            statement.setString(3, Destinataire);
					            statement.setString(4, Message);
					            
					            int rows = statement.executeUpdate();
								
								statement.close();
								ID_Message++;
								lblRegistration.setForeground(new Color(0, 128, 0));
								lblRegistration.setText("The message is sent successfully!");
							}catch(SQLException ex) {
								ex.printStackTrace();
							}
						}
					}
				}
			}
		});
		btnEnvoyer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEnvoyer.setBounds(347, 389, 118, 37);
		panel.add(btnEnvoyer);
		
		
		JButton btnRetourn = new JButton("Retourn");
		btnRetourn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Retourn Frame
				Frame_Distribution frame = new Frame_Distribution();
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
	
	public static int NbrRowTable() {
		int conteur=0;
		Connection connection = null;
		//Count the row of EnvoyerMessage:
		try {	
			connection = ConnectionDB.getConnection();
            System.out.println("Connected to MySQL server");
            String sql ="SELECT * FROM Message WHERE 1";
            PreparedStatement statement = connection.prepareStatement(sql);
            
	        ResultSet rs = statement.executeQuery();
	        
	        while(rs.next()) {
				conteur++;
			}
			rs.close();
			statement.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return conteur;
	}
}

