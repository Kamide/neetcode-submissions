from dataclasses import dataclass, field


@dataclass
class TrieNode:
    children: dict[str, TrieNode] = field(default_factory=dict)
    leaf: bool = False


@dataclass
class WordDictionary:
    root: TrieNode = field(default_factory=TrieNode)

    def addWord(self, word: str) -> None:
        node = self.root

        for char in word:
            if char not in node.children:
                node.children[char] = TrieNode()

            node = node.children[char]

        node.leaf = True

    def search(self, word: str) -> bool:
        def pattern_match(node: TrieNode, char_index: int) -> bool:
            if char_index == len(word):
                return node.leaf

            char = word[char_index]

            if char == '.':
                return any(
                    pattern_match(child, char_index + 1)
                    for child in node.children.values()
                )

            if char not in node.children:
                return False

            return pattern_match(node.children[char], char_index + 1)

        return pattern_match(self.root, 0)
