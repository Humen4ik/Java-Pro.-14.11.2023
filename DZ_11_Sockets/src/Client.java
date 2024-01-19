import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private Scanner scanner;
    private PrintWriter printWriter;
    private BufferedReader reader;

    public Client(String ip, int port) {
        boolean russianDetector = false;
        try {
            socket = new Socket(ip, port);
            System.out.println("Сокет було створено");
            scanner = new Scanner(System.in);
            printWriter = new PrintWriter(socket.getOutputStream(), true);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String str;
            do {
                System.out.println(reader.readLine());
                str = scanner.nextLine();
                if (containsRussianLetters(str) && russianDetector) {
                    System.out.println("Москаля ідентифіковано, завершення програми!");
                    printWriter.println("");
                    break;
                }
                else if (containsRussianLetters(str) && !russianDetector) {
                    russianDetector = true;
                    System.out.println("Що таке паляниця?");
                    String answer = scanner.nextLine().toLowerCase();
                    if (answer.contains("хліб")) {
                        System.out.println("На цей раз тобі пощастило, даю тобі ще один шанс! -_- Я за тобою слідкую -_-");
                        System.out.println(LocalDateTime.now());
                        printWriter.println(str);
                    }
                    else {
                        System.out.println("Москаля ідентифіковано, завершення програми!");
                        printWriter.println("");
                        break;
                    }
                } else {
                    printWriter.println(str);
                }
            } while (!(str.equalsIgnoreCase("")));
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

    private boolean containsRussianLetters(String str) {
        return str.matches(".*[ЁёъыЭэ]+");
    }

    public static void main(String[] args) {
        Client client = new Client("localhost", 8081);
    }
}