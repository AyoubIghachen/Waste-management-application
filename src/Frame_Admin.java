import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;




public class Frame_Admin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_Admin frame = new Frame_Admin();
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
	public Frame_Admin() {
		setTitle("Espace Admin");
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
		
		JButton btnCreateAccount = new JButton("Create account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Frame Create account
				Admin_CreateAccount frame = new Admin_CreateAccount();
				frame.setVisible(true);
				dispose();
			}
		});
		btnCreateAccount.setForeground(SystemColor.textHighlightText);
		btnCreateAccount.setFont(new Font("Batang", Font.BOLD, 18));
		btnCreateAccount.setBorder(new RoundBtn(35));
		btnCreateAccount.setBackground(SystemColor.activeCaption);
		btnCreateAccount.setBounds(231, 83, 302, 50);
		panel.add(btnCreateAccount);
		
		JButton btnUpdateAccount = new JButton("Delete/Update account");
		btnUpdateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Frame Update account
				Admin_UpdateAccount frame = new Admin_UpdateAccount();
				frame.setVisible(true);
				dispose();
			}
		});
		btnUpdateAccount.setForeground(SystemColor.textHighlightText);
		btnUpdateAccount.setFont(new Font("Batang", Font.BOLD, 18));
		btnUpdateAccount.setBorder(new RoundBtn(35));
		btnUpdateAccount.setBackground(SystemColor.activeCaption);
		btnUpdateAccount.setBounds(231, 176, 302, 50);
		panel.add(btnUpdateAccount);
		
		JButton btnGererCas = new JButton("Gerer les cas de besoin");
		btnGererCas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Frame Gerer les cas de besoin
				Admin_GererBesoin frame = new Admin_GererBesoin();
				frame.setVisible(true);
				dispose();
			}
		});
		btnGererCas.setForeground(SystemColor.textHighlightText);
		btnGererCas.setFont(new Font("Batang", Font.BOLD, 18));
		btnGererCas.setBorder(new RoundBtn(35));
		btnGererCas.setBackground(SystemColor.activeCaption);
		btnGererCas.setBounds(231, 271, 302, 50);
		panel.add(btnGererCas);
		
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

