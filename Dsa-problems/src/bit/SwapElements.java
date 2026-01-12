package bit;

public class SwapElements {

    public static void main(String[] args) {


        int a = 5;
        int b = 6;

        a = a ^ b;
        System.out.println(a);
        b = a ^ b;
        a = a^ b;
        System.out.println("a:" + a + " b:"+b);

    }
}
