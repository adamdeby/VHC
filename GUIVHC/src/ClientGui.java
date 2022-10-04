import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class ClientGui {

	 JFrame ClientGui;
	 private final Action action = new SwingAction();

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
		BackToMain.setBounds(109, 383, 89, 23);
		ClientGui.getContentPane().add(BackToMain);
		ClientGui.setBounds(100, 100, 720, 560);
		ClientGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
