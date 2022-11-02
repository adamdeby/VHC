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
import java.awt.event.ActionListener;

public class MainMenu extends CloudControllerGui{

	JFrame Mainframe;
	private final Action action = new SwingAction();
	private JLabel Clock;
	private final JPanel panel = new JPanel();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.Mainframe.setVisible(true);
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
		Mainframe = new JFrame();
		Mainframe.getContentPane().setBackground(new Color(0, 191, 255));
		Mainframe.setBounds(100, 100, 940, 704);
		Mainframe.setResizable(false);
		Mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Mainframe.getContentPane().setLayout(null);

		JButton btnClient = new JButton("Client");
		btnClient.setAction(action_1);
		btnClient.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		btnClient.setBounds(723, 293, 132, 50);
		Mainframe.getContentPane().add(btnClient);

		JButton btnOwner = new JButton("Owner");
		btnOwner.setAction(action);
		btnOwner.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		btnOwner.setBounds(723, 167, 132, 50);
		Mainframe.getContentPane().add(btnOwner);

		JLabel ownerIcon = new JLabel("");
		ownerIcon.setBounds(614, 167, 72, 50);
		Mainframe.getContentPane().add(ownerIcon);
		ImageIcon owner = new ImageIcon(".//res//owner.png");
		ownerIcon.setIcon(owner);

		JLabel clientIcon = new JLabel("");
		clientIcon.setBounds(614, 293, 72, 50);
		Mainframe.getContentPane().add(clientIcon);
		ImageIcon client = new ImageIcon(".//res//client.png");
		clientIcon.setIcon(client);

		JLabel centerLbl = new JLabel("Choose an Option:");
		centerLbl.setBorder(new LineBorder(new Color(0, 0, 0)));
		centerLbl.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
		centerLbl.setHorizontalAlignment(SwingConstants.CENTER);
		centerLbl.setBounds(589, 32, 241, 80);
		Mainframe.getContentPane().add(centerLbl);

		JButton btnRealTimeReport = new JButton("Real Time Report"); //controller
		btnRealTimeReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloudControllerGui sss = new CloudControllerGui();
				sss.RTRframe.setVisible(true);
				Mainframe.dispose();
				
				
				
				
				sumArray =cloudController.computeResult(jobTime);
				
				
				
				CloudControllerGui.txtfieldID.setText(stringID.toString());
				
				CloudControllerGui.textField.setText(jobTime.toString());
				
				CloudControllerGui.textFieldTime.setText(sumArray.toString());
				
				
				
				
			}
		});
		btnRealTimeReport.setAction(action_2);
		btnRealTimeReport.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		btnRealTimeReport.setBounds(723, 409, 132, 50);
		Mainframe.getContentPane().add(btnRealTimeReport);

		JLabel reportIcon = new JLabel("");
		reportIcon.setBounds(614, 409, 72, 50);
		Mainframe.getContentPane().add(reportIcon);
		ImageIcon report = new ImageIcon(".//res//report.png");
		reportIcon.setIcon(report);
		panel.setBounds(0, 0, 466, 681);
		Mainframe.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel cloudIcon = new JLabel("");
		cloudIcon.setBounds(10, 23, 408, 261);
		panel.add(cloudIcon);
		ImageIcon cloud = new ImageIcon(".//res//cloud.png");
		cloudIcon.setIcon(cloud);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(348, 478, -320, -183);
		panel.add(lblNewLabel);

		JLabel cloudCar = new JLabel("");
		cloudCar.setBounds(90, 266, 350, 288);
		panel.add(cloudCar);
		ImageIcon cloudCarIcon = new ImageIcon(".//res//cloudCar.png");
		cloudCar.setIcon(cloudCarIcon);

		// CLOCK
		Clock = new JLabel("clock");
		Clock.setHorizontalAlignment(SwingConstants.CENTER);
		Clock.setBounds(72, 608, 350, 32);
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
			Mainframe.dispose();
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
			Mainframe.dispose();		
			

		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Controller");
			putValue(SHORT_DESCRIPTION, "Real time support");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
