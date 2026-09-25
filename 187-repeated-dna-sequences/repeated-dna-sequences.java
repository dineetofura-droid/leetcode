class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> ans = new HashSet<>();

        for (int i = 0; i + 10 <= s.length(); i++) {
            String x = s.substring(i, i + 10);

            if (set.contains(x)) {
                ans.add(x);
            } else {
                set.add(x);
            }
        }

        return new ArrayList<>(ans);
    }
}