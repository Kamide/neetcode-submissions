from collections import deque
from dataclasses import dataclass
from enum import IntEnum
from typing import Generator, NamedTuple


class Point(NamedTuple):
    row: int
    column: int

    def offset(self, delta: Point) -> Point:
        return Point(self.row + delta.row, self.column + delta.column)


@dataclass
class Grid[T]:
    raw: list[list[T]]

    @property
    def rows(self) -> int:
        return len(self.raw)

    @property
    def columns(self) -> int:
        try:
            return len(self.raw[0])
        except IndexError:
            return 0

    def contains(self, point: Point) -> bool:
        return 0 <= point.row < self.rows and 0 <= point.column < self.columns

    def get(self, point: Point) -> T:
        return self.raw[point.row][point.column]

    def set(self, point: Point, value: T) -> None:
        self.raw[point.row][point.column] = value

    def items(self) -> Generator[tuple[Point, T], None, None]:
        for row in range(self.rows):
            for column in range(self.columns):
                point = Point(row, column)
                yield point, self.get(point)


class Fruit(IntEnum):
    NONE = 0
    FRESH = 1
    ROTTEN = 2


DIRECTIONS = [
    Point(-1, 0),
    Point(1, 0),
    Point(0, -1),
    Point(0, 1),
]


class Solution:
    def orangesRotting(self, raw: list[list[int]]) -> int:
        grid = Grid[Fruit](raw)
        fresh = set[Point]()
        rotten = deque[Point]()
        minutes = 0

        for point, tile in grid.items():
            match tile:
                case Fruit.NONE:
                    continue
                case Fruit.FRESH:
                    fresh.add(point)
                case Fruit.ROTTEN:
                    rotten.append(point)

        while fresh and rotten:
            for _ in range(len(rotten)):
                point = rotten.popleft()

                for delta in DIRECTIONS:
                    neighbor = point.offset(delta)

                    if not grid.contains(neighbor):
                        continue

                    if grid.get(neighbor) == Fruit.FRESH:
                        grid.set(neighbor, Fruit.ROTTEN)
                        fresh.remove(neighbor)
                        rotten.append(neighbor)

            minutes += 1

        if fresh:
            return -1

        return minutes
