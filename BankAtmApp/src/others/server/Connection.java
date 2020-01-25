package others.server;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Connection implements Runnable {
    private final Socket client;
    private final InputStream inputStream;
    private final OutputStream outputStream;

    public Connection(Socket client) throws IOException {
        this.client = client;
        inputStream = client.getInputStream();
        outputStream = client.getOutputStream();
    }

    @Override
    public void run() {

        Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8);
        boolean done = false;
        while(!done) {
            //jesli masz jeszcze jakas linie do odczytania
            if (scanner.hasNextLine()) {
                //wstrzm program dopoki nie wpisze i nie da entera
                String line = scanner.nextLine();

                if (line.toLowerCase().trim().equals("peace")) {
                    done = true;
                }
                if (line.equals("Adam")) {
                    send("Podales ADAM");
                }
            }
        }
    }

    public void send(String message) {
        PrintWriter serverPrintOut = new PrintWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8), true);
        serverPrintOut.println(message);
    }
}
