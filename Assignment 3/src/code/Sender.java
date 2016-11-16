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
		
		Object obj;
		Socket sock;
		int portNumber = 4545;
		String portName = "localhost";
		ObjectCreator objC = new ObjectCreator();
		obj = objC.getObj();
		try {
			Document doc = Serializer.serializeObject(obj);
			FileOutputStream fileOutputstream = new FileOutputStream("output.xml");
			XMLOutputter xo = new XMLOutputter();
			xo.output(doc, fileOutputstream);
			fileOutputstream.close();

			File file = new File("output.xml");
			FileInputStream fileInputStream = new FileInputStream(file);
			int fileSize = fileInputStream.available();
			byte[] fileByte = new byte[fileSize];
			fileInputStream.read(fileByte);
			fileInputStream.close();
			
			sock = new Socket(portName,portNumber);
			OutputStream outputStream = sock.getOutputStream();
			outputStream.write(fileByte, 0, fileSize);
			try {
				sock.close();
			}catch (Exception e) {
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
	

