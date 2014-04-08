import java.net.Socket;
import java.util.*;
import java.io.*;

public class MessageSender implements Runnable {
	private Socket soc;
	public MessageSender(Socket client) {
		this.soc = client;
	}
	public void run() {
		try {
			Scanner sc = new Scanner(System.in);
			DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
			String msg;
			while(true) {
				msg = sc.nextLine();
				if(msg == "quit") {
					System.exit(0);
				}
				System.out.println("You typed: " + msg);
				dos.write(msg.getBytes());
			}
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
