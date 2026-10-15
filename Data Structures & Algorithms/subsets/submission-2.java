class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        var all = new ArrayList<List<Integer>>();
        collect(nums, 0, new ArrayList<>(), all);
        return all;
    }

    private void collect(
        int[] nums,
        int index,
        List<Integer> current,
        List<List<Integer>> all
    ) {
        if (index == nums.length) {
            all.add(new ArrayList<>(current));
            return;
        }

        collect(nums, index + 1, current, all);

        current.add(nums[index]);
        collect(nums, index + 1, current, all);
        current.removeLast();
    }
}
