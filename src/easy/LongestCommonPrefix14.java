package easy;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonPrefix14 {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder stringBuilder = new StringBuilder();
        String result = "";
        List<String> prefixes = new ArrayList<>();
        for (char s : strs[0].toCharArray()) {
            stringBuilder.append(s);
            prefixes.add(stringBuilder.toString());
        }
        result = prefixes.get(prefixes.size() - 1);
        for (int i = 1; i < strs.length; i++) {
            stringBuilder = new StringBuilder();
            for (char s : strs[i].toCharArray()) {
                stringBuilder.append(s);
                if (prefixes.contains(stringBuilder.toString())) {
                    result = stringBuilder.toString();
                } else {
                    return result;
                }
            }
        }
        return result;
    }
}
