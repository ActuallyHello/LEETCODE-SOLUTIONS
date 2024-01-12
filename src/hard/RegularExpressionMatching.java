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
                } else if (pattern.charAt(0) == '.' || pattern.charAt(0) == s.charAt(index)) {
                    index++;
                } else {
                    return false;
                }
            } else if (".*".equals(starPattern)) {
                if (patternDeque.size() == 1) { // only mock available
                    return true;
                }
                String nextPattern = patternDeque.peek();
                if (".*".equals(nextPattern)) {
                    patternDeque.pollFirst();
                } else if (nextPattern.charAt(0) == '.') {
                    if (patternDeque.size() == 2) { // mock(.*) and nextPattern('.') => any string
                        return true;
                    } else {
                        starPattern = "";
                        patternDeque.pollLast(); // delete mock
                    }
                }


                else if (nextPattern.contains("*")) {
                    if (s.charAt(index) != nextPattern.charAt(0)) {
                        index++;
                    } else {
                        starPattern = "";
                        patternDeque.pollLast(); // delete mock
                    }
                } else if (nextPattern.charAt(0) == '.') {

                } else if (nextPattern.charAt(0) != s.charAt(index)) {
                    index++;
                } else {
                    starPattern = "";
                    patternDeque.pollLast(); // delete mock
                }
            } else { // star pattern like [a-z]*
                if (patternDeque.size() == 1) { // only mock available
                    if (s.charAt(index) == starPattern.charAt(0)) {
                        index++;
                    } else {
                        return false;
                    }
                } else {
                    String nextPattern = patternDeque.peek();

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
