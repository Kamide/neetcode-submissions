class Solution {
    private static class TrieNode {
        final Map<Integer, TrieNode> children = new HashMap<>();
        String word;

        void remove(final int codePoint) {
            final var child = children.get(codePoint);

            if (child != null && child.children.isEmpty() && child.word == null) {
                children.remove(codePoint);
            }
        }
    }

    private static class Trie {
        final TrieNode root = new TrieNode();

        void add(final String word) {
            var node = root;

            for (final var iterator = word.codePoints().iterator(); iterator.hasNext(); ) {
                node = node.children.computeIfAbsent(
                    iterator.nextInt(),
                    codePoint -> new TrieNode()
                );
            }

            node.word = word;
        }
    }

    private record Point(int row, int column) {
        static final Point[] DIRECTIONS = {
            new Point(-1, 0),
            new Point(1, 0),
            new Point(0, -1),
            new Point(0, 1),
        };

        Point add(final Point other) {
            return new Point(
                row + other.row,
                column + other.column
            );
        }
    }

    private record Matrix(char[][] board) {
        int rows() {
            return board.length;
        }

        int columns() {
            return rows() == 0 ? 0 : board[0].length;
        }

        boolean isEmpty() {
            return rows() == 0 || columns() == 0;
        }

        Stream<Cell> cells() {
            return IntStream
                .range(0, rows())
                .boxed()
                .flatMap(row ->
                    IntStream
                        .range(0, columns())
                        .mapToObj(column ->
                            new Cell(this, new Point(row, column))
                        )
                );
        }
    }

    private record Cell(Matrix matrix, Point point) {
        int row() {
            return point.row();
        }

        int column() {
            return point.column();
        }

        int value() {
            return matrix.board()[row()][column()];
        }

        boolean outOfBounds() {
            return row() < 0
                || row() >= matrix.rows()
                || column() < 0
                || column() >= matrix.columns();
        }

        Cell add(final Point direction) {
            return new Cell(matrix, point.add(direction));
        }
    }

    private enum Phase {
        ENTER,
        EXPLORE,
        EXIT,
    }

    private record Frame(
        Cell cell,
        TrieNode parent,
        TrieNode node,
        int direction,
        Phase phase
    ) {
    }

    public List<String> findWords(final char[][] board, final String[] words) {
        final var found = new ArrayList<String>();
        final var matrix = new Matrix(board);

        if (matrix.isEmpty()) {
            return found;
        }

        final var trie = new Trie();

        for (final var word : words) {
            trie.add(word);
        }

        final var visited = new HashSet<Point>();
        final var stack = new ArrayDeque<Frame>();

        for (final var iterator = matrix.cells().iterator(); iterator.hasNext(); ) {
            final var startingCell = iterator.next();
            final var startingNode = trie.root.children.get(startingCell.value());

            if (startingNode == null) {
                continue;
            }

            stack.push(new Frame(
                startingCell,
                trie.root,
                startingNode,
                0,
                Phase.ENTER
            ));

            while (!stack.isEmpty()) {
                final var frame = stack.pop();
                final var cell = frame.cell();
                final var parent = frame.parent();
                final var node = frame.node();
                final var direction = frame.direction();

                switch (frame.phase()) {
                    case ENTER -> {
                        if (!visited.add(cell.point())) {
                            continue;
                        }

                        if (node.word != null) {
                            found.add(node.word);
                            node.word = null;
                        }

                        stack.push(new Frame(
                            cell,
                            parent,
                            node,
                            0,
                            Phase.EXPLORE
                        ));
                    }
                    case EXIT -> {
                        visited.remove(cell.point());

                        if (node.children.isEmpty() && node.word == null) {
                            parent.remove(cell.value());
                        }
                    }
                    case EXPLORE -> {
                        if (direction == Point.DIRECTIONS.length) {
                            stack.push(new Frame(
                                cell,
                                parent,
                                node,
                                0,
                                Phase.EXIT
                            ));

                            continue;
                        }

                        stack.push(new Frame(
                            cell,
                            parent,
                            node,
                            direction + 1,
                            Phase.EXPLORE
                        ));

                        final var nextCell = cell.add(Point.DIRECTIONS[direction]);

                        if (nextCell.outOfBounds() || visited.contains(nextCell.point())) {
                            continue;
                        }

                        final var nextNode = node.children.get(nextCell.value());

                        if (nextNode != null) {
                            stack.push(new Frame(
                                nextCell,
                                node,
                                nextNode,
                                0,
                                Phase.ENTER
                            ));
                        }
                    }
                }
            }

            if (trie.root.children.isEmpty()) {
                return found;
            }
        }

        return found;
    }
}
