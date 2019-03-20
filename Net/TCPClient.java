
package Net;

import java.net.*;
import java.io.*;

public class TCPClient {
    public static void main(String[] args) throws Exception {
        // 向服务器发起连接
        Socket s = new Socket("192.168.10.105", 9000);

        //
        InputStream is = s.getInputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        for (int i = 1; i <= 30; i++) {
            String str = in.readLine();
            System.out.println(str);
        }
        s.close();
    }
}
