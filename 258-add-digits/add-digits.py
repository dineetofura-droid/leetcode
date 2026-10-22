class Solution:
    def addDigits(self, num):
        while num >= 10:
            num = sum(int(c) for c in str(num))
        return num