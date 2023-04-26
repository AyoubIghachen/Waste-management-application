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



public class Distribution_DeclarerBesoin extends JFrame {
	String User=DashBord.User_now;
	
	static Object[][] data;

	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JLabel lblID_Besoin;
	private JLabel lblName;
	private JLabel lblQuantity;
	private JLabel lblDate;
	private JLabel lblDeclarer;
	private JLabel lblValider;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Distribution_DeclarerBesoin frame = new Distribution_DeclarerBesoin();
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
	public Distribution_DeclarerBesoin() {
		
		setTitle("Les cas de besoin");
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
		
		//Table remplissage:
		Connection connection = null;
		
		try {	
			connection = ConnectionDB.getConnection();
            System.out.println("Connected to MySQL server");
            String sql ="SELECT ID,Name,Quantity,Date,Declarer,Valider FROM Besoin_Distribution WHERE Username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, User);
            
	        ResultSet rs = statement.executeQuery();
	        int conteur=0;
	        while(rs.next()) {
				conteur++;
			}
	        if(conteur!=0) {
	        	data = new Object[conteur][6];
		        rs = statement.executeQuery();
		        //Besoin_Distribution (ID,Name,Quantity,Date,Declarer,Valider,Username)
				while(rs.next()) {
					int i = rs.getRow()-1;
					for(int j=0;j<6;j++) {
						data[i][j] = rs.getString(j+1);
					}
				}
	        }
			rs.close();
			statement.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		String[] Titles = new String[]{
				"ID", "Name", "Quantity", "Date", "Declarer", "Valider"
			};
		
		table.setModel(new DefaultTableModel(data,Titles) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, String.class, String.class, String.class
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
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(0).setMaxWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setMaxWidth(80);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(70);
		table.getColumnModel().getColumn(3).setMaxWidth(70);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(80);
		table.getColumnModel().getColumn(4).setMaxWidth(80);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(80);
		table.getColumnModel().getColumn(5).setMaxWidth(80);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(121, 123, 527, 289);
		
		
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
		
		lblNewLabel = new JLabel("Les cas de besoin");
		lblNewLabel.setForeground(SystemColor.window);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 21, 779, 37);
		panel.add(lblNewLabel);
		
		lblID_Besoin = new JLabel("ID");
		lblID_Besoin.setForeground(new Color(240, 255, 240));
		lblID_Besoin.setFont(new Font("Eras Demi ITC", Font.PLAIN, 15));
		lblID_Besoin.setBounds(125, 94, 29, 30);
		panel.add(lblID_Besoin);
		
		lblName = new JLabel("Name");
		lblName.setForeground(new Color(240, 255, 240));
		lblName.setFont(new Font("Eras Demi ITC", Font.PLAIN, 15));
		lblName.setBounds(184, 94, 92, 30);
		panel.add(lblName);
		
		lblQuantity = new JLabel("Quantity");
		lblQuantity.setForeground(new Color(240, 255, 240));
		lblQuantity.setFont(new Font("Eras Demi ITC", Font.PLAIN, 15));
		lblQuantity.setBounds(344, 94, 83, 30);
		panel.add(lblQuantity);
		
		lblDate = new JLabel("Date");
		lblDate.setForeground(new Color(240, 255, 240));
		lblDate.setFont(new Font("Eras Demi ITC", Font.PLAIN, 15));
		lblDate.setBounds(426, 94, 47, 30);
		panel.add(lblDate);
		
		lblDeclarer = new JLabel("Declarer");
		lblDeclarer.setForeground(new Color(240, 255, 240));
		lblDeclarer.setFont(new Font("Eras Demi ITC", Font.PLAIN, 15));
		lblDeclarer.setBounds(493, 94, 73, 30);
		panel.add(lblDeclarer);
		
		lblValider = new JLabel("Valider");
		lblValider.setForeground(new Color(240, 255, 240));
		lblValider.setFont(new Font("Eras Demi ITC", Font.PLAIN, 15));
		lblValider.setBounds(575, 94, 73, 30);
		panel.add(lblValider);
		
		JButton btnDeclarerBesoin = new JButton("Declarer besoin");
		btnDeclarerBesoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int selectedRowIndex = table.getSelectedRow();
				
				if(selectedRowIndex!=-1) {
					String Declarer = model.getValueAt(selectedRowIndex, 4).toString();
					int ID_Besoin = Integer.valueOf(model.getValueAt(selectedRowIndex, 0).toString());
					
					if(Declarer.equals("No")) {
						Declarer = "Yes";
						model.setValueAt(Declarer, selectedRowIndex, 4);
						
						Connection connection = null;
						try {	
							connection = ConnectionDB.getConnection();
				            System.out.println("Connected to MySQL server");
				            String sql ="UPDATE Besoin_Distribution SET Declarer = ? WHERE ID = ?";
				            PreparedStatement statement = connection.prepareStatement(sql);
				            statement.setString(1, Declarer);
				            statement.setInt(2, ID_Besoin);
				            
				            int rows = statement.executeUpdate();
							statement.close();
						}catch(SQLException ex) {
							ex.printStackTrace();
						}
					}else {
						Declarer = "No";
						model.setValueAt(Declarer, selectedRowIndex, 4);
						
						Connection connection = null;
						try {	
							connection = ConnectionDB.getConnection();
				            System.out.println("Connected to MySQL server");
				            String sql ="UPDATE Besoin_Distribution SET Declarer = ? WHERE ID = ?";
				            PreparedStatement statement = connection.prepareStatement(sql);
				            statement.setString(1, Declarer);
				            statement.setInt(2, ID_Besoin);
				            
				            int rows = statement.executeUpdate();
							statement.close();
						}catch(SQLException ex) {
							ex.printStackTrace();
						}
					}
				}
			}
		});
		btnDeclarerBesoin.setBounds(121, 423, 146, 37);
		panel.add(btnDeclarerBesoin);
		
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
		
		JLabel lblRegistration = new JLabel("  ");
		lblRegistration.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistration.setBounds(278, 423, 370, 37);
		panel.add(lblRegistration);
		
		if(User.equals("")) {
			lblRegistration.setForeground(new Color(255, 0, 0));
			lblRegistration.setText("You must connect!");
		}
	}
	
}


