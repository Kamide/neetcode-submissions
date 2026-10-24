class Solution {
    private static class Task {
        final char id;
        int count = 0;

        Task(final char id) {
            this.id = id;
        }
    }

    private record Cooldown(Task task, int expiry) {
    }

    public int leastInterval(final char[] tasks, final int n) {
        final var taskMap = new HashMap<Character, Task>();

        for (final var task : tasks) {
            taskMap.computeIfAbsent(task, Task::new).count += 1;
        }

        final var maxHeap = new PriorityQueue<>(
            Comparator
                .comparingInt((Task task) -> task.count)
                .reversed()
        );

        maxHeap.addAll(taskMap.values());

        final var cooldownQueue = new ArrayDeque<Cooldown>();
        var time = 0;

        while (!maxHeap.isEmpty() || !cooldownQueue.isEmpty()) {
            time += 1;

            while (!cooldownQueue.isEmpty() && cooldownQueue.peek().expiry() <= time) {
                maxHeap.offer(cooldownQueue.poll().task());
            }

            if (!maxHeap.isEmpty()) {
                final var task = maxHeap.poll();

                task.count -= 1;

                if (task.count > 0) {
                    cooldownQueue.offer(new Cooldown(task, time + n + 1));
                }
            }
        }

        return time;
    }
}
