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
		Scanner sc = new Scanner(soc.getInputStream());
		String msg;
		while(true) {
			msg = sc.nextLine();
			System.out.println(msg);
		}
		} catch(IOException e) {
			System.out.println("Session ended");
		}
	}
}
