import java.awt.EventQueue;
import java.awt.SystemColor;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;



public class Restaurant_MessageBesoin extends JFrame {
	String User=DashBord.User_now;
	
	static Object[][] data;

	private JPanel contentPane;
	private JLabel lblRegistration;

	
	
	public Restaurant_MessageBesoin(Object[] BigDataRow) {
		int ID_Besoin2 = (int) BigDataRow[0];
		
		String ID_Besoin = String.valueOf((int) BigDataRow[0]);
		String Name = (String) BigDataRow[1];
		String Quantity = String.valueOf((int) BigDataRow[2]);
		String Date = (String) BigDataRow[3];
		String To = (String) BigDataRow[4];
		
		String Message = "Case accepted !"+"\r\nID_Besoin : "+ID_Besoin+"\r\nName : "+Name+"\r\nQuantity : "+Quantity+"\r\nDate limite : "+Date ;
		
		
		setTitle("ID Besoin : "+ID_Besoin);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 11, 421, 280);
		contentPane.add(panel);
		
		JLabel lblTo = new JLabel("To :");
		lblTo.setForeground(new Color(240, 255, 240));
		lblTo.setFont(new Font("Eras Demi ITC", Font.PLAIN, 17));
		lblTo.setBounds(33, 11, 62, 26);
		panel.add(lblTo);
		
		JLabel lblUsername = new JLabel(To);
		lblUsername.setForeground(SystemColor.infoText);
		lblUsername.setFont(new Font("Eras Demi ITC", Font.PLAIN, 17));
		lblUsername.setBounds(147, 11, 243, 26);
		panel.add(lblUsername);
		
		JTextArea textAreaMessage = new JTextArea();
		textAreaMessage.setEditable(false);
		textAreaMessage.setText(Message);
		textAreaMessage.setBounds(33, 48, 357, 167);
		panel.add(textAreaMessage);
		
		JButton btnSend = new JButton("SEND");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(User.equals("")) {
					lblRegistration.setForeground(new Color(255, 0, 0));
					lblRegistration.setText("You must connect!");
				}else {
					Connection connection = null;
					try {
						int ID_Message = Distribution_EnvoyerMessage.NbrRowTable()+1;
						connection = ConnectionDB.getConnection();
			            System.out.println("Connected to MySQL server");
			            String sql ="INSERT INTO Message (ID,User,Destinataire,Message) VALUES (?,?,?,?)";
			            PreparedStatement statement = connection.prepareStatement(sql);
			            statement.setInt(1, ID_Message);
			            statement.setString(2, User);
			            statement.setString(3, To);
			            statement.setString(4, Message);
			            
			            int rows = statement.executeUpdate();
						statement.close();
						
						Connection connection2 = null;
						try {	
							connection2 = ConnectionDB.getConnection();
				            System.out.println("Connected to MySQL server");
				            String sql2 ="UPDATE Besoin_Distribution SET Resolved = ? WHERE ID = ?";
				            PreparedStatement statement2 = connection2.prepareStatement(sql2);
				            statement2.setString(1, "Yes");
				            statement2.setInt(2, ID_Besoin2);
				            
				            int rows2 = statement2.executeUpdate();
							statement2.close();
						}catch(SQLException ex) {
							ex.printStackTrace();
						}
					}catch(SQLException ex) {
						ex.printStackTrace();
					}
					dispose();
					Restaurant_ChoisirBesoin frame = new Restaurant_ChoisirBesoin();
					frame.setVisible(true);
				}
			}
		});
		btnSend.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSend.setBounds(65, 226, 114, 37);
		panel.add(btnSend);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancel.setBounds(252, 226, 114, 37);
		panel.add(btnCancel);
		
		lblRegistration = new JLabel("  ");
		lblRegistration.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistration.setBounds(318, 7, 93, 37);
		panel.add(lblRegistration);
		
	}
	
}



