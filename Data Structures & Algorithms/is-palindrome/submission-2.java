class Solution {
    public boolean isPalindrome(String s) {
        var ltr = new StringBuilder();
        var rtl = new StringBuilder();

        for (var c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                c = Character.toLowerCase(c);
                ltr.append(c);
                rtl.insert(0, c);
            }
        }

        return ltr.compareTo(rtl) == 0;
    }
}
