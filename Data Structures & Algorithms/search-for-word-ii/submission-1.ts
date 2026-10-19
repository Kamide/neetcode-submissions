class TrieNode {
    children: Map<string, TrieNode> = new Map();
    word: string | undefined;

    remove(char: string): void {
        const child = this.children.get(char)!;

        if (child.children.size === 0 && child.word == null) {
            this.children.delete(char);
        }
    }
}

class Trie {
    root: TrieNode = new TrieNode();

    add(word: string): void {
        let node = this.root;

        for (const char of word) {
            if (!node.children.has(char)) {
                node.children.set(char, new TrieNode());
            }

            node = node.children.get(char)!;
        }

        node.word = word;
    }
}

class Solution {
    findWords(board: string[][], words: string[]): string[] {
        const found: string[] = [];

        const rows = board.length;

        if (rows === 0) {
            return found;
        }

        const columns = board[0].length;

        if (columns === 0) {
            return found;
        }

        const trie = new Trie();

        for (const word of words) {
            trie.add(word);
        }

        const visited = new Set<number>();

        function dfs(r: number, c: number, parent: TrieNode): void {
            if (r < 0 || r >= rows || c < 0 || c >= columns) {
                return;
            }

            const cell = r * columns + c;

            if (visited.has(cell)) {
                return;
            }

            const char = board[r][c];
            const child = parent.children.get(char);

            if (child == null) {
                return;
            }

            if (child.word != null) {
                found.push(child.word);
                child.word = undefined;
            }

            visited.add(cell);

            dfs(r - 1, c, child);
            dfs(r + 1, c, child);
            dfs(r, c - 1, child);
            dfs(r, c + 1, child);

            visited.delete(cell);
            parent.remove(char);
        }

        for (let row = 0; row < rows; row++) {
            for (let column = 0; column < columns; column++) {
                dfs(row, column, trie.root);

                if (trie.root.children.size === 0) {
                    return found;
                }
            }
        }

        return found;
    }
}
