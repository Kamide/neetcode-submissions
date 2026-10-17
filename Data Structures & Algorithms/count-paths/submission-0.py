from functools import cache


class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        destination = (m - 1, n - 1)

        @cache
        def count_paths_from(row: int, column: int) -> int:
            if row >= m or column >= n:
                return 0

            if (row, column) == destination:
                return 1

            return count_paths_from(row + 1, column) + count_paths_from(row, column + 1)

        return count_paths_from(0, 0)
