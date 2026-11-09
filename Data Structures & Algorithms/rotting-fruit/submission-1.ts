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

enum Fruit {
    NONE = 0,
    FRESH = 1,
    ROTTEN = 2,
}

const DIRECTIONS: readonly Point[] = [
    new Point(-1, 0),
    new Point(1, 0),
    new Point(0, -1),
    new Point(0, 1),
];

class Solution {
    orangesRotting(raw: number[][]): number {
        const grid = new Grid<Fruit>(raw);
        let fresh = 0;
        const rotten: Point[] = [];
        let minutes = 0;

        for (const [point, tile] of grid.items()) {
            switch (tile) {
                case Fruit.NONE:
                    break;
                case Fruit.FRESH:
                    fresh += 1;
                    break;
                case Fruit.ROTTEN:
                    rotten.push(point);
                    break;
            }
        }

        let head = 0;

        while (fresh > 0 && head < rotten.length) {
            const tail = rotten.length;

            for (; head < tail; head += 1) {
                const point = rotten[head];

                for (const delta of DIRECTIONS) {
                    const neighbor = point.offset(delta);

                    if (!grid.contains(neighbor)) {
                        continue;
                    }

                    if (grid.get(neighbor) === Fruit.FRESH) {
                        grid.set(neighbor, Fruit.ROTTEN);
                        fresh -= 1;
                        rotten.push(neighbor);
                    }
                }
            }

            minutes += 1;
        }

        if (fresh > 0) {
            return -1;
        }

        return minutes;
    }
}
