//package sortAlg;

/**
 *  Effective Java 第一版推荐写法
 *  对于内部类SingletonHolder，它是一个饿汉式的单例实现，在SingleHolder初始化时会由ClassLoader来保证同步，使INSTANCE是一个真·单例
 *  同时，由于SingletonHolder是一个内部类，只在外部类的Singleton的getInstance()中被使用，所以它被加载的时机也就是getInstance()方法第一次被调用的时候.
 *  利用ClassLoader来保证了同步，同时又能让开发者控制类加载的时机。从内部看是一个饿汉式的单例，但是从外部看来，又的确是懒汉式的实现
 *  @author Leson
 *  @Time 2019.02.24
 */

public class Singleton {
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    private Singleton() {
    }

    public static final Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }


    /**
     *  SingleInstance是一个枚举类型，由于创建枚举实例的过程是线程安全的，所以这种写法也没有同步的问题.
     *  但是再需要继承的场景，它就不适用了.
     */
    public enum SingleInstance {
        INSTANCE;
        public void fun1() {
            // do something
        }
    }

    //使用
//    SingleInstance.INSTANCE.fun1();
}