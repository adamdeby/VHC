import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.TimeZone;

public class OwnerGui {
	public static String Ownerinput = "";
	public static JFrame OwnerGui;
	public static JTextField OwnerIdTextField;
	public static JTextField VeichleMakeTextField;
	public static JTextField VeichleModelTextField;
	public static JTextField VeichleYearTextField;
	public static JTextField resTimeLabel;
	public final Action action = new SwingAction();
	public final Action action_1 = new SwingAction_1();

	public static String tempOwnerID = "";
	public static String tempMake;
	public static String tempModel;
	public static String tempYear;
	public static String tempResTime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OwnerGui window = new OwnerGui();
					window.OwnerGui.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}//

	/**
	 * Create the application.
	 */
	public OwnerGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		OwnerGui = new JFrame();
		OwnerGui.setTitle("Owner Registration Page:");
		OwnerGui.setBounds(100, 100, 940, 704);
		OwnerGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		OwnerGui.getContentPane().setBackground(new Color(0, 191, 255));
		OwnerGui.getContentPane().setLayout(null);

		JLabel centerLbl = new JLabel("Owner Registration:");
		centerLbl.setBounds(0, 0, 944, 60);
		centerLbl.setHorizontalAlignment(SwingConstants.CENTER);
		centerLbl.setFont(new Font("Yu Gothic UI", Font.BOLD, 29));
		centerLbl.setBorder(new LineBorder(new Color(0, 0, 0)));
		OwnerGui.getContentPane().add(centerLbl);

		JLabel OwnerIdLabel = new JLabel("Owner ID: ");
		OwnerIdLabel.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		OwnerIdLabel.setBounds(251, 171, 243, 29);
		OwnerGui.getContentPane().add(OwnerIdLabel);

		JLabel VeichleMakeLabel = new JLabel("Vehicle Make: ");
		VeichleMakeLabel.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		VeichleMakeLabel.setBounds(251, 211, 243, 29);
		OwnerGui.getContentPane().add(VeichleMakeLabel);

		JLabel VeichleYearLabel = new JLabel("Vehicle Year: ");
		VeichleYearLabel.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		VeichleYearLabel.setBounds(251, 291, 243, 29);
		OwnerGui.getContentPane().add(VeichleYearLabel);

		JLabel VeichleModelLabel = new JLabel("Vehicle Model:");
		VeichleModelLabel.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		VeichleModelLabel.setBounds(251, 251, 243, 29);
		OwnerGui.getContentPane().add(VeichleModelLabel);

		JLabel ResidencyTimeTextField = new JLabel("Residency Time (Hours):");
		ResidencyTimeTextField.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		ResidencyTimeTextField.setBounds(251, 331, 243, 34);
		OwnerGui.getContentPane().add(ResidencyTimeTextField);

		OwnerIdTextField = new JTextField();
		OwnerIdTextField.setBounds(499, 173, 170, 20);
		OwnerGui.getContentPane().add(OwnerIdTextField);
		OwnerIdTextField.setColumns(10);

		VeichleMakeTextField = new JTextField();
		VeichleMakeTextField.setColumns(10);
		VeichleMakeTextField.setBounds(499, 213, 170, 20);
		OwnerGui.getContentPane().add(VeichleMakeTextField);

		VeichleModelTextField = new JTextField();
		VeichleModelTextField.setColumns(10);
		VeichleModelTextField.setBounds(499, 253, 170, 20);
		OwnerGui.getContentPane().add(VeichleModelTextField);

		VeichleYearTextField = new JTextField();
		VeichleYearTextField.setColumns(10);
		VeichleYearTextField.setBounds(499, 293, 170, 20);
		OwnerGui.getContentPane().add(VeichleYearTextField);

		resTimeLabel = new JTextField();
		resTimeLabel.setColumns(10);
		resTimeLabel.setBounds(499, 336, 170, 20);
		OwnerGui.getContentPane().add(resTimeLabel);

		JButton SubmitButton = new JButton("Submit");
		SubmitButton.setAction(action_1);
		SubmitButton.setBounds(474, 406, 170, 60);
		OwnerGui.getContentPane().add(SubmitButton);

		JButton BackToMainButton = new JButton("Back");
		BackToMainButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu mf = new MainMenu();
				mf.Mainframe.setVisible(true);
				OwnerGui.setVisible(false);

			}
		});
		BackToMainButton.setAction(action);
		BackToMainButton.setBounds(270, 406, 159, 60);
		OwnerGui.getContentPane().add(BackToMainButton);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Back");
			putValue(SHORT_DESCRIPTION, "Back button");
		}

		public void actionPerformed(ActionEvent e) {
		}
	}

	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Submit");
			putValue(SHORT_DESCRIPTION, "Submit Button");
		}

		public void actionPerformed(ActionEvent e) {

			if (OwnerIdTextField.getText().trim().isEmpty() || VeichleMakeTextField.getText().trim().isEmpty()
					|| VeichleModelTextField.getText().trim().isEmpty()
					|| VeichleYearTextField.getText().trim().isEmpty() || resTimeLabel.getText().trim().isEmpty()) {

				JOptionPane.showMessageDialog(null, "Error. Please enter all the info");
			}

			else {
				try {
					// PrintStream output = new PrintStream(new
					// FileOutputStream("OwnerInfoTest.txt", true));

					tempOwnerID = OwnerIdTextField.getText();
					tempMake = VeichleMakeTextField.getText();
					tempModel = VeichleModelTextField.getText();
					tempYear = VeichleYearTextField.getText();
					tempResTime = resTimeLabel.getText();

					String timeStamp = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss ").format(new java.util.Date());
					Ownerinput = "Time: " + timeStamp + "Owner: ID:" + OwnerIdTextField.getText() + " Make:"
							+ VeichleMakeTextField.getText() + " Model:" + VeichleModelTextField.getText() + " Year:"
							+ VeichleYearTextField.getText() + " Residency Time:" + resTimeLabel.getText();

					OwnerIdTextField.setText("");
					VeichleMakeTextField.setText("");
					VeichleModelTextField.setText("");
					VeichleYearTextField.setText("");
					resTimeLabel.setText("");

					JOptionPane.showMessageDialog(null, "Information sent to server. Waiting for approval.");

				} catch (Exception a) {
					JOptionPane.showMessageDialog(null, "Error :(");
				}
			}
		}
	}
}