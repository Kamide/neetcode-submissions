type LN = {
  val: number;
  next: LN | null;
};

class Solution {
  hasCycle(head: LN | null): boolean {
    const visited = new Set<LN>();

    for (let current = head; current != null; current = current.next) {
      if (visited.has(current)) {
        return true;
      }

      visited.add(current);
    }

    return false;
  }
}
