from dataclasses import dataclass
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

    def points(self) -> Generator[Point, None, None]:
        for row in range(self.rows):
            for column in range(self.columns):
                yield Point(row, column)


DIRECTIONS = [
    Point(-1, 0),
    Point(1, 0),
    Point(0, -1),
    Point(0, 1),
]


class Solution:
    def pacificAtlantic(self, heights: list[list[int]]) -> list[list[int]]:
        grid = Grid(heights)
        pacific = set[Point]()
        atlantic = set[Point]()

        def dfs(point: Point, visited: set[Point]) -> None:
            if point in visited:
                return

            visited.add(point)

            for delta in DIRECTIONS:
                neighbor = point.offset(delta)

                if grid.contains(neighbor) and grid.get(neighbor) >= grid.get(point):
                    dfs(neighbor, visited)

        for point in grid.points():
            if point.row == 0 or point.column == 0:
                dfs(point, pacific)

            if point.row == grid.rows - 1 or point.column == grid.columns - 1:
                dfs(point, atlantic)

        return [
            [point.row, point.column]
            for point in pacific & atlantic
        ]
