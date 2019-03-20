package Net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();
        //客户端发送消息给服务器
        String str = "I am here!";
        byte[] bs1 = str.getBytes();
        DatagramPacket sendLetter = new DatagramPacket(
                bs1, 0, bs1.length, InetAddress.getLocalHost(), 9000
        );
        ds.send(sendLetter);

        //从服务器收30次消息
        DatagramPacket receiverLetter = new DatagramPacket(
                new byte[100], 0, 100
        );
        for (int i = 0; i < 30; i++) {
            ds.receive(receiverLetter);
            //显示消息
            byte[] bs = receiverLetter.getData();
            int offset = receiverLetter.getOffset();
            int length = receiverLetter.getLength();
            String s = new String(bs, offset, length);
            System.out.println(s);
        }

        ds.close();
    }
}
