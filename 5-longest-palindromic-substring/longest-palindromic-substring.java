class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int max = 1;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {

                int left = i;
                int right = j;
                boolean ok = true;

                while (left < right) {
                    if (s.charAt(left) != s.charAt(right)) {
                        ok = false;
                        break;
                    }
                    left++;
                    right--;
                }

                if (ok && j - i + 1 > max) {
                    start = i;
                    max = j - i + 1;
                }
            }
        }

        return s.substring(start, start + max);
    }
}