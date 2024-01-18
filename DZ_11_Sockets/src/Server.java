import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private BufferedReader reader;
    private Socket socket;

    public Server(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Waiting for a client");
            socket = serverSocket.accept();
            System.out.println("Client accepted");
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String str;
            while(!(str = reader.readLine()).equalsIgnoreCase("")) {
                System.out.println(str);
            }
            System.out.println("Execution finished");
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