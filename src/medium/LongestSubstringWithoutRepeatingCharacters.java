package medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
//        System.out.println(lengthOfLongestSubstring(" "));
//        System.out.println(lengthOfLongestSubstring("au"));
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) return 1;
        int maximumSubstring = 0;
        Set<Character> usedLetters = new HashSet<>();

        int leftPointer = 0;
        for (int rightPointer = 0; rightPointer < s.length(); rightPointer++) {
            if (!usedLetters.contains(s.charAt(rightPointer))) {
                usedLetters.add(s.charAt(rightPointer));
                maximumSubstring = Math.max(maximumSubstring, usedLetters.size());
            } else {
                while (usedLetters.contains(s.charAt(rightPointer))) {
                    usedLetters.remove(s.charAt(leftPointer));
                    leftPointer++;
                }
                usedLetters.add(s.charAt(rightPointer));
            }
        }
        return maximumSubstring;
    }
}
