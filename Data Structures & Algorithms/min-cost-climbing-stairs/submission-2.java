class Solution {
    public int minCostClimbingStairs(int[] cost) {
        var topStep = cost.length;
        var minCost = new int[topStep + 1];

        for (var step = 2; step <= topStep; step += 1) {
            var costFromOneStepBelow = cost[step - 1] + minCost[step - 1];
            var costFromTwoStepsBelow = cost[step - 2] + minCost[step - 2];
            minCost[step] = Math.min(costFromOneStepBelow, costFromTwoStepsBelow);
        }

        return minCost[topStep];
    }
}