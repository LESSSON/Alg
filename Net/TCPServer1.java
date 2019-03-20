package Net;

import java.net.*;
import java.io.*;

public class TCPServer1 {
    public static void main(String[] args) throws Exception {
        //服务器进程绑定9000端口
        ServerSocket ss = new ServerSocket(9000);
        //阻塞方法 等待客户端的连接请求
        while (true) {
            Socket s = ss.accept();
            System.out.println(s.getInetAddress());
            Thread t = new ServerThread(s);
            t.start();
        }
    }

    static class ServerThread extends Thread {
        Socket s;

        public ServerThread(Socket s) {
            this.s = s;
        }

        @Override
        public void run() {
            OutputStream os = null;
            try {
                os = s.getOutputStream();
                PrintWriter out = new PrintWriter(os);
                for (int i = 1; i <= 30; i++) {
                    out.println("Hello" + i);
                    out.flush();
                    Thread.sleep(600);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
