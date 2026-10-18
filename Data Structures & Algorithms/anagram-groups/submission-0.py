from collections import defaultdict


class Solution:
    def groupAnagrams(self, strs: list[str]) -> list[list[str]]:
        groups: defaultdict[str, list[str]] = defaultdict(list)

        for word in strs:
            sorted_anagram = "".join(sorted(word))
            groups[sorted_anagram].append(word)

        return list(groups.values())
