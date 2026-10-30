const ops: Record<string, (a: number, b: number) => number> = {
    "+": (a, b) => a + b,
    "-": (a, b) => a - b,
    "*": (a, b) => a * b,
    "/": (a, b) => Math.trunc(a / b),
};

class Solution {
    evalRPN(tokens: string[]): number | undefined {
        const stack: number[] = [];

        for (const token of tokens) {
            const op = ops[token];

            if (op != null) {
                const b = stack.pop()!;
                const a = stack.pop()!;
                stack.push(op(a, b));
            } else {
                stack.push(Number(token));
            }
        }

        return stack.pop();
    }
}
