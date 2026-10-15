class Solution:
    def numIslands(self, grid: list[list[str]]) -> int:
        count = 0
        rows = len(grid)
        columns = len(grid[0])
        visited = set()

        def dfs(row, column):
            if (
                row < 0
                or row >= rows
                or column < 0
                or column >= columns
                or grid[row][column] != "1"
                or (row, column) in visited
            ):
                return

            visited.add((row, column))

            dfs(row - 1, column)
            dfs(row + 1, column)
            dfs(row, column - 1)
            dfs(row, column + 1)

        for row in range(rows):
            for column in range(columns):
                if grid[row][column] == "1" and (row, column) not in visited:
                    count += 1

                    dfs(row, column)

        return count
