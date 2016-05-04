/* Implement pow(x, n). */

public class Solution {
    public double myPow(double x, int n) {
        if (n < 0) return 1/x * myPow(1/x, -(n + 1));
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n % 2 == 0) return myPow(x * x, n / 2);
        return x * myPow(x * x, n / 2);
    }
}
