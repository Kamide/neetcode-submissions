type OpeningBracket = "(" | "{" | "[";
type ClosingBracket = ")" | "}" | "]";
type Bracket = OpeningBracket | ClosingBracket;

const openingBracketOf = {
    ")": "(",
    "}": "{",
    "]": "[",
} as const satisfies Record<ClosingBracket, OpeningBracket>;

class Solution {
    /**
     * @param {string} s
     * @return {boolean}
     */
    isValid(s: string): boolean {
        const danglingOpeningBrackets: OpeningBracket[] = [];

        for (const c of s as Iterable<Bracket>) {
            switch (c) {
                case "(":
                case "{":
                case "[":
                    danglingOpeningBrackets.push(c);
                    break;

                case ")":
                case "}":
                case "]":
                    if (danglingOpeningBrackets.pop() !== openingBracketOf[c]) {
                        return false;
                    }
                    break;
            }
        }

        return danglingOpeningBrackets.length === 0;
    }
}
