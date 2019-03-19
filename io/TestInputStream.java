package io;

import java.io.*;

public class TestInputStream {
    public static void main(String[] args) throws Exception {
        InputStream is = new FileInputStream("1.txt");
//        //一次读一个字节
//        while (true) {
//            int i = is.read();
//            if (i == -1) break;
//            System.out.print((char) i);
//        }

        //一次读一定长度
//        byte[] bs = new byte[3];
//        while (true){
//            int i = is.read(bs);
//            if(i == -1) break;
//            for(byte b:bs){
//                System.out.print((char) b);
//            }
//            System.out.println(i);
//        }

        //一次读指定长度放入指定位置
        byte[] bs = new byte[3];
        while (true){
            int i = is.read(bs,1,2);
            if(i == -1) break;
            for(byte b:bs){
                System.out.print((char) b);
            }
            System.out.println(i);
        }


        System.out.println();
        is.close();
    }
}
