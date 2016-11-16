package code;
import java.io.*;
import java.net.*;
import java.util.Scanner;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class Receiver {
	
	public static void main(String[] args) {
		int port = 9999;		
		Object obj;
		Scanner scan = new Scanner(System.in);;
	    try
	    {
	        ServerSocket serverSocket = new ServerSocket(port);
	        File file = new File("received.xml");
	        FileOutputStream fileOutputStream = new FileOutputStream(file);
	        byte[] fileByte = new byte[10000];

            System.out.println("Receiver waiting for Sender on port " + port + ".");
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
	            
            int fileSize;
            fileSize = inputStream.read(fileByte);
            fileOutputStream.write(fileByte, 0, fileSize);
	            
            SAXBuilder builder = new SAXBuilder();
            Document doc = (Document)builder.build(file);
            obj = Deserializer.deserialize(doc);
            
        	inputStream.close();
            serverSocket.close();
            socket.close();
            fileOutputStream.close();
	        
		}  
	    catch (IOException e) {
	        String msg = " Exception on new ServerSocket: " + e + "\n";
	        System.out.println(msg);
	    } catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}      
}
