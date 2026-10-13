class Solution {
    lastStoneWeight(stones: number[]): number {
        stones.sort((a, b) => a - b);

        while (stones.length >= 2) {
            const heaviest = stones.pop()!;
            const secondHeaviest = stones.pop()!;
            const remainingWeight = heaviest - secondHeaviest;

            if (remainingWeight <= 0) {
                continue;
            }

            let left = 0;
            let right = stones.length;

            while (left < right) {
                const mid = Math.floor((left + right) / 2);

                if (stones[mid] <= remainingWeight) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            stones.splice(left, 0, remainingWeight);
        }

        return stones[0] ?? 0;
    }
}
