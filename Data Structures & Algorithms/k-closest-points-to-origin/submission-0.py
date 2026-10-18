from math import sqrt


def distance_from_origin(point: tuple[int, int]):
    return sqrt(point[0] ** 2 + point[1] ** 2)


class Solution:
    def kClosest(self, points: list[tuple[int, int]], k: int) -> list[tuple[int, int]]:
        return sorted(points, key=distance_from_origin)[:k]
