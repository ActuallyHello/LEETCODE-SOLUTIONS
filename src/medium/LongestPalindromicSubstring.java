package medium;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
//        System.out.println(longestPalindrome("babad"));
//        System.out.println(longestPalindrome("cbbd"));

    }

    public static String longestPalindrome(String s) {
        if (s.length() == 1) return s;

        StringBuilder palindromeBuilder = new StringBuilder();
        String longestPalindrom = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                palindromeBuilder.append(s.charAt(j));
                if (isPalindrome(palindromeBuilder) && longestPalindrom.length() < palindromeBuilder.length()) {
                    longestPalindrom = palindromeBuilder.toString();
                }
            }
            if (longestPalindrom.length() > s.length() - i) return longestPalindrom;
            palindromeBuilder.setLength(0);
        }
        return longestPalindrom;
    }

    static boolean isPalindrome(StringBuilder sb) {
        int first = 0;
        int last = sb.length() - 1;
        while (first <= last && sb.charAt(first) == sb.charAt(last)) {
            first++;
            last--;
        }
        return first >= last;
    }
}
