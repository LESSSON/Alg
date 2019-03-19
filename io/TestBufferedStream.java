package io;

import java.io.*;

public class TestBufferedStream {
    public static void main(String[] args) throws Exception{
        FileOutputStream fos = new FileOutputStream("1.txt");
        BufferedOutputStream out = new BufferedOutputStream(fos);
        out.write('A');
        out.flush();
        out.close();
    }
}
