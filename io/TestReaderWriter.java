package io;

import java.io.*;

public class TestReaderWriter {
    public static void main(String[] args) throws Exception {
        OutputStream fos = new FileOutputStream("poem.txt");
        Writer ow = new OutputStreamWriter(fos);
        PrintWriter out = new PrintWriter(ow);
        out.println("一二三四五六七");
        out.println("七六五四三二一");
        out.println("一二三四五六七");
        out.println("七六五四三二一");
        out.close();

        InputStream fis = new FileInputStream("poem.txt");
        Reader fr = new InputStreamReader(fis);
        BufferedReader in = new BufferedReader(fr);

        while (true) {
            String str = in.readLine();
            if (str == null) break;
            System.out.println(str);
        }
        in.close();
    }
}
