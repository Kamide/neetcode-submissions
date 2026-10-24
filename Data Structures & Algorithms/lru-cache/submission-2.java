class LRUCache {
    private final Map<Integer, Integer> items;

    public LRUCache(final int capacity) {
        this.items = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(final int key) {
        return items.getOrDefault(key, -1);
    }

    public void put(final int key, final int value) {
        items.put(key, value);
    }
}
