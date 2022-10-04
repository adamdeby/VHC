import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.Writer; 
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

public class ClientGui {

	 JFrame ClientGui;
	 private final Action action = new SwingAction();
	 private JTextField clientIDBox;
	 private JTextField jobDurBox;
	 private JTextField textField_1;
	 private final Action action_1 = new SwingAction_1(); //submit button needs to be copied

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
		BackToMain.setBounds(109, 383, 89, 23);
		ClientGui.getContentPane().add(BackToMain);
		
		JLabel clientIDtxt = new JLabel("Client ID:");
		clientIDtxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		clientIDtxt.setBounds(106, 116, 118, 40);
		ClientGui.getContentPane().add(clientIDtxt);
		
		JLabel jobDurTxt = new JLabel("Job Duration:");
		jobDurTxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jobDurTxt.setBounds(106, 167, 118, 40);
		ClientGui.getContentPane().add(jobDurTxt);
		
		JLabel jobDeadlineTxt = new JLabel("Job Deadline:");
		jobDeadlineTxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jobDeadlineTxt.setBounds(106, 218, 118, 40);
		ClientGui.getContentPane().add(jobDeadlineTxt);
		
		clientIDBox = new JTextField();
		clientIDBox.setBounds(261, 128, 86, 20);
		ClientGui.getContentPane().add(clientIDBox);
		clientIDBox.setColumns(10);
		
		jobDurBox = new JTextField();
		jobDurBox.setColumns(10);
		jobDurBox.setBounds(261, 179, 86, 20);
		ClientGui.getContentPane().add(jobDurBox);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(261, 230, 86, 20);
		ClientGui.getContentPane().add(textField_1);
		
		JButton submitClientButton = new JButton("Submit");
		submitClientButton.setAction(action_1);
		submitClientButton.setBounds(261, 383, 89, 23);
		ClientGui.getContentPane().add(submitClientButton);
		ClientGui.setBounds(100, 100, 720, 560);
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
			String input = clientIDBox.getText()+" "+jobDurBox.getText()+ " "+ textField_1.getText();
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
