MAX_U32 = 0xffffffff
MAX_I32 = 0x7fffffff


class Solution:
    def getSum(self, a: int, b: int) -> int:
        while b:
            carry = (a & b) << 1
            a = (a ^ b) & MAX_U32
            b = carry & MAX_U32

        if a <= MAX_I32:
            return a

        return ~(a ^ MAX_U32)
