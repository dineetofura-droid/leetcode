class Solution {
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;

        for (int i = left; i <= right; i++) {
            int x = i;
            int count = 0;

            while (x > 0) {
                count += x & 1;
                x = x >> 1;
            }

            if (isPrime(count))
                ans++;
        }

        return ans;
    }

    boolean isPrime(int n) {
        if (n < 2)
            return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }
}