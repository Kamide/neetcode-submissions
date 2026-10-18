class Solution {
    groupAnagrams(strs: string[]): string[][] {
        const groups: Record<string, string[]> = Object.create(null);

        for (const str of strs) {
            const sortedAnagram = [...str].sort().join("");
            (groups[sortedAnagram] ??= []).push(str);
        }

        return Object.values(groups);
    }
}
