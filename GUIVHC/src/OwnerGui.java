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
import java.io.FileWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.TimeZone;

public class OwnerGui {

	 JFrame OwnerGui;
	 private JTextField OwnerIdTextField;
	 private JTextField VeichleMakeTextField;
	 private JTextField VeichleModelTextField;
	 private JTextField VeichleYearTextField;
	 private JTextField resTimeLabel;
	 private final Action action = new SwingAction();
	 private final Action action_1 = new SwingAction_1();

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
		
		JLabel VeichleYearLabel = new JLabel("Veichle Year: ");
		VeichleYearLabel.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		VeichleYearLabel.setBounds(251, 291, 243, 29);
		OwnerGui.getContentPane().add(VeichleYearLabel);
		
		JLabel VeichleModelLabel = new JLabel("Veichle Model:");
		VeichleModelLabel.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		VeichleModelLabel.setBounds(251, 251, 243, 29);
		OwnerGui.getContentPane().add(VeichleModelLabel);
		
		JLabel ResidencyTimeTextField = new JLabel("Residency Time:");
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

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
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
			String timeStamp = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss ").format(new java.util.Date());
			
			
			String input ="Time: "+timeStamp+ "Owner: ID:"+ OwnerIdTextField.getText()+" Make:"+VeichleMakeTextField.getText()+ " Model:"+ VeichleModelTextField.getText()+" Year:"+ VeichleYearTextField.getText() +" Residency Time:" + resTimeLabel.getText();                   
			try {
				FileWriter Writer = new FileWriter("data.txt",true);
				Writer.write(input+"\n");
				Writer.close();
				JOptionPane.showMessageDialog(null, "Success, written to file");
				
				
			}
			catch(Exception a){
				JOptionPane.showMessageDialog(null, "Error :(");
			}
		}
	}
}
