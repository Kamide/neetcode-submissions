class TrieNode {
    children = new Map<string, TrieNode>();
    leaf = false;
}

class WordDictionary {
    root = new TrieNode();

    addWord(word: string): void {
        let node = this.root;

        for (const char of word) {
            let next = node.children.get(char);

            if (next == null) {
                next = new TrieNode();
                node.children.set(char, next);
            }

            node = next;
        }

        node.leaf = true;
    }

    search(word: string): boolean {
        return (function patternMatch(node: TrieNode, charIndex: number) {
            if (charIndex === word.length) {
                return node.leaf;
            }

            const char = word[charIndex];

            if (char === ".") {
                for (const next of node.children.values()) {
                    if (patternMatch(next, charIndex + 1)) {
                        return true;
                    }
                }

                return false;
            }

            const next = node.children.get(char);

            if (next == null) {
                return false;
            }

            return patternMatch(next, charIndex + 1);
        })(this.root, 0);
    }
}
