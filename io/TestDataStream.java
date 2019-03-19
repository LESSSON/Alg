package io;

import java.io.*;

/**
 * 1.创建节点流
 * 2.封装过滤流
 * 3.读/写数据
 * 4.关闭流
 */

public class TestDataStream {
    public static void main(String[] args) throws Exception{
        long l = 123456789012345678L;
        OutputStream os = new FileOutputStream("1.dat");
        DataOutputStream out = new DataOutputStream(os);
        //long ==> byte[8]
        out.writeLong(l);
        /**
         * 只需要关闭最外层的流就可以
         */
        out.close();

        InputStream is = new FileInputStream("1.dat");
        DataInputStream in = new DataInputStream(is);
        long l2 = in.readLong();
        in.close();
        System.out.println(l2);
    }
}
