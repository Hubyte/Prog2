package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    private final int port;
    public static final int PRTNMBR = 4445;

    public static void main(String[] args) throws IOException, InterruptedException {
        TCPServer tcpServer = new TCPServer(PRTNMBR);

        tcpServer.interact();
    }

    TCPServer (int port) {
        this.port = port;
    }

    private void interact() throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(this.port);
        Socket socket = serverSocket.accept();

        InputStream is = socket.getInputStream();
        is.read();

        OutputStream os = socket.getOutputStream();
        os.write("Welcome astonished one".getBytes());

        Thread.sleep(5000);

        //OutputStream schließen
        os.close();
    }
}
