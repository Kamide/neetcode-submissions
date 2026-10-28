class Solution {
    record RowMajorMatrix(int[][] raw) {
        int rows() {
            return raw.length;
        }

        int columns() {
            return rows() == 0 ? 0 : raw[0].length;
        }

        int size() {
            return rows() * columns();
        }

        int at(final int index) {
            return raw[index / columns()][index % columns()];
        }
    }

    public boolean searchMatrix(final int[][] matrix, final int target) {
        final var mat = new RowMajorMatrix(matrix);
        var left = 0;
        var right = mat.size();

        while (left < right) {
            final var mid = left + (right - left) / 2;
            final var num = mat.at(mid);

            if (num == target) {
                return true;
            }

            if (num < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return false;
    }
}
