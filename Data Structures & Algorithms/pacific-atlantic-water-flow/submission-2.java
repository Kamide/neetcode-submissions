final class Solution {
    private record Point(
        int row,
        int column
    ) {
        Point offset(final Point delta) {
            return new Point(
                row + delta.row(),
                column + delta.column()
            );
        }
    }

    private static final class Grid {
        private final int[][] raw;

        Grid(final int[][] raw) {
            this.raw = raw;
        }

        int rows() {
            return raw.length;
        }

        int columns() {
            if (rows() == 0) {
                return 0;
            }

            return raw[0].length;
        }

        boolean contains(final Point point) {
            return (
                point.row() >= 0 &&
                point.row() < rows() &&
                point.column() >= 0 &&
                point.column() < columns()
            );
        }

        int get(final Point point) {
            return raw[point.row()][point.column()];
        }

        void set(
            final Point point,
            final int value
        ) {
            raw[point.row()][point.column()] = value;
        }
    }

    private static final List<Point> DIRECTIONS = List.of(
        new Point(-1, 0),
        new Point(1, 0),
        new Point(0, -1),
        new Point(0, 1)
    );

    private void dfs(
        final Grid grid,
        final Point point,
        final Set<Point> visited
    ) {
        if (!visited.add(point)) {
            return;
        }

        for (final var delta : DIRECTIONS) {
            final var neighbor = point.offset(delta);

            if (
                grid.contains(neighbor) &&
                grid.get(neighbor) >= grid.get(point)
            ) {
                dfs(grid, neighbor, visited);
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(final int[][] heights) {
        final var grid = new Grid(heights);
        final var pacific = new HashSet<Point>();
        final var atlantic = new HashSet<Point>();
        final var intersection = new ArrayList<List<Integer>>();

        for (var row = 0; row < grid.rows(); row += 1) {
            dfs(grid, new Point(row, 0), pacific);
            dfs(grid, new Point(row, grid.columns() - 1), atlantic);
        }

        for (var column = 0; column < grid.columns(); column += 1) {
            dfs(grid, new Point(0, column), pacific);
            dfs(grid, new Point(grid.rows() - 1, column), atlantic);
        }

        pacific.retainAll(atlantic);

        for (final var point : pacific) {
            intersection.add(List.of(point.row(), point.column()));
        }

        return intersection;
    }
}
