from dataclasses import dataclass, field


@dataclass
class TrieNode:
    children: dict[str, TrieNode] = field(default_factory=dict)
    word: str | None = None

    def remove(self, char: str) -> None:
        child = self.children[char]

        if not child.children and child.word is None:
            del self.children[char]


@dataclass
class Trie:
    root: TrieNode = field(default_factory=TrieNode)

    def add(self, word: str) -> None:
        node = self.root

        for char in word:
            if char not in node.children:
                node.children[char] = TrieNode()

            node = node.children[char]

        node.word = word


class Solution:
    def findWords(self, board: list[list[str]], words: list[str]) -> list[str]:
        found: list[str] = []

        rows = len(board)

        if rows == 0:
            return found

        columns = len(board[0])

        if columns == 0:
            return found

        trie = Trie()

        for word in words:
            trie.add(word)

        visited: set[tuple[int, int]] = set()

        def dfs(r: int, c: int, parent: TrieNode) -> None:
            if not (0 <= r < rows and 0 <= c < columns):
                return

            cell = (r, c)

            if cell in visited:
                return

            char = board[r][c]
            child = parent.children.get(char)

            if child is None:
                return

            if child.word is not None:
                found.append(child.word)
                child.word = None

            visited.add(cell)

            dfs(r - 1, c, child)
            dfs(r + 1, c, child)
            dfs(r, c - 1, child)
            dfs(r, c + 1, child)

            visited.remove(cell)
            parent.remove(char)

        for row in range(rows):
            for column in range(columns):
                dfs(row, column, trie.root)

                if not trie.root.children:
                    return found

        return found
