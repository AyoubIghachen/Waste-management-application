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



public class Admin_UpdateAccount extends JFrame {
	
	static Object[][] data;

	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JButton btnDeleteAccount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_UpdateAccount frame = new Admin_UpdateAccount();
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
	public Admin_UpdateAccount() {
		
		setTitle("Delete/Update account");
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
		
		Admin_UpdateAccount.setTable(table);
		/*
		 new Object[][] {
				{"Ayoub", "N459043", "Ayoub@gmail.com", "test", "restaurant", "Male"},
				{"Ali", "J546387", "Ali@gmaill.com", "test", "distribution", "Female"},
			},
			new String[] {
				"Name", "CIN", "Username", "Password", "Role", "Gender"
			}
		 */
		panel.add(table);
		
		lblNewLabel = new JLabel("Table of Users");
		lblNewLabel.setForeground(SystemColor.window);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(264, 21, 251, 37);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setForeground(new Color(240, 255, 240));
		lblNewLabel_1.setFont(new Font("Eras Demi ITC", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(91, 94, 63, 30);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("CIN");
		lblNewLabel_2.setForeground(new Color(240, 255, 240));
		lblNewLabel_2.setFont(new Font("Eras Demi ITC", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(184, 94, 92, 30);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Username");
		lblNewLabel_3.setForeground(new Color(240, 255, 240));
		lblNewLabel_3.setFont(new Font("Eras Demi ITC", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(282, 94, 160, 30);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setForeground(new Color(240, 255, 240));
		lblNewLabel_4.setFont(new Font("Eras Demi ITC", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(469, 94, 97, 30);
		panel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Role");
		lblNewLabel_5.setForeground(new Color(240, 255, 240));
		lblNewLabel_5.setFont(new Font("Eras Demi ITC", Font.PLAIN, 17));
		lblNewLabel_5.setBounds(567, 94, 73, 30);
		panel.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Gender");
		lblNewLabel_6.setForeground(new Color(240, 255, 240));
		lblNewLabel_6.setFont(new Font("Eras Demi ITC", Font.PLAIN, 17));
		lblNewLabel_6.setBounds(642, 94, 73, 30);
		panel.add(lblNewLabel_6);
		
		btnDeleteAccount = new JButton("Delete Account");
		btnDeleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int selectedRowIndex = table.getSelectedRow();
				
				if(selectedRowIndex!=-1) {
					String cin = model.getValueAt(selectedRowIndex, 1).toString();
					String username = model.getValueAt(selectedRowIndex, 2).toString();
					
					Connection connection = null;
					//Delete from Users:
					try {	
						connection = ConnectionDB.getConnection();
			            System.out.println("Connected to MySQL server");
			            String sql ="DELETE FROM Users WHERE CIN = ?";
			            PreparedStatement statement = connection.prepareStatement(sql);
			            statement.setString(1, cin);
			            int rows = statement.executeUpdate();
						statement.close();
					}catch(SQLException ex) {
						ex.printStackTrace();
					}
					//Delete from authentification:
					try {	
						connection = ConnectionDB.getConnection();
			            System.out.println("Connected to MySQL server");
			            String sql ="DELETE FROM authentification WHERE Username = ?";
			            PreparedStatement statement = connection.prepareStatement(sql);
			            statement.setString(1, username);
			            int rows = statement.executeUpdate();
						statement.close();
					}catch(SQLException ex) {
						ex.printStackTrace();
					}
					Admin_UpdateAccount.setTable(table);
				}
			}
		});
		btnDeleteAccount.setBounds(233, 435, 146, 37);
		panel.add(btnDeleteAccount);
		
		JButton btnUpdateRole = new JButton("Update Role");
		btnUpdateRole.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int selectedRowIndex = table.getSelectedRow();
				
				if(selectedRowIndex!=-1) {
					String role = model.getValueAt(selectedRowIndex, 4).toString();
					String cin = model.getValueAt(selectedRowIndex, 1).toString();
					
					if(role.equals("restaurant")) {
						role = "distribution";
						model.setValueAt(role, selectedRowIndex, 4);
						
						Connection connection = null;
						try {	
							connection = ConnectionDB.getConnection();
				            System.out.println("Connected to MySQL server");
				            String sql ="UPDATE Users SET Role = ? WHERE CIN = ?";
				            PreparedStatement statement = connection.prepareStatement(sql);
				            statement.setString(1, role);
				            statement.setString(2, cin);
				            int rows = statement.executeUpdate();
							statement.close();
						}catch(SQLException ex) {
							ex.printStackTrace();
						}
						
						
					}else {
						role = "restaurant";
						model.setValueAt(role, selectedRowIndex, 4);
						
						Connection connection = null;
						try {	
							connection = ConnectionDB.getConnection();
				            System.out.println("Connected to MySQL server");
				            String sql ="UPDATE Users SET Role = ? WHERE CIN = ?";
				            PreparedStatement statement = connection.prepareStatement(sql);
				            statement.setString(1, role);
				            statement.setString(2, cin);
				            int rows = statement.executeUpdate();
							statement.close();
						}catch(SQLException ex) {
							ex.printStackTrace();
						}
					}
				}
			}
		});
		btnUpdateRole.setBounds(413, 435, 146, 37);
		panel.add(btnUpdateRole);
		
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
	
	public static void setTable(JTable table) {
		//Table remplissage:
				Connection connection = null;
				
				try {	
					connection = ConnectionDB.getConnection();
		            System.out.println("Connected to MySQL server");
		            String sql ="SELECT * FROM Users WHERE 1";
		            PreparedStatement statement = connection.prepareStatement(sql);
		            
			        ResultSet rs = statement.executeQuery();
			        int conteur=0;
			        while(rs.next()) {
						conteur++;
					}
			        if(conteur!=0) {
			        	data = new Object[conteur][6];
				        rs = statement.executeQuery();
				        //Name,CIN,Username,Password,Role,Gender
						while(rs.next()) {
							int i = rs.getRow()-1;
							for(int j=0;j<6;j++) {
								data[i][j] = rs.getString(j+1);
							}
						}
			        }else {
			        	data = null;
			        }
					rs.close();
					statement.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
				String[] Titles = new String[]{
						"Name", "CIN", "Username", "Password", "Role", "Gender"
					};
				
				table.setModel(new DefaultTableModel(data,Titles) {
					Class[] columnTypes = new Class[] {
						String.class, String.class, String.class, String.class, String.class, String.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
					boolean[] columnEditables = new boolean[] {
						false, false, false, false, false, false
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				table.getColumnModel().getColumn(2).setPreferredWidth(169);
				table.getColumnModel().getColumn(4).setResizable(false);
				table.getColumnModel().getColumn(4).setPreferredWidth(76);
				table.getColumnModel().getColumn(4).setMaxWidth(80);
				table.getColumnModel().getColumn(5).setResizable(false);
				table.getColumnModel().getColumn(5).setPreferredWidth(80);
				table.getColumnModel().getColumn(5).setMaxWidth(80);
				table.setBorder(new LineBorder(new Color(0, 0, 0)));
				table.setBounds(87, 123, 631, 289);
	}
	
}




