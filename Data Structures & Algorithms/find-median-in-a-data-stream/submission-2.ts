type Comparator<T> = (a: T, b: T) => number;

class Heap<T> {
    private readonly heap: T[] = [];

    constructor(private readonly compare: Comparator<T>) {
    }

    get size(): number {
        return this.heap.length;
    }

    top(): T | undefined {
        return this.heap.at(0);
    }

    push(value: T): void {
        this.heap.push(value);
        this.bubbleUp(this.size - 1);
    }

    pop(): T | undefined {
        if (this.size === 0) {
            return undefined;
        }

        const top = this.top()!;
        const last = this.heap.pop()!;

        if (this.size > 0) {
            this.heap[0] = last;
            this.bubbleDown(0);
        }

        return top;
    }

    private bubbleUp(index: number): void {
        while (index > 0) {
            const parent = Math.floor((index - 1) / 2);

            if (this.compare(this.heap[index], this.heap[parent]) >= 0) {
                break;
            }

            [this.heap[index], this.heap[parent]] = [this.heap[parent], this.heap[index]];

            index = parent;
        }
    }

    private bubbleDown(index: number): void {
        const length = this.size;

        while (true) {
            let best = index;
            const left = 2 * index + 1;
            const right = 2 * index + 2;

            if (left < length && this.compare(this.heap[left], this.heap[best]) < 0) {
                best = left;
            }

            if (right < length && this.compare(this.heap[right], this.heap[best]) < 0) {
                best = right;
            }

            if (best === index) {
                break;
            }

            [this.heap[index], this.heap[best]] = [this.heap[best], this.heap[index]];

            index = best;
        }
    }
}

class MedianFinder {
    private readonly lowerHalf = new Heap<number>((a, b) => b - a);
    private readonly upperHalf = new Heap<number>((a, b) => a - b);

    addNum(num: number): void {
        this.lowerHalf.push(num);
        this.upperHalf.push(this.lowerHalf.pop()!);

        if (this.upperHalf.size > this.lowerHalf.size) {
            this.lowerHalf.push(this.upperHalf.pop()!);
        }
    }

    findMedian(): number {
        if (this.lowerHalf.size === 0) {
            return NaN;
        }

        if (this.lowerHalf.size > this.upperHalf.size) {
            return this.lowerHalf.top()!;
        }

        return (this.lowerHalf.top()! + this.upperHalf.top()!) / 2;
    }
}
