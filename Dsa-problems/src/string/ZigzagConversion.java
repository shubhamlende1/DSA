package string;

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);


Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
Example 3:

Input: s = "A", numRows = 1
Output: "A"

* */
public class ZigzagConversion {


    public static String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }
        StringBuilder res = new StringBuilder();
        int cycle = 2 * numRows -2;
        for(int i =0 ; i < numRows; i++) {
            for (int j = i; j < s.length(); j+=cycle) {
                res.append(s.charAt(j));

                // diagonal element missing
                // 0 + 4 - 0 = 4
                int dig = j + cycle - 2 * i;
                System.out.println("i: "+i +"  j: "+j + " dig:" +dig);
                if(i != 0 && i != numRows - 1 && dig < s.length()) {
                    System.out.println("correect dig: "+ dig);
                    res.append(s.charAt(dig));
                }
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",3));
    }
}
