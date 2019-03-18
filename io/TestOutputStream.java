package io;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class TestOutputStream {
    public static void main(String[] args) throws Exception{
        OutputStream os = new FileOutputStream("1.txt",true);
    }
}
