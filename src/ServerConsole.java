import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import common.ChatIF;
import ocsf.server.ConnectionToClient;
import client.ChatClient;
import ocsf.server.*;
import server.*;

public class ServerConsole implements ChatIF{
	EchoServer server;

	/**
	 * The default port to listen on.
	 */
	final public static int DEFAULT_PORT = 5555;	
	
	public ServerConsole(int port) {
		this.server = new EchoServer(port, this);
	}
	
	public void launchConsol(){
		try {
			this.server.listen();
			this.server.acceptServer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Start listening for connections
	}

	@Override
	public void display(String message) {
		System.out.println(message);
	}
	
	
	
	/**
	 * This method is responsible for the creation of the server instance (there
	 * is no UI in this phase).
	 *
	 * @param args
	 *            [0] The port number to listen on. Defaults to 5555 if no
	 *            argument is entered.
	 */
	public static void main(String[] args) {
		int port = 0; // Port to listen on

		try {
			port = Integer.parseInt(args[0]); // Get port from command line
		} catch (Throwable t) {
			port = DEFAULT_PORT; // Set port to 5555
		}

		ServerConsole serverConsole = new ServerConsole(port);
		serverConsole.launchConsol();
	}
}