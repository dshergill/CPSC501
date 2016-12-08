package code;
import java.io.*;
import java.net.*;
import java.util.Scanner;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class Receiver {
	
	public static void main (String[] args) {
		Object obj;
		int portNumber = 4545;
		try {
			ServerSocket serverSocket = new ServerSocket(portNumber);
			File file = new File("received.xml");
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			byte[] fileByte = new byte[10000];
			
			Socket socket = serverSocket.accept();
			InputStream inputStream = socket.getInputStream();
			
			int fileSize;
			fileSize = inputStream.read(fileByte);
			fileOutputStream.write(fileByte, 0, fileSize);
			
			SAXBuilder builder = new SAXBuilder();
			Document doc = (Document)builder.build(file);
			obj = Deserializer.deserializer(doc);
			try {
				inputStream.close();
				serverSocket.close();
				socket.close();
				fileOutputStream.close();
			}
			catch(Exception ec) {
	            System.out.println("Error closing sockets/streams:" + ec);
	            
	        }
			Inspector.inspect(obj, true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
