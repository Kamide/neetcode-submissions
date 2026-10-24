from collections import OrderedDict


class LRUCache:
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.items = OrderedDict()

    def get(self, key: int) -> int:
        if key not in self.items:
            return -1

        self.items.move_to_end(key)
        return self.items[key]

    def put(self, key: int, value: int) -> None:
        self.items[key] = value
        self.items.move_to_end(key)

        if len(self.items) > self.capacity:
            self.items.popitem(last=False)
