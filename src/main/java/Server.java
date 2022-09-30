
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {


  static String textTemp;
  static String text;

  public static void main(String[] args) {

    try (ServerSocket serverSocket = new ServerSocket(8080)) {
      System.out.println("Сервер запущен!");
      while (true) {
        try (Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream())) {
          char backChar = 0;
          if (text == null) {
            out.write("Введите название города:" + "\n");
            out.flush();
          } else {
            char Char = text.charAt(text.length() - 1);
            backChar = Character.toUpperCase(Char);
            out.write("Город " + text + ". Напишите город на букву '" + backChar + "'\n");
            out.flush();
          }
          textTemp = in.readLine();
          System.out.println(textTemp);
          if (text != null && backChar == textTemp.charAt(0) ||
              text != null && backChar == Character.toUpperCase(textTemp.charAt(0))) {
            out.write("Ответ принят." + "\n");
            text = textTemp;
          } else if (text == null) {
            out.write("Игра началась." + "\n");
            text = textTemp;
          } else {
            out.write("Не правильный ответ." + "\n");
          }
          out.flush();
        }
      }
    } catch (IOException e) {
      System.out.println("Ошибка запуска сервера");
      e.printStackTrace();
    }
  }
}


