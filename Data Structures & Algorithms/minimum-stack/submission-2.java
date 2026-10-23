class MinStack {
    private final Deque<Integer> vals = new ArrayDeque<>();
    private final Deque<Integer> minVals = new ArrayDeque<>();

    public void push(final int val) {
        vals.push(val);
        minVals.push(Math.min(val, minVals.isEmpty() ? val : minVals.peek()));
    }

    public void pop() {
        vals.pop();
        minVals.pop();
    }

    public int top() {
        return vals.peek();
    }

    public int getMin() {
        return minVals.peek();
    }
}
