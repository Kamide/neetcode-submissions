class KthLargest {
    sorted: number[] = [];

    constructor(
        private readonly k: number,
        nums: number[],
    ) {
        nums.forEach(this.add);
    }

    add = (val: number) => {
        let left = 0;
        let right = this.size;

        while (left < right) {
            const mid = Math.floor((left + right) / 2);
            if (this.sorted[mid] >= val) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        this.sorted.splice(left, 0, val);

        if (this.size > this.k) {
            this.size = this.k;
        }

        return this.sorted.at(-1)!;
    };

    get size() {
        return this.sorted.length;
    }

    set size(capacity: number) {
        this.sorted.length = capacity;
    }
}
