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
import javax.swing.JPanel;

public class MainMenu {

	private JFrame frame;
	private final Action action = new SwingAction();
	private JLabel Clock;
	private final JPanel panel = new JPanel();
	private final Action action_1 = new SwingAction_1();

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
//test test
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 191, 255));
		frame.setBounds(100, 100, 720, 560);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnClient = new JButton("Client");
		btnClient.setAction(action_1);
		btnClient.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		btnClient.setBounds(519, 267, 132, 50);
		frame.getContentPane().add(btnClient);

		JButton btnOwner = new JButton("Owner");
		btnOwner.setAction(action);
		btnOwner.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		btnOwner.setBounds(519, 167, 132, 50);
		frame.getContentPane().add(btnOwner);

		JLabel ownerIcon = new JLabel("");
		ownerIcon.setBounds(437, 167, 72, 50);
		frame.getContentPane().add(ownerIcon);
		ImageIcon owner = new ImageIcon(".//res//owner.png");
		ownerIcon.setIcon(owner);

		JLabel clientIcon = new JLabel("");
		clientIcon.setBounds(437, 267, 72, 50);
		frame.getContentPane().add(clientIcon);
		ImageIcon client = new ImageIcon(".//res//client.png");
		clientIcon.setIcon(client);

		JLabel centerLbl = new JLabel("Choose an Option:");
		centerLbl.setBorder(new LineBorder(new Color(0, 0, 0)));
		centerLbl.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
		centerLbl.setHorizontalAlignment(SwingConstants.CENTER);
		centerLbl.setBounds(403, 33, 241, 80);
		frame.getContentPane().add(centerLbl);

		JButton RealTimeReport = new JButton("Real Time Report");
		RealTimeReport.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		RealTimeReport.setBounds(519, 368, 132, 50);
		frame.getContentPane().add(RealTimeReport);

		JLabel reportIcon = new JLabel("");
		reportIcon.setBounds(437, 368, 72, 50);
		frame.getContentPane().add(reportIcon);
		ImageIcon report = new ImageIcon(".//res//report.png");
		reportIcon.setIcon(report);
		panel.setBounds(0, 0, 355, 521);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel cloudIcon = new JLabel("");
		cloudIcon.setBounds(-66, 11, 432, 261);
		panel.add(cloudIcon);
		ImageIcon cloud = new ImageIcon(".//res//cloud.png");
		cloudIcon.setIcon(cloud);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(348, 478, -320, -183);
		panel.add(lblNewLabel);
		
		JLabel cloudCar = new JLabel("");
		cloudCar.setBounds(21, 222, 368, 288);
		panel.add(cloudCar);
		ImageIcon cloudCarIcon = new ImageIcon(".//res//cloudCar.png");
		cloudCar.setIcon(cloudCarIcon);
		
		
		// CLOCK
				Clock = new JLabel("clock");
				Clock.setBounds(71, 478, 203, 32);
				panel.add(Clock);
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
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Client");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			ClientGui openClientGui = new ClientGui();
			openClientGui.ClientGui.setVisible(true);
			frame.dispose();
			
			//test
			
			
		}
	}
}
