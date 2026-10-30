from collections import deque


class Solution:
    def evalRPN(self, tokens: list[str]) -> int:
        stack = deque[int]()

        for token in tokens:
            match token:
                case "+":
                    stack.append(stack.pop() + stack.pop())
                case "-":
                    right = stack.pop()
                    stack.append(stack.pop() - right)
                case "*":
                    stack.append(stack.pop() * stack.pop())
                case "/":
                    right = stack.pop()
                    stack.append(int(stack.pop() / right))
                case _:
                    stack.append(int(token))

        return stack.pop()
