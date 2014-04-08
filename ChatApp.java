import java.net.*;
import java.io.*;

public class ChatApp {
	public static void main(String[] args) {
		Socket cli_soc = null;
		if(args.length == 1) {	// Serverside app
			try {
				ServerSocket svr_soc = new ServerSocket(Integer.parseInt(args[0]), 0, InetAddress.getByName("0.0.0.0"));
				System.out.println("Waiting for a client on " + svr_soc.getLocalPort());

				cli_soc = svr_soc.accept();
				System.out.println("Successfully connected!");

				Thread receiver = new Thread(new MessageReceiver(cli_soc));
				Thread sender = new Thread(new MessageSender(cli_soc));
			} catch(IOException e) {
				System.out.println("Server failure: " + e.getMessage());
			}
		} else if(args.length == 2) {
			try {
				System.out.println("Connecting to " + args[0] + ":" + args[1]);
				cli_soc = new Socket(args[0], Integer.parseInt(args[1]));
				System.out.println("Successfully connected!");
			} catch(IOException e) {
				System.out.println("Could not connect: " + e.getMessage());
			}
		} else {
			System.out.println("Wrong # of arguments!");
			return;
		}
		Thread receiver = new Thread(new MessageReceiver(cli_soc));
		Thread sender = new Thread(new MessageSender(cli_soc));
		receiver.start();
		sender.start();
	}
}
