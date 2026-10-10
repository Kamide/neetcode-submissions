opening_bracket_of = {
    ")": "(",
    "}": "{",
    "]": "[",
}


class Solution:
    def isValid(self, s: str) -> bool:
        dangling_opening_brackets = []

        for c in s:
            match c:
                case '(' | '{' | '[':
                    dangling_opening_brackets.append(c)

                case ')' | '}' | ']':
                    if not dangling_opening_brackets or dangling_opening_brackets.pop() != opening_bracket_of[c]:
                        return False

        return not dangling_opening_brackets
