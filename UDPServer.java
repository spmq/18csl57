import java.io.*;
import java.net.*;
import java.util.Scanner;

public class UDPServer {
  public static void main(String[] args) throws IOException {
    DatagramSocket socket = new DatagramSocket(9876);
    Scanner sc = new Scanner(System.in);
    System.out.println("Server started. Type a message and press Enter to send: ");

    while (true) {
      String message = sc.nextLine();
      byte[] sendBuffer = message.getBytes();

      DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length,
          InetAddress.getByName("localhost"), 9999);
      socket.send(sendPacket);
    }
  }
}