class Solution {
    public int evalRPN(String[] tokens) {
        final var stack = new ArrayDeque<Integer>();

        for (final var token : tokens) {
            switch (token) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "-" -> {
                    final var right = stack.pop();
                    stack.push(stack.pop() - right);
                }
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "/" -> {
                    final var right = stack.pop();
                    stack.push(stack.pop() / right);
                }
                default -> stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
