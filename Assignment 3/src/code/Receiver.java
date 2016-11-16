package code;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Receiver {
	
	public static void main (String[] args) {
		int port;
		boolean keepGoing;
		Scanner scan = new Scanner(System.in);;
		
		System.out.println("Enter the server port number: ");
		port = scan.nextInt();
		
		keepGoing = true;
	    try
	    {
	        ServerSocket serverSocket = new ServerSocket(port);
	        while(keepGoing)
	        {
	            System.out.println("Receiver waiting for Sender on port " + port + ".");
	            Socket socket = serverSocket.accept();
	            if(!keepGoing)
	                break;
	        }
	        try {
	            serverSocket.close();
	        }
	        catch(Exception e) {
	        	System.out.println("Exception closing the sender and receiver: " + e);
	        }
	    }
	    catch (IOException e) {
	        String msg = " Exception on new ServerSocket: " + e + "\n";
	        System.out.println(msg);
	    }
	}      
}
