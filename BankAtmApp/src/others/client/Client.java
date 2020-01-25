package others.client;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8888);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        Scanner scanner = new Scanner(socket.getInputStream(), StandardCharsets.UTF_8);
        out.println("Adam");
        while (true) {
            if (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        }


    }
}


