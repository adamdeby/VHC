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
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.Action;
import java.awt.SystemColor;

public class MainMenu {

	private JFrame frame;
	private final Action action = new SwingAction();
	private JLabel Clock;

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

	public void clock() {

		Thread clock = new Thread() {
			public void run() {
				try {
					for (;;) {
						Calendar cal = new GregorianCalendar();
						int day = cal.get(Calendar.DAY_OF_MONTH);
						int month = cal.get(Calendar.MONTH);
						int year = cal.get(Calendar.YEAR);

						int second = cal.get(Calendar.SECOND);
						int minute = cal.get(Calendar.MINUTE);
						int hour = cal.get(Calendar.HOUR);

						Clock.setText("Date:  " + month + "/" + day + "/" + year + "    Time: " + hour + ":" + minute
								+ ":" + second);

						sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		clock.start();
	}

	/**
	 * Create the application.
	 */
	public MainMenu() {
		initialize();
		clock();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaption);
		frame.setBounds(100, 100, 570, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnClient = new JButton("Client");
		btnClient.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		btnClient.setBounds(289, 244, 132, 50);
		frame.getContentPane().add(btnClient);

		JButton btnOwner = new JButton("Owner");
		btnOwner.setAction(action);
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
		centerLbl.setFont(new Font("Yu Gothic UI", Font.BOLD, 29));
		centerLbl.setHorizontalAlignment(SwingConstants.CENTER);
		centerLbl.setBounds(110, 52, 325, 80);
		frame.getContentPane().add(centerLbl);

		JButton RealTimeReport = new JButton("Real Time Report");
		RealTimeReport.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		RealTimeReport.setBounds(289, 338, 132, 50);
		frame.getContentPane().add(RealTimeReport);

		// CLOCK
		Clock = new JLabel("New label");
		Clock.setBounds(186, 11, 203, 32);
		frame.getContentPane().add(Clock);

	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Owner");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		// When user clicks button a new frame will appear
		public void actionPerformed(ActionEvent e) {
			OwnerGui openOwnerGui = new OwnerGui();
			openOwnerGui.OwnerGui.setVisible(true);
			frame.dispose();
		}

	}
}
