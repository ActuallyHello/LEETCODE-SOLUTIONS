package easy;

import java.util.List;
import java.util.Set;

public class DetermineifStringHalvesAreAlike1704 {
    public static void main(String[] args) {
        System.out.println(halvesAreAlike("textbook"));
    }

    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    public static boolean halvesAreAlike(String s) {
        int firstPart = 0;
        int secondPart = 0;

        for (int i = 0; i < s.length(); i++) {
            if (VOWELS.contains(s.charAt(i))) {
                if (i < s.length() / 2) {
                    firstPart++;
                } else {
                    secondPart++;
                }
            }
        }
        return firstPart == secondPart;
    }
}
