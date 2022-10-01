import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class MainMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 570, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnClient = new JButton("Client");
		btnClient.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		btnClient.setBounds(289, 244, 132, 50);
		frame.getContentPane().add(btnClient);
		
		JButton btnOwner = new JButton("Owner");
		btnOwner.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		btnOwner.setBounds(289, 143, 132, 50);
		frame.getContentPane().add(btnOwner);
		
		JLabel ownerIcon = new JLabel("");
		ownerIcon.setBounds(218, 143, 72, 50);
		frame.getContentPane().add(ownerIcon);
		ImageIcon owner = new ImageIcon(".//res//owner.png");
		ownerIcon.setIcon(owner);
		
		JLabel clientIcon = new JLabel("");
		clientIcon.setBounds(218, 244, 72, 50);
		frame.getContentPane().add(clientIcon);
		ImageIcon client = new ImageIcon(".//res//client.png");
		clientIcon.setIcon(client);
		
		JLabel centerLbl = new JLabel("Choose an Option:");
		centerLbl.setBorder(new LineBorder(new Color(0, 0, 0)));
		centerLbl.setFont(new Font("Yu Gothic UI", Font.BOLD, 11));
		centerLbl.setHorizontalAlignment(SwingConstants.CENTER);
		centerLbl.setBounds(110, 52, 325, 80);
		frame.getContentPane().add(centerLbl);
		
		//TESTING
		//TESTING
	}
}
