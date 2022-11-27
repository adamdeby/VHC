import java.awt.Color;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class CloudControllerGui extends cloudController {
	//
	JFrame RTRframe;

	private final Action action = new SwingAction();
	public static JTextField txtfieldID;
	
	public static JTextField textFieldTime;
	public JLabel UserLabel;
	public JLabel JobDurationLabel;
	public JTable table;
	public static JTextField textField;
	ArrayList<Integer> sumArray = new ArrayList<Integer>() ;
	private JButton Refresh;
	private final Action action_1 = new SwingAction_1();
	/**
	 * Launch the application.//
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CloudControllerGui window = new CloudControllerGui();
					window.RTRframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CloudControllerGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		RTRframe = new JFrame();
		RTRframe.setBounds(100, 100, 940, 704);
		RTRframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		RTRframe.getContentPane().setBackground(new Color(0, 191, 255));
		RTRframe.getContentPane().setLayout(null);

		JButton btnBackReport = new JButton("Back");
		btnBackReport.setAction(action);
		btnBackReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu mf = new MainMenu();
				mf.Mainframe.setVisible(true);
				RTRframe.setVisible(false);
			}
		});

		btnBackReport.setBounds(75, 583, 152, 46);
		RTRframe.getContentPane().add(btnBackReport);
		
		
		
		txtfieldID = new JTextField();
		txtfieldID.setEditable(false);
		
		txtfieldID.setBounds(75, 120, 351, 46);
		RTRframe.getContentPane().add(txtfieldID);
		txtfieldID.setColumns(10);
		
		
		textFieldTime = new JTextField();
		textFieldTime.setEditable(false);
		
		textFieldTime.setColumns(10);
		textFieldTime.setBounds(75, 346, 351, 46);
		RTRframe.getContentPane().add(textFieldTime);
		
		textField = new JTextField();
		textField.setEditable(false);
		
		textField.setColumns(10);
		textField.setBounds(75, 220, 351, 46);
		RTRframe.getContentPane().add(textField);
		
		
		UserLabel = new JLabel("Client IDs:");
		UserLabel.setFont(new Font("Yu Gothic", Font.BOLD, 17));
		UserLabel.setBounds(75, 90, 152, 30);
		RTRframe.getContentPane().add(UserLabel);
		
		JobDurationLabel = new JLabel("Job Duration (Completed Time in hours):");
		JobDurationLabel.setFont(new Font("Yu Gothic", Font.BOLD, 17));
		JobDurationLabel.setBounds(75, 304, 351, 30);
		RTRframe.getContentPane().add(JobDurationLabel);
		
		JLabel originalTextBox = new JLabel("Original Time:");
		originalTextBox.setFont(new Font("Dialog", Font.BOLD, 17));
		originalTextBox.setBounds(75, 190, 152, 30);
		RTRframe.getContentPane().add(originalTextBox);
		
		JButton acceptClient = new JButton("Accept Client");
		acceptClient.setFont(new Font("Tahoma", Font.PLAIN, 11));
		acceptClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		acceptClient.setBounds(574, 504, 112, 39);
		RTRframe.getContentPane().add(acceptClient);
		
		JButton acceptOwner = new JButton("Accept Owner");
		acceptOwner.setFont(new Font("Tahoma", Font.PLAIN, 11));
		acceptOwner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		acceptOwner.setBounds(687, 504, 101, 39);
		RTRframe.getContentPane().add(acceptOwner);
		
		JButton reject = new JButton("Reject");
		reject.setBounds(786, 504, 101, 39);
		RTRframe.getContentPane().add(reject);
		
		Refresh = new JButton("Refresh");
		Refresh.setFont(new Font("Tahoma", Font.BOLD, 15));
		Refresh.setAction(action_1);
		Refresh.addActionListener(new ActionListener() {
			//refresh button will refresh the GUI 
			public void actionPerformed(ActionEvent e) {
				
				
				
				RTRframe.invalidate();
				RTRframe.validate();
				RTRframe.repaint();
				
				
				
				
			}
		});
		Refresh.setBounds(763, 11, 151, 58);
		RTRframe.getContentPane().add(Refresh);
		

	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Back");
			putValue(SHORT_DESCRIPTION, "back button report");
		}

		public void actionPerformed(ActionEvent e) {

		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Refresh");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
