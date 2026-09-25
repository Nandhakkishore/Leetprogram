class Solution {
    public int myAtoi(String s) {
        int index = 0, n = s.length();
        
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }
        
        if (index == n) return 0;
        
        int sign = 1;
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            sign = s.charAt(index) == '+' ? 1 : -1;
            index++;
        }
        
        int res = 0;
        while (index < n && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';
            
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            res = res * 10 + digit;
            index++;
        }
        
        return res * sign;
    }
}
