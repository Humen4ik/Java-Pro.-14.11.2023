import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private BufferedReader reader;
    private PrintWriter printWriter;
    private Socket socket;

    public Server(int port) {
        try {
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

    public static void main(String args[]) {
        Server server = new Server(8081);
    }

}