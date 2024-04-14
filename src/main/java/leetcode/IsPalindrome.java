package leetcode;

public class IsPalindrome {
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            System.out.println(revertedNumber);
            System.out.println(x);
            x /= 10;
        }
        System.out.println(x == revertedNumber || x == revertedNumber / 10);
        return x == revertedNumber;
    }

    public static void main(String[] args) {
        isPalindrome(121);
    }
}
