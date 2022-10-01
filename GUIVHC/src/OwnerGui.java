import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;

public class OwnerGui {

	 JFrame OwnerGui;

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
	}

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
		OwnerGui.getContentPane().setBackground(new Color(0, 191, 255));
		OwnerGui.setBounds(100, 100, 720, 560);
		OwnerGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
