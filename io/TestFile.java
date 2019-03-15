package io;

import java.io.File;

public class TestFile {
    public static void main(String[] args) throws Exception{
        File f = new File("1.txt");
        f.delete();
    }
}
