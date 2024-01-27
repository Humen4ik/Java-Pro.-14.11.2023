import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Server {
    private ServerSocket serverSocket;
    private BufferedReader reader;
    private PrintWriter printWriter;
    private Socket socket;
    boolean russianDetector;

    public Server(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Чекаємо клієнта");
            socket = serverSocket.accept();
            System.out.println("Клієнта прийнято");
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeResources(socket, reader, printWriter);
        }
    }

    public void listenForMessages() {
        new Thread(() -> {
            try {
                while (socket.isConnected()) {
                    String message = reader.readLine();
                    if (containsRussianLetters(message) && russianDetector) {
                        System.out.println("Москаля ідентифіковано, завершення програми!");
                        printWriter.println("exit");
                        break;
                    }
                    else if (containsRussianLetters(message) && !russianDetector) {
                        russianDetector = true;
                        printWriter.println("Що таке паляниця?");
                        String answer = reader.readLine().toLowerCase();
                        if (answer.contains("хліб")) {
                            printWriter.println("На цей раз тобі пощастило, що ти можеш сказати в своє виправдання?");
                            System.out.println(reader.readLine());
                        } else {
                            System.out.println("Москаля ідентифіковано, завершення програми!");
                            printWriter.println("");
                            break;
                        }
                    } else
                        System.out.println(message);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    public void writeMessages() {
        Scanner scanner = new Scanner(System.in);
        String messagePrefix = "SERVER: ";
        while (socket.isConnected()) {
            String message = scanner.nextLine();
            printWriter.println(messagePrefix + message);
        }
    }

    private boolean containsRussianLetters(String str) {
        Pattern pattern = Pattern.compile("[ЁёъыЭэ]+");
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
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

    public static void main(String args[]) {
        Server server = new Server(8081);
        server.listenForMessages();
        server.writeMessages();
    }

}