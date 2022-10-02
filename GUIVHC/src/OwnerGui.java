import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class OwnerGui {

	 JFrame OwnerGui;
	 private JTextField textField;
	 private JTextField textField_1;
	 private JTextField textField_2;
	 private JTextField textField_3;
	 private JTextField textField_4;

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
		OwnerGui.setBounds(100, 100, 720, 560);
		OwnerGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		OwnerGui.getContentPane().setBackground(new Color(0, 191, 255));
		OwnerGui.getContentPane().setLayout(null);

		JLabel centerLbl = new JLabel("Owner Registration:");
		centerLbl.setBounds(0, 0, 704, 60);
		centerLbl.setHorizontalAlignment(SwingConstants.CENTER);
		centerLbl.setFont(new Font("Yu Gothic UI", Font.BOLD, 29));
		centerLbl.setBorder(new LineBorder(new Color(0, 0, 0)));
		OwnerGui.getContentPane().add(centerLbl);
		
		JLabel lblNewLabel = new JLabel("Owner ID: ");
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		lblNewLabel.setBounds(199, 171, 94, 29);
		OwnerGui.getContentPane().add(lblNewLabel);
		
		JLabel lblVeichleMake = new JLabel("Veichle Make: ");
		lblVeichleMake.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		lblVeichleMake.setBounds(164, 211, 129, 29);
		OwnerGui.getContentPane().add(lblVeichleMake);
		
		JLabel lblNewLabel_2 = new JLabel("Owner Year: ");
		lblNewLabel_2.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		lblNewLabel_2.setBounds(179, 251, 114, 29);
		OwnerGui.getContentPane().add(lblNewLabel_2);
		
		JLabel lblVeichleMake_1 = new JLabel("Veichle Make: ");
		lblVeichleMake_1.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		lblVeichleMake_1.setBounds(164, 291, 129, 29);
		OwnerGui.getContentPane().add(lblVeichleMake_1);
		
		JLabel lblVeichleMake_1_1 = new JLabel("Residency Time:");
		lblVeichleMake_1_1.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		lblVeichleMake_1_1.setBounds(141, 331, 152, 34);
		OwnerGui.getContentPane().add(lblVeichleMake_1_1);
		
		textField = new JTextField();
		textField.setBounds(311, 173, 170, 20);
		OwnerGui.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(311, 213, 170, 20);
		OwnerGui.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(311, 253, 170, 20);
		OwnerGui.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(311, 293, 170, 20);
		OwnerGui.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(311, 336, 170, 20);
		OwnerGui.getContentPane().add(textField_4);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(314, 389, 152, 51);
		OwnerGui.getContentPane().add(btnNewButton);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
