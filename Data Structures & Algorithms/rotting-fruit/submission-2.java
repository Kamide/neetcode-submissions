final class Solution {
    private record Point(
        int row,
        int column
    ) {
        Point offset(final Point delta) {
            return new Point(row + delta.row(), column + delta.column());
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

        void set(final Point point, final int value) {
            raw[point.row()][point.column()] = value;
        }
    }

    private static final class Fruit {
        static final int NONE = 0;
        static final int FRESH = 1;
        static final int ROTTEN = 2;
    }

    private static final List<Point> DIRECTIONS = List.of(
        new Point(-1, 0),
        new Point(1, 0),
        new Point(0, -1),
        new Point(0, 1)
    );

    public int orangesRotting(final int[][] raw) {
        final var grid = new Grid(raw);
        final var fresh = new HashSet<Point>();
        final var rotten = new ArrayDeque<Point>();
        var minutes = 0;

        for (var row = 0; row < grid.rows(); row += 1) {
            for (var column = 0; column < grid.columns(); column += 1) {
                final var point = new Point(row, column);
                final var tile = grid.get(point);

                switch (tile) {
                    case Fruit.NONE -> {}
                    case Fruit.FRESH -> fresh.add(point);
                    case Fruit.ROTTEN -> rotten.addLast(point);
                }
            }
        }

        while (!fresh.isEmpty() && !rotten.isEmpty()) {
            final var tail = rotten.size();

            for (var head = 0; head < tail; head += 1) {
                final var point = rotten.removeFirst();

                for (final var delta : DIRECTIONS) {
                    final var neighbor = point.offset(delta);

                    if (!grid.contains(neighbor)) {
                        continue;
                    }

                    if (grid.get(neighbor) == Fruit.FRESH) {
                        grid.set(neighbor, Fruit.ROTTEN);
                        fresh.remove(neighbor);
                        rotten.addLast(neighbor);
                    }
                }
            }

            minutes += 1;
        }

        if (!fresh.isEmpty()) {
            return -1;
        }

        return minutes;
    }
}
