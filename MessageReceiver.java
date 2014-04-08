import java.net.Socket;
import java.util.*;
import java.io.*;

public class MessageReceiver implements Runnable {
	private Socket soc;
	public MessageReceiver(Socket client) {
		this.soc = client;
	}
	public void run() {
		try {
			DataInputStream sc = new DataInputStream(soc.getInputStream());
			String msg;
			System.out.println("Listening..." + soc.getPort());
			while(true) {
				msg = sc.readUTF();
				System.out.println(soc.getRemoteSocketAddress() + " says: " + msg);
			}
		} catch(IOException e) {
			System.out.println("Session ended");
		}
	}
}
