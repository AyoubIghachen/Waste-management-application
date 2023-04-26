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



public class Frame_Restaurant extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_Restaurant frame = new Frame_Restaurant();
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
	public Frame_Restaurant() {
		setTitle("Espace Restaurant");
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
		
		JButton btnDeclarer = new JButton("Déclarer des déchets");
		btnDeclarer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Frame Déclarer des déchets
				Restaurant_DeclarerDechets frame = new Restaurant_DeclarerDechets();
				frame.setVisible(true);
				dispose();
			}
		});
		btnDeclarer.setForeground(SystemColor.textHighlightText);
		btnDeclarer.setFont(new Font("Batang", Font.BOLD, 18));
		btnDeclarer.setBorder(new RoundBtn(35));
		btnDeclarer.setBackground(SystemColor.activeCaption);
		btnDeclarer.setBounds(202, 49, 397, 50);
		panel.add(btnDeclarer);
		
		JButton btnChoisir = new JButton("Choisir un point de vente");
		btnChoisir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Frame Choisir un point de vente
				Restaurant_ChoisirBesoin frame = new Restaurant_ChoisirBesoin();
				frame.setVisible(true);
				dispose();
			}
		});
		btnChoisir.setForeground(SystemColor.textHighlightText);
		btnChoisir.setFont(new Font("Batang", Font.BOLD, 18));
		btnChoisir.setBorder(new RoundBtn(35));
		btnChoisir.setBackground(SystemColor.activeCaption);
		btnChoisir.setBounds(202, 132, 397, 50);
		panel.add(btnChoisir);
		
		JButton btnEnyoyer = new JButton("Envoyer un message");
		btnEnyoyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Frame Envoyer un message
				Restaurant_EnvoyerMessage frame = new Restaurant_EnvoyerMessage();
				frame.setVisible(true);
				dispose();
			}
		});
		btnEnyoyer.setForeground(SystemColor.textHighlightText);
		btnEnyoyer.setFont(new Font("Batang", Font.BOLD, 18));
		btnEnyoyer.setBorder(new RoundBtn(35));
		btnEnyoyer.setBackground(SystemColor.activeCaption);
		btnEnyoyer.setBounds(202, 214, 397, 50);
		panel.add(btnEnyoyer);
		
		JButton btnVisualiserMessage = new JButton("Visualiser les messages");
		btnVisualiserMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Frame Visualiser les messages
				Restaurant_VisualiserMessage frame = new Restaurant_VisualiserMessage();
				frame.setVisible(true);
				dispose();
			}
		});
		btnVisualiserMessage.setForeground(Color.WHITE);
		btnVisualiserMessage.setFont(new Font("Dialog", Font.BOLD, 18));
		btnVisualiserMessage.setBorder(new RoundBtn(35));
		btnVisualiserMessage.setBackground(SystemColor.activeCaption);
		btnVisualiserMessage.setBounds(202, 297, 397, 50);
		panel.add(btnVisualiserMessage);
		
		
		JButton btnVisualiser = new JButton("Visualiser l’historique");
		btnVisualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Frame Visualiser l’historique
				Restaurant_HistoriqueDeclaration frame = new Restaurant_HistoriqueDeclaration();
				frame.setVisible(true);
				dispose();
			}
		});
		btnVisualiser.setForeground(Color.WHITE);
		btnVisualiser.setFont(new Font("Batang", Font.BOLD, 18));
		btnVisualiser.setBorder(new RoundBtn(35));
		btnVisualiser.setBackground(SystemColor.activeCaption);
		btnVisualiser.setBounds(202, 377, 397, 50);
		panel.add(btnVisualiser);
		
		
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

