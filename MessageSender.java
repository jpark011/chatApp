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
			DataInputStream sc = new DataInputStream(System.in);
			DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
			String msg;
			while(true) {
				msg = sc.readLine();
				if(msg == "quit") {
					System.exit(0);
				}
				dos.writeUTF(msg);
			}
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
