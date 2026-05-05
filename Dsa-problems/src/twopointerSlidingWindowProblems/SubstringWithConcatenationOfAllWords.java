package twopointerSlidingWindowProblems;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SubstringWithConcatenationOfAllWords {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        if (s == null || s.isEmpty() || words == null || words.length == 0) {
            return result;
        }

        int wordL = words[0].length();
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for(int i = 0 ; i< wordL; i++) {
            int left = i;
            int count = 0;
            Map<String, Integer> seen = new HashMap<>();
            for (int right = i; right + wordL <= s.length(); right+=wordL) {
                String word = s.substring(right, right+wordL);

                if(wordCount.containsKey(word)) {
                    seen.put(word,seen.getOrDefault(word,0)+1);
                    count++;

                    while (seen.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left+wordL);
                        seen.put(leftWord,seen.get(leftWord) - 1);
                        left+=wordL;
                        count--;
                    }

                    if(count == words.length) {
                        result.add(left);
                    }
                } else {
                    seen.clear();
                    count = 0;
                    left= right + wordL;
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findSubstring("barfoothefoobarman",new String[]{"foo","bar"}));
    }
}
