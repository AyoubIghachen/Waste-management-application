import java.awt.EventQueue;
import java.awt.SystemColor;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class Admin_GererBesoin extends JFrame {
	String User=DashBord.User_now;
	
	static Object[][] data;

	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JLabel lblID_Besoin;
	private JLabel lblName;
	private JLabel lblQuantity;
	private JLabel lblDate;
	private JLabel lblUsername;
	private JButton btnRefuser;
	private JLabel lblRegistration;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_GererBesoin frame = new Admin_GererBesoin();
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
	public Admin_GererBesoin() {
		
		setTitle("Valider / Refuser Cas De Besoin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 836, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(11, 11, 799, 483);
		contentPane.add(panel);
		
		//Table content:
		table = new JTable();
		
		Admin_GererBesoin.setTable(table);
		
		panel.add(table);
		
		lblNewLabel = new JLabel("Valider/Refuser Cas De Besoin");
		lblNewLabel.setForeground(SystemColor.window);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 21, 779, 37);
		panel.add(lblNewLabel);
		
		lblID_Besoin = new JLabel("ID");
		lblID_Besoin.setForeground(new Color(240, 255, 240));
		lblID_Besoin.setFont(new Font("Eras Demi ITC", Font.PLAIN, 15));
		lblID_Besoin.setBounds(169, 94, 29, 30);
		panel.add(lblID_Besoin);
		
		lblName = new JLabel("Name");
		lblName.setForeground(new Color(240, 255, 240));
		lblName.setFont(new Font("Eras Demi ITC", Font.PLAIN, 15));
		lblName.setBounds(203, 94, 92, 30);
		panel.add(lblName);
		
		lblQuantity = new JLabel("Quantity");
		lblQuantity.setForeground(new Color(240, 255, 240));
		lblQuantity.setFont(new Font("Eras Demi ITC", Font.PLAIN, 15));
		lblQuantity.setBounds(336, 94, 83, 30);
		panel.add(lblQuantity);
		
		lblDate = new JLabel("Date");
		lblDate.setForeground(new Color(240, 255, 240));
		lblDate.setFont(new Font("Eras Demi ITC", Font.PLAIN, 15));
		lblDate.setBounds(419, 94, 47, 30);
		panel.add(lblDate);
		
		lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(240, 255, 240));
		lblUsername.setFont(new Font("Eras Demi ITC", Font.PLAIN, 15));
		lblUsername.setBounds(487, 94, 97, 30);
		panel.add(lblUsername);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(User.equals("")) {
					lblRegistration.setForeground(new Color(255, 0, 0));
					lblRegistration.setText("You must connect!");
				}else {
					//Frame Are you sure ?
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					int selectedRowIndex = table.getSelectedRow();
					
					if(selectedRowIndex!=-1) {
						//"ID", "Name", "Quantity", "Date", "Username"
						int ID_Besoin = Integer.valueOf(model.getValueAt(selectedRowIndex, 0).toString());
						int Quantity = Integer.valueOf(model.getValueAt(selectedRowIndex, 2).toString());
						String Name = model.getValueAt(selectedRowIndex, 1).toString();
						//Fonction(Quantity)
						int quantity=0;
						Connection connection = null;
						try {	
							connection = ConnectionDB.getConnection();
				            System.out.println("Connected to MySQL server");
				            String sql ="SELECT ID,Quantity,Date FROM DeclarerDechet WHERE Name = ? AND Resolved = ?";
				            PreparedStatement statement = connection.prepareStatement(sql);
				            statement.setString(1, Name);
				            statement.setString(2, "Not yet");
				            
					        ResultSet rs = statement.executeQuery();
					        
					        while(rs.next()) {
					        	quantity += rs.getInt("Quantity");
							}
							rs.close();
							statement.close();
						}catch(SQLException ex) {
							ex.printStackTrace();
						}
						
						if(Quantity >quantity) {
				        	lblRegistration.setText("Stock insuffisant!");
				        }else {
				        	try {	
								connection = ConnectionDB.getConnection();
					            System.out.println("Connected to MySQL server");
					            String sql ="UPDATE Besoin_Distribution SET Valider = ? WHERE ID = ?";
					            PreparedStatement statement = connection.prepareStatement(sql);
					            statement.setString(1, "Yes");
					            statement.setInt(2, ID_Besoin);
					            
					            int rows = statement.executeUpdate();
								statement.close();
							}catch(SQLException ex) {
								ex.printStackTrace();
							}
							Admin_GererBesoin.setTable(table);
				        }
					}
				}
			}
		});
		btnValider.setBounds(229, 423, 146, 37);
		panel.add(btnValider);
		
		btnRefuser = new JButton("Refuser");
		btnRefuser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(User.equals("")) {
					lblRegistration.setForeground(new Color(255, 0, 0));
					lblRegistration.setText("You must connect!");
				}else {
					//Frame Are you sure ?
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					int selectedRowIndex = table.getSelectedRow();
					
					if(selectedRowIndex!=-1) {
						//"ID", "Name", "Quantity", "Date", "Username"
						int ID_Besoin = Integer.valueOf(model.getValueAt(selectedRowIndex, 0).toString());
						
						Connection connection = null;
						try {	
							connection = ConnectionDB.getConnection();
				            System.out.println("Connected to MySQL server");
				            String sql ="UPDATE Besoin_Distribution SET Valider = ? WHERE ID = ?";
				            PreparedStatement statement = connection.prepareStatement(sql);
				            statement.setString(1, "No");
				            statement.setInt(2, ID_Besoin);
				            
				            int rows = statement.executeUpdate();
							statement.close();
						}catch(SQLException ex) {
							ex.printStackTrace();
						}
						Admin_GererBesoin.setTable(table);
					}
				}
			}
		});
		btnRefuser.setBounds(455, 423, 146, 37);
		panel.add(btnRefuser);
		
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
		btnRetourn.setBounds(629, 11, 160, 35);
		panel.add(btnRetourn);
		
		lblRegistration = new JLabel("  ");
		lblRegistration.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistration.setBounds(10, 423, 194, 37);
		panel.add(lblRegistration);
		
	}
	
	public static void setTable(JTable table) {
		//Table remplissage:
				Connection connection = null;
				
				try {	
					connection = ConnectionDB.getConnection();
		            System.out.println("Connected to MySQL server");
		            // AND Date>Tooday 
		            String sql ="SELECT ID,Name,Quantity,Date,Username FROM Besoin_Distribution WHERE Declarer = ? AND Valider = ? AND Resolved = ?";
		            PreparedStatement statement = connection.prepareStatement(sql);
		            statement.setString(1, "Yes");
		            statement.setString(2, "Not yet");
		            statement.setString(3, "Not yet");
		            
			        ResultSet rs = statement.executeQuery();
			        int conteur=0;
			        while(rs.next()) {
						conteur++;
					}
			        if(conteur!=0) {
			        	data = new Object[conteur][5];
				        rs = statement.executeQuery();
				        //Besoin_Distribution (ID,Name,Quantity,Date,Declarer,Valider,Username,Resolved)
						while(rs.next()) {
							int i = rs.getRow()-1;
							for(int j=0;j<5;j++) {
								data[i][j] = rs.getString(j+1);
							}
						}
			        }
			        else {
			        	data = null;
			        }
					rs.close();
					statement.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
				String[] Titles = new String[]{
						"ID", "Name", "Quantity", "Date", "Username"
					};
				
				table.setModel(new DefaultTableModel(data,Titles) {
						Class[] columnTypes = new Class[] {
							Integer.class, String.class, Integer.class, String.class, String.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
						boolean[] columnEditables = new boolean[] {
							false, false, false, false, false
						};
						public boolean isCellEditable(int row, int column) {
							return columnEditables[column];
						}
					});
				table.getColumnModel().getColumn(0).setResizable(false);
				table.getColumnModel().getColumn(0).setPreferredWidth(30);
				table.getColumnModel().getColumn(0).setMaxWidth(30);
				table.getColumnModel().getColumn(1).setPreferredWidth(100);
				table.getColumnModel().getColumn(2).setPreferredWidth(80);
				table.getColumnModel().getColumn(2).setMaxWidth(80);
				table.getColumnModel().getColumn(3).setResizable(false);
				table.getColumnModel().getColumn(3).setPreferredWidth(70);
				table.getColumnModel().getColumn(3).setMaxWidth(70);
				table.getColumnModel().getColumn(4).setPreferredWidth(130);
				table.setBorder(new LineBorder(new Color(0, 0, 0)));
				table.setBounds(166, 123, 482, 289);
	}
	
}



