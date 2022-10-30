import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class RealTimeReportGui {

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
		
		JButton button = new JButton("New button");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		button.setAction(action);
		button.setBounds(93, 319, 89, 23);
		RTRframe.getContentPane().add(button);

	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
