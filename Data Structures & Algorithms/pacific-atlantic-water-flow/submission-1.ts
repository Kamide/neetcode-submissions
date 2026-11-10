function* range(length: number): Generator<number, void, void> {
    for (let index = 0; index < length; index += 1) {
        yield index;
    }
}

class Point {
    private static cache = new Map<string, Point>();

    static from(row: number, column: number) {
        const key = `${row},${column}`;
        let point = this.cache.get(key);
        if (point == null) {
            point = new Point(row, column);
            this.cache.set(key, point);
        }
        return point;
    }

    private constructor(
        public readonly row: number,
        public readonly column: number,
    ) {
    }

    offset(delta: Point): Point {
        return Point.from(this.row + delta.row, this.column + delta.column);
    }
}

class Grid<T> {
    constructor(public readonly raw: T[][]) {
    }

    get rows(): number {
        return this.raw.length;
    }

    get columns(): number {
        return this.raw.at(0)?.length ?? 0;
    }

    contains(point: Point): boolean {
        return (
            point.row >= 0 &&
            point.row < this.rows &&
            point.column >= 0 &&
            point.column < this.columns
        );
    }

    get(point: Point): T {
        return this.raw[point.row][point.column];
    }

    set(point: Point, value: T): void {
        this.raw[point.row][point.column] = value;
    }
}

const DIRECTIONS: readonly Point[] = [
    Point.from(-1, 0),
    Point.from(1, 0),
    Point.from(0, -1),
    Point.from(0, 1),
];

class Solution {
    pacificAtlantic(heights: number[][]): number[][] {
        const grid = new Grid(heights);
        const pacific = new Set<Point>();
        const atlantic = new Set<Point>();

        function dfs(point: Point, visited: Set<Point>): void {
            if (visited.has(point)) {
                return;
            }

            visited.add(point);

            for (const delta of DIRECTIONS) {
                const neighbor = point.offset(delta);

                if (grid.contains(neighbor) && grid.get(neighbor) >= grid.get(point)) {
                    dfs(neighbor, visited);
                }
            }
        }

        for (const row of range(grid.rows)) {
            dfs(Point.from(row, 0), pacific);
            dfs(Point.from(row, grid.columns - 1), atlantic);
        }

        for (const column of range(grid.columns)) {
            dfs(Point.from(0, column), pacific);
            dfs(Point.from(grid.rows - 1, column), atlantic);
        }

        return [...pacific]
            .filter((point) => atlantic.has(point))
            .map((point) => [point.row, point.column]);
    }
}
