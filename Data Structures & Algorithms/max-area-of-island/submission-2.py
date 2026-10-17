class Solution:
    def maxAreaOfIsland(self, grid: list[list[int]]) -> int:
        max_area = 0
        rows = len(grid)
        columns = len(grid[0])
        visited = set()

        for row in range(rows):
            for column in range(columns):
                if grid[row][column] == 1 and (row, column) not in visited:
                    area = 0

                    def dfs(r, c):
                        if (
                            r < 0
                            or r >= rows
                            or c < 0
                            or c >= columns
                            or grid[r][c] != 1
                            or (r, c) in visited
                        ):
                            return

                        visited.add((r, c))

                        nonlocal area
                        area += 1

                        dfs(r - 1, c)
                        dfs(r + 1, c)
                        dfs(r, c - 1)
                        dfs(r, c + 1)

                    dfs(row, column)

                    max_area = max(max_area, area)

        return max_area
