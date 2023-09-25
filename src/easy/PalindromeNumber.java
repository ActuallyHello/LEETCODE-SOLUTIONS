package easy;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(123));
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(1001));
        System.out.println(isPalindrome(100154));
        System.out.println(isPalindrome(1));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        int result = 0;
        int bufX = x;
        while (bufX > 0) {
            result = result * 10 + bufX % 10;
            bufX /= 10;
        }
        return x == result;
    }

}
