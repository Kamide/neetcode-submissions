const LAND = 1;

class Solution {
    maxAreaOfIsland(grid: number[][]): number {
        let maxArea = 0;

        const rows = grid.length;
        const columns = grid[0].length;

        const visited = Array.from({ length: rows }, () =>
            new Array<boolean>(columns).fill(false),
        );

        for (let row = 0; row < rows; row += 1) {
            for (let column = 0; column < columns; column += 1) {
                if (grid[row][column] !== LAND || visited[row][column]) {
                    continue;
                }

                let area = 0;

                const dfs = (row: number, column: number) => {
                    if (
                        row < 0 ||
                        row >= rows ||
                        column < 0 ||
                        column >= columns ||
                        grid[row][column] !== LAND ||
                        visited[row][column]
                    ) {
                        return;
                    }

                    visited[row][column] = true;

                    area += 1;

                    dfs(row - 1, column);
                    dfs(row + 1, column);
                    dfs(row, column - 1);
                    dfs(row, column + 1);
                };

                dfs(row, column);

                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }
}
