class Solution {
    private static final char LAND = '1';

    private static final int[][] DIRECTIONS = {
        {-1, 0}, // up
        {1, 0}, // down
        {0, -1}, // left
        {0, 1}, // right
    };

    private record Point(int row, int column) {
        public char at(final char[][] grid) {
            return grid[row][column];
        }

        public boolean outOfBounds(final char[][] grid) {
            return row < 0
                || row >= grid.length
                || column < 0
                || column >= grid[0].length;
        }
    }

    public int numIslands(final char[][] grid) {
        var count = 0;

        final var rows = grid.length;
        final var columns = grid[0].length;
        final var visited = new HashSet<Point>();

        for (var row = 0; row < rows; row += 1) {
            for (var column = 0; column < columns; column += 1) {
                final var origin = new Point(row, column);

                if (origin.at(grid) != LAND
                    || !visited.add(origin)) {
                    continue;
                }

                count += 1;

                final var stack = new ArrayDeque<Point>();

                stack.push(origin);

                while (!stack.isEmpty()) {
                    final var current = stack.pop();

                    for (var direction : DIRECTIONS) {
                        final var next = new Point(
                            current.row + direction[0],
                            current.column + direction[1]
                        );

                        if (next.outOfBounds(grid)
                            || next.at(grid) != LAND
                            || !visited.add(next)) {
                            continue;
                        }

                        stack.push(next);
                    }
                }
            }
        }

        return count;
    }
}
