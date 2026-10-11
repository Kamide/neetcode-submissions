class Solution {
    private final Map<Integer, Integer> cache = new HashMap<>();

    public int climbStairs(int n) {
        return climb(n);
    }

    private int climb(final int steps) {
        if (steps <= 2) {
            return steps;
        }

        var permutations = cache.get(steps);

        if (permutations == null) {
            permutations = climb(steps - 1) + climb(steps - 2);
            cache.put(steps, permutations);
        }

        return permutations;
    }
}