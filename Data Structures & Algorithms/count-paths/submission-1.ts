class Solution {
    uniquePaths(rows: number, columns: number) {
        const paths = new Array<number>(columns).fill(1);

        for (let row = 1; row < rows; row += 1) {
            for (let column = 1; column < columns; column += 1) {
                paths[column] += paths[column - 1];
            }
        }

        return paths[columns - 1];
    }
}
