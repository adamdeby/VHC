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

public class RealTimeReportGui extends cloudController {

	//THIS IS OUR CONTROLLER GUI FRAME! not real time report will change name later 
	
	JFrame RTRframe;

	private final Action action = new SwingAction();
	private JTextField txtfieldID;
	
	private JTextField textFieldTime;
	private JLabel UserLabel;
	private JLabel JobDurationLabel;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RealTimeReportGui window = new RealTimeReportGui();
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
	public RealTimeReportGui() {
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
		textFieldTime.setBounds(75, 213, 351, 46);
		RTRframe.getContentPane().add(textFieldTime);
		
		
		
		JButton btnNewButton = new JButton("Calculate Time"); //we need to show calculated time
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
				queueTest();// get number duration
				JOptionPane.showMessageDialog(null, "completed time will be: "+ cloudController.sum(queue) );
				
				
				
				cloudController.computeTime(stringID,jobTime);
				
				JOptionPane.showMessageDialog(null, "completed time will be: "+ cloudController.results() );
				
				
				 Set<String> keySet = idTime.keySet();
				  
			        // Creating an ArrayList of keys
			        // by passing the keySet
			        ArrayList<String> listOfKeys = new ArrayList<String>(keySet);
			  
			        // Getting Collection of values from HashMap
			        Collection<Integer> values = idTime.values();
			  
			        // Creating an ArrayList of values
			        ArrayList<Number> listOfValues = new ArrayList<>(values);
				
			        String listString = String.join(", ", listOfKeys);
			        String listTime = listOfValues.toString();
				
				txtfieldID.setText(listString);
				
				textFieldTime.setText(listTime);
				
				
				
				
				
				
				
				
				
			}
		});
		btnNewButton.setBounds(593, 501, 162, 46);
		RTRframe.getContentPane().add(btnNewButton);
		
		UserLabel = new JLabel("Client ID:");
		UserLabel.setFont(new Font("Yu Gothic", Font.BOLD, 17));
		UserLabel.setBounds(75, 90, 152, 30);
		RTRframe.getContentPane().add(UserLabel);
		
		JobDurationLabel = new JLabel("Job Duration:");
		JobDurationLabel.setFont(new Font("Yu Gothic", Font.BOLD, 17));
		JobDurationLabel.setBounds(75, 177, 152, 30);
		RTRframe.getContentPane().add(JobDurationLabel);
		
		
		
		
	
		
		
	
		
	
		
	
		
		
		

	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Back");
			putValue(SHORT_DESCRIPTION, "back button report");
		}

		public void actionPerformed(ActionEvent e) {

		}
	}

	public void showResults() {

		
		
	}
}
