const cache = new Map<number, number>();

const climb = (steps: number) => {
    if (steps <= 2) {
        return steps;
    }

    let permutations = cache.get(steps);
    if (permutations != null) {
        return permutations;
    }

    permutations = climb(steps - 1) + climb(steps - 2);
    cache.set(steps, permutations);
    return permutations;
};

class Solution {
    climbStairs = (n: number) => climb(n);
}
