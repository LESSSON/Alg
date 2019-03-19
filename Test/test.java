package Test;

public class test {
    private int a;

    public static void main(String[] args){
        CloneExample e1 = new CloneExample(1,2);
        test t1 = new test();
        t1.a = e1.a;
    }


}
