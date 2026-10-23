class MinStack:
    def __init__(self):
        self.vals: list[int] = []
        self.min_vals: list[int] = []

    def push(self, val: int) -> None:
        self.vals.append(val)

        if not self.min_vals:
            self.min_vals.append(val)
        else:
            self.min_vals.append(min(val, self.min_vals[-1]))

    def pop(self) -> None:
        self.vals.pop()
        self.min_vals.pop()

    def top(self) -> int:
        return self.vals[-1]

    def getMin(self) -> int:
        return self.min_vals[-1]
