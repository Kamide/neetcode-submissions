class Solution {
    public boolean isValid(String s) {
        var stack = new ArrayDeque<Character>();

        for (var i = 0; i < s.length(); i += 1) {
            var c = s.charAt(i);

            switch (c) {
                case '(' -> stack.push(')');
                case '{' -> stack.push('}');
                case '[' -> stack.push(']');

                case ')', '}', ']' -> {
                    if (stack.isEmpty() || stack.pop() != c) {
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty();
    }
}
