class Solution {
    public boolean isHappy(int n) {
        int count = 0;

        while (n != 1 && count < 20) {
            int sum = 0;

            while (n > 0) {
                int x = n % 10;
                sum += x * x;
                n /= 10;
            }

            n = sum;
            count++;
        }

        return n == 1;
    }
}