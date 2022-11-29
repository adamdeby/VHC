import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.DriverManager;
import java.sql.Statement;
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
	public static int dummy;
	public static String dummy2;

	public static ArrayList<Integer> AcceptedjobTime = new ArrayList<Integer>(); // updated arraylist to hold all time
	// values
	public static ArrayList<String> AcceptedClientID = new ArrayList<String>();

	private final Action action = new SwingAction();
	public static JTextField txtfieldID;

	public static JTextField textFieldTime;
	public JLabel UserLabel;
	public JLabel JobDurationLabel;
	public JTable table;
	public static JTextField textField;
	ArrayList<Integer> sumArray = new ArrayList<Integer>();
	

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

		// CLient
		JButton acceptClient = new JButton("Accept Client");
		acceptClient.setFont(new Font("Tahoma", Font.PLAIN, 11));

		acceptClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand() == acceptClient.getActionCommand() && tempFName!="") {

					try {

						PrintStream output = new PrintStream(new FileOutputStream("ClientData.txt", true));
						output.println("**************************************");
						output.println("CLIENT DATA: ");

						output.println(Clientinput);
						
						
						
						
						
						
						
						try {
							dummy = Integer.parseInt(tempJobDur);
							AcceptedjobTime.add(dummy);
						} catch (NumberFormatException ex) {
							ex.printStackTrace();
						}

						dummy2 = tempID;

						AcceptedClientID.add(dummy2);
						
						sumArray =cloudController.computeResult(AcceptedjobTime);
						CloudControllerGui.txtfieldID.setText(AcceptedClientID.toString());
						CloudControllerGui.textField.setText(AcceptedjobTime.toString());
						CloudControllerGui.textFieldTime.setText(sumArray.toString());
						//last value of the accepted completion times arrayList
						int last = sumArray.get(sumArray.size()-1);
						
						connection = DriverManager.getConnection(url, username, password);
						String sql = "INSERT INTO client_data" + "(ClientID , firstName, lastName, Duration, Deadline, compTime)" + "VALUES ('"+tempID+"','"+tempFName+"','"+tempLName+"','"+tempJobDur+"','"+tempJobDead+"','"+last+"')";  
						//String sql2 = "INSERT INTO owner_data" + "(OwnerID, vehicleMake, vehicleModel, vehicleYear, ResidencyTime)" + "VALUES ('"+tempID+"','"+tempFName+"','"+tempLName+"','"+tempJobDur+"','"+tempJobDead+"','"+last+"')";
						Statement statement = connection.createStatement();
						
						
						
						
						int row = statement.executeUpdate(sql);
						//the return value is the indication of success or failure of the query execution
						if (row > 0)
							JOptionPane.showMessageDialog(null, "sql success");
						connection.close();

						tempFName =  "";
						tempLName = "";
						tempID = "";
						tempJobDur = "";
						tempJobDead = "";

					
						Clientinput = "";

						outputStream.writeUTF("DATA ACCEPTED");
						JOptionPane.showMessageDialog(null, "Users data has been accepted!");
						
						
						
						

						output.close();
					} catch (Exception a) {
						JOptionPane.showMessageDialog(null, "There is an error!\nPerhaps the ID is already taken. Try again");
						a.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "No Information to Accept!");
				}

			}
		});
		
		
		
		acceptClient.setBounds(637, 124, 201, 39);
		RTRframe.getContentPane().add(acceptClient);

		// Owner
		JButton acceptOwner = new JButton("Accept Owner");
		acceptOwner.setFont(new Font("Tahoma", Font.PLAIN, 11));
		acceptOwner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand() == acceptOwner.getActionCommand() && OwnerGui.tempOwnerID!="") {

					try {

						PrintStream output = new PrintStream(new FileOutputStream("OwnerData.txt", true));
						output.println("**************************************");
						output.println("OWNER DATA: ");

						output.println(OwnerGui.Ownerinput);



					
						OwnerGui.Ownerinput = "";

						
						
						connection = DriverManager.getConnection(url, username, password);
						String sql2 = "INSERT INTO owner_data" + "(OwnerID, vehicleMake, vehicleModel, vehicleYear, residencyTime)" + "VALUES ('"+OwnerGui.tempOwnerID+"','"+OwnerGui.tempMake+"','"+OwnerGui.tempModel+"','"+OwnerGui.tempYear+"','"+OwnerGui.tempResTime+"')";
						Statement statement = connection.createStatement();
						
						
						int row = statement.executeUpdate(sql2);
						//the return value is the indication of success or failure of the query execution
						if (row > 0)
							JOptionPane.showMessageDialog(null, "sql success");
						connection.close();
						
						OwnerGui.tempOwnerID = "";
						OwnerGui.tempMake = "";
						OwnerGui.tempModel = "";
						OwnerGui.tempYear = "";
						OwnerGui.tempResTime = "";
						
						outputStream.writeUTF("DATA ACCEPTED");
						JOptionPane.showMessageDialog(null, "Users data has been accepted!");

						output.close();
					} catch (Exception a) {
						JOptionPane.showMessageDialog(null, "There is an error!\nPerhaps the ID is already taken. Try again");
						a.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "No Information to Accept!");
				}
			}
		});
		acceptOwner.setBounds(637, 206, 201, 39);
		RTRframe.getContentPane().add(acceptOwner);

		
		
		// reject
		JButton reject = new JButton("Reject");
		reject.setFont(new Font("Tahoma", Font.PLAIN, 11));
		reject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand() == reject.getActionCommand()) {
					try {
						tempFName =  "";
						tempLName = "";
						tempID = "";
						tempJobDur = "";
						tempJobDead = "";
						
						OwnerGui.tempOwnerID = "";
						OwnerGui.tempMake = "";
						OwnerGui.tempModel = "";
						OwnerGui.tempYear = "";
						OwnerGui.tempResTime = "";
						
						

						outputStream.writeUTF("DATA REJECTED");
						JOptionPane.showMessageDialog(null, "Users data has been rejected!");

					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
					}
					{

					}
				}
				
			
				
				
				
				
				
		
			}
		});
		reject.setBounds(637, 297, 201, 39);
		RTRframe.getContentPane().add(reject);

	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Back");
			putValue(SHORT_DESCRIPTION, "back button report");
		}

		public void actionPerformed(ActionEvent e) {

		}
	}

	
}
