package sortAlg;

public class ExtendsTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        C c = new  D();
    }

}
class C {
    static
    {
        System.out.println("C 基类静态域 ");
    }
    {
        System.out.println("C 基类对象成员构造函数");
    }
    public C(){
        System.out.println("C 基类本身的构造函数");
    }
}
class D extends C{
    static
    {
        System.out.println("D 派生类静态域");
    }
    {
        System.out.println("D 派生类对象成员构造函数");
    }
    public D(){
        System.out.println("D 派生类本身的构造函数");
    }
}