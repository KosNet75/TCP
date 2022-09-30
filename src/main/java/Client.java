import java.io.*;
import java.net.Socket;

public class Client {

    static Socket clientSocket;
    private static BufferedReader reader;
    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) {
        while (true) {
            try {
                clientSocket = new Socket("localhost", 8080);
                reader = new BufferedReader(new InputStreamReader(System.in));
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                String serverDialogue = in.readLine();
                System.out.println(serverDialogue);

                String city = reader.readLine();
                out.write(city + "\n");
                out.flush();

                String dialAnswer = in.readLine();
                System.out.println(dialAnswer);


            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }
}