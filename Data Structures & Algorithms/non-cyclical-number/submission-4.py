def sum_of_square_of_digits(number: int) -> int:
    return sum(int(digit) ** 2 for digit in str(number))


class Solution:
    def isHappy(self, number: int) -> bool:
        slow = fast = number
        while True:
            if (fast := sum_of_square_of_digits(sum_of_square_of_digits(fast))) == 1:
                return True
            if (slow := sum_of_square_of_digits(slow)) == fast:
                return False
