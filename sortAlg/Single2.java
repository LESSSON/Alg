package sortAlg;

/**
 * Single2类，此为单例模式的饿汉式写法，由于饿汉式下的单例有JVM负责创建，所以能避免很多在多线程下可能出现的问题
 * @author Leson
 * @param
 * @Time 2019.02.24
 */

public class Single2 {
    private static final Single2 INSTANCE = new Single2();

    private Single2() {
    }

    public static Single2 getInstance() {
        return INSTANCE;
    }
}
