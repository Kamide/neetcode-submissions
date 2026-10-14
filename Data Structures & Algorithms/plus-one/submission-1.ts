class Solution {
    plusOne = (digits: number[]) => [...String(Number(digits.join("")) + 1)].map(Number);
}
