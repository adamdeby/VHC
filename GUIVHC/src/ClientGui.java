import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class ClientGui {

	 JFrame ClientGui;

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
		ClientGui.setBounds(100, 100, 720, 560);
		ClientGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	


}
