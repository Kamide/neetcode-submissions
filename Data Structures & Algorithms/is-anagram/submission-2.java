class Solution {
    public boolean isAnagram(String s, String t) {
        return count(s).equals(count(t));
    }

    private Map<Integer, Long> count(String string) {
        return string.codePoints()
                .boxed()
                .collect(Collectors.groupingBy(
                        codePoint -> codePoint,
                        Collectors.counting()));
    }
}
