package code;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Sender {
	public static void main (String[] args){
		
		ObjectOutputStream sOutput;
		Socket socket = null;
		String receiver;
		int port;
		Scanner scan;
		
		scan = new Scanner(System.in);
		System.out.println("Enter the receiver name: ");
		receiver = scan.nextLine();
		System.out.println("Enter the port number: ");
		port = scan.nextInt();
		
        try {
            socket = new Socket(receiver, port);
        }
        catch(Exception ec) {
            System.out.println("Error connectiong to server:" + ec);
        }
        
        String msg = "Connection accepted " + socket.getInetAddress() + ":" + socket.getPort();
        System.out.println(msg);
        
        try
        {
            sOutput = new ObjectOutputStream(socket.getOutputStream());
        }
        catch (IOException eIO) {
        	System.out.println("Exception creating new Output streams: " + eIO);
        }

	}
}
	

