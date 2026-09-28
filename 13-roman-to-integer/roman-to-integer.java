class Solution {
    public int romanToInt(String s) {
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            int value = 0;

            if (s.charAt(i) == 'I') value = 1;
            else if (s.charAt(i) == 'V') value = 5;
            else if (s.charAt(i) == 'X') value = 10;
            else if (s.charAt(i) == 'L') value = 50;
            else if (s.charAt(i) == 'C') value = 100;
            else if (s.charAt(i) == 'D') value = 500;
            else if (s.charAt(i) == 'M') value = 1000;

            if (i + 1 < s.length() && value < getValue(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }

        return ans;
    }

    public int getValue(char c) {
        if (c == 'I') return 1;
        if (c == 'V') return 5;
        if (c == 'X') return 10;
        if (c == 'L') return 50;
        if (c == 'C') return 100;
        if (c == 'D') return 500;
        return 1000;
    }
}