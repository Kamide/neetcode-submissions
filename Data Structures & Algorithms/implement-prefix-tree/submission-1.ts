class TrieNode {
    children = new Map<string, TrieNode>();
    leaf = false;
}

class PrefixTree {
    root = new TrieNode();

    insert(word: string): void {
        let last = this.root;

        for (const context of this.traverse(word)) {
            if (context.next == null) {
                context.next = new TrieNode();
                context.current.children.set(context.char, context.next);
            }

            last = context.next;
        }

        last.leaf = true;
    }

    search(word: string): boolean {
        let last = this.root;

        for (const context of this.traverse(word)) {
            if (context.next == null) {
                return false;
            }

            last = context.next;
        }

        return last.leaf;
    }

    startsWith(prefix: string): boolean {
        for (const context of this.traverse(prefix)) {
            if (context.next == null) {
                return false;
            }
        }

        return true;
    }

    *traverse(word: string) {
        const context = {
            char: "",
            current: this.root,
            next: undefined as TrieNode | undefined,
        };

        for (const char of word) {
            context.char = char;
            context.next = context.current.children.get(char);

            yield context;

            if (context.next == null) {
                return;
            }

            context.current = context.next;
        }
    }
}
