class Solution {
    productExceptSelf(nums: number[]): number[] {
        const length = nums.length;
        const productsExceptSelf = new Array<number>(length).fill(1);

        for (let i = 0, productSoFarLtr = 1; i < length; i += 1) {
            productsExceptSelf[i] = productSoFarLtr;
            productSoFarLtr *= nums[i];
        }

        for (let i = length - 1, productSoFarRtl = 1; i >= 0; i -= 1) {
            productsExceptSelf[i] *= productSoFarRtl;
            productSoFarRtl *= nums[i];
        }

        return productsExceptSelf;
    }
}
