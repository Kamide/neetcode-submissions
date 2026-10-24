class LRUCache {
    items = new Map<number, number>();

    constructor(readonly capacity: number) {}

    get(key: number): number {
        const value = this.items.get(key);

        if (value == null) {
            return -1;
        }

        this.items.delete(key);
        this.items.set(key, value);

        return value;
    }

    put(key: number, value: number): void {
        this.items.delete(key);
        this.items.set(key, value);

        if (this.items.size > this.capacity) {
            for (const key of this.items.keys()) {
                this.items.delete(key);
                return;
            }
        }
    }
}
