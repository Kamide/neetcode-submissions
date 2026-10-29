class Solution {
    public int maxArea(final int[] heights) {
        var left = 0;
        var right = heights.length - 1;
        var maxArea = 0;

        while (left < right) {
            final var area = Math.min(heights[left], heights[right]) * (right - left);
            maxArea = Math.max(maxArea, area);

            if (heights[left] < heights[right]) {
                left += 1;
            } else {
                right -= 1;
            }
        }

        return maxArea;
    }
}
