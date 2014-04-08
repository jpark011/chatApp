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
			while(true) {
				System.out.println("Listening...");
				msg = sc.readLine();
				System.out.println(msg);
			}
		} catch(IOException e) {
			System.out.println("Session ended");
		}
	}
}
