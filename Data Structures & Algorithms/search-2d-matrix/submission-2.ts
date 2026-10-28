class Solution {
    searchMatrix(matrix: number[][], target: number): boolean {
        const rows = matrix.length;
        const columns = matrix[0].length;

        function search(left: number, right: number): boolean {
            if (left > right) {
                return false;
            }

            const mid = Math.trunc((left + right) / 2);
            const num = matrix[Math.trunc(mid / columns)][mid % columns];

            if (num === target) {
                return true;
            }

            if (num < target) {
                return search(mid + 1, right);
            }

            return search(left, mid - 1);
        }

        return search(0, rows * columns - 1);
    }
}
