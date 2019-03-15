package sortAlg;

/**
 * Single1类，此为单例模式的懒汉式最佳写法
 * @author Leson
 * @param
 * @Time 2019.02.24
 */

//
public class Single1 {
    private static volatile Single1 instance;

    private Single1() {
    }

    public static Single1 getInstance() {
        if (instance == null) {
            synchronized (Single1.class) {
                if (instance == null) {
                    instance = new Single1();
                }
            }
        }
        return instance;
    }
}
