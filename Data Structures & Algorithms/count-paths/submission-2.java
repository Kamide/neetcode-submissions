class Solution {
    public int uniquePaths(int rows, int columns) {
        var paths = new int[rows][columns];

        for (var row : paths) {
            Arrays.fill(row, 1);
        }

        for (var row = 1; row < rows; row += 1) {
            for (var column = 1; column < columns; column += 1) {
                paths[row][column] = paths[row - 1][column] + paths[row][column - 1];
            }
        }

        return paths[rows - 1][columns - 1];
    }
}
