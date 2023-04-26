import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;



public class Restaurant_VisualiserMessage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Restaurant_VisualiserMessage frame = new Restaurant_VisualiserMessage();
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
	public Restaurant_VisualiserMessage() {
		setTitle("Visualiser les messages");
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
		
		JButton btnMsgEnvoyer = new JButton("Messages Envoyés");
		btnMsgEnvoyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Frame message envoyé
				Restaurant_MessageEnvoye frame = new Restaurant_MessageEnvoye();
				frame.setVisible(true);
			}
		});
		btnMsgEnvoyer.setForeground(SystemColor.textHighlightText);
		btnMsgEnvoyer.setFont(new Font("Batang", Font.BOLD, 18));
		btnMsgEnvoyer.setBorder(new RoundBtn(35));
		btnMsgEnvoyer.setBackground(SystemColor.activeCaption);
		btnMsgEnvoyer.setBounds(203, 159, 397, 50);
		panel.add(btnMsgEnvoyer);
		
		JButton btnMsgRecu = new JButton("Messages Reçus");
		btnMsgRecu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Frame message recus
				Restaurant_MessageRecu frame = new Restaurant_MessageRecu();
				frame.setVisible(true);
			}
		});
		btnMsgRecu.setForeground(SystemColor.textHighlightText);
		btnMsgRecu.setFont(new Font("Batang", Font.BOLD, 18));
		btnMsgRecu.setBorder(new RoundBtn(35));
		btnMsgRecu.setBackground(SystemColor.activeCaption);
		btnMsgRecu.setBounds(203, 241, 397, 50);
		panel.add(btnMsgRecu);
		
		JButton btnRetourn = new JButton("Retourn");
		btnRetourn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Retourn Frame
				Frame_Restaurant frame = new Frame_Restaurant();
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


