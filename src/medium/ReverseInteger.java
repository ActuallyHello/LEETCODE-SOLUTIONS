package medium;

public class ReverseInteger {
    public static void main(String[] args) {
//        System.out.println(reverse(123));
//        System.out.println(reverse(321));
//        System.out.println(reverse(-321));
//        System.out.println(reverse(-123));
//        System.out.println();
//        System.out.println(reverse(1));
//        System.out.println(reverse(0));
//        System.out.println(reverse(1000));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(reverse(Integer.MAX_VALUE));
        System.out.println(reverse(2111111111));
        System.out.println(reverse(2147447412));
//        System.out.println(reverse(2111111113));
    }

    public static int reverse(int x) {
        boolean isPositive = x >= 0;
        if (!isPositive) x = -x;

        int result = 0;
        while (x > 0) {
            if (result > Integer.MAX_VALUE/10 || result < Integer.MIN_VALUE/10) return 0;
            result = result * 10 + x % 10;
            x /= 10;
        }
        return isPositive ? result : -result;
    }
}
