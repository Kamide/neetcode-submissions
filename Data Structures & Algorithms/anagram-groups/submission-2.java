class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        return Arrays.stream(strs)
            .collect(Collectors.groupingBy(this::countByCodePoint))
            .values()
            .stream()
            .toList();
    }

    private Map<Integer, Long> countByCodePoint(String string) {
        return string.codePoints()
            .boxed()
            .collect(Collectors.groupingBy(
                codePoint -> codePoint,
                Collectors.counting()));
    }
}
