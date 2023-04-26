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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;



public class Distribution_CreerBesoin extends JFrame {
	String User=DashBord.User_now;
	
	private static int ID_Besoin=NbrRowTable()+1;

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField txtNom;
	private JTextField textQuantite;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Distribution_CreerBesoin frame = new Distribution_CreerBesoin();
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
	public Distribution_CreerBesoin() {
		setTitle("Créer un besoin");
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
		
		lblNewLabel = new JLabel("Créer un besoin");
		lblNewLabel.setForeground(SystemColor.window);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 21, 779, 37);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Nom du produit :");
		lblNewLabel_1.setForeground(new Color(240, 255, 240));
		lblNewLabel_1.setFont(new Font("Eras Demi ITC", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(69, 117, 160, 30);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Quantité (Kg):");
		lblNewLabel_2.setForeground(new Color(240, 255, 240));
		lblNewLabel_2.setFont(new Font("Eras Demi ITC", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(69, 208, 130, 30);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Date limite:");
		lblNewLabel_3.setForeground(new Color(240, 255, 240));
		lblNewLabel_3.setFont(new Font("Eras Demi ITC", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(69, 302, 190, 30);
		panel.add(lblNewLabel_3);
		
		txtNom = new JTextField();
		txtNom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNom.setBounds(239, 117, 315, 31);
		txtNom.setColumns(10);
		panel.add(txtNom);
		
		textQuantite = new JTextField();
		textQuantite.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
	             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
	                  e.consume();  // ignorer l'événement
	             }
			}
		});
		textQuantite.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textQuantite.setColumns(10);
		textQuantite.setBounds(239, 208, 315, 31);
		panel.add(textQuantite);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBorder(new LineBorder(new Color(0, 0, 0)));
		dateChooser.setDateFormatString("d/M/y");
		dateChooser.setBounds(239, 302, 315, 30);
		panel.add(dateChooser);
		
		JButton btnCreer = new JButton("Créer");
		btnCreer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Nom =txtNom.getText();
				String Quantite = textQuantite.getText();
				String Date = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
				
				if(User.equals("")) {
					lblRegistration.setForeground(new Color(255, 0, 0));
					lblRegistration.setText("You must connect!");
				}else if(Nom.equals("")||Quantite.equals("")||Date.equals("")) {
					lblRegistration.setForeground(new Color(255, 0, 0));
					lblRegistration.setText("You must fill all fields!");
				}else {
					Connection connection = null;
					try {	
						connection = ConnectionDB.getConnection();
			            System.out.println("Connected to MySQL server");
			            String sql ="INSERT INTO Besoin_Distribution (ID,Name,Quantity,Date,Declarer,Valider,Username,Resolved) VALUES (?,?,?,?,?,?,?,?)";
			            PreparedStatement statement = connection.prepareStatement(sql);
			            statement.setInt(1, ID_Besoin);
			            statement.setString(2, Nom);
			            statement.setString(3, Quantite);
			            statement.setString(4, Date);
			            statement.setString(5, "No");
			            statement.setString(6, "Not yet");
			            statement.setString(7, User);
			            statement.setString(8, "Not yet");
			            
			            int rows = statement.executeUpdate();
						
						statement.close();
						ID_Besoin++;
						lblRegistration.setForeground(new Color(0, 128, 0));
						lblRegistration.setText("The creation is done correctly!");
					}catch(SQLException ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		btnCreer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCreer.setBounds(347, 389, 118, 37);
		panel.add(btnCreer);
		
		
		JButton btnRetourn = new JButton("Retourn");
		btnRetourn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Return Frame
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
		//Count the row of DeclarerDechet:
		try {	
			connection = ConnectionDB.getConnection();
            System.out.println("Connected to MySQL server");
            String sql ="SELECT * FROM Besoin_Distribution WHERE 1";
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

