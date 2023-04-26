import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



public class Frame_Distribution extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_Distribution frame = new Frame_Distribution();
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
	public Frame_Distribution() {
		setTitle("Espace Distribution");
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
		
		JButton btnCreerBesoin = new JButton("Créer un besoin");
		btnCreerBesoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Frame Créer un besoin
				Distribution_CreerBesoin frame = new Distribution_CreerBesoin();
				frame.setVisible(true);
				dispose();
			}
		});
		btnCreerBesoin.setForeground(SystemColor.textHighlightText);
		btnCreerBesoin.setFont(new Font("Batang", Font.BOLD, 18));
		btnCreerBesoin.setBorder(new RoundBtn(35));
		btnCreerBesoin.setBackground(SystemColor.activeCaption);
		btnCreerBesoin.setBounds(202, 83, 397, 50);
		panel.add(btnCreerBesoin);
		
		JButton btnVisualiser = new JButton("Visualiser les messages");
		btnVisualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Frame Visualiser les messages
				Distribution_VisualiserMessage frame = new Distribution_VisualiserMessage();
				frame.setVisible(true);
				dispose();
			}
		});
		btnVisualiser.setForeground(SystemColor.textHighlightText);
		btnVisualiser.setFont(new Font("Batang", Font.BOLD, 18));
		btnVisualiser.setBorder(new RoundBtn(35));
		btnVisualiser.setBackground(SystemColor.activeCaption);
		btnVisualiser.setBounds(202, 166, 397, 50);
		panel.add(btnVisualiser);
		
		JButton btnEnyoyer = new JButton("Envoyer un message");
		btnEnyoyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Frame Envoyer un message
				Distribution_EnvoyerMessage frame = new Distribution_EnvoyerMessage();
				frame.setVisible(true);
				dispose();
			}
		});
		btnEnyoyer.setForeground(SystemColor.textHighlightText);
		btnEnyoyer.setFont(new Font("Batang", Font.BOLD, 18));
		btnEnyoyer.setBorder(new RoundBtn(35));
		btnEnyoyer.setBackground(SystemColor.activeCaption);
		btnEnyoyer.setBounds(202, 248, 397, 50);
		panel.add(btnEnyoyer);
		
		JButton btnDeclarer = new JButton("Déclarer des besoins");
		btnDeclarer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Frame Déclarer des besoins
				Distribution_DeclarerBesoin frame = new Distribution_DeclarerBesoin();
				frame.setVisible(true);
				dispose();
			}
		});
		btnDeclarer.setForeground(Color.WHITE);
		btnDeclarer.setFont(new Font("Batang", Font.BOLD, 18));
		btnDeclarer.setBorder(new RoundBtn(35));
		btnDeclarer.setBackground(SystemColor.activeCaption);
		btnDeclarer.setBounds(202, 331, 397, 50);
		panel.add(btnDeclarer);
		
		JButton btnRetourn = new JButton("Retourn");
		btnRetourn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Retourn Frame
				DashBord frame = new DashBord();
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



