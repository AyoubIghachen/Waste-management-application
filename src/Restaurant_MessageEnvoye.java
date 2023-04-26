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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class Restaurant_MessageEnvoye extends JFrame {
	String User=DashBord.User_now;
	
	Object[][] BigData;
	Object[][] data;

	private JPanel contentPane;
	private JTable table;
	private JLabel lblReceivedMessage;
	private JLabel lblID_msg;
	private JLabel lblFrom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Restaurant_MessageEnvoye frame = new Restaurant_MessageEnvoye();
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
	public Restaurant_MessageEnvoye() {
		
		setTitle("Messages Envoyés");
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
		
		JLabel lblRegistration = new JLabel("  ");
		lblRegistration.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistration.setBounds(212, 437, 396, 35);
		panel.add(lblRegistration);
		
		//Table content:
		
		String[] Titles = new String[]{
				"ID_msg", "From"
			};
		
		//Table remplissage:
		Connection connection = null;
		
		try {	
			connection = ConnectionDB.getConnection();
            System.out.println("Connected to MySQL server");
            String sql ="SELECT ID,Destinataire,Message FROM Message WHERE User = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, User);
            
	        ResultSet rs = statement.executeQuery();
	        int conteur=0;
	        while(rs.next()) {
				conteur++;
			}
	        if(conteur!=0) {
	        	BigData = new Object[conteur][3];
		        data = new Object[conteur][2];
		        rs = statement.executeQuery();
		        
				while(rs.next()) {
					int i = rs.getRow()-1;
					for(int j=0;j<2;j++) {
						//Maybe ERROR j=0: rs.getInt(1)
						if(j==0) {
							data[i][j] = String.valueOf(rs.getInt(j+1));
						}else {
							data[i][j] = rs.getString(j+1);
						}
					}
					for(int j=0;j<3;j++) {
						if(j==0) {
							BigData[i][j] = String.valueOf(rs.getInt(j+1));
						}else {
							BigData[i][j] = rs.getString(j+1);
						}
					}
				}
	        }
			rs.close();
			statement.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		/*
			new Object[][] {
				{"5", "Ighachen@gmail.com"},
				{"28", "J546387"},
			},
			new String[] {
				"ID_msg", "From"
			}
		 */
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table.setModel(new DefaultTableModel(data,Titles) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setMaxWidth(75);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(245, 124, 331, 303);
		panel.add(table);
		
		
		if(User.equals("")) {
			lblRegistration.setForeground(new Color(255, 0, 0));
			lblRegistration.setText("You must connect!");
		}else {
			if(BigData!=null) {
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						int selectedRowIndex = table.getSelectedRow();
					//	String ID_msg = model.getValueAt(selectedRowIndex, 0).toString();
					//	String From = model.getValueAt(selectedRowIndex, 1).toString();
						
						Message_To frameMessage = new Message_To(BigData[selectedRowIndex]);
						frameMessage.setVisible(true);
					}
				});
			}
		}
		
		lblReceivedMessage = new JLabel("Sent Messages");
		lblReceivedMessage.setForeground(SystemColor.window);
		lblReceivedMessage.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblReceivedMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceivedMessage.setBounds(10, 21, 779, 37);
		panel.add(lblReceivedMessage);
		
		lblID_msg = new JLabel("ID_msg");
		lblID_msg.setForeground(new Color(240, 255, 240));
		lblID_msg.setFont(new Font("Eras Demi ITC", Font.PLAIN, 17));
		lblID_msg.setBounds(250, 96, 63, 30);
		panel.add(lblID_msg);
		
		lblFrom = new JLabel("To");
		lblFrom.setForeground(new Color(240, 255, 240));
		lblFrom.setFont(new Font("Eras Demi ITC", Font.PLAIN, 17));
		lblFrom.setBounds(385, 96, 92, 30);
		panel.add(lblFrom);
		
		//DataBase:
		/*DefaultTableModel model = (DefaultTableModel) table.getModel();
		int selectedRowIndex = table.getSelectedRow();
		String cin = model.getValueAt(selectedRowIndex, 1).toString();
		String username = model.getValueAt(selectedRowIndex, 2).toString();
		*/
		//***
		
		JButton btnRetourn = new JButton("Retourn");
		btnRetourn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Retourn Frame
				Restaurant_VisualiserMessage frame = new Restaurant_VisualiserMessage();
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


