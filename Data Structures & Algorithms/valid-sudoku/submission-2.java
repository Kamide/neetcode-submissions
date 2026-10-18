class Solution {
    public boolean isValidSudoku(char[][] board) {
        return indices().allMatch(
            row -> hasNoDuplicates(indices().mapToObj(column -> board[row][column]))
                && hasNoDuplicates(indices().mapToObj(column -> board[column][row]))
                && hasNoDuplicates(indices().mapToObj(column -> board[(row / 3) * 3 + column / 3]
                                                                     [(row % 3) * 3 + column % 3])));
    }

    private IntStream indices() {
        return IntStream.range(0, 9);
    }

    private boolean hasNoDuplicates(Stream<Character> digits) {
        return digits
            .filter(digit -> digit != '.')
            .allMatch(new HashSet<>()::add);
    }
}
