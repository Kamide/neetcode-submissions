class Climber {
    cache = new Map<number, number>();

    constructor(public cost: number[]) {}

    climb(step: number) {
        if (step >= this.cost.length) {
            return 0;
        }

        let total = this.cache.get(step);

        if (total == null) {
            total = this.cost[step] + Math.min(this.climb(step + 1), this.climb(step + 2));
            this.cache.set(step, total);
        }

        return total;
    }
}

class Solution {
    minCostClimbingStairs(cost: number[]): number {
        const climber = new Climber(cost);
        return Math.min(climber.climb(0), climber.climb(1));
    }
}
