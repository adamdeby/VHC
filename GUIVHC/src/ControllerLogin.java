import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class ControllerLogin extends CloudControllerGui {

	JFrame loginFrame;

	private JTextField Username;
	private JPasswordField passwordField;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControllerLogin window = new ControllerLogin();
					window.loginFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ControllerLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		loginFrame = new JFrame();
		loginFrame.setTitle("Controller Login Page:");
		loginFrame.setBounds(100, 100, 940, 704);
		loginFrame.getContentPane().setBackground(new Color(0, 191, 255));
		loginFrame.getContentPane().setLayout(null);

		JLabel lblControllerLogin = new JLabel("Controller Login");
		lblControllerLogin.setFont(new Font("Trebuchet MS", Font.BOLD, 60));
		lblControllerLogin.setBounds(212, 59, 462, 67);
		loginFrame.getContentPane().add(lblControllerLogin);

		JLabel lblNewLabel = new JLabel("Password:");
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 22));
		lblNewLabel.setBounds(285, 256, 118, 39);
		loginFrame.getContentPane().add(lblNewLabel);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Yu Gothic", Font.BOLD, 22));
		lblUsername.setBounds(285, 206, 118, 39);
		loginFrame.getContentPane().add(lblUsername);

		Username = new JTextField();
		Username.setBounds(412, 206, 177, 27);
		loginFrame.getContentPane().add(Username);
		Username.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(413, 260, 176, 27);
		loginFrame.getContentPane().add(passwordField);

		JButton LoginButton = new JButton("New button");
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String unsername = "Admin";
				String password = "Admin";

				String userEntered = Username.getText();
				String passEntered = passwordField.getText();

				if (userEntered.equals(unsername) && passEntered.equals(password)) {
					CloudControllerGui sss = new CloudControllerGui();
					sss.RTRframe.setVisible(true);
					loginFrame.dispose();

					sumArray = cloudController.computeResult(AcceptedjobTime);
					CloudControllerGui.txtfieldID.setText(AcceptedClientID.toString());
					CloudControllerGui.textField.setText(AcceptedjobTime.toString());
					CloudControllerGui.textFieldTime.setText(sumArray.toString());
					;

				} else {
					JOptionPane.showMessageDialog(null, "Invalid credentials!");
					Username.setText("");
					passwordField.setText("");
				}
			}
		});
		LoginButton.setAction(action);
		LoginButton.setBounds(432, 315, 129, 39);
		loginFrame.getContentPane().add(LoginButton);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu mf = new MainMenu();
				mf.Mainframe.setVisible(true);
				loginFrame.setVisible(false);
			}
		});
		btnNewButton.setBounds(212, 575, 129, 39);
		loginFrame.getContentPane().add(btnNewButton);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Login");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
		}
	}
}
