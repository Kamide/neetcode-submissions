function sumOfSquareOfDigits(n: number) {
    let sum = 0;
    for (; n; n = Math.floor(n / 10)) {
        sum += (n % 10) ** 2;
    }
    return sum;
}

class Solution {
    isHappy(n: number): boolean {
        for (let slow = n, fast = n; ; ) {
            if ((fast = sumOfSquareOfDigits(sumOfSquareOfDigits(fast))) === 1) {
                return true;
            }
            if ((slow = sumOfSquareOfDigits(slow)) === fast) {
                return false;
            }
        }
    }
}
