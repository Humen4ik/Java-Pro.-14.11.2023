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

            String str;
            String serverAnswer;
            do {
                serverAnswer = reader.readLine();
                if (serverAnswer.equals("exit"))
                    break;
                System.out.println(serverAnswer);
                str = scanner.nextLine();
                printWriter.println(str);
            } while (!str.equals(""));

            System.out.println("Виконання закінчено");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null && !socket.isClosed())
                    socket.close();
                if (scanner != null)
                    scanner.close();
                if (printWriter != null)
                    printWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client("localhost", 8081);
    }
}