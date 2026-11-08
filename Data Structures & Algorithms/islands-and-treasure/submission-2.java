final class Solution {
    private record Point(
        int row,
        int column
    ) {
        Point offset(Point delta) {
            return new Point(row + delta.row(), column + delta.column());
        }
    }

    private static final class Grid {
        private final int[][] raw;

        Grid(int[][] raw) {
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

        boolean contains(Point point) {
            return (
                point.row() >= 0 &&
                point.row() < rows() &&
                point.column() >= 0 &&
                point.column() < columns()
            );
        }

        int get(Point point) {
            return raw[point.row()][point.column()];
        }

        void set(Point point, int value) {
            raw[point.row()][point.column()] = value;
        }
    }

    private static final class Tile {
        static final int WATER = -1;
        static final int TREASURE = 0;
        static final int LAND = Integer.MAX_VALUE;
    }

    private static final List<Point> DIRECTIONS = List.of(
        new Point(-1, 0),
        new Point(1, 0),
        new Point(0, -1),
        new Point(0, 1)
    );

    public void islandsAndTreasure(final int[][] raw) {
        final var grid = new Grid(raw);
        final var queue = new ArrayDeque<Point>();

        for (var row = 0; row < grid.rows(); row += 1) {
            for (var column = 0; column < grid.columns(); column += 1) {
                final var point = new Point(row, column);
                final var tile = grid.get(point);

                if (tile == Tile.TREASURE) {
                    queue.addLast(point);
                }
            }
        }

        while (!queue.isEmpty()) {
            final var point = queue.removeFirst();
            final var distance = grid.get(point);

            for (final var delta : DIRECTIONS) {
                final var neighbor = point.offset(delta);

                if (!grid.contains(neighbor)) {
                    continue;
                }

                if (grid.get(neighbor) == Tile.LAND) {
                    grid.set(neighbor, distance + 1);
                    queue.addLast(neighbor);
                }
            }
        }
    }
}
