import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Server {
    private ServerSocket serverSocket;
    private BufferedReader reader;
    private PrintWriter printWriter;
    private Socket socket;

    public Server(int port) {
        try {
            boolean russianDetector = false;
            serverSocket = new ServerSocket(port);
            System.out.println("Чекаємо клієнта");
            socket = serverSocket.accept();
            System.out.println("Клієнта прийнято");
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter = new PrintWriter(socket.getOutputStream(), true);
            String str = "";
//            while(!(str = reader.readLine()).equalsIgnoreCase("")) {
//                if (str.equalsIgnoreCase("test")) {
//                    printWriter.println("Що таке паляниця?");
//                }
//                System.out.println(str);
//            }
            do {
                printWriter.println("Уведіть значення / натисніть 'Enter', щоб закінчити : ");
                str = reader.readLine();
                if (containsRussianLetters(str) && russianDetector) {
                    System.out.println("Москаля ідентифіковано, завершення програми!");
                    printWriter.println("exit");
                    break;
                }
                else if (containsRussianLetters(str) && !russianDetector) {
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
                    System.out.println(str);
            } while (!str.isEmpty());

            System.out.println("Виконання закінчено");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null && !socket.isClosed())
                    socket.close();
                if (reader != null)
                    reader.close();
                if (serverSocket != null && !serverSocket.isClosed())
                    serverSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private boolean containsRussianLetters(String str) {
        Pattern pattern = Pattern.compile("[ЁёъыЭэ]+");
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

    public static void main(String args[]) {
        Server server = new Server(8081);
    }

}