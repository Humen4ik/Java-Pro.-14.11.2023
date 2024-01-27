import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private Scanner scanner;
    private PrintWriter printWriter;
    private BufferedReader reader;

    public Client(String ip, int port) {
        try {
            socket = new Socket(ip, port);
            System.out.println("Сокет було створено");
            scanner = new Scanner(System.in);
            printWriter = new PrintWriter(socket.getOutputStream(), true);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeResources(socket, reader, printWriter);
        }
    }

    public void listenForMessages() {
        new Thread(() -> {
            while (socket.isConnected()) {
                try {
                    String message = reader.readLine();
                    System.out.println("SERVER: " + message);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    public void writeMessages() {
        Scanner scanner = new Scanner(System.in);
        String messagePrefix = "CLIENT: ";
        while (socket.isConnected()) {
            String message = scanner.nextLine();
            printWriter.println(messagePrefix + message);
        }
    }

    private void closeResources(Socket socket, BufferedReader reader, PrintWriter writer) {
        try {
            if (socket != null && !socket.isClosed())
                socket.close();
            if (reader != null)
                reader.close();
            if (writer != null)
                writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Client client = new Client("localhost", 8081);
        client.listenForMessages();
        client.writeMessages();
    }
}