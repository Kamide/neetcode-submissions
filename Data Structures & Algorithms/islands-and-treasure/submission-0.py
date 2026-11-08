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


class Tile(IntEnum):
    WATER = -1
    TREASURE = 0
    LAND = 2 ** 31 - 1


DIRECTIONS = [
    Point(-1, 0),
    Point(1, 0),
    Point(0, -1),
    Point(0, 1),
]


class Solution:
    def islandsAndTreasure(self, raw: list[list[int]]) -> None:
        grid = Grid(raw)
        queue = deque[Point]()

        for point, tile in grid.items():
            if tile == Tile.TREASURE:
                queue.append(point)

        while queue:
            point = queue.popleft()
            distance = grid.get(point)

            for delta in DIRECTIONS:
                neighbor = point.offset(delta)

                if not grid.contains(neighbor):
                    continue

                if grid.get(neighbor) == Tile.LAND:
                    grid.set(neighbor, distance + 1)
                    queue.append(neighbor)
