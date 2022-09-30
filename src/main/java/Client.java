import java.io.*;
import java.net.Socket;

public class Client {

  static Socket clientSocket;

  public static void main(String[] args) {
    while (true) {
      try {
        clientSocket = new Socket("localhost", 8080);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader in = new BufferedReader(
            new InputStreamReader(clientSocket.getInputStream()));
        BufferedWriter out = new BufferedWriter(
            new OutputStreamWriter(clientSocket.getOutputStream()));

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