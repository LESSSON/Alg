package Test;

public class CloneExample {
    protected int a;
    private int b;

    public CloneExample(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneExample e1 = new CloneExample(1, 2);
        CloneExample e2 = new CloneExample(3, 4);
        e2.a = e1.a;
        e2.b = e1.b;


        System.out.println(e2.a);

    }
}


