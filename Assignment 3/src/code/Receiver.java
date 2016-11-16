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
			ServerSocket servSock = new ServerSocket(portNumber);
			File file = new File("received.xml");
			FileOutputStream fos = new FileOutputStream(file);
			byte[] fileByte = new byte[10000];
			
			Socket sock = servSock.accept();
			InputStream is = sock.getInputStream();
			
			int fileSize;
			fileSize = is.read(fileByte);
			fos.write(fileByte, 0, fileSize);
			
			SAXBuilder builder = new SAXBuilder();
			Document doc = (Document)builder.build(file);
			obj = Deserializer.deserialize(doc);
			
			is.close();
			servSock.close();
			sock.close();
			fos.close();

			Inspector.inspect(obj, true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
