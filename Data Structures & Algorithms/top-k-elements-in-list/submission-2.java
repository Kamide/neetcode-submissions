class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        var numToFrequency = new HashMap<Integer, Integer>();

        for (var num : nums) {
            numToFrequency.put(num, numToFrequency.getOrDefault(num, 0) + 1);
        }

        var frequencyToNums = new ArrayList<ArrayList<Integer>>();

        for (var frequency = 0; frequency <= nums.length; frequency += 1) {
            frequencyToNums.add(new ArrayList<>());
        }

        for (var entry : numToFrequency.entrySet()) {
            var num = entry.getKey();
            var frequency = entry.getValue();

            frequencyToNums.get(frequency).add(num);
        }

        var topK = new int[k];
        var topKSize = 0;

        for (var frequency = frequencyToNums.size() - 1; frequency >= 1; frequency -= 1) {
            for (var num : frequencyToNums.get(frequency)) {
                topK[topKSize] = num;
                topKSize += 1;

                if (topKSize == k) {
                    return topK;
                }
            }
        }

        return topK;
    }
}
