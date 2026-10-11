from functools import cache


@cache
def climb(steps: int):
    if steps <= 2:
        return steps

    return climb(steps - 1) + climb(steps - 2)


class Solution:
    def climbStairs(self, n: int) -> int:
        return climb(n)
