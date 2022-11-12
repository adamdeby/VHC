import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
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
				final int FrameWidth = 550;
				final int FrameHeight = 400;
				JLabel question;
				JButton acceptButton;
				JButton rejectButton;

				public acceptRejectWindow() {
					question = new JLabel("Do you want to accept or reject the client's data?");
					createAcceptButton();
					 createRejectButton();
					 createPanel();

					setSize(FrameWidth, FrameHeight);
				}

				private void createAcceptButton() {
					acceptButton = new JButton("Accept");
					acceptButton.setBounds(10, 100, 180, 125);
					ActionListener acceptButtonListener = new acceptButtonListener();
					acceptButton.addActionListener(acceptButtonListener);
				}

				class acceptButtonListener implements ActionListener {

					public void actionPerformed(ActionEvent e) {
						if (e.getActionCommand() == acceptButton.getActionCommand()) {

							try {
								////
								// clientTable();
								// vehicleOwnerTable();
								// ////

								PrintStream output = new PrintStream(new FileOutputStream("Client Data.txt", true));
								output.println("**************************************");
								output.println("CLIENT DATA: ");
								output.println(inputStream);
								output.println("**************************************");

								outputStream.writeUTF("DATA ACCEPTED");
								output.close();
							} catch (Exception a) {

								a.printStackTrace();
							}
						}

					}

				}
				class rejectButtonListener implements ActionListener
				{
					public void actionPerformed(ActionEvent e)
					{	
						if(e.getActionCommand()== rejectButton.getActionCommand())
						{
							try 
							{
								outputStream.writeUTF("DATA REJECTED");
							}
							catch(Exception ex){JOptionPane.showMessageDialog(null, ex);} 
							{
								
							}
						}
					}
				}

				private void createRejectButton() 
				{
					rejectButton = new JButton("Reject");
					rejectButton.setBounds(10, 125, 80, 25);
					ActionListener rejectButtonListener = new rejectButtonListener(); 
					rejectButton.addActionListener(rejectButtonListener);
				}
				private void createPanel() 
				{
					JPanel panel = new JPanel();
					panel.add(question);
					panel.add(acceptButton);
					panel.add(rejectButton);
					add(panel);
				}
					
			}
			//////
			
			while(true)
			{
				if(dataIn.equals("exit")==true) 
				{
					System.exit(1);
				}
				
				dataIn = inputStream.readUTF();
				System.out.println("Data received from client: " + "\"" + dataIn + "\"");
				
				MainMenu mFrame = new MainMenu();
				
				mFrame.Mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				mFrame.Mainframe.setVisible(true);
				
				JFrame frame = new acceptRejectWindow();
				frame.setTitle("SERVER");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);

			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
