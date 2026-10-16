class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        int[] targetFreq = new int[128];
        for (char c : t.toCharArray()) {
            targetFreq[c]++;
        }

        int left = 0;
        int right = 0;
        int required = t.length();
        int minLen = Integer.MAX_VALUE;
        int startIdx = 0;

        while (right < s.length()) {
            char rightChar = s.charAt(right);

        
            if (targetFreq[rightChar] > 0) {
                required--;
            }
            targetFreq[rightChar]--;
            right++;

            
            while (required == 0) {
                int currentLen = right - left;
                if (currentLen < minLen) {
                    minLen = currentLen;
                    startIdx = left;
                }

                char leftChar = s.charAt(left);
                targetFreq[leftChar]++;

               
                if (targetFreq[leftChar] > 0) {
                    required++;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIdx, startIdx + minLen);
    }
}
