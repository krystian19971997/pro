package others.server;

public class ServerMain {
    public static void main(String[] args) {
        new Thread(new Server(8888)).start();
    }
}
