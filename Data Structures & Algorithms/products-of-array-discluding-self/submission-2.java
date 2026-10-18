class Solution {
    public int[] productExceptSelf(final int[] nums) {
        final var length = nums.length;
        final var productsExceptSelf = new int[length];

        Arrays.fill(productsExceptSelf, 1);

        for (int i = 0, productSoFarLtr = 1; i < length; i += 1) {
            productsExceptSelf[i] = productSoFarLtr;
            productSoFarLtr *= nums[i];
        }

        for (int i = length - 1, productSoFarRtl = 1; i >= 0; i -= 1) {
            productsExceptSelf[i] *= productSoFarRtl;
            productSoFarRtl *= nums[i];
        }

        return productsExceptSelf;
    }
}