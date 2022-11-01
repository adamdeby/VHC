import java.awt.Color;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class RealTimeReportGui extends cloudController {

	//THIS IS OUR CONTROLLER GUI FRAME! not real time report will change name later 
	
	JFrame RTRframe;

	private final Action action = new SwingAction();
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
		
		JButton btnNewButton = new JButton("Calculate Time"); //we need to show calculated time
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cloudController.computeTime(jobTime);
				JOptionPane.showMessageDialog(null, "completed time will be: "+ idTime.keySet()+cloudController.results() );
				
			}
		});
		btnNewButton.setBounds(593, 501, 162, 46);
		RTRframe.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("We need to somehow dispaly the current jobs and then return the time after the user clicks the button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(51, 75, 756, 254);
		RTRframe.getContentPane().add(btnNewButton_1);

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
