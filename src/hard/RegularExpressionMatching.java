package hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class RegularExpressionMatching {

    public static void main(String[] args) {
        isMatch("aaa", "a");
        isMatch("aaa", "aa");
        isMatch("aaa", "a*");
        isMatch("aaa", "aa*");
        isMatch("aaa", "a*a.*");
    }

    public static boolean isMatch(String s, String p) {
        if (".*".equals(p)) return true;

        var patternDeque = collectPatternsToDeque(p);
        System.out.println(patternDeque);

        int index = 0;
        String starPattern = "";
        while (index < s.length() && !patternDeque.isEmpty()) {
            if (starPattern.isEmpty()) {
                String pattern = patternDeque.pollFirst();
                if (pattern.contains("*")) {
                    starPattern = pattern;
                    patternDeque.add(null); // mock the pattern to continue
                    continue;
                } else if (pattern.charAt(0) == '.' || pattern.charAt(0) == s.charAt(index)) {
                    index++;
                } else {
                    return false;
                }
            } else if (".*".equals(starPattern)) {
                if (patternDeque.size() == 1) { // only mock available
                    return true;
                } else {
                    String peekPattern = patternDeque.peek();
                    if (".*".equals(peekPattern)) {
                        patternDeque.pollFirst();
                        continue;
                    } else if (peekPattern.contains("*")) {

                    }
                }
            }
        }
        return false;
    }

    public static Deque<String> collectPatternsToDeque(String pattern) {
        Deque<String> patternDeque = new ArrayDeque<>();
        int index = 0;
        while (index < pattern.length()) {
            if (index + 1 < pattern.length() && '*' == pattern.charAt(index+1)) {
                patternDeque.add(
                        String.valueOf(pattern.charAt(index)) + pattern.charAt(index + 1)
                );
                index += 2;
            } else {
                patternDeque.add(String.valueOf(pattern.charAt(index)));
                index++;
            }
        }
        return patternDeque;
    }
}
