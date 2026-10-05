class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int max = 0;

        java.util.Stack<Integer> st = new java.util.Stack<>();

        for (int i = 0; i <= n; i++) {
            int curr = (i == n) ? 0 : heights[i];

            while (!st.isEmpty() && heights[st.peek()] > curr) {
                int h = heights[st.pop()];
                int width;

                if (st.isEmpty())
                    width = i;
                else
                    width = i - st.peek() - 1;

                max = Math.max(max, h * width);
            }

            st.push(i);
        }

        return max;
    }
}