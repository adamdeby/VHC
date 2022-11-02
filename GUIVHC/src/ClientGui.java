import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ClientGui {

	JFrame ClientGui;
	private final Action action = new SwingAction();
	public  JTextField clientIDBox;
	public JTextField jobDurBox;
	private JTextField dealineBox;
	private final Action action_1 = new SwingAction_1(); // submit button needs to be copied
	public static ArrayList<Integer> jobTime = new ArrayList<Integer>(); // arraylist to hold all time values
	private JTextField textFieldLName;
	private JTextField textFieldFName;
	int x;
	int xx;
	String y;
	String yy;
	public static ArrayList<String> stringID = new ArrayList<String>();
	public static Map<String, Integer> idTime = new HashMap<>();
	public static PriorityQueue<Integer> queue=new PriorityQueue<Integer>();
	public static PriorityQueue<Integer> duplicate=new PriorityQueue<Integer>();
	
	public static PriorityQueue<String> queueID=new PriorityQueue<String>(Collections.reverseOrder());
	
	 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientGui window = new ClientGui();
					window.ClientGui.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClientGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ClientGui = new JFrame();
		ClientGui.getContentPane().setBackground(new Color(0, 191, 255));
		ClientGui.setResizable(false);
		ClientGui.getContentPane().setLayout(null);

		JButton BackToMain = new JButton("Back");
		BackToMain.setAction(action);
		BackToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu mf = new MainMenu();
				mf.Mainframe.setVisible(true);
				ClientGui.setVisible(false);
			}
		});
		//
		BackToMain.setBounds(252, 375, 150, 53);
		ClientGui.getContentPane().add(BackToMain);

		JLabel clientIDtxt = new JLabel("Client ID:");
		clientIDtxt.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		clientIDtxt.setBounds(268, 161, 225, 40);
		ClientGui.getContentPane().add(clientIDtxt);

		JLabel jobDurTxt = new JLabel("Job Duration:");
		jobDurTxt.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		jobDurTxt.setBounds(268, 212, 225, 40);
		ClientGui.getContentPane().add(jobDurTxt);

		JLabel jobDeadlineTxt = new JLabel("Job Deadline:");
		jobDeadlineTxt.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		jobDeadlineTxt.setBounds(268, 263, 225, 40);
		ClientGui.getContentPane().add(jobDeadlineTxt);

		clientIDBox = new JTextField();
		clientIDBox.setBounds(503, 169, 150, 20);
		ClientGui.getContentPane().add(clientIDBox);
		clientIDBox.setColumns(10);

		jobDurBox = new JTextField();
		jobDurBox.setColumns(10);
		jobDurBox.setBounds(503, 220, 150, 20);
		ClientGui.getContentPane().add(jobDurBox);

		dealineBox = new JTextField();
		dealineBox.setColumns(10);
		dealineBox.setBounds(503, 276, 150, 23);
		ClientGui.getContentPane().add(dealineBox);

		JButton submitClientButton = new JButton("Submit");
		submitClientButton.setAction(action_1);
		submitClientButton.setBounds(488, 375, 165, 53);
		ClientGui.getContentPane().add(submitClientButton);

		JLabel clientTitle = new JLabel("Client Registration:");
		clientTitle.setBorder(new LineBorder(new Color(0, 0, 0)));
		clientTitle.setHorizontalAlignment(SwingConstants.CENTER);
		clientTitle.setFont(new Font("Yu Gothic UI", Font.BOLD, 29));
		clientTitle.setBounds(0, 0, 941, 53);
		ClientGui.getContentPane().add(clientTitle);

		textFieldLName = new JTextField();
		textFieldLName.setColumns(10);
		textFieldLName.setBounds(503, 129, 150, 20);
		ClientGui.getContentPane().add(textFieldLName);

		textFieldFName = new JTextField();
		textFieldFName.setColumns(10);
		textFieldFName.setBounds(503, 88, 150, 20);
		ClientGui.getContentPane().add(textFieldFName);
		String FName = textFieldFName.getText();

		JLabel lastNameLabel = new JLabel("Last Name:");
		lastNameLabel.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		lastNameLabel.setBounds(268, 121, 225, 40);
		ClientGui.getContentPane().add(lastNameLabel);

		JLabel firstNameLabel = new JLabel("First Name:");
		firstNameLabel.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		firstNameLabel.setBounds(268, 77, 225, 40);
		ClientGui.getContentPane().add(firstNameLabel);
		ClientGui.setBounds(100, 100, 940, 704);
		ClientGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Back");
			putValue(SHORT_DESCRIPTION, "back button");
		}

		public void actionPerformed(ActionEvent e) {
		}
	}

	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Submit");
			putValue(SHORT_DESCRIPTION, "submit button");
		}

		public void actionPerformed(ActionEvent e) {

			if (clientIDBox.getText().trim().isEmpty() || jobDurBox.getText().trim().isEmpty()
					|| dealineBox.getText().trim().isEmpty() || textFieldLName.getText().trim().isEmpty()
					|| textFieldFName.getText().trim().isEmpty()) {

				JOptionPane.showMessageDialog(null, "Error. Please enter all the info");
			} else {
				try {
					
					FileWriter Writer = new FileWriter("ClientInfo.txt", true);
					String timeStamp = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss ").format(new java.util.Date());
					String input = "Time: " + timeStamp + "Client ID:" + clientIDBox.getText() + " Job Duration:"
							+ jobDurBox.getText() + " Deadline:" + dealineBox.getText() + " All Duration Times:" +arrayMethod() + " All Client IDs:" + arrayMethodID();

					Writer.write(input + "\n");
					Writer.close();
					JOptionPane.showMessageDialog(null, "Success, written to file");
					clientIDBox.setText("");
					jobDurBox.setText("");
					dealineBox.setText("");
					textFieldFName.setText("");
					textFieldLName.setText("");

				} catch (Exception a) {
					JOptionPane.showMessageDialog(null, "Error :(");
				}
			}
		}
	}
	public ArrayList<Integer> arrayMethod() {
		
		try {
			x = Integer.parseInt(jobDurBox.getText());
			
		} catch (NumberFormatException v) {
			x = 0; // error handling
		}
		jobTime.add(x);
		
		return jobTime;
	}
	public ArrayList<String> arrayMethodID() {
		
		try {
			y= clientIDBox.getText();
		} catch (NumberFormatException w) {
			y = ""; // error handling
		}
		stringID.add(y);
		
		return stringID;
	}	
		
	
}