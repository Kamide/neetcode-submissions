const lengthOf9 = { length: 9 };
const createStringSet = () => new Set<string>();
const empty = ".";

class Solution {
    isValidSudoku(board: string[][]): boolean {
        const rows = Array.from(lengthOf9, createStringSet);
        const columns = Array.from(lengthOf9, createStringSet);
        const boxes = Array.from(lengthOf9, createStringSet);

        for (let row = 0; row < 9; row += 1) {
            for (let column = 0; column < 9; column += 1) {
                const digit = board[row][column];

                if (digit === empty) {
                    continue;
                }

                const box = Math.trunc(row / 3) * 3 + Math.trunc(column / 3);

                if (
                    rows[row].has(digit) ||
                    columns[column].has(digit) ||
                    boxes[box].has(digit)
                ) {
                    return false;
                }

                rows[row].add(digit);
                columns[column].add(digit);
                boxes[box].add(digit);
            }
        }

        return true;
    }
}
