class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int negatives = 2;
        if (dividend > 0) {
            negatives--;
            dividend = -dividend;
        }
        if (divisor > 0) {
            negatives--;
            divisor = -divisor;
        }

        int quotient = 0;
        while (dividend <= divisor) {
            int powerOfTwo = -1;
            int value = divisor;

            while (value >= (Integer.MIN_VALUE >> 1) && dividend <= (value + value)) {
                value += value;
                powerOfTwo += powerOfTwo;
            }

            dividend -= value;
            quotient += powerOfTwo;
        }

        return negatives == 1 ? quotient : -quotient;
    }
}  
