class Solution {
    leastInterval(tasks: string[], n: number): number {
        const counts = new Map<string, number>();

        for (const task of tasks) {
            counts.set(task, (counts.get(task) ?? 0) + 1);
        }

        const maxCount = Math.max(...counts.values());

        const maxCountTasks = [...counts.values()].filter((count) => count === maxCount).length;

        return Math.max(tasks.length, (maxCount - 1) * (n + 1) + maxCountTasks);
    }
}
