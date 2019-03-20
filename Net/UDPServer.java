
package Net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(9000);
        // 服务器准备从客户端收信
        DatagramPacket receiverLetter = new DatagramPacket(new byte[100], 0, 100);
        ds.receive(receiverLetter);

        InetAddress address = receiverLetter.getAddress();
        int port = receiverLetter.getPort();

        // 给客户端发送30次消息
        for (int i = 1; i <= 30; i++) {
            String str = "Hello " + i;
            byte[] bs = str.getBytes();
            DatagramPacket sendLetter = new DatagramPacket(bs, 0, bs.length, address, port);
            ds.send(sendLetter);
            Thread.sleep(1000);
        }

        ds.close();

    }
}
