import java.io.*;
import java.net.*;

public class UDPClient {
  public static void main(String[] args) throws IOException {
    DatagramSocket socket = new DatagramSocket(9999);

    while (true) {
      byte[] receiveBuffer = new byte[1024];

      DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
      socket.receive(receivePacket);
      String message = new String(receivePacket.getData(), 0, receivePacket.getLength());

      System.out.println("Message received from server: " + message);
    }
  }
}