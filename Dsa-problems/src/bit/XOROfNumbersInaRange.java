package bit;

/*
   Problem Statement: Given two integers L and R return the XOR of elements of the range [L, R].

       Input: L = 4, R = 8
       Output: 8
       Explanation: The XOR of all numbers from 4 to 8 is: 4^5^6^7^8 = 8

       Input: L = 3, R = 19
       Output: 3
       Explanation: The XOR of all numbers from 3 to 19 is: 3
   * */
public class XOROfNumbersInaRange {

    /*
     xor till N number

     1  ->  1
     2  ->  3
     3  ->  0
     4  ->  4

     5  -> 1
     6  -> 7
     7 -> 0
     8 -> 8

    * */
    public static int xorTill(int n) {
        int result = 0;
        if(n % 4 == 1) result = 1;
        else if(n % 4 == 2) result = n +1;
        else if(n % 4 == 0) result = n;
        return result;
    }

    public static int xorTill(int L, int R) {
        return xorTill(R) ^ xorTill(L - 1);
    }

    public static void main(String[] args) {

        System.out.println(xorTill(3, 19));

    }
}
