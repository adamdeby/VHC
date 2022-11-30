import java.util.ArrayList;
import java.sql.*;
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
	public static int sum;

	// MySql stuff
	static Connection connection = null;
	static String url = "jdbc:mysql://localhost:3306/vhc?useTimezone=true&serverTimezone=UTC";
	static String username = "root";
	static String password = "VHCproject123";

	public static ArrayList<Integer> computeResult(ArrayList<Integer> input) {
		sum = 0;
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

		String dataOut = "";
		try {

			System.out.println("----------$$$ This is server side $$$--------");
			System.out.println("Wating for client to connect...");
			// creating the server
			serverSocket = new ServerSocket(3322);
			// sever accepts connection request from client
			socket = serverSocket.accept();
			System.out.println("Client is connected!");

			inputStream = new DataInputStream(socket.getInputStream());
			outputStream = new DataOutputStream(socket.getOutputStream());

			MainMenu mFrame = new MainMenu();

			mFrame.Mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mFrame.Mainframe.setVisible(true);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
