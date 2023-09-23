package medium;

public class StringToIntegerAtoi {
    public static void main(String[] args) {
//        System.out.println(myAtoi("123"));
//        System.out.println(myAtoi("   123"));
//        System.out.println(myAtoi("   -123"));
//        System.out.println(myAtoi("   -123 abc"));
//        System.out.println(myAtoi("   -a123 abc"));
//        System.out.println(myAtoi("   -1b23 abc"));
//        System.out.println(myAtoi("   -123-"));
//        System.out.println(myAtoi("1111111111111111111111"));
//        System.out.println(myAtoi("-1111111111111111111111"));
//        System.out.println(myAtoi("--1111111111111111111111"));
//        System.out.println(myAtoi("-111.1111111111111111111"));
//        System.out.println(myAtoi("00000-42a1234"));
//        System.out.println(myAtoi("9223372036854775808"));
//        System.out.println(myAtoi("21474836460"));
//        System.out.println(myAtoi("-2147483647"));
        System.out.println(myAtoi("  +  413"));
    }

    public static int myAtoi(String s) {
        boolean isPositive = true;
        boolean isAlreadyReadSign = false;
        boolean isAlreadyReadNumber = false;
        long result = 0;
        for (char letter : s.toCharArray()) {
            if (Character.isDigit(letter)) {
                result = result * 10 + Character.getNumericValue(letter);
                isAlreadyReadNumber = true;
                if (isPositive) {
                    if (result >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
                } else {
                    if (-result <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
                }
            } else {
                if (letter == ' ') {
                    if (isAlreadyReadNumber) break;
                    if (isAlreadyReadSign) break;
                } else if (letter == '-') {
                    if (isAlreadyReadNumber) break;
                    if (isAlreadyReadSign) break;
                    else {
                        isPositive = false;
                        isAlreadyReadSign = true;
                    }
                } else if (letter == '+') {
                    if (isAlreadyReadNumber) break;
                    if (isAlreadyReadSign) break;
                    isAlreadyReadSign = true;
                } else {
                    break;
                }
            }
        }
        if (!isPositive) result = -result;
        return (int) result;
    }
}
