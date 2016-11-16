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

import org.jdom2.Document;
import org.jdom2.output.XMLOutputter;

public class Sender {
	public static void main (String[] args){
		
		Socket socket;
		String receiver = "localhost";
		int port;
		Scanner scan;
		ObjectCreator objectCreator = new ObjectCreator();
		Object obj = objectCreator.getObj();
		
		scan = new Scanner(System.in);
		System.out.println("Enter the port number: ");
		port = scan.nextInt();
		
        try {
            socket = new Socket(receiver, port);
            String msg = "Connection accepted " + socket.getInetAddress() + ":" + socket.getPort();
            System.out.println(msg);
            Document doc = Serializer.serializeObject(obj);
            FileOutputStream fileOutputStream = new FileOutputStream("output.xml");
            XMLOutputter xmlOutputter = new XMLOutputter();
            xmlOutputter.output(doc, fileOutputStream);
            fileOutputStream.close();
            
            File file = new File("output.xml");
            FileInputStream fileInputStream = new FileInputStream(file);
            int fileSize = fileInputStream.available();
            byte[] fileByte = new byte[fileSize];
            fileInputStream.read(fileByte);
            fileInputStream.close();
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(fileByte, 0, fileSize);
            socket.close();
        }
        catch(Exception ec) {
            System.out.println("Error connectiong to server:" + ec);
        }
        
        
        

	}
}
	

