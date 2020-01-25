package others.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server implements Runnable {
    private final List<Connection> connections = new ArrayList<>();
    private final int port;

    public Server(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try(ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Serwer uruchomil sie na porcie:  " + port);
            Socket socket = serverSocket.accept();
            System.out.println("Klient podlaczony ");
            Connection connection = new Connection(socket);
            connection.send("Podaj imie");
            connections.add(connection);
            new Thread(connection).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
