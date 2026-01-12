package bit;

public class CheckKthBit {

    public static void main(String[] args) {
        int n = (int)(Math.random() * 90) + 10;
        System.out.println("number:" + n);
        int k = 2;

        int res = n & (1 << k);
        int res2 = (n >> k) & 1;
        if(res2 > 0)
            System.out.println("Kth bit is set");
        else
            System.out.println("Kth bit is not set");
    }
}
