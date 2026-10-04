class Solution {
    public int minRotations(String s) {
        int ans = 0;
        int cur = 0;

        for (char ch : s.toCharArray()) {
            int next = ch - '0';

            int diff = Math.abs(cur - next);
            ans += Math.min(diff, 10 - diff);

            cur = next;
        }

        return ans;
    }
}