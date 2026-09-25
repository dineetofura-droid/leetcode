import java.util.*;

class Solution {
    public String longestDupSubstring(String s) {
        int low = 1;
        int high = s.length() - 1;
        String ans = "";

        while (low <= high) {
            int mid = (low + high) / 2;
            String x = check(s, mid);

            if (!x.equals("")) {
                ans = x;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public String check(String s, int len) {
        HashMap<Long, Integer> map = new HashMap<>();

        long hash = 0;
        long power = 1;
        long base = 31;

        for (int i = 0; i < len; i++) {
            hash = hash * base + s.charAt(i);
            power = power * base;
        }

        map.put(hash, 0);

        for (int i = len; i < s.length(); i++) {
            hash = hash * base + s.charAt(i);
            hash = hash - power * s.charAt(i - len);

            if (map.containsKey(hash)) {
                int start = map.get(hash);

                boolean same = true;

                for (int j = 0; j < len; j++) {
                    if (s.charAt(start + j) != s.charAt(i - len + 1 + j)) {
                        same = false;
                        break;
                    }
                }

                if (same)
                    return s.substring(i - len + 1, i + 1);
            }

            map.put(hash, i - len + 1);
        }

        return "";
    }
}