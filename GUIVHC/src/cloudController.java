import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.StringWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class cloudController extends ClientGui {

	public static ArrayList<Integer> AcceptedjobTime = new ArrayList<Integer>(); // updated arraylist to hold all time
																					// values
	public static ArrayList<String> AcceptedClientID = new ArrayList<String>();
	public static int dummy;
	public static String dummy2;

	public static ArrayList<Integer> computeResult(ArrayList<Integer> input) {
		int sum = 0;
		ArrayList<Integer> resultArray = new ArrayList<Integer>();
		for (int i = 0; i < input.size(); i++) {
			sum += input.get(i);
			resultArray.add(sum);

		}
		return resultArray;
	}

	static ServerSocket serverSocket;
	static Socket socket;
	static DataInputStream inputStream;
	static DataOutputStream outputStream;

	public static void main(String[] args) {

		String dataIn = "";
		try {

			System.out.println("----------$$$ This is server side $$$--------");
			System.out.println("wating for client to connect...");
			// creating the server
			serverSocket = new ServerSocket(3322);
			// sever accepts connection request from client
			socket = serverSocket.accept();
			System.out.println("client is connected!");
			System.out.println("go to client side and send me a message");

			inputStream = new DataInputStream(socket.getInputStream());
			outputStream = new DataOutputStream(socket.getOutputStream());

			class acceptRejectWindow extends JFrame {

				JLabel question;
				JButton acceptButton;
				JButton rejectButton;

				public acceptRejectWindow() {
					question = new JLabel("Accept or reject the users data?");
					question.setFont(new Font("Yu Gothic", Font.BOLD, 16));

					createAcceptButton();
					createRejectButton();
					createPanel();

					setSize(550, 80);
				}

				private void createAcceptButton() {
					acceptButton = new JButton("Accept");
					acceptButton.setBounds(10, 100, 350, 125);
					ActionListener acceptButtonListener = new acceptButtonListener();
					acceptButton.addActionListener(acceptButtonListener);
				}

				class acceptButtonListener implements ActionListener {

					public void actionPerformed(ActionEvent e) {
						if (e.getActionCommand() == acceptButton.getActionCommand()) {

							try {

								PrintStream output = new PrintStream(new FileOutputStream("Everyone.txt", true));
								output.println("**************************************");
								output.println("CLIENT DATA: ");

								output.println(OwnerGui.input);

								output.println(input);

								try {
									dummy = Integer.parseInt(jobDurBox.getText());
								} catch (NumberFormatException w) {
									dummy = 0; // error handling
								}
								AcceptedjobTime.add(dummy);

								try {
									dummy2 = clientIDBox.getText();
								} catch (NumberFormatException w) {
									dummy2 = ""; // error handling
								}

								clientIDBox.setText("");
								jobDurBox.setText("");
								dealineBox.setText("");
								textFieldFName.setText("");
								textFieldLName.setText("");

								AcceptedClientID.add(dummy2);

								OwnerGui.input = "";
								input = "";

								outputStream.writeUTF("DATA ACCEPTED");
								JOptionPane.showMessageDialog(null, "Users data has been accepted!");

								output.close();
							} catch (Exception a) {

								a.printStackTrace();
							}
						}

					}

				}

				class rejectButtonListener implements ActionListener {
					public void actionPerformed(ActionEvent e) {
						if (e.getActionCommand() == rejectButton.getActionCommand()) {
							try {
								clientIDBox.setText("");
								jobDurBox.setText("");
								dealineBox.setText("");
								textFieldFName.setText("");
								textFieldLName.setText("");

								outputStream.writeUTF("DATA REJECTED");
								JOptionPane.showMessageDialog(null, "Users data has been rejected!");

							} catch (Exception ex) {
								JOptionPane.showMessageDialog(null, ex);
							}
							{

							}
						}
					}
				}

				private void createRejectButton() {
					rejectButton = new JButton("Reject");
					ActionListener rejectButtonListener = new rejectButtonListener();
					rejectButton.addActionListener(rejectButtonListener);
					rejectButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
					rejectButton.setFocusable(false);
				}

				private void createPanel() {
					JPanel panel = new JPanel();
					panel.add(question);
					panel.add(acceptButton);
					panel.add(rejectButton);
					panel.setBackground(new Color(0, 191, 255));
					add(panel);
				}

			}
			//////

			while (true) {
				if (dataIn.equals("exit") == true) {
					System.exit(1);
				}

				dataIn = inputStream.readUTF();
				System.out.println("Data received from client: " + "\"" + dataIn + "\"");

				MainMenu mFrame = new MainMenu();

				mFrame.Mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				mFrame.Mainframe.setVisible(true);

				JFrame frame = new acceptRejectWindow();
				frame.setTitle("Server");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);

			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
