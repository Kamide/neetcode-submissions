class Point {
    constructor(
        public readonly row: number,
        public readonly column: number,
    ) {
    }

    offset(delta: Point): Point {
        return new Point(this.row + delta.row, this.column + delta.column);
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

    * items(): Generator<[Point, T], void, void> {
        for (let row = 0; row < this.rows; row += 1) {
            for (let column = 0; column < this.columns; column += 1) {
                const point = new Point(row, column);
                yield [point, this.get(point)];
            }
        }
    }
}

const Tile = {
    WATER: -1,
    TREASURE: 0,
    LAND: 2 ** 31 - 1,
} as const;

const DIRECTIONS = [
    new Point(-1, 0),
    new Point(1, 0),
    new Point(0, -1),
    new Point(0, 1),
] as const satisfies Point[];

class Solution {
    islandsAndTreasure(raw: number[][]): void {
        const grid = new Grid(raw);
        const queue: Point[] = [];

        for (const [point, tile] of grid.items()) {
            if (tile === Tile.TREASURE) {
                queue.push(point);
            }
        }

        for (let head = 0; head < queue.length; head += 1) {
            const point = queue[head];
            const distance = grid.get(point);

            for (const delta of DIRECTIONS) {
                const neighbor = point.offset(delta);

                if (!grid.contains(neighbor)) {
                    continue;
                }

                if (grid.get(neighbor) === Tile.LAND) {
                    grid.set(neighbor, distance + 1);
                    queue.push(neighbor);
                }
            }
        }
    }
}
