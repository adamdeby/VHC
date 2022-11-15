import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class networkClient {
	
	 static ServerSocket serverSocket;
		static Socket socket;
		static DataInputStream inputStream;
		static DataOutputStream outputStream;


	public static void main(String[] args) throws IOException {
		
		String dataOut = "";
		Scanner input;
		
		try 
		
		{
			 System.out.println("******** Client Side ********");
			 System.out.println("Client Sucessfully Connected!... ");
			
			Socket socket = new Socket("localhost", 3322);
			
			inputStream = new DataInputStream(socket.getInputStream());
			outputStream = new DataOutputStream(socket.getOutputStream());
	
			
			input = new Scanner(System.in);
			dataOut = input.nextLine();
			outputStream.writeUTF(dataOut);
				
	}
		catch(Exception e) 
		{
			System.exit(1);
			socket.close();
			e.printStackTrace();
		}
}
}