import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;



public class Message_From extends JFrame {

	private JPanel contentPane;	
	
	
	public Message_From(Object[] BigDataRow) {
		
		String ID_msg = (String) BigDataRow[0];
		String From = (String) BigDataRow[1];
		String Message = (String) BigDataRow[2];
		
		setTitle("Message ID : "+ID_msg);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 279);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 11, 421, 218);
		contentPane.add(panel);
		
		JLabel lblFrom = new JLabel("From :");
		lblFrom.setForeground(new Color(240, 255, 240));
		lblFrom.setFont(new Font("Eras Demi ITC", Font.PLAIN, 17));
		lblFrom.setBounds(33, 11, 62, 26);
		panel.add(lblFrom);
		
		JLabel lblUsername = new JLabel(From);
		lblUsername.setForeground(SystemColor.infoText);
		lblUsername.setFont(new Font("Eras Demi ITC", Font.PLAIN, 17));
		lblUsername.setBounds(147, 11, 243, 26);
		panel.add(lblUsername);
		
		JTextArea textAreaMessage = new JTextArea();
		textAreaMessage.setText(Message);
		textAreaMessage.setEditable(false);
		textAreaMessage.setBounds(33, 48, 357, 144);
		panel.add(textAreaMessage);
		
	}
}



