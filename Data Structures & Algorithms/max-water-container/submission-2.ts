class Solution {
    maxArea(heights: number[]): number {
        let left = 0;
        let right = heights.length - 1;
        let maxArea = 0;

        while (left < right) {
            const area = Math.min(heights[left], heights[right]) * (right - left);
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
