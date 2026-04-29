package string;

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
* */


import java.util.Arrays;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {

        String prefix = "";
        for (int i = 0; i < strs[0].length(); i++) {
            prefix += strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                if (!strs[i].startsWith(prefix)) {
                    return prefix.substring(0,prefix.length()-1);
                }
            }
        }
        return prefix.substring(0,prefix.length()-1);
    }

    public static String longestCommonPrefix2(String[] strs) {

        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length - 1];

        int i = 0;
        while (i < first.length() && i < last.length() && first.charAt(i) == last.charAt(i)) {
            i++;
        }

        return first.substring(0, i);

    }

    public static void main(String[] args) {
//        System.out.println(longestCommonPrefix2(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefix2(new String[]{"dog","racecar","car"}));

    }
}
