class MinStack {
    vals: number[] = [];
    minVals: number[] = [];

    push(val: number): void {
        this.vals.push(val);
        this.minVals.push(Math.min(val, this.minVals.at(-1) ?? Infinity));
    }

    pop(): void {
        this.vals.pop();
        this.minVals.pop();
    }

    top(): number {
        return this.vals.at(-1)!;
    }

    getMin(): number {
        return this.minVals.at(-1)!;
    }
}
