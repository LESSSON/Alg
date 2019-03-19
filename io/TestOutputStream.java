package io;

import java.io.*;

public class TestOutputStream {
    public static void main(String[] args) {
        String str = "Hello World";
        OutputStream os = null;
        try {
            os = new FileOutputStream("1.txt", true);
            byte[] bs = str.getBytes();
            os.write(bs);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
