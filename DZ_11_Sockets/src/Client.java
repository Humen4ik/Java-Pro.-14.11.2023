import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private Scanner scanner;
    private PrintWriter printWriter;

    public Client(String ip, int port) {
        try {
            socket = new Socket(ip, port);
            System.out.println("Socket has been created");
            scanner = new Scanner(System.in);
            printWriter = new PrintWriter(socket.getOutputStream(), true);
            String str;
            do {
                System.out.println("Enter a value to send / press 'Enter' to finish");
                str = scanner.nextLine();
                printWriter.println(str);
            } while (!(str.equalsIgnoreCase("")));
            System.out.println("Execution finished");
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
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client("localhost", 8081);
    }
}