class Solution:
    def arrangeCoins(self, n):
        i = 1
        while n >= i:
            n -= i
            i += 1
        return i - 1