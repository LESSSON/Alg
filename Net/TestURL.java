package Net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

public class TestURL {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:63342/sortAlg/about.html");
        URLConnection uc = url.openConnection();
        InputStream is = uc.getInputStream();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(is));
        while (true) {
            String str = in.readLine();
            if (str == null) break;
            System.out.println(str);
        }
        in.close();
    }
}
